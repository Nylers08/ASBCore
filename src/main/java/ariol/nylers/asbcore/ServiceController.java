package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.island.services.clipboard.ClipboardPlacer;
import ariol.nylers.asbcore.core.island.services.island.IslandPlacer;
import ariol.nylers.asbcore.core.island.services.region.configurator.FlagPrivateConfigurator;
import ariol.nylers.asbcore.core.island.services.region.configurator.PrivateConfigurator;
import ariol.nylers.asbcore.core.island.services.region.configurator.RegionWithMembership;
import ariol.nylers.asbcore.core.island.services.region.placer.*;
import ariol.nylers.asbcore.core.profile.ProfileModule;
import ariol.nylers.asbcore.core.island.services.region.MemberPermParser;
import lombok.Getter;

public class ServiceController {

    @Getter private final ProfileModule profileModule = new ProfileModule();
    @Getter private final MemberPermParser memberPermParser = new MemberPermParser();


    @Getter private final ClipboardPlacer clipboardPlacer = new ClipboardPlacer();
    @Getter private final PrivatePlacer<IslandRegionPlaceData> islandRegionPlacer = new IslandRegionPlacer();
    @Getter private final PrivateConfigurator<RegionWithMembership> privateConfigurator =
            new FlagPrivateConfigurator(profileModule.getMetaProfileProvider());
    @Getter private final PrivatePlacer<IslandRegionPlacementContext> configPrivatePlacer =
            new ConfiguredRegionPlacer(islandRegionPlacer, privateConfigurator);
    @Getter private final IslandPlacer islandPlacer = new IslandPlacer(clipboardPlacer, configPrivatePlacer);

}
