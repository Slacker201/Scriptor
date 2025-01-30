package com.slacker201.mixin.client;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

	@Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
	private void replaceSendMessage(String chatText, boolean addToHistory, CallbackInfo ci) {
		// New method logic (currently identical)
		MinecraftClient client = MinecraftClient.getInstance();
		chatText = this.normalize(chatText);

		if (!chatText.isEmpty()) {
			if (addToHistory) {
				client.inGameHud.getChatHud().addToMessageHistory(chatText);
			}

			if (chatText.startsWith("/")) {
				client.player.networkHandler.sendChatCommand(chatText.substring(1));
			} else {
				client.player.networkHandler.sendChatMessage(chatText);
			}
		}

		ci.cancel(); // Prevents the original method from running
	}

	// You'll need to implement normalize, since it's originally from ChatScreen
	private String normalize(String chatText) {
		return StringHelper.truncateChat(StringUtils.normalizeSpace(chatText.trim()));
	}
}
