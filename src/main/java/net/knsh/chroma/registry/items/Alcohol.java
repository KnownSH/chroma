package net.knsh.chroma.registry.items;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.knsh.chroma.network.ChromaS2C;
import net.knsh.chroma.network.SendPacket;
import net.knsh.chroma.util.AlcoholQuality;
import net.knsh.chroma.util.GlassType;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.SimplePlayerData;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Alcohol extends HoneyBottleItem {
    private static final int ALCOHOL_LIMIT = 100;
    private final int alcoholContent;
    private final int alcoholColor;
    public final AlcoholQuality quality;
    public final GlassType glassType;

    public Alcohol(Settings settings, AlcoholQuality quality, int alcoholContent, int alcoholTint, GlassType glassType) {
        super(settings);
        this.alcoholContent = alcoholContent;
        this.alcoholColor = alcoholTint;
        this.quality = quality;
        this.glassType = glassType;
    }

    public int getAlcoholColor(int tintIndex) {
        return tintIndex == 1 ? alcoholColor: -1;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.chroma.alcohol.quality." + quality.toString().toLowerCase()).formatted(Formatting.GOLD));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            if (alcoholContent > 0) {
                int playerAlcoholLevel = SimplePlayerData.getIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol");
                int newAlcoholLevel = playerAlcoholLevel;

                if (playerAlcoholLevel + alcoholContent <= ALCOHOL_LIMIT) {
                    newAlcoholLevel += alcoholContent;
                } else {
                    newAlcoholLevel = ALCOHOL_LIMIT;
                }

                SimplePlayerData.setIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol", newAlcoholLevel);
                ServerPlayNetworking.send(serverPlayerEntity, ChromaS2C.ALCOHOL_PACKET_ID, SendPacket.sendIntPacket(newAlcoholLevel));
            }

            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }

            return stack;
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return glassType.drinkTime();
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        int playerAlcoholLevel = SimplePlayerData.getIntNbt(((PlayerDataSaver) user), "alcohol");

        if (playerAlcoholLevel + alcoholContent > 100) {
            user.sendMessage(Text.translatable("item.chroma.alcohol.drinking_limit"), true);
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        return super.use(world, user, hand);
    }
}
