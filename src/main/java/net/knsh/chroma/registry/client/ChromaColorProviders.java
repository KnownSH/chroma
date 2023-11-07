package net.knsh.chroma.registry.client;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.knsh.chroma.registry.ChromaItems;
import net.knsh.chroma.registry.items.Alcohol;

public class ChromaColorProviders {
    public static void register() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((Alcohol) stack.getItem()).getAlcoholColor(tintIndex),
                ChromaItems.BEER);
    }
}
