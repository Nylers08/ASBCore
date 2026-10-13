package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayerIslandCache {

    private final Map<PlayerIslandId, PlayerIsland> cacheMap = new HashMap<>();


    public void cache(PlayerIsland playerIsland){
        cacheMap.put(playerIsland.getId(), playerIsland);
    }

    public void cacheAll(Collection<PlayerIsland> playerIslands){
        playerIslands.forEach(this::cache);
    }

    public void remove(PlayerIslandId playerIslandId){
        cacheMap.remove(playerIslandId);
    }

    public void remove(PlayerIsland playerIsland){
        cacheMap.remove(playerIsland.getId());
    }

    public void removeAll(Collection<PlayerIsland> playerIslands){
        playerIslands.forEach(this::remove);
    }

    public void removeByIds(Collection<PlayerIslandId> islandIds){
        islandIds.forEach(this::remove);
    }

    public void clear(){
        cacheMap.clear();
    }


    public Collection<PlayerIsland> getAll(){
        return cacheMap.values();
    }

    public PlayerIsland get(PlayerIslandId islandId){
        return cacheMap.get(islandId);
    }

    public int size(){
        return cacheMap.size();
    }


    public boolean contains(PlayerIslandId islandId){
        return cacheMap.containsKey(islandId);
    }

    public boolean contains(PlayerIsland playerIsland){
        return contains(playerIsland.getId());
    }
}
