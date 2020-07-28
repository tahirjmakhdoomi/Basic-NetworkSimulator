package Containers;

public class IPAddress {

	public int[] address = new int[4];
	
	
	public IPAddress(String ip) 
	{
		
		this.address[0] = Integer.parseInt(ip.substring(0, 3));
		this.address[1] = Integer.parseInt(ip.substring(4, 7));
		this.address[2] = Integer.parseInt(ip.substring(8, 11));
		this.address[3] = Integer.parseInt(ip.substring(12, 15));
	
	}
	public IPAddress xor(IPAddress a) {
		IPAddress x = new IPAddress("000.000.000.000");
		x.address[0] = this.address[0] & a.address[0];
		x.address[1] = this.address[1] & a.address[1];
		x.address[2] = this.address[2] & a.address[2];
		x.address[3] = this.address[3] & a.address[3];
		return x;
		
	}
	
	public boolean equality(IPAddress b) {
		if(this.address[0] == b.address[0] && this.address[1] == b.address[1] && this.address[2] == b.address[2] && this.address[3] == b.address[3])
		{return true;}
		else {return false;}
		
	}
	public String toStr() {
		return (this.address[0]+"."+this.address[1]+"."+this.address[2]+"."+this.address[3]);
	}
	
	
}
