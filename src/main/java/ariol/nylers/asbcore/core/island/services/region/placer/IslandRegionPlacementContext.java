package ariol.nylers.asbcore.core.island.services.region.placer;

import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import lombok.Getter;
import lombok.experimental.Delegate;
import org.bukkit.World;

public class IslandRegionPlacementContext {

    @Delegate @Getter
    private final IslandRegionPlaceData islandRegionPlaceData;

    @Getter
    private final Membership membership;

    public IslandRegionPlacementContext(IslandRegionPlaceData islandRegionPlaceData, Membership membership) {
        this.islandRegionPlaceData = islandRegionPlaceData;
        this.membership = membership;
    }
}
