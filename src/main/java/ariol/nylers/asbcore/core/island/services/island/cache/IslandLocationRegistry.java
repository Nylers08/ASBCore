package ariol.nylers.asbcore.core.island.services.island.cache;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.pos.IslandLocalLocation;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.bukkit.Location;

import java.util.Collection;

public class IslandLocationRegistry {

    private final BiMap<Island, Location> registry = HashBiMap.create();


    public void register(Island island, Location location){
        registry.put(island, location);
    }


    public void unregister(Island island){
        registry.remove(island);
    }

    public void unregister(Location location){
        registry.inverse().remove(location);
    }

    public void unregisterAllIslands(Collection<Island> islands){
        islands.forEach(this::unregister);
    }

    public void unregisterAllLocations(Collection<Location> locations){
        locations.forEach(this::unregister);
    }

    public void unregisterAll(){
        registry.clear();
    }


    public Island getIsland(Location location){
        return registry.inverse().get(location);
    }

    public Location getLocation(Island island){
        return registry.get(island);
    }

    public int size(){
        return registry.size();
    }


    public boolean contains(Island island){
        return registry.containsKey(island);
    }

    public boolean contains(Location location){
        return registry.inverse().containsKey(location);
    }
}
