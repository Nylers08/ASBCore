package ariol.nylers.asbcore.core.island.services.profile;

import ariol.nylers.asbcore.core.island.profile.Profile;

public interface ProfileFactory<Param> {

    Profile create(Param param);
}
