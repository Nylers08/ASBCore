package ariol.nylers.asbcore.core;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AbstractId {

    @Getter private UUID id;

    public AbstractId(){

    }

    public AbstractId(UUID uuid){
        this.id = uuid;
    }


    @Override
    public @NotNull String toString(){
        return id.toString();
    }
}
