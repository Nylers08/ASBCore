package ariol.nylers.asbcore.core.island.services.island.place;

import ariol.nylers.asbcore.core.island.playerIsland.Island;

import java.util.concurrent.CompletableFuture;

public interface IslandPlacer {

    CompletableFuture<IslandPlacementResult> place(Island island);
}
