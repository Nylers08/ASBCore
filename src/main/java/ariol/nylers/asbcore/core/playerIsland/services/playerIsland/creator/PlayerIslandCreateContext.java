package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.creator;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import lombok.Getter;

import java.util.UUID;

public class PlayerIslandCreateContext {

    @Getter
    private final UUID playerId;

    @Getter
    private final IslandPlacementPreset preset;

    public PlayerIslandCreateContext(UUID playerId, IslandPlacementPreset preset) {
        this.playerId = playerId;
        this.preset = preset;
    }
}
