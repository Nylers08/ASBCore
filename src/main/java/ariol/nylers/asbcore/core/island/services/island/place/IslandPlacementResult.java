package ariol.nylers.asbcore.core.island.services.island.place;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import org.bukkit.Location;

public record IslandPlacementResult(
        Island island,
        Location location
) {
}
