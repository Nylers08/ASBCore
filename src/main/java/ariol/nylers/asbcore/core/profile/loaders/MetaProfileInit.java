package ariol.nylers.asbcore.core.profile.loaders;

import ariol.nylers.asbcore.core.profile.services.SelectedMetaProfileLoader;
import ariol.nylers.asbcore.core.profile.services.ProfileCreator;
import ariol.nylers.asbcore.core.profile.services.ProfileCaches;

import java.util.UUID;

public class MetaProfileInit {

    private final ProfileCaches cacheFacade;
    private final MetaProfilesCacheLoader cacheLoader;
    private final ProfileCreator profileCreator;
    private final SelectedMetaProfileLoader selectedMetaProfileLoader;

    public MetaProfileInit(ProfileCaches cacheFacade, MetaProfilesCacheLoader cacheLoader, ProfileCreator profileCreator, SelectedMetaProfileLoader selectedMetaProfileLoader) {
        this.cacheFacade = cacheFacade;
        this.cacheLoader = cacheLoader;
        this.profileCreator = profileCreator;
        this.selectedMetaProfileLoader = selectedMetaProfileLoader;
    }

    public void init(UUID playerId){
        if(!isMetaProfilesCached(playerId)){
            boolean isCachedFromDB = cacheLoader.tryCacheFromDB(playerId);
            if(!isCachedFromDB){
                profileCreator.createNewProfile(playerId);
            }
        }

        if(!isMetaProfileSelected(playerId)){
            selectedMetaProfileLoader.selectMetaProfile(playerId);
        }
    }

    private boolean isMetaProfilesCached(UUID playerId){
        return cacheFacade.playerMetaProfileCache().containsValue(playerId);
    }

    private boolean isMetaProfileSelected(UUID playerId){
        return cacheFacade.selectedMetaProfileRegistry().isProfileSelected(playerId);
    }
}
