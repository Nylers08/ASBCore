package ariol.nylers.asbcore.core.profile;

import ariol.nylers.asbcore.core.AbstractId;

import java.util.UUID;

public class ProfileId extends AbstractId {

    public ProfileId(){

    }

    public ProfileId(UUID uuid){
        super(uuid);
    }

    public static ProfileId randomId(){
        return new ProfileId(UUID.randomUUID());
    }
}
