package ariol.nylers.asbcore.core.profile.db;

import ariol.nylers.asbcore.core.profile.Profile;
import ariol.nylers.asbcore.db.DBSaver;

import java.sql.Connection;

public class EmptyProfileSaver implements DBSaver<Profile> {

    @Override
    public void save(Profile profile) {

    }

    @Override
    public void save(Profile profile, Connection conn) {

    }
}
