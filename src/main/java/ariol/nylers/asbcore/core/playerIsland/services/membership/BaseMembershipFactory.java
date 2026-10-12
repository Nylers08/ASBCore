package ariol.nylers.asbcore.core.playerIsland.services.membership;

import ariol.nylers.asbcore.core.playerIsland.pojo.members.Member;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.MemberRole;
import ariol.nylers.asbcore.core.playerIsland.pojo.members.Membership;
import ariol.nylers.asbcore.core.profile.ProfileId;

public class BaseMembershipFactory implements MembershipFactory<ProfileId>{

    @Override
    public Membership create(ProfileId ownerId) {
        Member owner = new Member(ownerId, MemberRole.OWNER);
        return new Membership(owner);
    }
}
