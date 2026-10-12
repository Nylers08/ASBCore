package ariol.nylers.asbcore.core.playerIsland.services.membership;

import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;

public interface MembershipFactory<CreateContext> {

    Membership create(CreateContext createContext);
}
