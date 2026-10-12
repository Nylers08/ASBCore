package ariol.nylers.asbcore.core.playerIsland.services.island.place;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import org.bukkit.Location;

public record IslandPlacementResult(
        Island island,
        Location location
) {
}
