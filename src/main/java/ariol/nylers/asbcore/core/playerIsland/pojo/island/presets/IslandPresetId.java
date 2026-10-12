package ariol.nylers.asbcore.core.playerIsland.pojo.island.presets;

import ariol.nylers.asbcore.core.AbstractId;

import java.util.UUID;

public class IslandPresetId extends AbstractId {

    public IslandPresetId(UUID uuid){
        super(uuid);
    }

    public static IslandPresetId generateId(){
        return new IslandPresetId(UUID.randomUUID());
    }
}
