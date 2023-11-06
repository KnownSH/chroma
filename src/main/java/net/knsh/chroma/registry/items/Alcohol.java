package net.knsh.chroma.registry.items;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.knsh.chroma.Chroma;
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
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
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

            Chroma.LOGGER.info(String.valueOf(newAlcoholLevel));

            if (playerAlcoholLevel + ALCOHOL_CONTENT <= ALCOHOL_LIMIT) {
                newAlcoholLevel += ALCOHOL_CONTENT;
            } else {
                newAlcoholLevel = 100;
            }

            SimplePlayerData.setIntNbt(((PlayerDataSaver) serverPlayerEntity), "alcohol", newAlcoholLevel);
            Chroma.LOGGER.info(String.valueOf(newAlcoholLevel));

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
}
