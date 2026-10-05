package ariol.nylers.asbcore.core.playerIsland.members;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum MemberPerms {

    BUILD("BU"),
    BREAK("BR"),
    OPEN("O"),
    KICK("K"),
    INVITE("I"),
    MOB_KILL("MK"),
    PLAYER_KILL("PK"),
    REDSTONE_USE("RU"),
    ITEM_USE("IU"),
    ITEM_DROP("ID"),
    ITEM_PICKUP("IP");

    @Getter
    private final String code;

    private static final Map<String, MemberPerms> BY_CODE = new HashMap<>();

    static {
        for (MemberPerms perm : values()) {
            BY_CODE.put(perm.code, perm);
        }
    }

    MemberPerms(String code){
        this.code = code;
    }

    public static MemberPerms fromCode(String code) {
        return BY_CODE.get(code);
    }
}
