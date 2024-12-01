package moe.yuyui.mcstreamerbot.events.minecraft;

import java.net.InetSocketAddress;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.yuyui.mcstreamerbot.MinecraftStreamerBotIntegration;
import moe.yuyui.mcstreamerbot.common.EventListener;
import moe.yuyui.mcstreamerbot.common.WSServer;

public class OnWorldJoin {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity == Minecraft.getMinecraft().thePlayer && Minecraft.getMinecraft()
            .isIntegratedServerRunning() && event.world.isRemote) {
            if (MinecraftStreamerBotIntegration.eventListener != null) {
                if (MinecraftStreamerBotIntegration.eventListener.isAlive()) {
                    return;
                }
            }
            MinecraftStreamerBotIntegration.eventListener = new EventListener(
                new WSServer(new InetSocketAddress("127.0.0.1", 8080)));
        }
    }
}
