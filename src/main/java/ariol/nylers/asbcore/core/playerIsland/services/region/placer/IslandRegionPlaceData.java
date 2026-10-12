package ariol.nylers.asbcore.core.playerIsland.services.region.placer;

import ariol.nylers.asbcore.core.playerIsland.pojo.region.IslandRegion;
import org.bukkit.Location;

public record IslandRegionPlaceData(
        IslandRegion islandRegion, Location center
) {


}
