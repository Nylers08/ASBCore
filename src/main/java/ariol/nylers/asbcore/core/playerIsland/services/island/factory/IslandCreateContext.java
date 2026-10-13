package ariol.nylers.asbcore.core.playerIsland.services.island.factory;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import lombok.Getter;
import org.bukkit.World;

import java.util.Objects;

public class IslandCreateContext {

    @Getter
    private final World world;

    @Getter
    private final ClipboardId clipboardId;

    @Getter
    private final Membership membership;

    public IslandCreateContext(World world, ClipboardId clipboardId, Membership membership) {
        this.world = world;
        this.clipboardId = clipboardId;
        this.membership = Objects.requireNonNull(membership, "Membership cannot be null");
    }
}
