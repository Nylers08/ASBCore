package ariol.nylers.asbcore.core.profile.cache;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MetaProfileCache {

    private final Map<ProfileId, MetaProfile> cache = new HashMap<>();

    public void put(MetaProfile metaProfile){
        cache.put(metaProfile.getProfileId(), metaProfile);
    }

    public void putAll(Collection<MetaProfile> profiles){
        profiles.forEach(this::put);
    }


    public void remove(ProfileId profileId){
        cache.remove(profileId);
    }

    public void remove(Profile profile){
        remove(profile.getProfileId());
    }


    public MetaProfile get(ProfileId profileId){
        return cache.get(profileId);
    }


    public boolean contains(ProfileId profileId){
        return cache.containsKey(profileId);
    }

    public boolean contains(MetaProfile metaProfile){
        return contains(metaProfile.getProfileId());
    }

    public boolean isEmpty(){
        return cache.isEmpty();
    }

    public int size(){
        return cache.size();
    }
}
