package com.slacker201;

import net.fabricmc.api.ModInitializer;
import org.graalvm.polyglot.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scriptor implements ModInitializer {
	public static final String MOD_ID = "scriptor";

	// This logger is used to write text to the console and the log file.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	// Public static final for GraalVM Context (JavaScript engine)
	public static final Context GRAALVM_CONTEXT = Context.create();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// Proceed with caution, as some things may still be uninitialized.

		LOGGER.info("Hello Fabric world!");

		// Example of using GraalVM to execute JavaScript
	}

}
