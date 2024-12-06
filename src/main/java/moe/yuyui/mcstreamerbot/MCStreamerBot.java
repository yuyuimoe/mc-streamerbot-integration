package moe.yuyui.mcstreamerbot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moe.yuyui.mcstreamerbot.common.EventListener;
import moe.yuyui.mcstreamerbot.common.SimpleChatLogger;

@Mod(
    modid = MCStreamerBot.MODID,
    version = Tags.VERSION,
    name = "MCStreamerBot",
    acceptedMinecraftVersions = "[1.7.10]",
    guiFactory = "moe.yuyui." + MCStreamerBot.MODID + ".gui.MCStreamerBotGuiFactory")
public class MCStreamerBot {

    public static final String MODID = "mcstreamerbot";
    public static final Logger LOG = LogManager.getLogger(MODID);
    public static EventListener eventListener;
    public static SimpleChatLogger CHATLOG;

    @SidedProxy(clientSide = "moe.yuyui.mcstreamerbot.ClientProxy", serverSide = "moe.yuyui.mcstreamerbot.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
