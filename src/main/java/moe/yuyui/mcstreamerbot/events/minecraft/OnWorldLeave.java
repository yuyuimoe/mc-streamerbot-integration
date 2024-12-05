package moe.yuyui.mcstreamerbot.events.minecraft;

import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moe.yuyui.mcstreamerbot.MCStreamerBot;

public class OnWorldLeave {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unused")
    public void onPlayerLeave(WorldEvent.Unload event) {
        if (event.world.isRemote || MCStreamerBot.eventListener == null) {
            return;
        }
        try {
            MCStreamerBot.eventListener.end();
            MCStreamerBot.eventListener = null;
        } catch (InterruptedException | NullPointerException ignored) {}

    }
}
