package net.knsh.chroma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.knsh.chroma.registry.ChromaEffects;
import net.knsh.chroma.registry.ChromaPotions;

public class EnLangProvider extends FabricLanguageProvider {
    public EnLangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ChromaEffects.DRUNK_EFFECT, "Drunkeness");
        translationBuilder.add(ChromaEffects.UWUIFY_EFFECT, "Uwuification");
    }
}
