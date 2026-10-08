package ariol.nylers.asbcore.core.island.services.region;

import ariol.nylers.asbcore.core.island.members.MemberPerms;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;

public class MemberPermParser {

    private final BiMap<MemberPerms, StateFlag> parserMap = HashBiMap.create();

    public MemberPermParser(){
        init();
    }

    private void init(){
        put(MemberPerms.BLOCK_PLACE, Flags.BLOCK_PLACE);
        put(MemberPerms.BLOCK_BREAK, Flags.BLOCK_BREAK);
        put(MemberPerms.MOB_DAMAGE, Flags.MOB_DAMAGE);
        put(MemberPerms.PLAYER_DAMAGE, Flags.PVP);
        put(MemberPerms.ITEM_PICKUP, Flags.ITEM_PICKUP);
        put(MemberPerms.ITEM_DROP, Flags.ITEM_DROP);
        put(MemberPerms.CHEST_ACCESS, Flags.CHEST_ACCESS);
    }

    public void put(MemberPerms perm, StateFlag flag){
        parserMap.put(perm, flag);
    }

    public void remove(MemberPerms perm){
        parserMap.remove(perm);
    }

    public void remove(StateFlag stateFlag){
        parserMap.inverse().remove(stateFlag);
    }

    public StateFlag getFlag(MemberPerms perm){
        return parserMap.get(perm);
    }

    public MemberPerms getPerm(StateFlag flag){
        return parserMap.inverse().get(flag);
    }
}
