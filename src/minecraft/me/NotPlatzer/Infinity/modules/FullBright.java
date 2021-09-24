package me.NotPlatzer.Infinity.modules;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventUpdate;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;
import me.NotPlatzer.Infinity.settings.NumberSetting;

public class FullBright extends Module {
	
	public NumberSetting gamma = new NumberSetting("Gamma", 100, 1, 100, 1);
	
	public FullBright() {
		super("Full Bright", Category.RENDER, "Makes you see in the dark", Keyboard.KEY_J);
		this.addSettings(gamma);
	}
	
	
	
	

	public void onEnable() {
		
		mc.gameSettings.gammaSetting = (float) gamma.getValue();
	}
		
	
	
	
	public void onDisable() {
 
		mc.gameSettings.gammaSetting = 1;

	}


}

