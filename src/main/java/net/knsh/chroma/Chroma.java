package net.knsh.chroma;

import com.tterrag.registrate.Registrate;
import net.fabricmc.api.ModInitializer;
import net.knsh.chroma.network.ChromaC2S;
import net.knsh.chroma.registry.ChromaCommands;
import net.knsh.chroma.registry.ChromaEffects;
import net.knsh.chroma.registry.ChromaItems;
import net.knsh.chroma.registry.ChromaPotions;
import net.knsh.chroma.util.DrunkifyMessage;
import net.minecraft.world.tick.SimpleTickScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chroma implements ModInitializer {
	public static final String MOD_ID = "chroma";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Chroma has Loaded.");

		ChromaItems.register(REGISTRATE);
		REGISTRATE.register();

		ChromaEffects.register();
		ChromaPotions.register();
		ChromaCommands.register();
		ChromaC2S.register();

		DrunkifyMessage.register();
	}
}