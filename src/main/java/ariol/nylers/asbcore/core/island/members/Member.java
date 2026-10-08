package ariol.nylers.asbcore.core.island.members;

import ariol.nylers.asbcore.core.island.profile.ProfileId;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Member {

    @Getter private ProfileId profileId;
    @Getter private final MemberId memberId;
    @Getter @Setter private MemberRole role;
    @Getter @Setter private List<MemberPerms> perms;

    public Member(){
        this.memberId = MemberId.randomId();
        this.profileId = new ProfileId();
        this.role = MemberRole.GUEST;
        this.perms = new ArrayList<>();
    }

    public Member(@NotNull ProfileId profileId, @NotNull MemberRole role){
        this.memberId = MemberId.randomId();
        this.profileId = profileId;
        this.role = role;
        this.perms = new ArrayList<>();
    }

    public Member(@NotNull ProfileId profileId, @NotNull MemberRole role, @NotNull List<MemberPerms> perms){
        this.memberId = MemberId.randomId();
        this.profileId = profileId;
        this.role = role;
        this.perms = perms;
    }

    public Member(@NotNull MemberId memberId, @NotNull ProfileId profileId, @NotNull MemberRole role, @NotNull List<MemberPerms> perms){
        this.memberId = memberId;
        this.profileId = profileId;
        this.role = role;
        this.perms = perms;
    }


    public void addPerm(@NotNull MemberPerms perm){
        perms.add(perm);
    }

    public void addPerms(@NotNull Collection<MemberPerms> perms){
        this.perms.addAll(perms);
    }


    public void removePerm(@NotNull MemberPerms perm){
        perms.remove(perm);
    }

    public void removePerms(@NotNull Collection<MemberPerms> perms){
        this.perms.removeAll(perms);
    }


    public boolean hasPerm(@NotNull MemberPerms perm){
        return perms.contains(perm);
    }

}
