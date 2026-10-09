package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.island.services.clipboard.ClipboardPlacer;
import ariol.nylers.asbcore.core.island.services.island.cache.IslandCache;
import ariol.nylers.asbcore.core.island.services.island.cache.IslandCacheController;
import ariol.nylers.asbcore.core.island.services.island.cache.IslandCacheControllerImpl;
import ariol.nylers.asbcore.core.island.services.island.cache.IslandLocationRegistry;
import ariol.nylers.asbcore.core.island.services.island.paste.IslandPasteExecutor;
import ariol.nylers.asbcore.core.island.services.island.place.CoordinateIslandPlacementStrategy;
import ariol.nylers.asbcore.core.island.services.island.place.IslandPlacer;
import ariol.nylers.asbcore.core.island.services.island.place.IslandPlacerImpl;
import ariol.nylers.asbcore.core.island.services.posResolver.IslandPosResolver;
import ariol.nylers.asbcore.core.island.services.posResolver.LinerPosResolver;
import ariol.nylers.asbcore.core.island.services.posResolver.PosResolverByPlayer;
import ariol.nylers.asbcore.core.island.services.region.configurator.FlagPrivateConfigurator;
import ariol.nylers.asbcore.core.island.services.region.configurator.PrivateConfigurator;
import ariol.nylers.asbcore.core.island.services.region.configurator.RegionWithMembership;
import ariol.nylers.asbcore.core.island.services.region.placer.*;
import ariol.nylers.asbcore.core.profile.ProfileModule;
import ariol.nylers.asbcore.core.island.services.region.MemberPermParser;
import lombok.Getter;
import org.bukkit.World;

import java.util.UUID;

public class ServiceController {

    @Getter private final ProfileModule profileModule = new ProfileModule();
    @Getter private final MemberPermParser memberPermParser = new MemberPermParser();


    @Getter private final IslandCache islandCache = new IslandCache();
    @Getter private final IslandLocationRegistry islandLocationRegistry = new IslandLocationRegistry();
    @Getter private final IslandCacheController islandCacheController =
            new IslandCacheControllerImpl(islandCache, islandLocationRegistry);


    @Getter private final ClipboardPlacer clipboardPlacer = new ClipboardPlacer();

    @Getter private final PrivatePlacer<IslandRegionPlaceData> islandRegionPlacer = new IslandRegionPlacer();
    @Getter private final PrivateConfigurator<RegionWithMembership> privateConfigurator =
            new FlagPrivateConfigurator(profileModule.getMetaProfileProvider());
    @Getter private final PrivatePlacer<IslandRegionPlacementContext> configPrivatePlacer =
            new ConfiguredRegionPlacer(islandRegionPlacer, privateConfigurator);

    @Getter private final IslandPasteExecutor islandPasteExecutor = new IslandPasteExecutor(clipboardPlacer, configPrivatePlacer);
    @Getter private final IslandPosResolver<World> islandPosResolver = new LinerPosResolver();

    @Getter private final IslandPlacer cordIslandPlacementStrategy =
            new CoordinateIslandPlacementStrategy(islandPasteExecutor, islandPosResolver);

    @Getter private final IslandPlacer islandPlacer =
            new IslandPlacerImpl(cordIslandPlacementStrategy, islandCacheController);


    @Getter private io.neris.NGui.core.services.ServiceController menuController;

    public ServiceController() {
    }
}
