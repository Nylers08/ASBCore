package ariol.nylers.asbcore.core.playerIsland.pojo;

import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

public class PlayerIsland {

    @Getter
    private final PlayerIslandId id;

    @Getter @Setter
    private ProfileId ownerId;

    @Getter @Setter @Delegate
    private PlayerIslandData data;


    public PlayerIsland(){
        this.id = PlayerIslandId.generateId();
    }


    public PlayerIsland(ProfileId ownerId, PlayerIslandData data){
        this.id = PlayerIslandId.generateId();
        this.ownerId = ownerId;
        this.data = data;
    }

    public PlayerIsland(PlayerIslandId id, ProfileId ownerId, PlayerIslandData data){
        this.id = id;
        this.ownerId = ownerId;
        this.data = data;
    }
}
