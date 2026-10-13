package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIslandId;
import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

import java.util.Collection;

public class PlayerIslandCacheController {

    @Getter
    private final PlayerIslandCache cache;

    @Getter
    private final ProfilePlayerIslandRegistry registry;

    public PlayerIslandCacheController(PlayerIslandCache cache, ProfilePlayerIslandRegistry registry) {
        this.cache = cache;
        this.registry = registry;
    }


    public void cache(PlayerIsland playerIsland){
        cache.cache(playerIsland);
        registry.register(playerIsland);
    }

    public void cacheAll(Collection<PlayerIsland> playerIslands){
        cache.cacheAll(playerIslands);
        registry.registerAll(playerIslands);
    }

    public void uncache(PlayerIsland playerIsland){
        cache.remove(playerIsland);
        registry.unregister(playerIsland);
    }

    public void uncacheAll(Collection<PlayerIsland> playerIslands){
        cache.removeAll(playerIslands);
        registry.unregisterAll(playerIslands);
    }

    public void clear(){
        cache.clear();
        registry.clear();
    }


    public Collection<PlayerIsland> getAll(){
        return cache.getAll();
    }

    public PlayerIsland get(PlayerIslandId playerIslandId){
        return cache.get(playerIslandId);
    }

    public PlayerIsland getByProfileId(ProfileId profileId){
        return registry.get(profileId);
    }


    public int size(){
        return cache.size();
    }


    public boolean contains(PlayerIslandId playerIslandId){
        return cache.contains(playerIslandId);
    }

    public boolean contains(ProfileId profileId){
        return registry.contains(profileId);
    }


}
