package ariol.nylers.asbcore.core.island.services.island.place;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.services.island.cache.IslandCacheController;

import java.util.concurrent.CompletableFuture;

public class IslandPlacerImpl implements IslandPlacer{

    private final IslandPlacer delegator;
    private final IslandCacheController cacheController;

    public IslandPlacerImpl(IslandPlacer delegator, IslandCacheController cacheController) {
        this.delegator = delegator;
        this.cacheController = cacheController;
    }

    @Override
    public CompletableFuture<IslandPlacementResult> place(Island island) {
        CompletableFuture<IslandPlacementResult> placeFuture = delegator.place(island);
        return placeFuture.thenApply(result -> {
            cache(result);
            return result;
        });
    }

    private void cache(IslandPlacementResult result){
        cacheController.cacheWithLocation(result.island(), result.location());
    }
}
