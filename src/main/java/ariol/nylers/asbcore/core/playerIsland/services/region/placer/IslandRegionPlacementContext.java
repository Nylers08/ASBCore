package ariol.nylers.asbcore.core.playerIsland.services.region.placer;

import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import lombok.Getter;
import lombok.experimental.Delegate;

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
