package ariol.nylers.asbcore.core.playerIsland.members;

import java.util.*;

public class Membership {


    private final Map<UUID, Member> members;


    public Membership(){
        members = new HashMap<>();
    }

    public Membership(Member member){
        this.members = new HashMap<>();
        add(member);
    }

    public Membership(Collection<Member> members){
        this.members = new HashMap<>();
        addAll(members);
    }

    public Membership(Map<UUID, Member> members){
        this.members = members;
    }


    public void add(Member member){
        members.put(member.getUuid(), member);
    }

    public void addAll(Collection<Member> members){
        members.forEach(this::add);
    }


    public void remove(UUID uuid){
        members.remove(uuid);
    }

    public void remove(Member member){
        remove(member.getUuid());
    }

    public void removeAllByUUID(Collection<UUID> uuids){
        uuids.forEach(this::remove);
    }

    public void removeAll(Collection<Member> members){
        members.forEach(this::remove);
    }


    public boolean has(UUID uuid){
        return members.containsKey(uuid);
    }

    public boolean has(Member member){
        return has(member.getUuid());
    }


    public Member getMember(UUID uuid){
        return members.get(uuid);
    }
}
