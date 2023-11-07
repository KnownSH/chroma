package net.knsh.chroma.registry.items;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.knsh.chroma.network.ChromaS2C;
import net.knsh.chroma.network.SendPacket;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.SimplePlayerData;
import net.minecraft.advancement.criterion.Criteria;
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
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Alcohol extends HoneyBottleItem {
    public static int ALCOHOL_CONTENT = 10;
    private static final int ALCOHOL_LIMIT = 100;

    public Alcohol(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {

            int playerAlcoholLevel = SimplePlayerData.getIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol");
            int newAlcoholLevel = playerAlcoholLevel;

            if (playerAlcoholLevel + ALCOHOL_CONTENT <= ALCOHOL_LIMIT) {
                newAlcoholLevel += ALCOHOL_CONTENT;
            } else {
                newAlcoholLevel = 100;
            }

            SimplePlayerData.setIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol", newAlcoholLevel);
            ServerPlayNetworking.send(serverPlayerEntity, ChromaS2C.ALCOHOL_PACKET_ID, SendPacket.sendIntPacket(newAlcoholLevel));

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
    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        int playerAlcoholLevel = SimplePlayerData.getIntNbt(((PlayerDataSaver) user), "alcohol");

        if (playerAlcoholLevel + ALCOHOL_CONTENT > 100) {
            user.sendMessage(Text.translatable("item.chroma.alcohol.drinking_limit"), true);
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        return super.use(world, user, hand);
    }
}
