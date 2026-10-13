package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.playerIsland.services.PlayerIslandFactoriesSetup;
import ariol.nylers.asbcore.core.playerIsland.services.clipboard.fawe.ClipboardPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.island.cache.IslandLocationRegistry;
import ariol.nylers.asbcore.core.playerIsland.services.island.paste.IslandPasteExecutor;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.CoordinateIslandPlacementStrategy;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.IslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.island.place.IslandPlacerImpl;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCache;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandCacheController;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.PlayerIslandPlacedRegistry;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache.ProfilePlayerIslandRegistry;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreatorByPlayerId;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator.PlayerIslandCreatorByProfileId;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.db.EmptyPlayerIslandRepository;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.db.PlayerIslandRepository;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer.MegaPlayerIslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer.PlayerIslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.placer.ProfilePlayerIslandPlacer;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.provider.PlayerIslandProvider;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.provider.PlayerIslandProviderImpl;
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


    @Getter private final PlayerIslandFactoriesSetup playerIslandFactoriesSetup = new PlayerIslandFactoriesSetup();


    @Getter private final IslandLocationRegistry islandLocationRegistry = new IslandLocationRegistry();

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
            new IslandPlacerImpl(cordIslandPlacementStrategy, islandLocationRegistry);

    @Getter private final PlayerIslandPlacedRegistry playerIslandPlacedRegistry = new PlayerIslandPlacedRegistry();
    @Getter private final PlayerIslandPlacer playerIslandPlacer =
            new PlayerIslandPlacer(islandPlacer, playerIslandPlacedRegistry);


    @Getter private final PlayerIslandCache playerIslandCache = new PlayerIslandCache();
    @Getter private final ProfilePlayerIslandRegistry profilePlayerIslandRegistry = new ProfilePlayerIslandRegistry();
    @Getter private final PlayerIslandCacheController playerIslandCacheController =
            new PlayerIslandCacheController(playerIslandCache, profilePlayerIslandRegistry);

    @Getter private final PlayerIslandRepository playerIslandRepository = new EmptyPlayerIslandRepository();

    @Getter private final PlayerIslandProvider playerIslandProvider =
            new PlayerIslandProviderImpl(playerIslandCacheController, playerIslandRepository);

    @Getter private final PlayerIslandCreatorByProfileId playerIslandCreatorByProfileId =
            new PlayerIslandCreatorByProfileId(playerIslandFactoriesSetup.getPlayerIslandFactory(), playerIslandCacheController);

    @Getter private final PlayerIslandCreatorByPlayerId playerIslandCreatorByPlayerId =
            new PlayerIslandCreatorByPlayerId(
                    playerIslandCreatorByProfileId,
                    profileModule.getProfileCaches().selectedMetaProfileRegistry());

    @Getter private final ProfilePlayerIslandPlacer profilePlayerIslandPlacer =
            new ProfilePlayerIslandPlacer(playerIslandPlacer, profilePlayerIslandRegistry);

    @Getter private final MegaPlayerIslandPlacer megaPlayerIslandPlacer =
            new MegaPlayerIslandPlacer(profilePlayerIslandPlacer,
                    profileModule.getProfileCaches().selectedMetaProfileRegistry());


    @Getter private MenuServiceController menuController;

    public ServiceController() {
    }

    public ServiceController(MenuServiceController menuController){
        this.menuController = menuController;
    }
}
