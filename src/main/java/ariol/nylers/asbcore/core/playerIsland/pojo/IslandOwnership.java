package ariol.nylers.asbcore.core.playerIsland.pojo;

import ariol.nylers.asbcore.core.playerIsland.pojo.island.Island;
import org.bukkit.World;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IslandOwnership {

    private final Map<World, Island> islands = new HashMap<>();

    public void add(Island island){
        islands.put(island.getOrigin().getWorld(), island);
    }

    public void addAll(Collection<Island> islands){
        islands.forEach(this::add);
    }

    public void remove(World world){
        islands.remove(world);
    }

    public void remove(Island island){
        islands.remove(island.getOrigin().getWorld());
    }

    public Island get(World world){
        return islands.get(world);
    }

    public int size(){
        return islands.size();
    }

    public boolean contains(World world){
        return islands.containsKey(world);
    }

    public boolean contains(Island island){
        return islands.containsKey(island.getOrigin().getWorld());
    }

    public Collection<Island> getIslands(){
        return islands.values();
    }
}
