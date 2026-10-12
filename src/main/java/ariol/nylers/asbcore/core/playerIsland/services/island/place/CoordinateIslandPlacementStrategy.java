package ariol.nylers.asbcore.core.playerIsland.services.island.place;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.services.island.paste.IslandPasteExecutor;
import ariol.nylers.asbcore.core.playerIsland.services.posResolver.IslandPosResolver;
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
        Location location = posResolver.resolve(island.getOrigin().getWorld());
        CompletableFuture<Void> pasteFuture = islandPasteExecutor.place(island, location);
        return pasteFuture.thenApply(ignored->
                new IslandPlacementResult(island, location)
        );
    }
}
