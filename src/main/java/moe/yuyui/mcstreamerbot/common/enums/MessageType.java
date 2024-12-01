package moe.yuyui.mcstreamerbot.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {

    CHAT(0),
    COMMAND(1),
    LISTEN(2),
    IGNORE(3);

    private final int value;
    private static final Map<Integer, MessageType> map = new HashMap<>();

    MessageType(int value) {
        this.value = value;
    }

    static {
        for (MessageType messageType : MessageType.values()) {
            map.put(messageType.value, messageType);
        }
    }

    public static MessageType valueOf(int value) {
        return (MessageType) map.get(value);
    }

    public int getValue() {
        return value;
    }
}
