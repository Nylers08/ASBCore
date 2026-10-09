package ariol.nylers.asbcore.core.profile.factory;

import ariol.nylers.asbcore.core.profile.Profile;

public interface ProfileFactory<Param> {

    Profile create(Param param);
}
