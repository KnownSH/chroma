package net.knsh.chroma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.knsh.chroma.registry.ChromaEffects;
import net.knsh.chroma.registry.ChromaItems;
import net.knsh.chroma.registry.ChromaPotions;
import net.knsh.chroma.registry.ChromaTab;

public class EnLangProvider extends FabricLanguageProvider {
    public EnLangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        String alcohol = "item.chroma.alcohol";

        translationBuilder.add(ChromaItems.BEER, "Mug of Beer");
        translationBuilder.add(ChromaItems.ALCOHOLIC_DRINK, "Mug of Alcoholic Drink");
        translationBuilder.add(ChromaItems.MYSTERIOUS_SHOTGLASS, "Mysterious Shotglass");
        translationBuilder.add(ChromaEffects.DRUNK_EFFECT, "Drunkeness");
        translationBuilder.add(ChromaEffects.UWUIFY_EFFECT, "Uwuification");
        translationBuilder.add(ChromaTab.CHROMA_GROUP, "Chroma Brewery");
        translationBuilder.add(alcohol + ".drinking_limit", "You can't drink anymore.");
        translationBuilder.add(alcohol + ".quality.awful", "Awful Brew");
        translationBuilder.add(alcohol + ".quality.subpar", "Subpar Brew");
        translationBuilder.add(alcohol + ".quality.standard", "Standard Brew");
        translationBuilder.add(alcohol + ".quality.good", "Good Brew");
        translationBuilder.add(alcohol + ".quality.fantastic", "Fantastic Brew");
        translationBuilder.add(alcohol + ".quality.best", "Best Brew");
        translationBuilder.add("item.chroma.mysterious", "Crazy? I was crazy once.");
    }
}
