package DataBase;

public class Hasta extends User{
	private String hastaninDoktoru;
	
	
	public Hasta(int id, String tcno, String name, String password, String type) {
		super(id, tcno, name, password, type);
	}
	public Hasta() {
		
	}
	
	public String getHastaninDoktoru() {
		return hastaninDoktoru;
	}
	public void setHastaninDoktoru(String hastaninDoktoru) {
		this.hastaninDoktoru = hastaninDoktoru;
	}
	
	
	

}
