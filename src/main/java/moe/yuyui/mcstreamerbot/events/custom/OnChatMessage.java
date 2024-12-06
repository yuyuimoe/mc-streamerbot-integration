package moe.yuyui.mcstreamerbot.events.custom;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;

import moe.yuyui.mcstreamerbot.common.beans.MessageBean;
import moe.yuyui.mcstreamerbot.common.beans.UserBean;
import moe.yuyui.mcstreamerbot.common.message.ChatMessageFactory;

public final class OnChatMessage {

    public static void sendMessage(List<MessageBean> messageParts, long timestamp, UserBean user) {
        if (messageParts == null) {
            return;
        }
        final IChatComponent message = new ChatMessageFactory(messageParts, user, timestamp).buildChatMessage();
        Minecraft.getMinecraft().thePlayer.addChatMessage(message);
    }
}
