package net.knsh.chroma.client;

import net.fabricmc.api.ClientModInitializer;
import net.knsh.chroma.network.ChromaS2C;
import net.knsh.chroma.registry.client.ChromaColorProviders;
import net.knsh.chroma.registry.client.ChromaEvents;

public class ChromaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ChromaS2C.register();
		ChromaColorProviders.register();
		ChromaEvents.register();
	}
}