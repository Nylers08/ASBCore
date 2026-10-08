package ariol.nylers.asbcore.core.island.services.profile.cache;

import ariol.nylers.asbcore.core.island.profile.MetaProfile;
import ariol.nylers.asbcore.db.DBLoader;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MetaProfilesCacheLoader {

    private final MetaProfileCache metaProfileCache;
    private final DBLoader<Set<MetaProfile>, UUID> metaProfilesLoader;

    public MetaProfilesCacheLoader(MetaProfileCache metaProfileCache,
                                   DBLoader<Set<MetaProfile>, UUID> metaProfilesLoader) {
        this.metaProfileCache = metaProfileCache;
        this.metaProfilesLoader = metaProfilesLoader;
    }

    public boolean tryCacheFromDB(UUID playerId){
        Optional<Set<MetaProfile>> optMetaDataSet = metaProfilesLoader.load(playerId);
        if(optMetaDataSet.isEmpty()){ // Не удалось загрузить список профилей
            return false;
        }

        // Удалось загрузить список профилей
        Set<MetaProfile> metaDataSet = optMetaDataSet.get();
        metaProfileCache.putAll(playerId, metaDataSet);
        return true;
    }
}
