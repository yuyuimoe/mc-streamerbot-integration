package moe.yuyui.mcstreamerbot;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moe.yuyui.mcstreamerbot.events.minecraft.OnWorldJoin;
import moe.yuyui.mcstreamerbot.events.minecraft.OnWorldLeave;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Config.configuration = new Configuration(event.getSuggestedConfigurationFile(), Tags.CONFIG_VERSION);
        Config.synchronizeConfiguration();

        MCStreamerBot.LOG.info("MCStreamerBot is meowing in version " + Tags.VERSION);
    }

    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new OnWorldJoin());
        MinecraftForge.EVENT_BUS.register(new OnWorldLeave());
        MCStreamerBot.LOG.info("Loaded MCStreamerBot");
    }

}
