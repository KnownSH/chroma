package net.knsh.chroma.registry;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.knsh.chroma.util.ServerTick;

public class ChromaEvents {
    public static void register() {
        ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
            ((ServerTick) server).chroma_1_19_2$sendServer(server);
        });
    }
}
