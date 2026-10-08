package ariol.nylers.asbcore.core.island.members;

import java.util.*;

public class Membership {


    private final Map<MemberId, Member> members;


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

    public Membership(Map<MemberId, Member> members){
        this.members = members;
    }


    public void add(Member member){
        members.put(member.getMemberId(), member);
    }

    public void addAll(Collection<Member> members){
        members.forEach(this::add);
    }


    public void remove(MemberId memberId){
        members.remove(memberId);
    }

    public void remove(Member member){
        remove(member.getMemberId());
    }

    public void removeAllByUUID(Collection<MemberId> uuids){
        uuids.forEach(this::remove);
    }

    public void removeAll(Collection<Member> members){
        members.forEach(this::remove);
    }


    public boolean has(MemberId memberId){
        return members.containsKey(memberId);
    }

    public boolean has(Member member){
        return has(member.getMemberId());
    }


    public Member getMember(MemberId memberId){
        return members.get(memberId);
    }
}
