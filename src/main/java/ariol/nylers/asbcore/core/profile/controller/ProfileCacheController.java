package ariol.nylers.asbcore.core.profile.controller;

import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.cache.ProfileCache;

import java.util.Collection;

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
}
