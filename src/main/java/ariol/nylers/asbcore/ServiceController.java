package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.playerIsland.services.clipboard.fawe.ClipboardPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.island.cache.IslandCache;
import ariol.nylers.asbcore.core.playerIsland.services.island.cache.IslandCacheController;
import ariol.nylers.asbcore.core.playerIsland.services.island.cache.IslandCacheControllerImpl;
import ariol.nylers.asbcore.core.playerIsland.services.island.cache.IslandLocationRegistry;
import ariol.nylers.asbcore.core.playerIsland.services.island.paste.IslandPasteExecutor;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.CoordinateIslandPlacementStrategy;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.IslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.IslandPlacerImpl;
import ariol.nylers.asbcore.core.playerIsland.services.posResolver.IslandPosResolver;
import ariol.nylers.asbcore.core.playerIsland.services.posResolver.LinerPosResolver;
import ariol.nylers.asbcore.core.playerIsland.services.region.configurator.FlagPrivateConfigurator;
import ariol.nylers.asbcore.core.playerIsland.services.region.configurator.PrivateConfigurator;
import ariol.nylers.asbcore.core.playerIsland.services.region.configurator.RegionWithMembership;
import ariol.nylers.asbcore.core.playerIsland.services.region.placer.*;
import ariol.nylers.asbcore.core.profile.ProfileModule;
import ariol.nylers.asbcore.core.playerIsland.services.region.MemberPermParser;
import io.neris.NGui.core.services.MenuServiceController;
import lombok.Getter;
import org.bukkit.World;

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


    @Getter private MenuServiceController menuController;

    public ServiceController() {
    }

    public ServiceController(MenuServiceController menuController){
        this.menuController = menuController;
    }
}
