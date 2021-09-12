package me.NotPlatzer.Infinity.module;

import java.util.ArrayList;

public class ModuleManager {

	
	
	public ArrayList<Module> modulelist = new ArrayList<Module>();
	
	public void init() {
		
		
		
	}
	
	public ArrayList<Module> getEnabledModules() {
		ArrayList<Module> toggledmodules = new ArrayList<Module>();
		
		for(Module module : modulelist) {
			
			if(module.isEnabled()) {
				toggledmodules.add(module);
			}
		}
		return toggledmodules;
	}
	
}
