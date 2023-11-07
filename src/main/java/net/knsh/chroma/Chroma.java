package net.knsh.chroma;

import net.fabricmc.api.ModInitializer;
import net.knsh.chroma.network.ChromaC2S;
import net.knsh.chroma.registry.*;
import net.knsh.chroma.util.DrunkifyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chroma implements ModInitializer {
	public static final String MOD_ID = "chroma";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Chroma has Loaded.");

		ChromaItems.register();
		ChromaEffects.register();
		ChromaPotions.register();
		ChromaCommands.register();
		ChromaEvents.register();
		ChromaC2S.register();

		DrunkifyMessage.register();
	}
}