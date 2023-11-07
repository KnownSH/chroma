package net.knsh.chroma.registry.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.knsh.chroma.network.ChromaC2S;

public class ChromaEvents {
    public static void register() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            ClientPlayNetworking.send(ChromaC2S.REQUEST_NBT_PACKET, PacketByteBufs.create().writeString("alcohol"));
        });
    }
}
