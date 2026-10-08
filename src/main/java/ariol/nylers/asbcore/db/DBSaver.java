package ariol.nylers.asbcore.db;

import java.sql.Connection;

public interface DBSaver<Obj> {

    void save(Obj obj);
    void save(Obj obj, Connection conn);
}
