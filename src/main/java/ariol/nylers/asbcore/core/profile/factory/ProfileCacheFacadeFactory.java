package ariol.nylers.asbcore.core.profile.factory;

import ariol.nylers.asbcore.core.profile.modules.ProfileCaches;

public interface ProfileCacheFacadeFactory<Param>{

    ProfileCaches create(Param param);
}
