package moe.yuyui.mcstreamerbot.common.message;

import java.text.Normalizer;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import moe.yuyui.mcstreamerbot.common.beans.UserBean;

public class UserFactory {

    private final UserBean _userBean;

    public UserFactory(UserBean userBean) {
        _userBean = userBean;
    }

    private ChatStyle getUserColor() {
        if (_userBean.getIsBroadcaster()) {
            return new ChatStyle().setColor(EnumChatFormatting.RED);
        }
        if (_userBean.getIsModerator()) {
            return new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
        }
        if (_userBean.getIsMember()) {
            return new ChatStyle().setColor(EnumChatFormatting.DARK_AQUA);
        }
        return new ChatStyle().setColor(EnumChatFormatting.RESET);
    }

    private String getUserBadge() {
        if (_userBean.getIsBroadcaster()) {
            return "✴";
        }
        if (_userBean.getIsModerator()) {
            return "♟";
        }
        if (_userBean.getIsMember()) {
            return "❤";
        }
        return "";
    }

    public IChatComponent buildUserPrefix() {
        return new ChatComponentText(
            String.format("%s[%s] ", getUserBadge(), Normalizer.normalize(_userBean.getName(), Normalizer.Form.NFKC)))
                .setChatStyle(getUserColor());
    }
}
