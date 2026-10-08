package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.exception.ASBPlayerOffline;
import ariol.nylers.asbcore.core.island.playerIsland.PlayerIsland;
import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.ProfileData;
import ariol.nylers.asbcore.core.profile.ProfileId;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.time.Duration;
import java.util.UUID;

public class TempProfileFactory implements ProfileFactory<UUID>{
    @Override
    public Profile create(UUID playerId) {
        MetaProfile metaData = new MetaProfile(
                ProfileId.randomId(),
                playerId,
                "test",
                Duration.ZERO,
                0
        );

        PlayerInventory inventory = getPlayerInventory(playerId);
        ProfileData data = new ProfileData(new PlayerIsland(), inventory);
        return new Profile(metaData, data);
    }

    private PlayerInventory getPlayerInventory(UUID playerId){
        Player player = Bukkit.getPlayer(playerId);
        if(player == null){
            throw new ASBPlayerOffline("Невозможно получить инвентарь игрока, т.к он не в сети");
        }
        return player.getInventory();
    }
}
