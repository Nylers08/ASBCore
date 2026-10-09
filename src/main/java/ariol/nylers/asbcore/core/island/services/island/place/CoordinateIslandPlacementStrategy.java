package ariol.nylers.asbcore.core.island.services.island.place;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.services.island.paste.IslandPasteExecutor;
import ariol.nylers.asbcore.core.island.services.posResolver.IslandPosResolver;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.concurrent.CompletableFuture;

public class CoordinateIslandPlacementStrategy implements IslandPlacer {

    private final IslandPasteExecutor islandPasteExecutor;
    private final IslandPosResolver<World> posResolver;

    public CoordinateIslandPlacementStrategy(IslandPasteExecutor islandPasteExecutor, IslandPosResolver<World> posResolver) {
        this.islandPasteExecutor = islandPasteExecutor;
        this.posResolver = posResolver;
    }

    @Override
    public CompletableFuture<IslandPlacementResult> place(Island island) {
        Location location = posResolver.resolve(island.getWorld());
        CompletableFuture<Void> pasteFuture = islandPasteExecutor.place(island, location);
        return pasteFuture.thenApply(ignored->
                new IslandPlacementResult(island, location)
        );
    }
}
