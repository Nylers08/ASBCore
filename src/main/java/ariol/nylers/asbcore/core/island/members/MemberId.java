package ariol.nylers.asbcore.core.island.members;

import ariol.nylers.asbcore.core.AbstractId;

import java.util.UUID;

public class MemberId extends AbstractId {

    public MemberId(){

    }

    public MemberId(UUID uuid){
        super(uuid);
    }

    public static MemberId randomId(){
        return new MemberId(UUID.randomUUID());
    }
}
