package ariol.nylers.asbcore.core.island.services.island.cache;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.playerIsland.IslandId;
import lombok.Getter;
import org.bukkit.Location;

import java.util.Collection;
import java.util.stream.Collectors;

public class IslandCacheControllerImpl implements IslandCacheController{

    @Getter
    private final IslandCache islandCache;

    @Getter
    private final IslandLocationRegistry locationRegistry;

    public IslandCacheControllerImpl(IslandCache islandCache, IslandLocationRegistry locationRegistry) {
        this.islandCache = islandCache;
        this.locationRegistry = locationRegistry;
    }


    @Override
    public void cache(Island island) {
        islandCache.cache(island);
    }

    @Override
    public void cacheWithLocation(Island island, Location location) {
        cache(island);
        locationRegistry.register(island, location);
    }

    @Override
    public void remove(Island island){
        islandCache.remove(island.getIslandId());
        locationRegistry.unregister(island);
    }

    @Override
    public void removeAll(Collection<Island> islands){
        islandCache.removeAll(islands.stream().map(Island::getIslandId).collect(Collectors.toSet()));
        locationRegistry.unregisterAllIslands(islands);
    }

    @Override
    public void clear() {
        islandCache.clear();
        locationRegistry.unregisterAll();
    }


    @Override
    public boolean contains(IslandId islandId) {
        return islandCache.contains(islandId);
    }

    @Override
    public boolean isRegister(Island island) {
        return locationRegistry.contains(island);
    }

    @Override
    public boolean isRegister(Location location) {
        return locationRegistry.contains(location);
    }


    @Override
    public int cacheSize() {
        return islandCache.size();
    }

    @Override
    public int registerSize() {
        return locationRegistry.size();
    }
}
