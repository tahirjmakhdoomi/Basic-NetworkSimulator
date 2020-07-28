package Devices;


import Containers.IPAddress;
import Containers.Packet;
import Containers.Pair;
import parent.Device;

public class Hub extends Device{
	
	public Hub(String deviceName)
	{
		this.deviceName = deviceName; 
		Thubs.add(new Pair<String, Hub>(this.deviceName, this));
		
	}
	
	public void setPorts(int n) 
	{
		this.ports = n;
		
	}
	
	
	
	
	@Override
	public void send(Packet p) {
		for(String i: connectedDevices) 
		{
			if(i.equals(p.prevhop)) continue;
			p.prevhop = this.deviceName;
			
			getObject(i).send(p);
			
			
		}
	}

}
