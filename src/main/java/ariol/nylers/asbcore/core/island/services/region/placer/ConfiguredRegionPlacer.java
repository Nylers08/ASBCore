package ariol.nylers.asbcore.core.island.services.region.placer;

import ariol.nylers.asbcore.core.island.services.region.configurator.PrivateConfigurator;
import ariol.nylers.asbcore.core.island.services.region.configurator.RegionWithMembership;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class ConfiguredRegionPlacer implements PrivatePlacer<IslandRegionPlacementContext> {

    private final PrivatePlacer<IslandRegionPlaceData> placer;
    private final PrivateConfigurator<RegionWithMembership> configurator;

    public ConfiguredRegionPlacer(
            PrivatePlacer<IslandRegionPlaceData> placer,
            PrivateConfigurator<RegionWithMembership> configurator) {
        this.placer = placer;
        this.configurator = configurator;
    }

    @Override
    public ProtectedRegion place(IslandRegionPlacementContext placeContext) {
        ProtectedRegion region = placer.place(placeContext.getIslandRegionPlaceData());
        RegionWithMembership configContext = new RegionWithMembership(region, placeContext.getMembership());
        configurator.configure(configContext);
        return region;
    }
}
