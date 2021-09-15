package me.NotPlatzer.Infinity.modules;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventUpdate;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;

public class Sprint extends Module {

	public Sprint() {
		
		super("Sprint", Category.MOVEMENT, "Sprint Hack", Keyboard.KEY_V);
		
	}


	public void onEnable() {
		
		
	}
		
	
	public void onDisable() {
		
		mc.player.setSprinting(false);
	}
		
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(!mc.player.isSneaking() && !mc.player.isCollidedHorizontally) {
					
					mc.player.setSprinting(true);
					
				}
			
			
		
			}
		}
	}
		
	
	

	
	
	

}
