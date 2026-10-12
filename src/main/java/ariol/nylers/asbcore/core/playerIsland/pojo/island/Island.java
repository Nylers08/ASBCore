package ariol.nylers.asbcore.core.playerIsland.pojo.island;

import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

public class Island {

    @Getter
    private final IslandId islandId;

    @Getter @Setter @Delegate
    private IslandContext context;

    @Getter @Setter
    private Membership membership;

    @Getter @Setter
    private IslandSettings settings;

    public Island(IslandContext context, Membership membership, IslandSettings settings){
        this.islandId = IslandId.generateIslandId();
        this.context = context;
        this.membership = membership;
    }

    public Island(IslandId islandId, IslandContext context, Membership membership, IslandSettings settings){
        this.islandId = islandId;
        this.context = context;
        this.membership = membership;
    }
}
