package ariol.nylers.asbcore.core.island.profile;

import ariol.nylers.asbcore.core.island.playerIsland.PlayerIsland;
import lombok.Getter;
import org.bukkit.inventory.PlayerInventory;

public record ProfileData(
        PlayerIsland playerIsland,
        PlayerInventory playerInventory
) {
}
