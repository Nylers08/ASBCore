package ariol.nylers.asbcore.core.playerIsland.pojo;

import ariol.nylers.asbcore.core.AbstractId;

import java.util.UUID;

public class PlayerIslandId extends AbstractId {

    public PlayerIslandId(UUID uuid){
        super(uuid);
    }

    public static PlayerIslandId generateId(){
        return new PlayerIslandId(UUID.randomUUID());
    }
}
