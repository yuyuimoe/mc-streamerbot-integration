package moe.yuyui.mcstreamerbot.common;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class SimpleChatLogger {

    private final IChatComponent _prefix;

    public SimpleChatLogger(IChatComponent prefix) {
        this._prefix = prefix;
    }

    private ChatStyle reset(EnumChatFormatting color) {
        return new ChatStyle().setColor(color)
            .setBold(false)
            .setItalic(false)
            .setObfuscated(false)
            .setUnderlined(false)
            .setStrikethrough(false);
    }

    public void log(IChatComponent message) {
        if (!Minecraft.getMinecraft().theWorld.isRemote) {
            return;
        }
        Minecraft.getMinecraft().thePlayer.addChatMessage(
            this._prefix.createCopy()
                .appendSibling(message));
    }

    public void info(IChatComponent message) {
        this.log(message.setChatStyle(reset(EnumChatFormatting.DARK_GRAY)));
    }

    public void info(String message) {
        this.info(new ChatComponentText(message));
    }

    public void success(IChatComponent message) {
        this.log(message.setChatStyle(reset(EnumChatFormatting.DARK_GREEN)));
    }

    public void success(String message) {
        this.success(new ChatComponentText(message));
    }

    public void error(IChatComponent message) {
        this.log(
            new ChatComponentText("[ERROR] ").appendSibling(message)
                .setChatStyle(reset(EnumChatFormatting.DARK_RED)));
    }

    public void error(String message) {
        this.error(new ChatComponentText(message));
    }
}
