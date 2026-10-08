package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.controller.ProfileCacheController;
import ariol.nylers.asbcore.core.profile.db.ProfileRepository;

import java.util.UUID;

public class ProfileCreator {

    private final ProfileFactory<UUID> profileFactory;
    private final ProfileCacheController cacheController;
    private final ProfileRepository repository;

    public ProfileCreator(ProfileFactory<UUID> profileFactory,
                          ProfileCacheController cacheController,
                          ProfileRepository repository) {
        this.profileFactory = profileFactory;
        this.cacheController = cacheController;
        this.repository = repository;
    }

    public void createNewProfile(UUID playerId){
        Profile profile = profileFactory.create(playerId);
        cacheController.cacheAndSelect(profile);
        repository.save(profile);
    }
}
