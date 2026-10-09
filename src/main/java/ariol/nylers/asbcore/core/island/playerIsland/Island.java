package ariol.nylers.asbcore.core.island.playerIsland;

import ariol.nylers.asbcore.core.island.members.Membership;
import ariol.nylers.asbcore.core.island.region.IslandRegion;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import lombok.Getter;

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
    private IslandLocalLocation homeLocation;


    public Island(){}

    public Island(Clipboard clipboard, IslandRegion region, Membership membership, IslandLocalLocation homeLocation){
        this.islandId = IslandId.generateIslandId();
        this.clipboard = clipboard;
        this.region = region;
        this.membership = membership;
        this.homeLocation = homeLocation;
    }

    public Island(IslandId islandId, Clipboard clipboard, IslandRegion region, Membership membership, IslandLocalLocation homeLocation){
        this.islandId = islandId;
        this.clipboard = clipboard;
        this.region = region;
        this.membership = membership;
        this.homeLocation = homeLocation;
    }
}
