package moe.yuyui.mcstreamerbot.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserType {

    VIEWER(0),
    SUBSCRIBER(1),
    MEMBER(2),
    MODERATOR(3),
    BROADCASTER(4);

    private final int value;
    private static final Map<Integer, UserType> map = new HashMap<>();

    UserType(int value) {
        this.value = value;
    }

    static {
        for (UserType messageType : UserType.values()) {
            map.put(messageType.value, messageType);
        }
    }

    public static UserType valueOf(int value) {
        return (UserType) map.get(value);
    }

    public int getValue() {
        return value;
    }
}
