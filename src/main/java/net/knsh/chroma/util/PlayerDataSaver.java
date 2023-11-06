package net.knsh.chroma.util;

import net.minecraft.nbt.NbtCompound;

public interface PlayerDataSaver {
    NbtCompound getPersistentData();
}
