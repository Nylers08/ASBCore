package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.IslandOwnership;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandData;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPresets;
import ariol.nylers.asbcore.core.playerIsland.pojo.levelSystem.LevelSystem;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import ariol.nylers.asbcore.core.playerIsland.services.islandOwnership.IslandOwnershipFactory;
import ariol.nylers.asbcore.core.playerIsland.services.levelSystem.LevelSystemFactory;
import ariol.nylers.asbcore.core.playerIsland.services.membership.MembershipFactory;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

import java.util.UUID;

public class BasePlayerIslandFactory implements PlayerIslandFactory<PlayerIslandCreateContext> {

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
    public PlayerIsland create(PlayerIslandCreateContext context) {
        PlayerIslandData playerIslandData = createPlayerIslandData(context);
        return new PlayerIsland(context.getProfileId(), playerIslandData);
    }

    private PlayerIslandData createPlayerIslandData(PlayerIslandCreateContext context){
        IslandOwnership islandOwnership = islandOwnershipFactory.create(context.getPreset());
        Membership membership = membershipFactory.create(context.getProfileId());
        LevelSystem levelSystem = levelSystemFactory.create();
        return new PlayerIslandData(islandOwnership, membership, levelSystem);
    }
}
