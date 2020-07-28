package Devices;

import java.util.ArrayList;



import Containers.IPAddress;
import Containers.Packet;
import Containers.Pair;
import Containers.Quad;
import Containers.Tuple;
import parent.Device;

public class Router extends Device{

	public Router(String name){
		this.deviceName = name;
		TRouter.add(new Pair<String, Router>(this.deviceName, this));
	}
	public ArrayList<Quad<String, IPAddress,IPAddress, String>> iface = new ArrayList<Quad<String,IPAddress,IPAddress,String>>();
	public ArrayList<Tuple<IPAddress, IPAddress, String>> route = new ArrayList<Tuple<IPAddress,IPAddress,String>>();
	
	public void configureInterface() {
		this.ports = 2;
		iface.add(new Quad<String, IPAddress,IPAddress,String>(this.deviceName+".Interface1", new IPAddress("192.168.001.001"),new IPAddress("255.255.255.000"),"Switch1"));
		getObject("Switch1").connectedDevices.add(this.deviceName+".Interface1");
		iface.add(new Quad<String, IPAddress,IPAddress,String>(this.deviceName+".Interface2", new IPAddress("172.031.002.001"),new IPAddress("255.255.255.000"),"Switch2"));
		getObject("Switch2").connectedDevices.add(this.deviceName+".Interface2");
	}
	public void getInterfaceInfo() 
	{
		System.out.println("Interface Name \t\tIPAddress\t\tSubnet Mask\t\tConnected Device Name");
		for(Quad<String, IPAddress, IPAddress, String> i: iface) {
			System.out.println(i.first+"\t"+i.second.toStr()+"\t\t"+i.third.toStr()+"\t\t"+i.forth);
		}
		
	}
	
	public void getRouteInfo() 
	{
		System.out.println("Network ID \t\tSubnet Mask\t\tNextHop Interface");
		for(Tuple<IPAddress, IPAddress, String> i: route) {
			System.out.println(i.first.toStr()+"\t\t"+i.second.toStr()+"\t\t\t"+i.third);
		}
		
	}
	public void addRoute() {
		route.add(new Tuple<IPAddress, IPAddress, String>(new IPAddress("172.031.002.000"), new IPAddress("255.255.255.000"), "Switch2"));
		route.add(new Tuple<IPAddress, IPAddress, String>(new IPAddress("192.168.001.000"), new IPAddress("255.255.255.000"), "Switch1"));
	}
	
	@Override
	public void makeConn(Device s2) {
	}
	
	@Override
	public void send(Packet p) {
		if(p.portno == 0)
		System.out.println("Reached Router");
		for(Tuple<IPAddress, IPAddress, String> i: route) {
			if(i.second.xor(p.destip).equality(i.first)) 
			{
				if(p.portno == 0) System.out.println(i.second.xor(p.destip).address[0]+"."+i.second.xor(p.destip).address[1]+"."+i.second.xor(p.destip).address[2]+"."+i.second.xor(p.destip).address[3]);
//				for(Quad<String, IPAddress, IPAddress, String> j: iface) {
//					if(j.third.equality(j.first)) getObject(j.forth).send(p);
//				}
				//boolean cp = p.sourceip.xor(new IPAddress("255.255.255.0")) == p.destip.xor(new IPAddress("255.255.255.0")) ;
				if(i.third.equals(p.prevhop) ) continue;
				p.prevhop = this.deviceName;
				p.hops = p.hops+3;
				getObject(i.third).send(p);
				p.hops--;
			}
			else {
				if(p.portno == 0)
				System.out.println("Roting info not availiable");
			}
		}
	}
	

}
