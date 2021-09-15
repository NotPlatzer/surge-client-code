package me.NotPlatzer.Infinity.module;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import net.minecraft.client.Minecraft;

public class Module {
	
	public String name;
	public Category category;
	public String description;
	public int keycode;
	
	private boolean enabled;
	
	protected Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, Category category, String description, int keycode) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.keycode = keycode;
	}
	
	
	
	public void onEvent(Event e) {
		
		
	}


	public Category getCat() {
		
		return category;
	}
	
	public String getName() {
		
		return name;
	}
	
	public boolean isEnabled() {
		return enabled;
		
		
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void onRender() {
		
	}
	
	public void onEnable() {
		
		
	}
		
	
	public void onDisable() {
		
		
	}

	
	public void onKeyPressed(int keycode) {
		if(this.keycode == keycode) {
			this.toggle();
		}
		
	}
	
	
	public void toggle() {
		setEnabled(!isEnabled());
	}
	

}
