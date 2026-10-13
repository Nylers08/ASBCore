package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

import java.util.Objects;

public class PlayerIslandFactoryContext {

    @Getter
    private final ProfileId profileId;

    @Getter
    private final IslandPlacementPreset preset;

    public PlayerIslandFactoryContext(ProfileId profileId, IslandPlacementPreset preset) {
        this.profileId = Objects.requireNonNull(profileId, "ProfileId cannot be null");
        this.preset = Objects.requireNonNull(preset, "IslandPlacementPreset cannot be null");
    }
}
