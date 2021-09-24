package me.NotPlatzer.Infinity;


import java.awt.Color;

import org.lwjgl.opengl.Display;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventKey;
import me.NotPlatzer.Infinity.module.Module;
import me.NotPlatzer.Infinity.module.ModuleManager;
import me.NotPlatzer.Infinity.ui.HUD;
import net.minecraft.client.Minecraft;



public class Client {

	
	public static String clientname = "Surge Client";
	public static String clientversion = "1.1";
	public static int clientcolor = 0xff002aff;
	
	public static void nameChange() {
		Display.setTitle(clientname + " " + clientversion);
	}
	
	public static HUD hud;
	public static ModuleManager modulemanager;
	
	public static void init() {
		
		hud = new HUD();
		modulemanager = new ModuleManager();
		modulemanager.init();
		
		
		
	}	
	
	
	public static void onEvent(Event e) {
		for(Module module : modulemanager.getEnabledModules()) {
			
			
			module.onEvent(e);
			
		}
		
	}
	
	public static void onGui() {
		
		hud.draw();
	}
	
	
	public static void onRender() {
		for(Module module : modulemanager.getEnabledModules()) {
			module.onRender();
		}	
	}
	
	public static void onEnable() {
		for(Module module : modulemanager.getEnabledModules()) {
			module.onEnable();
		}
		
	}
		
	
	public static void onDisable() {
		for(Module module : modulemanager.getEnabledModules()) {
			module.onDisable();
			module.toggle();
		}
		
		
	}

	
	public static void KeyPressed(int key) {
		Client.onEvent(new EventKey(key));
	for(Module module : modulemanager.modulelist) {
		if(module.getKey() == key) {
			module.toggle();
		}
	}
		
	}
	
}
