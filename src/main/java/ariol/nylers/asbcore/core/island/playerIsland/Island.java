package ariol.nylers.asbcore.core.island.playerIsland;

import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import lombok.Getter;
import lombok.experimental.Delegate;
import org.bukkit.World;

public class Island {

    @Getter
    private IslandId islandId;

    @Getter @Delegate
    private IslandContext context;

    @Getter
    private Membership membership;


    public Island(){}

    public Island(IslandContext context, Membership membership){
        this.islandId = IslandId.generateIslandId();
        this.context = context;
        this.membership = membership;
    }

    public Island(IslandId islandId, IslandContext context, Membership membership){
        this.islandId = islandId;
        this.context = context;
        this.membership = membership;
    }
}
