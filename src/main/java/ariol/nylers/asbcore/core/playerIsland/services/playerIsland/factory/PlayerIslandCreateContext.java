package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.factory;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

public class PlayerIslandCreateContext {

    @Getter
    private final ProfileId profileId;

    @Getter
    private final IslandPlacementPreset preset;

    public PlayerIslandCreateContext(ProfileId profileId, IslandPlacementPreset preset) {
        this.profileId = profileId;
        this.preset = preset;
    }
}
