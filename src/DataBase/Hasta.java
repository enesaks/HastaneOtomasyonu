package DataBase;

import java.time.LocalDate;

public class Hasta extends User{
	private String hastaninDoktoru;
	public Hasta(int id, String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super(id, tcno, ad, soyad, sifre, type, dogumTarih);
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
