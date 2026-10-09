package ariol.nylers.asbcore.core.profile.factory;

import ariol.nylers.asbcore.core.profile.cache.MetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.PlayerMetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.ProfileCache;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;
import ariol.nylers.asbcore.core.profile.modules.ProfileCaches;

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
