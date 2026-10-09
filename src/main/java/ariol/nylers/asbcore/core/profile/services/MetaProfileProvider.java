package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.ProfileId;
import ariol.nylers.asbcore.core.profile.controller.MetaProfileCacheController;
import ariol.nylers.asbcore.core.profile.db.MetaProfileRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MetaProfileProvider {

    private final MetaProfileCacheController cacheController;
    private final MetaProfileRepository repository;

    public MetaProfileProvider(MetaProfileCacheController cacheController, MetaProfileRepository repository) {
        this.cacheController = cacheController;
        this.repository = repository;
    }

    public Optional<MetaProfile> getMetaProfile(ProfileId profileId){
        MetaProfile metaProfile = cacheController.getMetaProfile(profileId);
        if(metaProfile != null){
            return Optional.of(metaProfile);
        }

        Optional<MetaProfile> optMetaProfile = repository.find(profileId);
        optMetaProfile.ifPresent(cacheController::cache);
        return optMetaProfile;
    }

    public Optional<MetaProfile> getMetaProfile(UUID playerId){
        MetaProfile metaProfile = cacheController.getSelectedMetaProfile(playerId);
        if(metaProfile != null){
            return Optional.of(metaProfile);
        }

        Optional<MetaProfile> optMetaProfile = repository.findSelectedByPlayer(playerId);;
        optMetaProfile.ifPresent(cacheController::cache);
        return optMetaProfile;
    }

    public Optional<Set<MetaProfile>> getMetaProfiles(UUID playerId){
        Set<MetaProfile> metaProfiles = cacheController.getAllMetaProfiles(playerId);
        if(metaProfiles != null){
            return Optional.of(metaProfiles);
        }

        Optional<Set<MetaProfile>> optMetaProfiles = repository.findByPlayer(playerId);
        optMetaProfiles.ifPresent(cacheController::cacheAll);
        return repository.findByPlayer(playerId);
    }

    public Optional<UUID> getPlayerId(ProfileId profileId){
        UUID playerId = cacheController.getPlayerId(profileId);
        if(playerId != null) {
            return Optional.of(playerId);
        }

        return repository.findPlayer(profileId);
    }


}
