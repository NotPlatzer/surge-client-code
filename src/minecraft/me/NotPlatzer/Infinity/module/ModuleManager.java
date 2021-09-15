package me.NotPlatzer.Infinity.module;

import java.util.ArrayList;


import me.NotPlatzer.Infinity.modules.Fly;
import me.NotPlatzer.Infinity.modules.Sprint;
import me.NotPlatzer.Infinity.gui.*;
import me.NotPlatzer.Infinity.ui.UIrenderer;

public class ModuleManager {

	
	
	public ArrayList<Module> modulelist = new ArrayList<Module>();
	
	public void init() {
		
		modulelist.add(new Sprint());
		modulelist.add(new Gui());
		modulelist.add(new Fly());
		
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
