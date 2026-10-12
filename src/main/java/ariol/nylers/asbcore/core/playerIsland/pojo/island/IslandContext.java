package ariol.nylers.asbcore.core.playerIsland.pojo.island;

import ariol.nylers.asbcore.core.playerIsland.pojo.region.IslandRegion;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

public class IslandContext{

    @Getter @Setter
    private Clipboard clipboard;

    @Getter @Setter
    private IslandRegion region;

    @Getter @Setter
    private Location origin;

    public IslandContext(Clipboard clipboard, IslandRegion region, Location origin) {
        this.clipboard = clipboard;
        this.region = region;
        this.origin = origin;
    }
}
