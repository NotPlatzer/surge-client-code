package me.NotPlatzer.Infinity.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.settings.Setting;
import net.minecraft.client.Minecraft;

public class Module {
	
	public String name;
	public Category category;
	public String description;
	public int keycode;
	
	public boolean toggled;
	
	protected Minecraft mc = Minecraft.getMinecraft();
	
	public boolean expanded;
	public  int index;
	public List<Setting> settings = new ArrayList<Setting>();
	
	public Module(String name, Category category, String description, int keycode) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.keycode = keycode;
	}
	
	public void addSettings(Setting... settings) {
		this.settings.addAll(Arrays.asList(settings));
	}
	
	public void onEvent(Event e) {
		
		
	}
	public int getKey() {
		return keycode;
	}


	public Category getCat() {
		
		return category;
	}
	
	public String getName() {
		
		return name;
	}
	
	public boolean isEnabled() {
		return toggled;
		
		
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
		toggled = !toggled;
		if(toggled) {
			onEnable();
		}
		else {
			onDisable();
		}
	}
	

}
