package net.knsh.chroma.mixin.client;

import net.knsh.chroma.registry.ChromaEffects;
import net.knsh.chroma.util.DrunkifyMessage;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.UwUifyMessage;
import net.minecraft.client.network.ClientPlayerEntity;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
    @Shadow @Final public static Logger LOGGER;

    @ModifyArg(
            method = "sendChatMessage(Ljava/lang/String;Lnet/minecraft/text/Text;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/network/ClientPlayerEntity;sendChatMessageInternal(Ljava/lang/String;Lnet/minecraft/text/Text;)V"
            ),
            index = 0
    )
    private String modifyMessage(String message) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        if (player.hasStatusEffect(ChromaEffects.UWUIFY_EFFECT)) {
            message = UwUifyMessage.alterString(message);
        }

        int alcoholLevels = ((PlayerDataSaver) player).getPersistentData().getInt("alcohol");

        if (alcoholLevels > 0) {
            message = DrunkifyMessage.alterString(message, alcoholLevels);
        }
        return message;
    }
}