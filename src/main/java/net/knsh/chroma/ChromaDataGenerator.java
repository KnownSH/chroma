package net.knsh.chroma;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.knsh.chroma.datagen.EnLangProvider;
import net.knsh.chroma.datagen.ItemModels;

public class ChromaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(EnLangProvider::new);
		fabricDataGenerator.addProvider(ItemModels::new);
	}
}
