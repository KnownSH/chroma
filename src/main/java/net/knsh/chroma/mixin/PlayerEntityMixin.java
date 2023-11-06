package net.knsh.chroma.mixin;

import net.knsh.chroma.Chroma;
import net.knsh.chroma.util.PlayerDataSaver;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerDataSaver {
    private NbtCompound persistentData;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public NbtCompound getPersistentData() {
        if (this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToNbt")
    public void writeNbt(NbtCompound nbt, CallbackInfo info) {
        if (persistentData != null) {
            nbt.put(Chroma.MOD_ID, persistentData);
        }
    }

    @Inject(at = @At("TAIL"), method = "readCustomDataFromNbt")
    public void readData(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains(Chroma.MOD_ID, 10)) {
            persistentData = nbt.getCompound(Chroma.MOD_ID);
        }
    }
}
