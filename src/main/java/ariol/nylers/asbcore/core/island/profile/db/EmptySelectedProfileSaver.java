package ariol.nylers.asbcore.core.island.profile.db;

import ariol.nylers.asbcore.core.island.profile.MetaProfile;
import ariol.nylers.asbcore.db.DBSaver;

import java.sql.Connection;

public class EmptySelectedProfileSaver implements DBSaver<MetaProfile> {
    @Override
    public void save(MetaProfile metaData) {

    }

    @Override
    public void save(MetaProfile metaData, Connection conn) {

    }
}
