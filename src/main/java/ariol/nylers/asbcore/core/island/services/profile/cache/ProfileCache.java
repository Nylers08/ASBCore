package ariol.nylers.asbcore.core.island.services.profile.cache;

import ariol.nylers.asbcore.core.island.profile.Profile;
import ariol.nylers.asbcore.core.island.profile.ProfileId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProfileCache {

    private final Map<ProfileId, Profile> profileCache = new HashMap<>();


    public void put(Profile profile){
        profileCache.put(profile.getProfileId(), profile);
    }

    public void putAll(Collection<Profile> profiles){
        profiles.forEach(this::put);
    }


    public void remove(ProfileId profileId){
        profileCache.remove(profileId);
    }

    public void remove(Profile profile){
        remove(profile.getProfileId());
    }


    public Profile get(ProfileId profileId){
        return profileCache.get(profileId);
    }


    public boolean has(ProfileId profileId){
        return profileCache.containsKey(profileId);
    }

    public boolean has(Profile profile){
        return has(profile.getProfileId());
    }

    public boolean isEmpty(){
        return profileCache.isEmpty();
    }

    public int size(){
        return profileCache.size();
    }
}
