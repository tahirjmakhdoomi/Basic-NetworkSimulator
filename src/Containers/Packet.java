package Containers;

public class Packet {
	
	public String source;
	public String prevhop = "";
	public String dest;
	public String data;
	public IPAddress sourceip;
	public IPAddress destip;
	public int hops = 0;
	public int portno = 0 ;
	
}
