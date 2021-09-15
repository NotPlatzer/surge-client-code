package me.NotPlatzer.Infinity;


import java.awt.Color;

import org.lwjgl.opengl.Display;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.module.Module;
import me.NotPlatzer.Infinity.module.ModuleManager;
import me.NotPlatzer.Infinity.ui.UIrenderer;
import net.minecraft.client.Minecraft;



public class Client {

	
	public static String clientname = "Surge Client";
	public static String clientversion = "1.1";
	public static int clientcolor = 0x002aff;
	
	public static void nameChange() {
		Display.setTitle(clientname + " " + clientversion);
	}
	
	public static UIrenderer uirenderer;
	public static ModuleManager modulemanager;
	
	public static void init() {
		
		uirenderer = new UIrenderer();
		modulemanager = new ModuleManager();
		modulemanager.init();
		
		
		
	}	
	
	
	public static void onEvent(Event e) {
		for(Module module : modulemanager.getEnabledModules()) {
			
			
			module.onEvent(e);
			
		}
		
	}
	
	public static void onGui() {
		
		uirenderer.draw();
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

	
	public static void onKeyPressed(int keycode) {
		
	for(Module module : modulemanager.modulelist) {
		module.onKeyPressed(keycode);
	}
		
	}
	
}
