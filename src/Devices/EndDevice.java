package Devices;

import java.util.ArrayList;

import Containers.IPAddress;
import Containers.Packet;
import Containers.Pair;

import parent.Device;

public class EndDevice extends Device {

	public IPAddress ip ;
	public IPAddress subnetmask ;
	
	public EndDevice(String name) {
		this.deviceName = name;
		TEndDevice.add(new Pair<String, EndDevice>(this.deviceName, this));
	}
	
	public ArrayList<Pair<String, Integer>> HopsFromDevice = new ArrayList<Pair<String,Integer>>();
	
	@Override
	public void send(Packet p) 
	{
		
		if(this.deviceName.equals(p.dest)) {
			for(Pair<String, Integer> i: HopsFromDevice) {
				if(i.first.equals(p.source)) {
					p.hops = i.second;
					break;
				}
			}
			
			this.data = p.data;
			if(p.portno == 10) {
				System.out.println("Generating Response ......");
				System.out.println(java.time.LocalDateTime.now().toString());
				
			}
			else if(p.portno == 20) {
				System.out.println("This is a WebPage");
			}
			
			if(p.portno == 0)
			System.out.println("Data Successfull Successfully Sent and RV " + p.source + " " + p.dest + " with " + p.hops +" hops");
			
			p.prevhop = "";
			p.hops = 0;
			
			HopsFromDevice.add(new Pair<String, Integer>(p.source,p.hops));
			
			return;
			
			
			
		}
		else 
		{				
			for(String i : connectedDevices) {
				if(i == p.prevhop) 
				
				{	
					//System.out.println("Data Received and Discarded by : " + this.deviceName);
					
					break;
					
				}
				//System.out.println("Sending "+ this.deviceName +" With Hop count " + p.hops);
				p.prevhop = this.deviceName;
				p.hops++;
				getObject(i).send(p);
				
			}
			
		}
		
	}
	
	public void arp(String ip) 
	{
		System.out.println(ip+"is in the network by name: " + getObjectip(ip));
		
		
		
	}
	
	
	
	

}
