package net.knsh.chroma.mixin;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.knsh.chroma.network.ChromaS2C;
import net.knsh.chroma.network.SendPacket;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.ServerTick;
import net.knsh.chroma.util.SimplePlayerData;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class ServerTickMixin implements ServerTick {
    @Unique
    private long ticksUntil = 0;
    @Unique
    private MinecraftServer server;

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo callback) {
        if (++this.ticksUntil == 600L) {
            PlayerLookup.all(server).forEach((serverPlayerEntity -> {
                int playerAlcoholLevel = SimplePlayerData.getIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol");

                if (playerAlcoholLevel > 0) {
                    int newAlcoholLevel = playerAlcoholLevel - 1;

                    SimplePlayerData.setIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol", newAlcoholLevel);
                    ServerPlayNetworking.send(serverPlayerEntity, ChromaS2C.ALCOHOL_PACKET_ID, SendPacket.sendIntPacket(newAlcoholLevel));
                }
            }));

            this.ticksUntil = 0L;
        }
    }

    @Override
    public void chroma_1_19_2$sendServer(MinecraftServer server) {
        this.server = server;
    }
}
