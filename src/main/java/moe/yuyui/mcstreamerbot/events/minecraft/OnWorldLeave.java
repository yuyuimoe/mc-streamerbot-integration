package moe.yuyui.mcstreamerbot.events.minecraft;

import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.yuyui.mcstreamerbot.MCStreamerBot;

public class OnWorldLeave {

    @SubscribeEvent
    public void onPlayerLeave(WorldEvent.Unload event) {
        try {
            MCStreamerBot.eventListener.end();
        } catch (InterruptedException | NullPointerException ignored) {}

    }
}
