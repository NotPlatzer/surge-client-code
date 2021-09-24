package me.NotPlatzer.Infinity.modules;

import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import me.NotPlatzer.Infinity.events.Event;
import me.NotPlatzer.Infinity.events.listeners.EventMotion;
import me.NotPlatzer.Infinity.module.Category;
import me.NotPlatzer.Infinity.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class KillAura extends Module {

	public KillAura() {
		
		super("Kill Aura", Category.COMBAT, "Kills nearby entitys", Keyboard.KEY_K);
		
	}


	public void onEnable() {
		
		
	}
		
	
	public void onDisable() {
		
		
	}
		
	public void onEvent(Event e) {
		
			if(e instanceof EventMotion) {
				
				if(e.isPre()) {
					
					//List<EntityLivingBase> targets = (List<EntityLivingBase>) mc.world.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
					
					
					
					
					
				}
			}
		
		}
	}
		
	
	

	
	
	


