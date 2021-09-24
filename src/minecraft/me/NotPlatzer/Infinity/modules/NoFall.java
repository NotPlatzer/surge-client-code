package me.NotPlatzer.Infinity.modules;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventUpdate;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class NoFall extends Module {

	public NoFall() {
		super("No Fall", Category.PLAYER, "Makes you not go Splat when u hit the Ground", Keyboard.KEY_N);
	}
	
	
	
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate && e.isPre()) {
		
			if(mc.player.fallDistance >= 3.0f && !mc.player.onGround)	{

				
					mc.player.onGround = true;

				

				}}
			
			
			
		}
	}
	
	
	
	
	




