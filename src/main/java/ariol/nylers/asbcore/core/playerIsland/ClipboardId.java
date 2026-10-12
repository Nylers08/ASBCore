package ariol.nylers.asbcore.core.playerIsland;

import ariol.nylers.asbcore.core.AbstractId;

import java.util.UUID;

public class ClipboardId extends AbstractId {

    public ClipboardId(UUID uuid){
        super(uuid);
    }

    public static ClipboardId generateId(){
        return new ClipboardId(UUID.randomUUID());
    }
}
