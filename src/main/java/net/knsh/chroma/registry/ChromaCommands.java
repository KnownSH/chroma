package net.knsh.chroma.registry;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.knsh.chroma.registry.commands.ClearAlcoholEffects;

public class ChromaCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> ClearAlcoholEffects.register(dispatcher)));
    }
}
