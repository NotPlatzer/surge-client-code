package me.NotPlatzer.Infinity.module;

import org.lwjgl.input.Keyboard;

public class Module {
	
	private String name;
	private Category category;
	private String description;
	private int keycode;
	private String[] modes;
	
	private boolean enabled;
	
	public Module(String name, Category category) {
		this(name, category, null, Keyboard.KEY_NONE, "Default");
	}
	
	public Module(String name, Category category, String description) {
		this(name, category, description, Keyboard.KEY_NONE, "Default");
	}
	
	public Module(String name, Category category, String description, int keycode) {
		this(name, category, null, keycode , "Default");
	}
	
	public Module(String name, Category category, String description, int keycode, String... modes) {
		
		
		
		this.name = name;
		this.category = category;
		this.description = description;
		this.keycode = keycode;
		this.modes = modes;
		
	}
	
	public boolean isEnabled() {
		return enabled;
		
		
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void onRender() {
		
	}
	
	public void onPreUpdate() {
		
		
	}
		
	
	public void onPostUpdate() {
		
		
	}

	
	public void onKeyPressed(int keyCode) {
		if(this.keycode == keycode) {
			this.toggle();
		}
		
	}
	
	
	public void toggle() {
		setEnabled(!isEnabled());
	}
	

}
