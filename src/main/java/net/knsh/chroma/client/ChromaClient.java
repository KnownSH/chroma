package net.knsh.chroma.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.knsh.chroma.network.ChromaC2S;
import net.knsh.chroma.network.ChromaS2C;

public class ChromaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
			ClientPlayNetworking.send(ChromaC2S.REQUEST_NBT_PACKET, PacketByteBufs.create().writeString("alcohol"));
		});

		ChromaS2C.register();
	}
}