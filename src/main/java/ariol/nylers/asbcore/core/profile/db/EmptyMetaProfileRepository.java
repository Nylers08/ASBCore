package ariol.nylers.asbcore.core.profile.db;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class EmptyMetaProfileRepository implements MetaProfileRepository{
    @Override
    public Optional<MetaProfile> find(ProfileId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Set<MetaProfile>> findByPlayer(UUID playerId) {
        return Optional.empty();
    }

    @Override
    public void save(MetaProfile metaProfile) {

    }

    @Override
    public void delete(ProfileId profileId) {

    }
}
