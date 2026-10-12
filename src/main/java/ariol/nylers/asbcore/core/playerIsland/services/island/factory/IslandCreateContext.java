package ariol.nylers.asbcore.core.playerIsland.services.island.factory;

import ariol.nylers.asbcore.core.playerIsland.ClipboardId;
import ariol.nylers.asbcore.core.playerIsland.pojo.island.IslandSettings;
import lombok.Getter;
import org.bukkit.World;

public class IslandCreateContext {

    @Getter
    private final World world;

    @Getter
    private final ClipboardId clipboardId;

    public IslandCreateContext(World world, ClipboardId clipboardId) {
        this.world = world;
        this.clipboardId = clipboardId;
    }
}
