package ariol.nylers.asbcore.core.profile.controller;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.ProfileId;
import ariol.nylers.asbcore.core.profile.cache.ProfileCache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProfileCacheController {

    private final MetaProfileCacheController metaProfileCacheController;
    private final ProfileCache profileCache;

    public ProfileCacheController(MetaProfileCacheController metaProfileCacheController, ProfileCache profileCache) {
        this.metaProfileCacheController = metaProfileCacheController;
        this.profileCache = profileCache;
    }

    public void cache(Profile profile){
        metaProfileCacheController.cache(profile.getMetaData());
        profileCache.put(profile);
    }

    public void cacheAll(Collection<Profile> profiles){
        profiles.forEach(this::cache);
    }

    public void select(Profile profile){
        metaProfileCacheController.select(profile.getMetaData());
    }

    public void cacheAndSelect(Profile profile){
        cache(profile);
        select(profile);
    }

    public void remove(Profile profile){
        metaProfileCacheController.remove(profile.getMetaData());
        profileCache.remove(profile);
    }

    public void removeAll(Collection<Profile> profiles){
        profiles.forEach(this::remove);
    }


    public Profile getProfile(ProfileId profileId){
        return profileCache.get(profileId);
    }

    public Profile getSelectedProfile(UUID playerId){
        MetaProfile metaProfile = metaProfileCacheController.getSelectedMetaProfile(playerId);
        return profileCache.get(metaProfile.getProfileId());
    }

    public Profile getByMetaProfile(MetaProfile metaProfile){
        return getProfile(metaProfile.getProfileId());
    }

    public UUID getPlayerId(ProfileId profileId){
        return metaProfileCacheController.getPlayerId(profileId);
    }


    public Set<Profile> getAllProfiles(UUID playerId){
        Set<MetaProfile> metaProfiles = metaProfileCacheController.getAllMetaProfiles(playerId);
        return getByMetaProfiles(metaProfiles);
    }

    public Set<Profile> getAll(Collection<ProfileId> profileIds){
        Set<Profile> profiles = new HashSet<>();
        for (ProfileId profileId : profileIds){
            Profile profile = getProfile(profileId);
            profiles.add(profile);
        }

        return profiles;
    }

    private Set<Profile> getByMetaProfiles(Collection<MetaProfile> metaProfiles){
        Set<Profile> profiles = new HashSet<>();
        for (MetaProfile metaProfile : metaProfiles){
            Profile profile = getByMetaProfile(metaProfile);
        }

        return profiles;
    }
}
