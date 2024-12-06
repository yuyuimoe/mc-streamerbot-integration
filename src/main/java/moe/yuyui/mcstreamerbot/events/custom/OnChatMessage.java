package moe.yuyui.mcstreamerbot.events.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;

import moe.yuyui.mcstreamerbot.common.beans.MessagePayloadBean;
import moe.yuyui.mcstreamerbot.common.message.ChatMessageFactory;

public final class OnChatMessage {

    public static void sendMessage(MessagePayloadBean payload) {
        if (payload.getParts() == null) {
            return;
        }
        final IChatComponent message = new ChatMessageFactory(
            payload.getParts(),
            payload.getUser(),
            payload.getTimestamp()).buildChatMessage();
        Minecraft.getMinecraft().thePlayer.addChatMessage(message);
    }
}
