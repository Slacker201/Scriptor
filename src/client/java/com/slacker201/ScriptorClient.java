package com.slacker201;


import net.fabricmc.api.ClientModInitializer;

public class ScriptorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		Scriptor.LOGGER.info("Client Init");
	}




}