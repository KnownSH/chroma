package net.knsh.chroma.network;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;

public class SendPacket {
    public static PacketByteBuf sendIntPacket(int value) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(value);
        return buffer;
    }
}
