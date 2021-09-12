package me.NotPlatzer.Infinity;

import me.NotPlatzer.Infinity.module.ModuleManager;
import me.NotPlatzer.Infinity.ui.UIrenderer;

public class Client {

	
	public static String clientname = "Surge Client";
	public static String clientversion = "1.0";
	
	public static UIrenderer uirenderer;
	public static ModuleManager modulemanager;
	
	public static void init() {
		
		uirenderer = new UIrenderer();
		modulemanager = new ModuleManager();
		
		
	}	
	
	public static void onGui() {
		
		uirenderer.draw();
	}
	
	
	public static void onRender() {
		for(Module module : modulemanager.getEnabledModules()) {
			module.onRender();
		}
	}
	
	public static void onPreUpdate() {
		for(Module module : modulemanager.getEnabledModules()) {
			module.onPreUpdate();
		}
		
	}
		
	
	public static void onPostUpdate() {
		for(Module module : modulemanager.getEnabledModules()) {
			module.onPostUpdate();
		}
		
		
	}

	
	public static void onKeyPressed(int keyCode) {
		
	for(Module module : modulemanager.modulelist) {
		module.onKeyPressed(keycode);
	}
		
	}
	
}
