package ariol.nylers.asbcore.core.island.services.island;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.services.clipboard.ClipboardPlacer;
import ariol.nylers.asbcore.core.island.services.region.placer.ConfiguredRegionPlacer;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlaceData;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlacementContext;
import ariol.nylers.asbcore.core.island.services.region.placer.PrivatePlacer;
import org.bukkit.Location;

import java.util.concurrent.CompletableFuture;

public class IslandPlacer {

    private final ClipboardPlacer clipboardPlacer;
    private final PrivatePlacer<IslandRegionPlacementContext> regionPlacer;

    public IslandPlacer(ClipboardPlacer clipboardPlacer, PrivatePlacer<IslandRegionPlacementContext> regionPlacer) {
        this.clipboardPlacer = clipboardPlacer;
        this.regionPlacer = regionPlacer;
    }

    public CompletableFuture<Void> place(Island island, Location location){
        IslandRegionPlaceData placeData = new IslandRegionPlaceData(location, island.getRegion());
        IslandRegionPlacementContext context = new IslandRegionPlacementContext(placeData, island.getMembership());
        regionPlacer.place(context);
        return clipboardPlacer.place(location, island.getClipboard());
    }
}
