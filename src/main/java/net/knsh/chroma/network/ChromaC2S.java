package net.knsh.chroma.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.knsh.chroma.Chroma;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.SimplePlayerData;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ChromaC2S {
    public static final Identifier REQUEST_NBT_PACKET = new Identifier(Chroma.MOD_ID, "getnbt");

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(REQUEST_NBT_PACKET, (server, player, handler, buf, responseSender) -> {
            String nbtType = buf.readString();

            if (nbtType.equals("alcohol")) {
                int newAlcoholLevel = SimplePlayerData.getIntNbt(((PlayerDataSaver) player), "alcohol");
                ServerPlayNetworking.send(player, ChromaS2C.ALCOHOL_PACKET_ID, SendPacket.sendIntPacket(newAlcoholLevel));
            }
        });
    }
}
