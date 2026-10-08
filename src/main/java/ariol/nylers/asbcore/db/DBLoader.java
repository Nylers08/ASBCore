package ariol.nylers.asbcore.db;

import java.sql.Connection;
import java.util.Optional;

public interface DBLoader<Obj, Id> {

    Optional<Obj> load(Id id);
    Optional<Obj> load(Id id, Connection conn);
}
