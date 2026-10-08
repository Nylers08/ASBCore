package ariol.nylers.asbcore.core.profile.controller;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.cache.MetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.PlayerMetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;

import java.util.Collection;

public class MetaProfileCacheController {

    private final PlayerMetaProfileCache playerMetaProfileCache;
    private final MetaProfileCache metaProfileCache;
    private final SelectedMetaProfileRegistry selectedMetaProfileRegistry;

    public MetaProfileCacheController(
            PlayerMetaProfileCache playerMetaProfileCache,
            MetaProfileCache metaProfileCache,
            SelectedMetaProfileRegistry selectedMetaProfileRegistry) {

        this.playerMetaProfileCache = playerMetaProfileCache;
        this.metaProfileCache = metaProfileCache;
        this.selectedMetaProfileRegistry = selectedMetaProfileRegistry;
    }


    public void cache(MetaProfile metaProfile){
        playerMetaProfileCache.put(metaProfile, metaProfile.getPlayerUuid());
        metaProfileCache.put(metaProfile);
    }

    public void cacheAll(Collection<MetaProfile> profiles){
        profiles.forEach(this::cache);
    }

    public void select(MetaProfile profile){
        selectedMetaProfileRegistry.selectProfile(profile.getPlayerUuid(), profile);
    }

    public void cacheAndSelect(MetaProfile metaProfile){
        cache(metaProfile);
        select(metaProfile);
    }


    public void remove(MetaProfile metaProfile){
        playerMetaProfileCache.removeByKey(metaProfile);
        metaProfileCache.remove(metaProfile.getProfileId());
        selectedMetaProfileRegistry.remove(metaProfile.getPlayerUuid());
    }

    public void remove(Collection<MetaProfile> profiles){
        profiles.forEach(this::remove);
    }
}
