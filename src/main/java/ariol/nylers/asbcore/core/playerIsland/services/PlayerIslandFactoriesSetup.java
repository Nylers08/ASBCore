package ariol.nylers.asbcore.core.playerIsland.services;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.IslandSettings;
import ariol.nylers.asbcore.core.playerIsland.services.clipboard.provider.ClipboardProvider;
import ariol.nylers.asbcore.core.playerIsland.services.clipboard.provider.TestClipboardProvider;
import ariol.nylers.asbcore.core.playerIsland.services.island.factory.*;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.BaseIslandOwnershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.IslandOwnershipCreateContext;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.IslandOwnershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.levelSystem.LevelSystemFactory;
import ariol.nylers.asbcore.core.playerIsland.services.levelSystem.TestLevelSystemFactory;
import ariol.nylers.asbcore.core.playerIsland.services.membership.BaseMembershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.membership.MembershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.BasePlayerIslandFactory;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.PlayerIslandFactoryContext;
import ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory.PlayerIslandFactory;
import ariol.nylers.asbcore.core.playerIsland.services.region.factory.BaseIslandRegionFactory;
import ariol.nylers.asbcore.core.playerIsland.services.region.factory.IslandRegionFactory;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

public class PlayerIslandFactoriesSetup {

    @Getter
    private final ClipboardProvider clipboardProvider = new TestClipboardProvider(); // TODO: поменять тестовый, на реализованный

    @Getter
    private final IslandSettingsFactory settingsFactory = new TestIslandSettingsFactory(); // TODO: поменять тестовый на реализованный

    @Getter
    private final IslandRegionFactory<IslandSettings> islandRegionFactory = new BaseIslandRegionFactory();

    @Getter
    private final IslandFactory<IslandCreateContext> islandFactory =
            new BaseIslandFactory(clipboardProvider, settingsFactory, islandRegionFactory);

    @Getter
    private final IslandOwnershipFactory<IslandOwnershipCreateContext> islandOwnershipFactory = new BaseIslandOwnershipFactory(islandFactory);


    @Getter
    private final MembershipFactory<ProfileId> membershipFactory = new BaseMembershipFactory();


    @Getter
    private final LevelSystemFactory levelSystemFactory = new TestLevelSystemFactory(); // TODO: поменять тестовый на реализованный


    @Getter
    private final PlayerIslandFactory<PlayerIslandFactoryContext> playerIslandFactory =
            new BasePlayerIslandFactory(islandOwnershipFactory, membershipFactory, levelSystemFactory);
}
