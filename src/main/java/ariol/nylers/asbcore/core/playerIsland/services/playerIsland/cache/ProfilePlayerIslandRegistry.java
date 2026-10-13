package ariol.nylers.asbcore.core.playerIsland.services.playerIsland.cache;

import ariol.nylers.asbcore.core.playerIsland.pojo.PlayerIsland;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProfilePlayerIslandRegistry {

    private final Map<ProfileId, PlayerIsland> registry = new HashMap<>();


    public void register(PlayerIsland playerIsland){
        registry.put(playerIsland.getOwnerId(), playerIsland);
    }

    public void registerAll(Collection<PlayerIsland> playerIslands){
        playerIslands.forEach(this::register);
    }


    public void unregister(ProfileId profileId){
        registry.remove(profileId);
    }

    public void unregister(PlayerIsland playerIsland){
        registry.remove(playerIsland.getOwnerId());
    }

    public void unregisterAll(Collection<PlayerIsland> playerIslands){
        playerIslands.forEach(this::unregister);
    }

    public void unregisterByIds(Collection<ProfileId> profileIds){
        profileIds.forEach(this::unregister);
    }

    public void clear(){
        registry.clear();
    }


    public PlayerIsland get(ProfileId profileId){
        return registry.get(profileId);
    }

    public int size(){
        return registry.size();
    }


    public boolean contains(ProfileId profileId){
        return registry.containsKey(profileId);
    }

    public boolean contains(PlayerIsland playerIsland){
        return contains(playerIsland.getOwnerId());
    }
}
