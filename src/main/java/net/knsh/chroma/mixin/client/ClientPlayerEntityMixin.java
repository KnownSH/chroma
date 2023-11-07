package net.knsh.chroma.mixin.client;

import net.knsh.chroma.registry.ChromaEffects;
import net.knsh.chroma.util.DrunkifyMessage;
import net.knsh.chroma.util.PlayerDataSaver;
import net.knsh.chroma.util.UwuifyMessage;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
    @Shadow public abstract void sendMessage(Text message);

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

        int alcoholLevels = ((PlayerDataSaver) player).getPersistentData().getInt("alcohol");

        if (alcoholLevels > 0) {
            message = DrunkifyMessage.alterString(message, alcoholLevels);
        }

        if (player.hasStatusEffect(ChromaEffects.UWUIFY_EFFECT)) {
            message = UwuifyMessage.alterString(message);
        }

        return message;
    }
}