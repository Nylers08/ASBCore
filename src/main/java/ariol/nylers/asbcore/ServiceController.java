package ariol.nylers.asbcore;

import ariol.nylers.asbcore.core.profile.ProfileModule;
import ariol.nylers.asbcore.core.island.services.region.MemberPermParser;
import lombok.Getter;

public class ServiceController {

    @Getter private final ProfileModule profileModule = new ProfileModule();
    @Getter private final MemberPermParser memberPermParser = new MemberPermParser();

}
