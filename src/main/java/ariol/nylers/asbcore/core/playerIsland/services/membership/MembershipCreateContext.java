package ariol.nylers.asbcore.core.playerIsland.services.membership;

import ariol.nylers.asbcore.core.profile.ProfileId;
import lombok.Getter;

import java.util.Collection;
import java.util.UUID;

public class MembershipCreateContext {

    @Getter
    private final ProfileId ownerId;

    @Getter
    private final Collection<ProfileId> membersIds;

    public MembershipCreateContext(ProfileId ownerId, Collection<ProfileId> membersIds) {
        this.ownerId = ownerId;
        this.membersIds = membersIds;
    }
}
