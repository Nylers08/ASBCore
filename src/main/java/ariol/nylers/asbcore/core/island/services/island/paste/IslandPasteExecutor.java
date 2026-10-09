package ariol.nylers.asbcore.core.island.services.island.paste;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.services.clipboard.ClipboardPlacer;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlaceData;
import ariol.nylers.asbcore.core.island.services.region.placer.IslandRegionPlacementContext;
import ariol.nylers.asbcore.core.island.services.region.placer.PrivatePlacer;
import org.bukkit.Location;

import java.util.concurrent.CompletableFuture;

public class IslandPasteExecutor implements IslandPaste {

    private final ClipboardPlacer clipboardPlacer;
    private final PrivatePlacer<IslandRegionPlacementContext> regionPlacer;

    public IslandPasteExecutor(ClipboardPlacer clipboardPlacer, PrivatePlacer<IslandRegionPlacementContext> regionPlacer) {
        this.clipboardPlacer = clipboardPlacer;
        this.regionPlacer = regionPlacer;
    }

    public CompletableFuture<Void> place(Island island, Location location){
        regionPlace(location, island);
        return clipboardPlacer.place(location, island.getClipboard());
    }

    private void regionPlace(Location location, Island island){
        IslandRegionPlaceData placeData = new IslandRegionPlaceData(island.getRegion(), location);
        IslandRegionPlacementContext context = new IslandRegionPlacementContext(placeData, island.getMembership());
        regionPlacer.place(context);
    }


}
