package ariol.nylers.asbcore.core.profile.services;

import ariol.nylers.asbcore.core.profile.Profile;

public interface ProfileFactory<Param> {

    Profile create(Param param);
}
