package me.NotPlatzer.Infinity.ui;

import me.NotPlatzer.Infinity.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

public class UIrenderer	extends Gui {
	
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public void draw() {
		
		mc.fontRendererObj.drawString(Client.clientname, 1, 1, 0x002aff);
	
		
	}

}
