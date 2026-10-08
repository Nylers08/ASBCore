package ariol.nylers.asbcore.core.island.members;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum MemberPerms {

    BLOCK_PLACE("BU"),
    BLOCK_BREAK("BR"),
    CHEST_ACCESS("O"),
    KICK("K"),
    INVITE("I"),
    MOB_DAMAGE("MK"),
    PLAYER_DAMAGE("PK"),
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
