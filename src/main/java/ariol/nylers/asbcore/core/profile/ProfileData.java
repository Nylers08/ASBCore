package ariol.nylers.asbcore.core.profile;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import org.bukkit.inventory.PlayerInventory;

public record ProfileData(
        PlayerIsland playerIsland,
        PlayerInventory playerInventory
) {
}
