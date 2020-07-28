package Devices;

import java.util.ArrayList;

import Containers.IPAddress;
import Containers.Packet;
import Containers.Pair;
import parent.Device;

public class Switch extends Device{

	public Switch(String name) {
		this.deviceName = name;
		TSwitch.add(new Pair<String, Switch>(this.deviceName, this));
	}
	
	public ArrayList<String> learnedHosts = new ArrayList<String>();
	
	private boolean firstBroadcast = true;
	
	
	
	@Override
	public void send(Packet p) {
		
		if((firstBroadcast==false) && (connectedDevices.contains(p.dest) || learnedHosts.contains(p.dest))) {
			
			//System.out.println("Sending "+getObject(p.dest) +" With Hop count " + p.hops);
			
			p.prevhop = this.deviceName;
			
			getObject(p.dest).send(p);
			
			return;
		}
		else {
			learnedHosts.add(p.dest);
			
			for(String i: connectedDevices) 
			{
				firstBroadcast = false;
				if(i.equals(p.prevhop)) continue;
				if(p.portno == 0)
				System.out.println("Sending "+ this.deviceName+" With Hop count " + p.hops);
				p.prevhop = this.deviceName;
				p.hops++;
				getObject(i).send(p);
				p.hops--;
			
		}
		
		
	}

	}
}
