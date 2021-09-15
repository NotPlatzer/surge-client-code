package me.NotPlatzer.Infinity.module;
import me.NotPlatzer.Infinity.module.ModuleManager;


public enum Category {
	
	
	
	RENDER, COMBAT, MOVEMENT, PLAYER, MISC, NONE;
	
	
	public static int size(Category cat) {
		
		ModuleManager modulemanager = new ModuleManager();
		
		int i = 0;
	
		
		for(Module module : modulemanager.getEnabledModules()) {
			
			if(module.getCat().equals(cat)) {
				i++;
			}
			
		}
		
		
		
		
		return i;
	}
	
	
	public static int placeInListRender(Module module) {
		
		ModuleManager modulemanager = new ModuleManager();
		
		int i = 0;
		
		for(Module module1 : modulemanager.getEnabledModules()) {
			if(module1.getCat().equals(RENDER) && !module.equals(module)) {
				i++;
				continue;
			}
			
			if(module1.getCat().equals(RENDER) && module1.equals(module)) {
				return i;
			}
			
			
			
		}
		
		return 0;
		
	}
	
public static int placeInListCombat(Module module) {
		
		ModuleManager modulemanager = new ModuleManager();
		
		int i = 1;
		
		for(Module module1 : modulemanager.getEnabledModules()) {
			if(module1.getCat().equals(COMBAT) && !module.equals(module)) {
				i++;
				continue;
			}
			
			if(module1.getCat().equals(COMBAT) && module1.equals(module)) {
				return i;
			}
			
			
			
		}
		
		return 0;
		
	}

public static int placeInListMovement(Module module) {
	
	ModuleManager modulemanager = new ModuleManager();
	
	int i = 1;
	
	for(Module module1 : modulemanager.getEnabledModules()) {
		if(module1.getCat().equals(MOVEMENT) && !module.equals(module)) {
			i++;
			continue;
		}
		
		if(module1.getCat().equals(MOVEMENT) && module1.equals(module)) {
			return i;
		}
		
		
		
	}
	
	return 0;
	
}

public static int placeInListPlayer(Module module) {
	
	ModuleManager modulemanager = new ModuleManager();
	
	int i = 1;
	
	for(Module module1 : modulemanager.getEnabledModules()) {
		if(module1.getCat().equals(PLAYER) && !module.equals(module)) {
			i++;
			continue;
		}
		
		if(module1.getCat().equals(PLAYER) && module1.equals(module)) {
			return i;
		}
		
		
		
	}
	
	return 0;
	
}

public static int placeInListMisc(Module module) {
	
	ModuleManager modulemanager = new ModuleManager();
	
	int i = 1;
	
	for(Module module1 : modulemanager.getEnabledModules()) {
		if(module1.getCat().equals(MISC) && !module.equals(module)) {
			i++;
			continue;
		}
		
		if(module1.getCat().equals(MISC) && module1.equals(module)) {
			return i;
		}
		
		
		
	}
	
	return 0;
	
}

}


