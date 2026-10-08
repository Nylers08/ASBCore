package ariol.nylers.asbcore.core.island.services.profile.cache;

import ariol.nylers.asbcore.core.island.services.profile.MetaProfileSelector;
import ariol.nylers.asbcore.core.island.services.profile.ProfileCreator;

import java.util.UUID;

public class MetaProfileInit {

    private final ProfileCacheFacade cacheFacade;
    private final MetaProfilesCacheLoader cacheLoader;
    private final ProfileCreator profileCreator;
    private final MetaProfileSelector metaProfileSelector;

    public MetaProfileInit(ProfileCacheFacade cacheFacade, MetaProfilesCacheLoader cacheLoader, ProfileCreator profileCreator, MetaProfileSelector metaProfileSelector) {
        this.cacheFacade = cacheFacade;
        this.cacheLoader = cacheLoader;
        this.profileCreator = profileCreator;
        this.metaProfileSelector = metaProfileSelector;
    }

    public void init(UUID playerId){
        if(!isMetaProfilesCached(playerId)){
            boolean isCachedFromDB = cacheLoader.tryCacheFromDB(playerId);
            if(!isCachedFromDB){
                profileCreator.createNewProfile(playerId);
            }
        }

        if(!isMetaProfileSelected(playerId)){
            metaProfileSelector.selectMetaProfile(playerId);
        }
    }

    private boolean isMetaProfilesCached(UUID playerId){
        return cacheFacade.metaProfileCache().has(playerId);
    }

    private boolean isMetaProfileSelected(UUID playerId){
        return cacheFacade.selectedMetaProfileRegistry().isProfileSelected(playerId);
    }
}
