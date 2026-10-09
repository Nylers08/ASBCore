package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.modules.ProfileCaches;

import java.util.UUID;

public class MetaProfileInit {

    private final ProfileCaches profileCaches;
    private final MetaProfilesCacheLoader cacheLoader;
    private final ProfileCreator profileCreator;
    private final SelectedMetaProfileLoader selectedMetaProfileLoader;

    public MetaProfileInit(ProfileCaches profileCaches, MetaProfilesCacheLoader cacheLoader, ProfileCreator profileCreator, SelectedMetaProfileLoader selectedMetaProfileLoader) {
        this.profileCaches = profileCaches;
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
            selectedMetaProfileLoader.loadSelectedMetaProfile(playerId);
        }
    }

    private boolean isMetaProfilesCached(UUID playerId){
        return profileCaches.playerMetaProfileCache().containsValue(playerId);
    }

    private boolean isMetaProfileSelected(UUID playerId){
        return profileCaches.selectedMetaProfileRegistry().isProfileSelected(playerId);
    }
}
