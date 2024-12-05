package moe.yuyui.mcstreamerbot;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        MCStreamerBot.LOG.info("MCStreamerBot is client-sided only!");
    }

    public void init(FMLInitializationEvent event) {}
}
