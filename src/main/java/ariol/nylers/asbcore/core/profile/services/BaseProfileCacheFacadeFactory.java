package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.cache.MetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.PlayerMetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.ProfileCache;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;

public class BaseProfileCacheFacadeFactory implements ProfileCacheFacadeFactory<Object>{

    @Override
    public ProfileCaches create(Object o) {
        PlayerMetaProfileCache playerMetaProfileCache = new PlayerMetaProfileCache();
        MetaProfileCache metaProfileCache = new MetaProfileCache();
        SelectedMetaProfileRegistry selectedMetaProfileRegistry = new SelectedMetaProfileRegistry();
        ProfileCache profileCache = new ProfileCache();

        return new ProfileCaches(
                playerMetaProfileCache,
                metaProfileCache,
                selectedMetaProfileRegistry,
                profileCache
        );
    }
}
