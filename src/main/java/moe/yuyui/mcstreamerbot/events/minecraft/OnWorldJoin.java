package moe.yuyui.mcstreamerbot.events.minecraft;

import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moe.yuyui.mcstreamerbot.Config;
import moe.yuyui.mcstreamerbot.MCStreamerBot;
import moe.yuyui.mcstreamerbot.common.EventListener;
import moe.yuyui.mcstreamerbot.common.WSServer;

public class OnWorldJoin {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unused")
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity == Minecraft.getMinecraft().thePlayer && Minecraft.getMinecraft()
            .isIntegratedServerRunning() && event.world.isRemote) {
            if (MCStreamerBot.eventListener != null) {
                if (MCStreamerBot.eventListener.isAlive()) {
                    return;
                }
            }
            try {
                MCStreamerBot.eventListener = new EventListener(
                    new WSServer(new InetSocketAddress(Config.ipAddress, Config.portNumber), Config.authToken));
            } catch (NoSuchAlgorithmException e) {
                MCStreamerBot.LOG.error("Your computer does not support SHA-256 hashing");
            }
        }
    }
}
