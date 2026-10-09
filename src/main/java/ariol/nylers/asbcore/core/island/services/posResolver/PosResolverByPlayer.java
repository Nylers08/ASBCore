package ariol.nylers.asbcore.core.island.services.posResolver;

import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PosResolverByPlayer implements IslandPosResolver<UUID>{

    @Override
    public Location resolve(UUID playerId) {
        Player player = Bukkit.getPlayer(playerId);
        if(player == null){
            return new Location(null, 0, 0 ,0);
        };

        return player.getLocation();
    }
}
