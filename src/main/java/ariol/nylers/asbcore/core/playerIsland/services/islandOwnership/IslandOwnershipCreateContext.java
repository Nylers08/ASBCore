package ariol.nylers.asbcore.core.playerIsland.services.islandOwnership;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.presets.IslandPlacementPreset;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import lombok.Getter;

import java.util.Objects;

public class IslandOwnershipCreateContext {

    @Getter
    private final IslandPlacementPreset preset;

    @Getter
    private final Membership membership;

    public IslandOwnershipCreateContext(IslandPlacementPreset preset, Membership membership) {
        this.preset = Objects.requireNonNull(preset, "IslandPlacementPreset cannot be null");
        this.membership = Objects.requireNonNull(membership, "Membership cannot be null");
    }
}
