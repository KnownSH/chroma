package net.knsh.chroma.registry;

import net.knsh.chroma.Chroma;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChromaPotions {
    public static PotionsType UWUIFY_POTION = register("uwuification_potion", ChromaEffects.UWUIFY_EFFECT);

    private static PotionsType register(String name, StatusEffect effect) {
        return new PotionsType(
                Registry.register(Registry.POTION, new Identifier(Chroma.MOD_ID, name), new Potion(new StatusEffectInstance(effect, 3600))),
                Registry.register(Registry.POTION, new Identifier(Chroma.MOD_ID, "long_" + name), new Potion(new StatusEffectInstance(effect, 9600))),
                Registry.register(Registry.POTION, new Identifier(Chroma.MOD_ID, "strong_" + name), new Potion(new StatusEffectInstance(effect, 1800, 1)))
        );
    }

    public static void register() {}

    public record PotionsType(Potion standard, Potion longer, Potion strong) {}
}
