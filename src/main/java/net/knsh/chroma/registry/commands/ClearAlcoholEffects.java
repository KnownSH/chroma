package net.knsh.chroma.registry.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.knsh.chroma.Chroma;
import net.knsh.chroma.network.ChromaS2C;
import net.knsh.chroma.network.SendPacket;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.SimplePlayerData;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class ClearAlcoholEffects {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal(Chroma.MOD_ID)
                .requires(source -> source.hasPermissionLevel(2))
                .then(literal("clearAlcoholEffects")
                        .then(argument("players", EntityArgumentType.players())
                                .executes(ClearAlcoholEffects::clearEffects)
                        )));
    }

    public static int clearEffects(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        final ServerCommandSource source = context.getSource();
        final ServerPlayerEntity player = source.getPlayer();

        if (player != null) {
            SimplePlayerData.setIntNbt(((PlayerDataSaver) player), "alcohol", 0);
            ServerPlayNetworking.send(player, ChromaS2C.ALCOHOL_PACKET_ID, SendPacket.sendIntPacket(0));
        }

        return 1;
    }
}
