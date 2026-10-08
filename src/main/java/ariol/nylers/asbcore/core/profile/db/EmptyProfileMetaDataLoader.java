package ariol.nylers.asbcore.core.profile.db;

import ariol.nylers.asbcore.core.profile.MetaProfile;
import ariol.nylers.asbcore.db.DBLoader;

import java.sql.Connection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class EmptyProfileMetaDataLoader implements DBLoader<Set<MetaProfile>, UUID> {
    @Override
    public Optional<Set<MetaProfile>> load(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<Set<MetaProfile>> load(UUID uuid, Connection conn) {
        return Optional.empty();
    }
}
