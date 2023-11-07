package net.knsh.chroma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.knsh.chroma.Chroma;
import net.knsh.chroma.registry.ChromaItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ItemModels extends FabricModelProvider {
    public ItemModels(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ChromaItems.BEER, item("mug_template"));
        itemModelGenerator.register(ChromaItems.ALCOHOLIC_DRINK, item("glass_template"));
        itemModelGenerator.register(ChromaItems.MYSTERIOUS_SHOTGLASS, item("shotglass_template"));
    }

    public static Model item(String parent) {
        return new Model(Optional.of(new Identifier(Chroma.MOD_ID, "item/" + parent)), Optional.empty());
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}
}
