package net.knsh.chroma.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.knsh.chroma.Chroma;
import net.knsh.chroma.registry.items.Alcohol;
import net.knsh.chroma.registry.items.MysteriousShotglass;
import net.knsh.chroma.util.AlcoholQuality;
import net.knsh.chroma.util.GlassType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChromaItems {
    public static final Item ALCOHOLIC_DRINK = new Alcohol(new FabricItemSettings().group(ChromaTab.CHROMA_GROUP),
            AlcoholQuality.Best, 10, 0xffffff, GlassType.Glass);
    public static final Item BEER = new Alcohol(new FabricItemSettings().group(ChromaTab.CHROMA_GROUP),
            AlcoholQuality.Good, 6, 0xffd333, GlassType.Mug);
    public static final Item MYSTERIOUS_SHOTGLASS = new MysteriousShotglass(new FabricItemSettings().group(ChromaTab.CHROMA_GROUP),
            AlcoholQuality.Fantastic, 0xeb9dc9, GlassType.Shotglass);

    public static void register() {
        register("alcoholic_drink", ALCOHOLIC_DRINK);
        register("beer", BEER);
        register("mysterious_shotglass", MYSTERIOUS_SHOTGLASS);
    }

    private static void register(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(Chroma.MOD_ID, name), item);
    }
}
