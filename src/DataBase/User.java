package DataBase;



public class User {
	private int id;
	private String tcno,ad,soyad,sifre,type,dogumTarih;
	
	public User( String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super();
		 
		this.tcno = tcno;
		this.ad = ad;
		this.soyad = soyad;
		this.sifre = sifre;
		this.type = type;
		this.dogumTarih = dogumTarih;
	}
	public User() {
		
	}
	
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDogumTarih() {
		return dogumTarih;
	}
	public void setDogumTarih(String dogumTarih) {
		
		this.dogumTarih = dogumTarih;
	}
	
	

}
