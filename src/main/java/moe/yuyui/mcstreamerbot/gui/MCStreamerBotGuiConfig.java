package moe.yuyui.mcstreamerbot.gui;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import moe.yuyui.mcstreamerbot.Config;
import moe.yuyui.mcstreamerbot.MCStreamerBot;

public class MCStreamerBotGuiConfig extends GuiConfig {

    public MCStreamerBotGuiConfig(GuiScreen parent) {
        super(
            parent,
            getConfigElements(),
            MCStreamerBot.MODID,
            false,
            false,
            "Configure the Streamer.bot integration.");
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

    private static List<IConfigElement> getConfigElements() {
        Configuration config = Config.configuration;
        return config.getCategoryNames()
            .stream()
            .map(name -> new ConfigElement<>(config.getCategory(name)))
            .collect(Collectors.toList());
    }
}
