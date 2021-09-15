package me.NotPlatzer.Infinity.gui;

import java.io.IOException;

import me.NotPlatzer.Infinity.*;
import me.NotPlatzer.Infinity.module.ModuleManager;
import me.NotPlatzer.Infinity.module.*;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen{
	
	
	ModuleManager ClickGuiMM = new ModuleManager();
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		drawDefaultBackground();
		drawRect(150, 2, 220, 14, 0x80000000);
		mc.fontRendererObj.drawString("Combat", 152, 4, 0x002aff); 
		
		drawRect(250, 2, 322, 14, 0x80000000);
		mc.fontRendererObj.drawString("Render", 252, 4, 0x002aff);
		
		drawRect(350, 2, 432, 14, 0x80000000);
		mc.fontRendererObj.drawString("Movement", 352, 4, 0x002aff);
		
		drawRect(450, 2, 506, 14, 0x80000000);
		mc.fontRendererObj.drawString("Player", 452, 4, 0x002aff);
		
		drawRect(550, 2, 616, 14, 0x80000000);
		mc.fontRendererObj.drawString("MISC", 552, 4, 0x002aff);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	
	@Override
	public boolean doesGuiPauseGame() {
		
		return false;
	}

	public int placeForHackY(Module module) {
		
		if(module.getCat().equals(Category.COMBAT)) return Category.placeInListCombat(module) * 14;
		if(module.getCat().equals(Category.RENDER)) return Category.placeInListRender(module) * 14;
		if(module.getCat().equals(Category.MOVEMENT)) return Category.placeInListMovement(module) * 14;
		if(module.getCat().equals(Category.PLAYER)) return Category.placeInListPlayer(module) * 14;
		if(module.getCat().equals(Category.MISC)) return Category.placeInListMisc(module) * 14;
		
		return 0;
	}
	
	public int placeForHackX(Module module) {
		
		if(module.getCat().equals(Category.COMBAT)) return 150;
		if(module.getCat().equals(Category.RENDER)) return 250;
		if(module.getCat().equals(Category.MOVEMENT)) return 350;
		if(module.getCat().equals(Category.PLAYER)) return 450;
		if(module.getCat().equals(Category.MISC)) return 550;
			
		return 0;
	}
	
	
	@Override
	public void initGui() {
		for(int i = 1; i < ClickGuiMM.getEnabledModules().size(); i++) {
			
			Module module = ClickGuiMM.getEnabledModules().get(i);
			buttonList.add(new GuiButton(i, placeForHackX(module), placeForHackY(module), 25 + (module.getName().length() * 3) + module.getName().length(), 14, module.getName()));
			
		}
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		for(int i = 1; i < ClickGuiMM.getEnabledModules().size(); i++) {
			
			if(button.id == i) {
				ClickGuiMM.getEnabledModules().get(i).toggle();
			}
			
			
		}
	}
}
