package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.modules.ProfileCaches;
import ariol.nylers.asbcore.db.DBLoader;
import ariol.nylers.asbcore.db.DBSaver;

import java.util.Optional;
import java.util.UUID;

public class SelectedMetaProfileLoader {

    private final ProfileCaches cacheFacade;
    private final DBLoader<MetaProfile, UUID> selectedMetaProfileLoader;
    private final DBSaver<MetaProfile> selectedMetaProfileSaver;

    public SelectedMetaProfileLoader(ProfileCaches cacheFacade,
                                     DBLoader<MetaProfile, UUID> selectedMetaProfileLoader,
                                     DBSaver<MetaProfile> selectedMetaProfileSaver) {
        this.cacheFacade = cacheFacade;
        this.selectedMetaProfileLoader = selectedMetaProfileLoader;
        this.selectedMetaProfileSaver = selectedMetaProfileSaver;
    }

    public void loadSelectedMetaProfile(UUID playerId){
        Optional<MetaProfile> selectedMetaProfile = selectedMetaProfileLoader.load(playerId);
        MetaProfile metaProfile = selectedMetaProfile.orElseGet(() -> getFirstMetaProfile(playerId));
        cacheFacade.selectedMetaProfileRegistry().selectProfile(playerId, metaProfile);
        selectedMetaProfileSaver.save(metaProfile);
    }

    private MetaProfile getFirstMetaProfile(UUID playerId){
        return cacheFacade.playerMetaProfileCache().getKeys(playerId).iterator().next();
    }
}
