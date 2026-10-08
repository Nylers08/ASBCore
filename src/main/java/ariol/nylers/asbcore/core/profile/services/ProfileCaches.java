package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.cache.MetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.PlayerMetaProfileCache;
import ariol.nylers.asbcore.core.profile.cache.ProfileCache;
import ariol.nylers.asbcore.core.profile.cache.SelectedMetaProfileRegistry;

public record ProfileCaches(
        PlayerMetaProfileCache playerMetaProfileCache,
        MetaProfileCache metaProfileCache,
        SelectedMetaProfileRegistry selectedMetaProfileRegistry,
        ProfileCache profileCache) {

}
