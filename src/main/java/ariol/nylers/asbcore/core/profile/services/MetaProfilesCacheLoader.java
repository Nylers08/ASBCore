package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.controller.MetaProfileCacheController;
import ariol.nylers.asbcore.core.profile.db.MetaProfileRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MetaProfilesCacheLoader {

    private final MetaProfileCacheController cacheController;
    private final MetaProfileRepository repository;

    public MetaProfilesCacheLoader(MetaProfileCacheController cacheController,
                                   MetaProfileRepository repository) {
        this.cacheController = cacheController;
        this.repository = repository;
    }

    public boolean tryCacheFromDB(UUID playerId){
        Optional<Set<MetaProfile>> optMetaDataSet = repository.findByPlayer(playerId);
        if(optMetaDataSet.isEmpty()){ // Не удалось загрузить список профилей
            return false;
        }

        // Удалось загрузить список профилей
        Set<MetaProfile> metaDataSet = optMetaDataSet.get();
        cacheController.cacheAll(metaDataSet);
        return true;
    }
}
