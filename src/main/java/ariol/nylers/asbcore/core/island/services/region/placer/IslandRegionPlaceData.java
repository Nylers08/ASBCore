package ariol.nylers.asbcore.core.island.services.region.placer;

import ariol.nylers.asbcore.core.island.region.IslandRegion;
import org.bukkit.Location;

public record IslandRegionPlaceData(
        Location center,
        IslandRegion islandRegion
) {


}
