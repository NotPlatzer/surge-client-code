package me.NotPlatzer.Infinity.modules;

import java.util.List;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.Client;
import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.*;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;
import me.NotPlatzer.Infinity.module.ModuleManager;
import me.NotPlatzer.Infinity.settings.Setting;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import me.NotPlatzer.Infinity.ui.*;

public class TabGui extends Module {
	public int currentTab;
	public boolean expanded;

	public TabGui() {
		super("TabGui", Category.RENDER, "Tab Gui", Keyboard.KEY_O);
		toggled = true;
	}

	
	//called every tick
	public void onEvent(Event e) {
		
		if (e instanceof EventRenderGUI) {
			FontRenderer fr = mc.fontRendererObj;
			
			//draw the black rectangle
			Gui.drawRect(5, 30.5, 70, 30 + Category.values().length * 16 + 2, 0x90000000);
			//draw blue selector for category
			Gui.drawRect(7, 33 + currentTab * 16, 7 + 63, 33 + currentTab * 16 + 12, Rainbow.rainbow("90"));

			int count = 0;
			
			//loops for every Category
			for (Category c : Category.values()) {
				
				//draw all the names of the category
				fr.drawStringWithShadow(c.name(), 11, 35 + count * 16, -1);

				count++;
			}
			
			//becomes true when right arrow is pressed
			if(expanded) {

				//category is the currenty selceted
				Category category = Category.values()[currentTab];
				//gets all the modules that are in the selected caegory
				List<Module> modules = ModuleManager.getModulesByCategory(category);
					
				//if there is no module in the category it stops
				if(modules.size() == 0) {
					return;
				}
				 //draws black rect for the place where modules will be shown
				Gui.drawRect(70, 30.5, 70 + 68, 30 + modules.size() * 16 + 2, 0x90000000);
				//draws selector acording to the module index
				Gui.drawRect(72, 33 + category.moduleIndex * 16, 7 + 63 + 68, 33 + category.moduleIndex * 16 + 12, Client.clientcolor);
	
				count = 0;
				
				//loops for every module in current category
				for (Module module : modules) {
						
					//draws the modules
					fr.drawStringWithShadow(module.name, 75, 35 + count * 16, -1);
					
					//if we are over a module and its expanded
					
					if(count == category.moduleIndex && module.expanded) {
						
						
						Gui.drawRect(70 + 68, 30.5, 70 + 68 + 68, 30 + module.settings.size() * 16 + 2, 0x90000000);
						Gui.drawRect(72 + 68, 33 + module.index * 16, 7 + 63 + 68 + 68, 33 + module.index * 16 + 12, Client.clientcolor);
						int index = 0;
						//draws the settings
						for (Setting setting : module.settings) {
							
							fr.drawStringWithShadow(setting.name, 75, 35 + count * 16, -1);
						
					}
					
					
					
					count++;
				}
			}
			
		}
			
		if (e instanceof EventKey) {

			int code = ((EventKey)e).code;
			System.out.printf("EventKey got called to the tab gui class");
			
			Category category = Category.values()[currentTab];
			
			List<Module> modules = ModuleManager.getModulesByCategory(category);
			
			if (code == Keyboard.KEY_UP); {
				if(expanded) {
					if (category.moduleIndex <= 0) {
						category.moduleIndex = modules.size() - 1;
					} else
						category.moduleIndex--;
				}else
					if (currentTab <= 0) {
						currentTab = Category.values().length - 1;
					} else
						currentTab--;

			}

			if (code == Keyboard.KEY_DOWN) {
				if(expanded) {
					if (category.moduleIndex >= modules.size() - 1) {
						category.moduleIndex = 0;
	
					} else
						category.moduleIndex++;
				}else {  
					if (currentTab >= Category.values().length - 1) {
						currentTab = 0;
	
					} else
						currentTab++;
				}
			}
			
			if (code == Keyboard.KEY_RETURN) {
				if(expanded && modules.size() != 0) {
					Module module = modules.get(category.moduleIndex);
				
					if(!module.expanded) {
						module.expanded = true;
					}
					
				}
			}

			if (code == Keyboard.KEY_RIGHT) {
				System.out.printf("Right arrow pressed");
				if(modules.size() <= 0) { }
				else {
				if(expanded && modules.size() != 0) {
					Module module = modules.get(category.moduleIndex);
					if(!module.name.equals("TabGui")) {
						module.toggle();
					}
					
				}else
				expanded = true;
				}
			}
			if (code == Keyboard.KEY_LEFT) {
				if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
					modules.get(category.moduleIndex).expanded = false;
				}else
					expanded = false;

			}
		}
		}

		

	}
	
	public void onEnable() {
		
		HUD.TabGuiIsOn = true;
	}
		
	
	public void onDisable() {
		
		HUD.TabGuiIsOn = false;
		
	}
}



	