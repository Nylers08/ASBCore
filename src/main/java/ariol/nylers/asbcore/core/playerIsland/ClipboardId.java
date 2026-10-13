package ariol.nylers.asbcore.core.playerIsland;

import ariol.nylers.asbcore.core.AbstractId;
import lombok.Getter;

import java.util.UUID;

public class ClipboardId {

    @Getter
    private final String id;

    public ClipboardId(String id){
        this.id = id;
    }

    public static ClipboardId generateId(){
        return new ClipboardId(UUID.randomUUID().toString());
    }
}
