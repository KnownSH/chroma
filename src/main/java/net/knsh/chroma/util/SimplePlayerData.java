package net.knsh.chroma.util;

import net.minecraft.nbt.NbtCompound;

public class SimplePlayerData {
    public static void setIntNbt(PlayerDataSaver player, String key, int value) {
        NbtCompound nbt = player.getPersistentData();
        nbt.putInt(key, value);
    }

    public static int getIntNbt(PlayerDataSaver player, String key) {
        NbtCompound nbt = player.getPersistentData();
        int value = nbt.getInt(key);

        return value;
    }
}
