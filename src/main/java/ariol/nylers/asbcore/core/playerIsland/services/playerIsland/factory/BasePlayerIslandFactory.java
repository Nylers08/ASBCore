package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandData;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import ariol.nylers.asbcore.core.playerIsland.pojo.levelSystem.LevelSystem;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.IslandOwnershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.levelSystem.LevelSystemFactory;
import ariol.nylers.asbcore.core.playerIsland.services.membership.MembershipFactory;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Collection;
import java.util.Set;

public class BasePlayerIslandFactory implements PlayerIslandFactory<PlayerIslandFactoryContext> {

    private final IslandOwnershipFactory<IslandPlacementPreset> islandOwnershipFactory;
    private final MembershipFactory<ProfileId> membershipFactory;
    private final LevelSystemFactory levelSystemFactory;

    public BasePlayerIslandFactory(IslandOwnershipFactory<IslandPlacementPreset> islandOwnershipFactory,
                                   MembershipFactory<ProfileId> membershipFactory,
                                   LevelSystemFactory levelSystemFactory) {
        this.islandOwnershipFactory = islandOwnershipFactory;
        this.membershipFactory = membershipFactory;
        this.levelSystemFactory = levelSystemFactory;
    }

    @Override
    public PlayerIsland create(PlayerIslandFactoryContext context) {
        PlayerIslandData playerIslandData = createPlayerIslandData(context);
        return new PlayerIsland(context.getProfileId(), playerIslandData);
    }

    private PlayerIslandData createPlayerIslandData(PlayerIslandFactoryContext context){
        IslandOwnership islandOwnership = islandOwnershipFactory.create(context.getPreset());
        Membership membership = membershipFactory.create(context.getProfileId());
        LevelSystem levelSystem = levelSystemFactory.create();
        setupIslandOwnership(islandOwnership, membership); // TODO: сделать адекватно
        return new PlayerIslandData(islandOwnership, membership, levelSystem);
    }

    private void setupIslandOwnership(IslandOwnership islandOwnership, Membership membership){
        Collection<Island> islands = islandOwnership.getIslands();
        islands.forEach(island->island.setMembership(membership));
    }
}
