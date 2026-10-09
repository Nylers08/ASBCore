package ariol.nylers.asbcore.core.island.playerIsland;

import ariol.nylers.asbcore.core.AbstractId;

import java.util.UUID;

public class IslandId extends AbstractId {

    public IslandId(){}

    public IslandId(UUID islandId){
        super(islandId);
    }

    public static IslandId generateIslandId(){
        return new IslandId(UUID.randomUUID());
    }
}
