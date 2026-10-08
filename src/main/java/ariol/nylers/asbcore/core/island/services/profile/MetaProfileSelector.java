package ariol.nylers.asbcore.core.island.services.profile;

import ariol.nylers.asbcore.core.island.profile.MetaProfile;
import ariol.nylers.asbcore.core.island.services.profile.cache.ProfileCacheFacade;
import ariol.nylers.asbcore.db.DBLoader;
import ariol.nylers.asbcore.db.DBSaver;

import java.util.Optional;
import java.util.UUID;

public class MetaProfileSelector {

    private final ProfileCacheFacade cacheFacade;
    private final DBLoader<MetaProfile, UUID> selectedMetaProfileLoader;
    private final DBSaver<MetaProfile> selectedMetaProfileSaver;

    public MetaProfileSelector(ProfileCacheFacade cacheFacade,
                               DBLoader<MetaProfile, UUID> selectedMetaProfileLoader,
                               DBSaver<MetaProfile> selectedMetaProfileSaver) {
        this.cacheFacade = cacheFacade;
        this.selectedMetaProfileLoader = selectedMetaProfileLoader;
        this.selectedMetaProfileSaver = selectedMetaProfileSaver;
    }

    public void selectMetaProfile(UUID playerId){
        Optional<MetaProfile> selectedMetaProfile = selectedMetaProfileLoader.load(playerId);
        MetaProfile metaProfile = selectedMetaProfile.orElseGet(() -> getFirstMetaProfile(playerId));
        cacheFacade.selectedMetaProfileRegistry().selectProfile(playerId, metaProfile);
        selectedMetaProfileSaver.save(metaProfile);
    }

    private MetaProfile getFirstMetaProfile(UUID playerId){
        return cacheFacade.metaProfileCache().getMetaDataSet(playerId).getFirst();
    }
}
