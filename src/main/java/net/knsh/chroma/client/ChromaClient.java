package net.knsh.chroma.client;

import net.fabricmc.api.ClientModInitializer;
import net.knsh.chroma.network.ChromaS2C;

public class ChromaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ChromaS2C.register();
	}
}