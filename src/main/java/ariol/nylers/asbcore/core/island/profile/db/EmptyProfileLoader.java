package ariol.nylers.asbcore.core.island.profile.db;

import ariol.nylers.asbcore.core.AbstractId;
import ariol.nylers.asbcore.core.island.profile.Profile;
import ariol.nylers.asbcore.db.DBLoader;

import java.sql.Connection;
import java.util.Optional;

public class EmptyProfileLoader implements DBLoader<Profile, AbstractId> {
    @Override
    public Optional<Profile> load(AbstractId abstractId) {
        return Optional.empty();
    }

    @Override
    public Optional<Profile> load(AbstractId abstractId, Connection conn) {
        return Optional.empty();
    }
}
