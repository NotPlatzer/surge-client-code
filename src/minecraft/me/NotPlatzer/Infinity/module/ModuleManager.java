package me.NotPlatzer.Infinity.module;

import java.util.ArrayList;
import java.util.List;

import me.NotPlatzer.Infinity.modules.*;
import me.NotPlatzer.Infinity.ui.HUD;

public class ModuleManager {

	
	
	public static ArrayList<Module> modulelist = new ArrayList<Module>();
	
	public void init() {
		
		modulelist.add(new Sprint());
		modulelist.add(new Fly());
		modulelist.add(new FullBright());
		modulelist.add(new NoFall());
		modulelist.add(new TabGui());
		modulelist.add(new KillAura());
	}
	
	
	
	public static ArrayList<Module> getEnabledModules() {
		
		
		ArrayList<Module> toggledmodules = new ArrayList<Module>();
		
		 
		
		for(Module module : modulelist) {
			
			if(module.isEnabled()) {
				toggledmodules.add(module);
				
			}
		}
		return toggledmodules;
	}
	
	
	
	public static List<Module> getModulesByCategory(Category c) {
		
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : modulelist) {
			if(m.category == c) {
				modules.add(m);
			}
		}
		return modules;
	}
	
	
	
	
}
