package ariol.nylers.asbcore.core.playerIsland.services.posResolver;

import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PosResolverByPlayer implements IslandPosResolver{

    @Getter private final UUID playerUUID;

    public PosResolverByPlayer(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    @Override
    public IslandLocalLocation resolve() {
        Player player = Bukkit.getPlayer(playerUUID);
        if(player == null){
            return new IslandLocalLocation(null, 0,0,0);
        }
        Location origin = player.getLocation();
        return new IslandLocalLocation(origin, 0, 0 ,0);
    }
}
