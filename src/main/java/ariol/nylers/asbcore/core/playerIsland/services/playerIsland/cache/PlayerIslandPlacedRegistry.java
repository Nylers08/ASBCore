package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PlayerIslandPlacedRegistry {


    private final Map<PlayerIslandId, PlayerIsland> registry = new HashMap<>();


    public void register(PlayerIsland playerIsland){
        registry.put(playerIsland.getId(), playerIsland);
    }

    public void registerAll(Collection<PlayerIsland> playerIslands){
        playerIslands.forEach(this::register);
    }

    public void unregister(PlayerIslandId playerIslandId){
        registry.remove(playerIslandId);
    }

    public void unregister(PlayerIsland playerIsland){
        registry.remove(playerIsland.getId());
    }

    public void unregisterAll(Collection<PlayerIsland> playerIslands){
        playerIslands.forEach(this::unregister);
    }

    public void unregisterByIds(Collection<PlayerIslandId> islandIds){
        islandIds.forEach(this::unregister);
    }

    public void clear(){
        registry.clear();
    }


    public PlayerIsland get(PlayerIslandId islandId){
        return registry.get(islandId);
    }

    public int size(){
        return registry.size();
    }


    private boolean contains(PlayerIslandId islandId){
        return registry.containsKey(islandId);
    }

    private boolean contains(PlayerIsland playerIsland){
        return contains(playerIsland.getId());
    }
}
