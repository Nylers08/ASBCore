package ariol.nylers.asbcore.core.island.services.island.cache;

import ariol.nylers.asbcore.core.island.playerIsland.Island;
import ariol.nylers.asbcore.core.island.playerIsland.IslandId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IslandCache {

    private final Map<IslandId, Island> cacheMap = new HashMap<>();


    public void cache(Island island){
        cacheMap.put(island.getIslandId(), island);
    }

    public void cacheAll(Collection<Island> islands){
        islands.forEach(this::cache);
    }


    public void remove(IslandId islandId){
        cacheMap.remove(islandId);
    }

    public void removeAll(Collection<IslandId> islandIds){
        islandIds.forEach(this::remove);
    }


    public boolean contains(IslandId islandId){
        return cacheMap.containsKey(islandId);
    }

    public Island get(IslandId islandId){
        return cacheMap.get(islandId);
    }


    public int size(){
        return cacheMap.size();
    }

    public void clear(){
        cacheMap.clear();
    }

}
