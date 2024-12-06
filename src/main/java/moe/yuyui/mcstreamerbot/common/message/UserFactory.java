package moe.yuyui.mcstreamerbot.common.message;

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
            return "\u2734"; // ✴
        }
        if (_userBean.getIsModerator()) {
            return "\u265F"; // ♟
        }
        if (_userBean.getIsMember()) {
            return "\u2764"; // ❤
        }
        return "";
    }

    public IChatComponent buildUserPrefix() {
        return new ChatComponentText(String.format("%s[%s] ", getUserBadge(), _userBean.getName()))
            .setChatStyle(getUserColor());
    }
}
