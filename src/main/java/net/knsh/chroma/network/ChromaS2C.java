package net.knsh.chroma.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.knsh.chroma.Chroma;
import net.knsh.chroma.util.PlayerDataSaver;
import net.minecraft.util.Identifier;

public class ChromaS2C {
    public static final Identifier ALCOHOL_PACKET_ID = new Identifier(Chroma.MOD_ID, "alcohol");

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(ALCOHOL_PACKET_ID, (client, handler, buf, responseSender) -> {
            if (client.player != null) {
                int alcoholLevel = buf.readInt();
                client.execute(() -> {
                    ((PlayerDataSaver) client.player).getPersistentData().putInt("alcohol", alcoholLevel);
                });
            }
        });
    }
}
