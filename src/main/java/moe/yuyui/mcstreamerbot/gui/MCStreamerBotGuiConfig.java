package moe.yuyui.mcstreamerbot.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import cpw.mods.fml.client.config.GuiConfig;
import moe.yuyui.mcstreamerbot.Config;
import moe.yuyui.mcstreamerbot.MCStreamerBot;

public class MCStreamerBotGuiConfig extends GuiConfig {

    public MCStreamerBotGuiConfig(GuiScreen parent) {
        super(
            parent,
            new ConfigElement<>(Config.configuration.getCategory(Config.CATEGORY_WEBSOCKET)).getChildElements(),
            MCStreamerBot.MODID,
            true,
            false,
            "Configure the Websocket.");
        titleLine2 = "Make sure you know what you're doing ;)";
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        super.actionPerformed(button);
    }
}
