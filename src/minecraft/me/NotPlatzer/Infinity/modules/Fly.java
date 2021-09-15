package me.NotPlatzer.Infinity.modules;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventUpdate;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;

public class Fly extends Module {

	public Fly() {
		super("Fly", Category.MOVEMENT, "Makes you fly", Keyboard.KEY_G);
	}

	public void onDisable() {

		mc.player.capabilities.isFlying = false;

	}

	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			if (e.isPre()) {

				mc.player.capabilities.isFlying = true;
			}
		}
	}
}
