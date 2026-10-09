package ariol.nylers.asbcore.core.island.services.island.cache;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.playerIsland.IslandId;
import org.bukkit.Location;

import java.util.Collection;

public interface IslandCacheController {

    void cache(Island island);
    void cacheWithLocation(Island island, Location location);

    void remove(Island island);
    void removeAll(Collection<Island> islands);
    void clear();

    boolean contains(IslandId islandId);
    boolean isRegister(Island island);
    boolean isRegister(Location location);

    int cacheSize();
    int registerSize();
}
