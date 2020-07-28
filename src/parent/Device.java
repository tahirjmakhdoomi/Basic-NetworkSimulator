package parent;

import java.util.ArrayList;
import Devices.EndDevice;
import Devices.Hub;
import Devices.Router;
import Devices.Switch;
import Containers.*;
public abstract class Device {
	
	public int ports;
	
	public ArrayList<String> connectedDevices =  new ArrayList<String>();
	
	public IPAddress ip ;
	public String data;
	
	public String deviceName;
	
	
	public int getPorts(){
		return this.ports;
	}

	public static ArrayList<Pair<String,Hub>> Thubs = new ArrayList<Pair<String,Hub>>();
	public static ArrayList<Pair<String,Switch>> TSwitch = new ArrayList<Pair<String,Switch>>();
	public static ArrayList<Pair<String,EndDevice>> TEndDevice = new ArrayList<Pair<String,EndDevice>>();
	public static ArrayList<Pair<String,Router>> TRouter = new ArrayList<Pair<String,Router>>();
	
	public void makeConn(Device s2) {
		this.connectedDevices.add(s2.deviceName);
		s2.connectedDevices.add(this.deviceName);
	}
	
	public void disConn(Device s2) {
		this.connectedDevices.remove(s2.deviceName);
		s2.connectedDevices.remove(this.deviceName);
	}
	
	public abstract void send(Packet p);
		
	public static Device getObject(String i) 
	{
		for(Pair<String, Hub> j: Device.Thubs) 
		{
			if(i.equals(j.first)) {
				return j.second;
			
			}
			
		}
		for(Pair<String, EndDevice> j: Device.TEndDevice) 
		{
			if(i.equals(j.first)) {
				return j.second;
			}
			
		}
		for(Pair<String, Switch> j: Device.TSwitch) 
		{
			if(i.equals(j.first)) {
				return j.second;
			}
			
		}
		for(Pair<String, Router> j: Device.TRouter) {
			if(j.first.startsWith(j.second.deviceName)) {
				return j.second;
			}
		}
				
		return null;
	}
	
	public static String getObjectip(String i) 
	{
		IPAddress iip = new IPAddress(i);
		
		for(Pair<String, EndDevice> j : Device.TEndDevice) 
		{
			if(iip.equality(j.second.ip)) {
				return j.second.deviceName;
			}
			
		}
		
		for(Pair<String, Router> j: Device.TRouter) {
			for(Quad<String, IPAddress, IPAddress, String> k: j.second.iface) {
				return k.first;
			
			}
			
		}
				
		return null;
	}
		
	
}
