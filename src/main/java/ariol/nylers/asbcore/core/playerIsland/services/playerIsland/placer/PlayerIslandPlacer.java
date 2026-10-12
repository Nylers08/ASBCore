package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer;

import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.IslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCacheController;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class PlayerIslandPlacer {

    private final IslandPlacer islandPlacer;
    private final PlayerIslandCacheController cacheController;

    public PlayerIslandPlacer(IslandPlacer islandPlacer, PlayerIslandCacheController cacheController) {
        this.islandPlacer = islandPlacer;
        this.cacheController = cacheController;
    }

    public CompletableFuture<Void> paste(PlayerIsland playerIsland){
        CompletableFuture<Void> placeFuture = placeIslands(playerIsland.getIslandOwnership());
        return placeFuture.thenApply(fn->{
            cache(playerIsland);
            return fn;
        });
    }

    private CompletableFuture<Void> placeIslands(IslandOwnership islandOwnership){
        Collection<Island> islands = islandOwnership.getIslands();

        CompletableFuture<?>[] futures = islands.stream()
                .map(islandPlacer::place)
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(futures);
    }

    private void cache(PlayerIsland playerIsland){
        cacheController.cache(playerIsland);
    }
}
