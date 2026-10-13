package ariol.nylers.asbcore.core.playerIsland.services.island.place;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.services.island.cache.IslandLocationRegistry;

import java.util.concurrent.CompletableFuture;

public class IslandPlacerImpl implements IslandPlacer{

    private final IslandPlacer delegator;
    private final IslandLocationRegistry locationRegistry;

    public IslandPlacerImpl(IslandPlacer delegator, IslandLocationRegistry locationRegistry) {
        this.delegator = delegator;
        this.locationRegistry = locationRegistry;
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
        locationRegistry.register(result.island(), result.location());
    }
}
