package mart;
public class Inimene{
	public double lbsid;
	public double ruutjalad;

	
	public Inimene(double lbsid, double ruutjalad){
		this.lbsid = lbsid;
		this.ruutjalad = ruutjalad;
	}	
	public double lbs(){
		lbsid = lbsid*2.20462262 ;
		
		return lbsid;
	}
	
}