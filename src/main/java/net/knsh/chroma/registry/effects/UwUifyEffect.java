package net.knsh.chroma.registry.effects;

import net.knsh.chroma.Chroma;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class UwUifyEffect extends StatusEffect {
    public UwUifyEffect() {
        super(
                StatusEffectCategory.NEUTRAL,
                0xf59ffc);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            Chroma.LOGGER.info("Effect added to " + entity.getEntityName());
        }
    }
}
