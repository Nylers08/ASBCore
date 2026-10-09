package ariol.nylers.asbcore.core.island.region;

import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import lombok.Getter;
import org.bukkit.Location;

import java.util.UUID;

public class IslandRegion {

    @Getter private final UUID uuid;
    @Getter private IslandLocalLocation minLocalPos;
    @Getter private IslandLocalLocation maxLocalPos;

    public IslandRegion(IslandLocalLocation minLocalPos, IslandLocalLocation maxLocalPos){
        this.uuid = UUID.randomUUID();
        this.minLocalPos = minLocalPos;
        this.maxLocalPos = maxLocalPos;
    }

    public IslandRegion(UUID uuid, IslandLocalLocation minLocalPos, IslandLocalLocation maxLocalPos){
        this.uuid = uuid;
        this.minLocalPos = minLocalPos;
        this.maxLocalPos = maxLocalPos;
    }

    public void setOrigin(Location origin){
        minLocalPos.setOrigin(origin);
        maxLocalPos.setOrigin(origin);
    }
}
