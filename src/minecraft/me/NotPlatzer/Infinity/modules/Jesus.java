package me.NotPlatzer.Infinity.modules;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventUpdate;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;

public class Jesus extends Module {

	public Jesus() {
		
		super("Jesus", Category.MOVEMENT, "jesus Hack", Keyboard.KEY_L);
		
	}


	public void onEnable() {
		
		
	}
		
	
	public void onDisable() {
		
		
	}
		
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
			
		
			}
		}
	}
		
	
	

	
	
	

}
