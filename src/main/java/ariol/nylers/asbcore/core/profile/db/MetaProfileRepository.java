package ariol.nylers.asbcore.core.profile.db;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface MetaProfileRepository {

    Optional<MetaProfile> find(ProfileId id);
    Optional<Set<MetaProfile>> findByPlayer(UUID playerId);

    void save(MetaProfile metaProfile);
    void delete(ProfileId profileId);
}
