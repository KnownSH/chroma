package net.knsh.chroma.registry.items;

import net.knsh.chroma.registry.ChromaEffects;
import net.knsh.chroma.util.AlcoholQuality;
import net.knsh.chroma.util.GlassType;
import net.knsh.chroma.util.TextStyles;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MysteriousShotglass extends Alcohol {
    public MysteriousShotglass(Settings settings, AlcoholQuality quality, int alcoholTint, GlassType glassType) {
        super(settings, quality, 0, alcoholTint, glassType);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.chroma.mysterious").setStyle(TextStyles.mysteriousStyle));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(ChromaEffects.UWUIFY_EFFECT, switch(this.quality) {
            case Awful -> 1200;
            case Subpar -> 2400;
            case Standard -> 3600;
            case Good -> 5000;
            case Fantastic -> 9600;
            case Best -> 19200;
        }));
        return super.finishUsing(stack, world, user);
    }
}
