package moe.yuyui.mcstreamerbot;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moe.yuyui.mcstreamerbot.common.SimpleChatLogger;
import moe.yuyui.mcstreamerbot.events.minecraft.OnWorldJoin;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Config.configuration = new Configuration(event.getSuggestedConfigurationFile(), Tags.CONFIG_VERSION);
        Config.synchronizeConfiguration();

        MCStreamerBot.LOG.info("MCStreamerBot is meowing in version " + Tags.VERSION);
    }

    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new OnWorldJoin());
        MCStreamerBot.LOG.info("Loaded MCStreamerBot");
    }

    public void postInit(FMLPostInitializationEvent event) {
        MCStreamerBot.CHATLOG = new SimpleChatLogger(
            new ChatComponentText("[MCStreamerBot] ").setChatStyle(
                new ChatStyle().setColor(EnumChatFormatting.GRAY)
                    .setBold(true)));
    }

}
