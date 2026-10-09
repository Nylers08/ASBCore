package ariol.nylers.asbcore.core.island.services.region.placer;

import ariol.nylers.asbcore.core.profile.services.MetaProfileProvider;
import ariol.nylers.asbcore.core.utils.adapters.WorldEditAdapter;
import ariol.nylers.asbcore.core.utils.worldGuard.ProtectedRegionUtils;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class IslandRegionPlacer implements PrivatePlacer<IslandRegionPlaceData> {

    @Override
    public ProtectedRegion place(IslandRegionPlaceData placeData) {
        placeData.islandRegion().setOrigin(placeData.center());
        ProtectedRegion protectedRegion = WorldEditAdapter.adapt(placeData.islandRegion());
        ProtectedRegionUtils.register(protectedRegion, placeData.center().getWorld());
        return protectedRegion;
    }

}
