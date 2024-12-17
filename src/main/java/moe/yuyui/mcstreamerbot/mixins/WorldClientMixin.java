package moe.yuyui.mcstreamerbot.mixins;

import net.minecraft.client.multiplayer.WorldClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import moe.yuyui.mcstreamerbot.MCStreamerBot;

@Mixin(WorldClient.class)
public class WorldClientMixin {

    @Inject(
        method = "Lnet/minecraft/client/multiplayer/WorldClient;sendQuittingDisconnectingPacket()V",
        at = @At("TAIL"))
    public void sendQuittingDisconnectingPacket(CallbackInfo callbackInfo) {
        if (MCStreamerBot.eventListener == null) {
            return;
        }
        try {
            MCStreamerBot.eventListener.end();
            MCStreamerBot.eventListener = null;
        } catch (InterruptedException | NullPointerException ignored) {}
    }

}
