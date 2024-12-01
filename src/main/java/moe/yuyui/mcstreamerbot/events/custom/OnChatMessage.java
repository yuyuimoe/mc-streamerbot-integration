package moe.yuyui.mcstreamerbot.events.custom;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import moe.yuyui.mcstreamerbot.Config;
import moe.yuyui.mcstreamerbot.common.beans.MessageBean;
import moe.yuyui.mcstreamerbot.common.beans.UserBean;

public final class OnChatMessage {

    private static final String _messageFormat = "%s%s[%s]%s: %s";
    private static final String _timestampedMessageFormat = "<%s>";

    private static String buildMessage(List<MessageBean> messageParts) {
        StringBuilder finalMessage = new StringBuilder();
        for (MessageBean messagePart : messageParts) {
            if (messagePart.getEmoji() != null) {
                finalMessage.append(
                    messagePart.getEmoji()
                        .getText(),
                    messagePart.getEmoji()
                        .getStartIndex(),
                    messagePart.getEmoji()
                        .getEndIndex());
            }
            finalMessage.append(messagePart.getText());
        }
        return finalMessage.toString();
    }

    private static String getUserColor(UserBean user) {
        if (user.getIsModerator()) {
            return EnumChatFormatting.RED.toString();
        }
        if (user.getIsMember()) {
            return EnumChatFormatting.DARK_GREEN.toString();
        }
        return EnumChatFormatting.RESET.toString();
    }

    private static char getUserBadge(UserBean user) {
        if (user.getIsModerator()) {
            return '⚔';
        }
        if (user.getIsMember()) {
            return '✨';
        }
        return ' ';
    }

    public static void sendMessage(List<MessageBean> messageParts, long timestamp, UserBean user) {
        if (messageParts == null) {
            return;
        }
        final String message = buildMessage(messageParts);
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        final String formattedTime = Instant.ofEpochSecond(timestamp)
            .atZone(ZoneId.systemDefault())
            .format(dateFormatter);
        StringBuilder chatMessage = new StringBuilder();

        if (Config.addTimestamp) {
            chatMessage.append(String.format(_timestampedMessageFormat, formattedTime));
        }

        chatMessage.append(
            String.format(
                _messageFormat,
                getUserColor(user),
                getUserBadge(user),
                user.getName(),
                EnumChatFormatting.RESET.toString(),
                message.replace('§', ' ')));

        ChatComponentText chatComponentText = new ChatComponentText(chatMessage.toString());
        Minecraft.getMinecraft().ingameGUI.getChatGUI()
            .printChatMessage(chatComponentText);
    }
}
