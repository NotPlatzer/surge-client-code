package me.NotPlatzer.Infinity.gui;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;
import me.NotPlatzer.Infinity.gui.ClickGui;

public class Gui extends Module{

	
	public Gui() {
		super("Click Gui", Category.RENDER, "Click Gui?", Keyboard.KEY_BACKSLASH);
	}
	
	public void onEnable() {
		mc.displayGuiScreen(new ClickGui());
		toggle();
		
	}
	
	public void onDisable() {
		
		toggle();
	}
		
		
	
		
	
}
