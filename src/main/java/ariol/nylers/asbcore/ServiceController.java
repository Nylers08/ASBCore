package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.island.services.profile.ProfileCacheServiceController;
import lombok.Getter;

public class ServiceController {

    @Getter private final ProfileCacheServiceController profileCacheServiceController = new ProfileCacheServiceController();
}
