package ariol.nylers.asbcore.core.profile.db;

import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ProfileRepository {

    Optional<Profile> find(ProfileId id);
    Optional<Set<Profile>> findByPlayer(UUID playerId);

    void save(Profile profile);
    void delete(ProfileId profileId);
}
