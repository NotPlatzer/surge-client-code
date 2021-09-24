package me.NotPlatzer.Infinity.events;

import net.minecraft.network.Packet;
import me.NotPlatzer.Infinity.events.*;

public class ReadPacketEvent extends Event{
	
	private Packet packet;
	
	public ReadPacketEvent(Packet packet) {
		
		this.packet = packet;
		
	}
	
	public Packet getPacket() {
		
		return this.packet;
		
	}

}
