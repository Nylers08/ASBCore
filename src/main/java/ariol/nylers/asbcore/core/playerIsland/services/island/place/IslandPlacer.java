package ariol.nylers.asbcore.core.playerIsland.services.island.place;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;

import java.util.concurrent.CompletableFuture;

public interface IslandPlacer {

    CompletableFuture<IslandPlacementResult> place(Island island);
}
