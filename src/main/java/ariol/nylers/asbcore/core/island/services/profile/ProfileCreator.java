package ariol.nylers.asbcore.core.island.services.profile;

import ariol.nylers.asbcore.core.island.profile.MetaProfile;
import ariol.nylers.asbcore.core.island.profile.Profile;
import ariol.nylers.asbcore.core.island.services.profile.cache.ProfileCacheFacade;
import ariol.nylers.asbcore.db.DBSaver;

import java.util.UUID;

public class ProfileCreator {

    private final ProfileFactory<UUID> profileFactory;
    private final ProfileCacheFacade cacheFacade;
    private final DBSaver<Profile> profileSaver;

    public ProfileCreator(ProfileFactory<UUID> profileFactory,
                          ProfileCacheFacade cacheFacade,
                          DBSaver<Profile> profileSaver) {
        this.profileFactory = profileFactory;
        this.cacheFacade = cacheFacade;
        this.profileSaver = profileSaver;
    }

    public void createNewProfile(UUID playerId){
        Profile profile = profileFactory.create(playerId);
        MetaProfile metaProfile = profile.getMetaData();

        cacheFacade.metaProfileCache().put(playerId, metaProfile);
        cacheFacade.selectedMetaProfileRegistry().selectProfile(playerId, metaProfile);
        cacheFacade.profileCache().put(profile);
        profileSaver.save(profile);
    }
}
