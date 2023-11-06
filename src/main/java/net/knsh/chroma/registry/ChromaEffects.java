package net.knsh.chroma.registry;

import net.knsh.chroma.Chroma;
import net.knsh.chroma.registry.effects.DrunkEffect;
import net.knsh.chroma.registry.effects.UwUifyEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChromaEffects {
    public static final StatusEffect UWUIFY_EFFECT = new UwUifyEffect();
    public static final StatusEffect DRUNK_EFFECT = new DrunkEffect();

    public static void register() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Chroma.MOD_ID, "uwuify"), UWUIFY_EFFECT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Chroma.MOD_ID, "drunk"), DRUNK_EFFECT);
    }
}
