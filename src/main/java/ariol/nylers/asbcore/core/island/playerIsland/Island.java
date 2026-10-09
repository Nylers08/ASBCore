package ariol.nylers.asbcore.core.island.playerIsland;

import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import lombok.Getter;
import org.bukkit.World;

public class Island {

    @Getter
    private IslandId islandId;

    @Getter
    private Clipboard clipboard;

    @Getter
    private IslandRegion region;

    @Getter
    private Membership membership;

    @Getter
    private World world;


    public Island(){}

    public Island(Clipboard clipboard, IslandRegion region, Membership membership, World world){
        this.islandId = IslandId.generateIslandId();
        this.clipboard = clipboard;
        this.region = region;
        this.membership = membership;
        this.world = world;
    }

    public Island(IslandId islandId, Clipboard clipboard, IslandRegion region, Membership membership, World world){
        this.islandId = islandId;
        this.clipboard = clipboard;
        this.region = region;
        this.membership = membership;
        this.world = world;
    }
}
