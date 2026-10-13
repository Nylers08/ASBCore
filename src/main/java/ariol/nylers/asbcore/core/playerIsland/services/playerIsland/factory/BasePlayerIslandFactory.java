package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandData;
import ariol.nylers.asbcore.core.playerIsland.pojo.levelSystem.LevelSystem;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.IslandOwnershipCreateContext;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.IslandOwnershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.levelSystem.LevelSystemFactory;
import ariol.nylers.asbcore.core.playerIsland.services.membership.MembershipFactory;
import ariol.nylers.asbcore.core.profile.ProfileId;

public class BasePlayerIslandFactory implements PlayerIslandFactory<PlayerIslandFactoryContext> {

    private final IslandOwnershipFactory<IslandOwnershipCreateContext> islandOwnershipFactory;
    private final MembershipFactory<ProfileId> membershipFactory;
    private final LevelSystemFactory levelSystemFactory;

    public BasePlayerIslandFactory(IslandOwnershipFactory<IslandOwnershipCreateContext> islandOwnershipFactory,
                                   MembershipFactory<ProfileId> membershipFactory,
                                   LevelSystemFactory levelSystemFactory) {
        this.islandOwnershipFactory = islandOwnershipFactory;
        this.membershipFactory = membershipFactory;
        this.levelSystemFactory = levelSystemFactory;
    }

    @Override
    public PlayerIsland create(PlayerIslandFactoryContext context) {
        requireContext(context);

        PlayerIslandData playerIslandData = createPlayerIslandData(context);
        return new PlayerIsland(context.getProfileId(), playerIslandData);
    }

    private PlayerIslandData createPlayerIslandData(PlayerIslandFactoryContext context) {
        Membership membership = membershipFactory.create(context.getProfileId());
        IslandOwnershipCreateContext ownershipContext =
                new IslandOwnershipCreateContext(context.getPreset(), membership);
        IslandOwnership islandOwnership = islandOwnershipFactory.create(ownershipContext);
        LevelSystem levelSystem = levelSystemFactory.create();

        return new PlayerIslandData(islandOwnership, membership, levelSystem);
    }

    private void requireContext(PlayerIslandFactoryContext context) {
        if (context == null) {
            throw new IllegalArgumentException("PlayerIslandFactoryContext cannot be null");
        }

        if (context.getProfileId() == null) {
            throw new IllegalArgumentException("ProfileId cannot be null");
        }

        if (context.getPreset() == null) {
            throw new IllegalArgumentException("IslandPlacementPreset cannot be null");
        }
    }
}
