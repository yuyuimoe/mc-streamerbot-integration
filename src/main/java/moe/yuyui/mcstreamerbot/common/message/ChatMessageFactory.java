package moe.yuyui.mcstreamerbot.common.message;

import java.text.Normalizer;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import com.vdurmont.emoji.EmojiParser;

import moe.yuyui.mcstreamerbot.Config;
import moe.yuyui.mcstreamerbot.common.beans.MessageBean;
import moe.yuyui.mcstreamerbot.common.beans.UserBean;

public class ChatMessageFactory {

    private final List<MessageBean> _messageParts;
    private final UserBean _userBean;
    private final long _timestamp;

    public ChatMessageFactory(List<MessageBean> messageParts, UserBean userBean, long timestamp) {
        this._messageParts = messageParts;
        this._userBean = userBean;
        this._timestamp = timestamp;
    }

    private IChatComponent buildParts() {
        StringBuilder finalMessage = new StringBuilder();
        for (MessageBean messagePart : _messageParts) {
            if (messagePart.getEmoji() != null) {
                finalMessage.append(
                    messagePart.getEmoji()
                        .getText(),
                    messagePart.getEmoji()
                        .getStartIndex(),
                    messagePart.getEmoji()
                        .getEndIndex());
            }
            if (Config.sanitizeFormatting) {
                finalMessage.append(
                    Normalizer.normalize(
                        messagePart.getText()
                            .replace("§", "\u180E"),
                        Normalizer.Form.NFKC));
                continue;
            }
            finalMessage.append(Normalizer.normalize(messagePart.getText(), Normalizer.Form.NFKC));
        }
        return new ChatComponentText(
            EmojiParser.parseToAliases(finalMessage.toString(), EmojiParser.FitzpatrickAction.IGNORE))
                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RESET));
    }

    private IChatComponent buildTimestamp() {
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        final String formattedTime = Instant.ofEpochSecond(_timestamp)
            .atZone(ZoneId.systemDefault())
            .format(dateFormatter);
        return new ChatComponentText(String.format("<%s>", formattedTime))
            .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GRAY));
    }

    public IChatComponent buildChatMessage() {
        if (Config.addTimestamp) {
            return this.buildTimestamp()
                .appendSibling(new UserFactory(this._userBean).buildUserPrefix())
                .appendSibling(buildParts());
        }
        return new UserFactory(this._userBean).buildUserPrefix()
            .appendSibling(buildParts());
    }
}
