package me.NotPlatzer.Infinity.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import me.NotPlatzer.Infinity.Client;
import me.NotPlatzer.Infinity.events.listeners.EventRenderGUI;
import me.NotPlatzer.Infinity.module.Module;
import me.NotPlatzer.Infinity.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class HUD extends Gui { 
	
	
	private Minecraft mc = Minecraft.getMinecraft();
	public static boolean TabGuiIsOn;
	
	
	
	public void draw() {
		
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
		
		
		Client.modulemanager.modulelist.sort(Comparator.comparingInt(m -> mc.fontRendererObj.getStringWidth(((Module)m).name)).reversed());
		
		GlStateManager.pushMatrix();
		GlStateManager.scale(2, 2, 1);
		fr.drawString(Client.clientname, 1, 1, Client.clientcolor);
		GlStateManager.scale(0.5, 0.5, 1);
		GlStateManager.popMatrix();
		
		this.mc.getTextureManager().bindTexture(new ResourceLocation("surgelogo.png"));  
		
		if(TabGuiIsOn == false) {
			
			String FPS = Integer.toString(mc.getDebugFPS());
			fr.drawString("Fps: " + FPS, 1, 19, -1);
			
			String xCoord = String.format("%.0f", mc.player.posX);
			String yCoord = String.format("%.0f", mc.player.posY);
			String zCoord = String.format("%.0f", mc.player.posZ);

			fr.drawString("x: " + xCoord, 1, 28, -1);
			fr.drawString("y: " + yCoord, 1, 37, -1);
			fr.drawString("z: " + zCoord, 1, 46, -1);
			
			
		}
		
		
		int count = 0;
		
		for(Module module : Client.modulemanager.getEnabledModules()) {
			
		
			
			
			double offset = count*(fr.FONT_HEIGHT + 2);
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(module.name) - 7, 2 + offset, sr.getScaledWidth() - fr.getStringWidth(module.name) - 5, 4 + fr.FONT_HEIGHT + offset, Client.clientcolor);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(module.name) - 5, 2 + offset, sr.getScaledWidth(), 4 + fr.FONT_HEIGHT + offset, 0x90000000);
			fr.drawString(module.getName(), sr.getScaledWidth() - fr.getStringWidth(module.name) - 4, 4 + offset, -1);
			
			count++;
		}
		
		
		Client.onEvent(new EventRenderGUI());
	
		}
		
	}


