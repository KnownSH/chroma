package net.knsh.chroma.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.knsh.chroma.Chroma;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ChromaTab {
    public static final ItemGroup CHROMA_GROUP = FabricItemGroupBuilder.create(new Identifier(Chroma.MOD_ID, "chroma_group"))
            .icon(() -> new ItemStack(ChromaItems.ALCOHOLIC_DRINK))
            .build();
}
