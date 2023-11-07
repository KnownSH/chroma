package net.knsh.chroma.util;

import net.minecraft.server.MinecraftServer;

public interface ServerTick {
    void sendServer(MinecraftServer server);
}
