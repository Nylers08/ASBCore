package ariol.nylers.asbcore.core.playerIsland.members;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Member {

    @Getter private final UUID uuid;
    @Getter @Setter private MemberRole role;
    @Getter @Setter private List<MemberPerms> perms;

    public Member(){
        this.uuid = UUID.randomUUID();
        this.role = MemberRole.GUEST;
        this.perms = new ArrayList<>();
    }

    public Member(@NotNull MemberRole role){
        this.uuid = UUID.randomUUID();
        this.role = role;
        this.perms = new ArrayList<>();
    }

    public Member(@NotNull MemberRole role, @NotNull List<MemberPerms> perms){
        this.uuid = UUID.randomUUID();
        this.role = role;
        this.perms = perms;
    }

    public Member(@NotNull UUID uuid, @NotNull MemberRole role, @NotNull List<MemberPerms> perms){
        this.uuid = uuid;
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
