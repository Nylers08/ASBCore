package ariol.nylers.asbcore.core.profile.db;

import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.core.profile.ProfileId;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class EmptyProfileRepository implements ProfileRepository{

    @Override
    public Optional<Profile> find(ProfileId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Set<Profile>> findByPlayer(UUID playerId) {
        return Optional.empty();
    }

    @Override
    public void save(Profile profile) {

    }

    @Override
    public void delete(ProfileId profileId) {

    }
}
