import java.util.Scanner;

import com.sun.javadoc.Type;

import Containers.IPAddress;
import Containers.Packet;
import Containers.Pair;
import Devices.EndDevice;
import Devices.Hub;
import Devices.Router;
import Devices.Switch;
import parent.Device;

public class Emulator {

	public static void main(String[] args) 
	{
		
		System.out.println(Device.Thubs.isEmpty());
//		Hub h1 = new Hub("Hub1");
//		Hub h2 = new Hub("Hub2");
//		Switch s1 = new Switch("Switch1");
//		//h1.setPorts(3);
//		//h1.data = "sdjfhgdsjf";
//		
//		Switch s2 = new Switch("Switch2");
		//h1.setPorts(3);
		//h1.setName("Hub_2");
		
//		EndDevice e1 = new EndDevice("E1");
//		e1.ip = new IPAddress("192.168.001.002");						
//		EndDevice e2 = new EndDevice("E2");
//		e2.ip = new IPAddress("192.168.001.003");
//		EndDevice e3 = new EndDevice("E3");
//		e3.ip = new IPAddress("172.031.002.002");
//		EndDevice e4 = new EndDevice("E4");
//		e4.ip = new IPAddress("192.168.002.003");
//		EndDevice e5 = new EndDevice("E5");
//		e5.ip = new IPAddress("192.168.001.004");
//		EndDevice e6 = new EndDevice("E6");
//		e1.ip = new IPAddress("192.168.001.005");
//		Router r1 = new Router("Router1");
		
		//System.out.println(Device.Thubs.isEmpty());
		//for (Pair<String, Hub> i: Device.Thubs) {
		//	System.out.println(i.first+ " " +i.second+ "" + i.second.data);
		//}
		
		
		
//		r1.configureInterface();
//		r1.addRoute();
//		h1.makeConn(s1);
//		s2.makeConn(h2);
//		e5.makeConn(s1);
//		e6.makeConn(s1);
//		e1.makeConn(h1);e2.makeConn(h1);
//		e3.makeConn(h2);e4.makeConn(h2);
		
		//r1.getInterfaceInfo();
		
		
		//e1.data ="RajniKa,tsdfs";
		//e1.send(e1.deviceName,"", e2.deviceName);
		
		//for (Pair<String, Hub> i: Device.Thubs) {
		//	System.out.println(i.first+ " " +i.second+ "" + i.second.data);
		//}
		//e1.send(e1.deviceName,"", e4.deviceName);
		/*Packet p1 = new Packet();
			
		p1.hops = 0;
		p1.source = e3.deviceName;
		p1.dest = e1.deviceName;
		p1.sourceip = e3.ip;
		p1.destip = e1.ip;
		Device.getObject(p1.source).send(p1);
		
		System.out.println("Data of e1 =" + e1.data);
		System.out.println("Data of e5 = " + e5.data);
		System.out.println("Data of e4 = " + e4.data);
		System.out.println("Data of e3 = " + e3.data);
		
		//System.out.println("Data of e4 = " + e4.data);*/
		
		System.out.println("Welcome \n Topology is already set");
		System.out.println("\t\t\t\t\t\t\t(192.168.001.001)Router1(172.31.002.001)");
		System.out.println("\t\t\t\t\tSwitch1\t\t\t\t\t\t\t\tSwitch2");
		System.out.println("\t\t(192.168.001.004)E5\tHub1\tE6(192.168.001.005)\t\t\t\t\tHub2");
		System.out.println("\t\t    (192.168.001.002)E1\tE2(192.168.001.003)\t\t\t(172.031.002.002)E3\t\t\t E4(172.031.002.003)");
		System.out.println("");
		
		EndDevice e1 = new EndDevice("E1");
		e1.ip = new IPAddress("192.168.001.002");						
		
		EndDevice e2 = new EndDevice("E2");
		e2.ip = new IPAddress("192.168.001.003");
		
		EndDevice e3 = new EndDevice("E3");
		e3.ip = new IPAddress("172.031.002.002");
		
		EndDevice e4 = new EndDevice("E4");
		e4.ip = new IPAddress("172.031.002.003");
		
		EndDevice e5 = new EndDevice("E5");
		e5.ip = new IPAddress("192.168.001.004");
		
		EndDevice e6 = new EndDevice("E6");
		e6.ip = new IPAddress("192.168.001.005");
		
		Hub h1 = new Hub("Hub1");
		Hub h2 = new Hub("Hub2");
		Switch s1 = new Switch("Switch1");
		Switch s2 = new Switch("Switch2");
		
		Router r1 = new Router("Router1");
		
		r1.configureInterface();
		r1.addRoute();
		h1.makeConn(s1);
		s2.makeConn(h2);
		e5.makeConn(s1);
		e6.makeConn(s1);
		e1.makeConn(h1);e2.makeConn(h1);
		e3.makeConn(h2);e4.makeConn(h2);
		System.out.println("Printing Router Information");
		r1.getInterfaceInfo();
		System.out.println();
		System.out.println("Printing Router Routes");
		r1.getRouteInfo();
		int cont = 1;
		while(cont != 0) {
		System.out.println();
		System.out.println("1. For ARP");
		System.out.println("2. Send Data");
		System.out.println("3. Get Date From Server");
		System.out.println("4. Get WebPage From Server");
		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		if(option == 1) {
			System.out.println("Enter IP address in XXX.XXX.XXX.XXX format");
			String ip = s.next();
			try {
				System.out.println("This device is of the following name in the network : "+Device.getObjectip(ip));
				
			} catch (Exception e) {
				System.out.println("Host not fouund");
			}
			
		}
		else if(option ==2) {
			Packet one  = new Packet();
			one.prevhop = "";
			one.hops = 0;
			
			System.out.println("Select names from tht above topology");
			System.out.println("Enter Source Name :");
			String source = s.next();
			System.out.println("Enter Dest Name :");
			String dest = s.next();
			System.out.println("Enter Source IP :");
			String sourceip = s.next();
			System.out.println("Enter Dest IP :");
			String destip = s.next();
			System.out.println("Enter Data :");
			String data = s.next();
			
			one.data = data;
			one.dest = dest;
			one.destip = new IPAddress(destip);
			one.source = source;
			one.sourceip = new IPAddress(sourceip);
			
			Device.getObject(source).send(one);
		}
		else if(option ==3) {
			Packet one  = new Packet();
			one.prevhop = "";
			one.hops = 0;
			
			System.out.println("Select names from tht above topology");
			System.out.println("Enter Source Name :");
			String source = s.next();
			System.out.println("Enter Dest Name :");
			String dest = s.next();
			System.out.println("Enter Source IP :");
			String sourceip = s.next();
			System.out.println("Enter Dest IP :");
			String destip = s.next();
					
			one.dest = dest;
			one.destip = new IPAddress(destip);
			one.source = source;
			one.sourceip = new IPAddress(sourceip);
			one.portno = 10;
			Device.getObject(source).send(one);
		}
		else if(option ==4) {
			Packet one  = new Packet();
			one.prevhop = "";
			one.hops = 0;
			
			System.out.println("Select names from tht above topology");
			System.out.println("Enter Source Name :");
			String source = s.next();
			System.out.println("Enter Dest Name :");
			String dest = s.next();
			System.out.println("Enter Source IP :");
			String sourceip = s.next();
			System.out.println("Enter Dest IP :");
			String destip = s.next();
					
			one.dest = dest;
			one.destip = new IPAddress(destip);
			one.source = source;
			one.sourceip = new IPAddress(sourceip);
			one.portno = 20;
			Device.getObject(source).send(one);
		}
		else {
			System.out.println("Not an option");
			
		}
		System.out.println();
		System.out.println("Thankyou");
		System.out.println("Press any number to to do again and 0  to exit");
		cont = s.nextInt();
	}
		
	}

}
