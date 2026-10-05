package ariol.nylers.asbcore.core.playerIsland.region;

import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import lombok.Getter;
import org.bukkit.Location;

import java.util.UUID;

public class IslandRegion {

    @Getter private final UUID uuid;
    @Getter private IslandLocalLocation minPos;
    @Getter private IslandLocalLocation maxPos;

    public IslandRegion(IslandLocalLocation minPos, IslandLocalLocation maxPos){
        this.uuid = UUID.randomUUID();
        this.minPos = minPos;
        this.maxPos = maxPos;
    }

    public IslandRegion(UUID uuid, IslandLocalLocation minPos, IslandLocalLocation maxPos){
        this.uuid = uuid;
        this.minPos = minPos;
        this.maxPos = maxPos;
    }

    public void setOrigin(Location origin){
        minPos.setOrigin(origin);
        maxPos.setOrigin(origin);
    }
}
