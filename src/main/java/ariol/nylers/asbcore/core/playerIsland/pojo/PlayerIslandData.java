package ariol.nylers.asbcore.core.playerIsland.pojo;

import ariol.nylers.asbcore.core.playerIsland.pojo.levelSystem.LevelSystem;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import lombok.Getter;
import lombok.Setter;

public class PlayerIslandData {

    @Getter @Setter
    private IslandOwnership islandOwnership;

    @Getter @Setter
    private Membership membership;

    @Getter @Setter
    private LevelSystem levelSystem;


    public PlayerIslandData(IslandOwnership islandOwnership, Membership membership, LevelSystem levelSystem) {

        this.islandOwnership = islandOwnership;
        this.membership = membership;
        this.levelSystem = levelSystem;
    }
}
