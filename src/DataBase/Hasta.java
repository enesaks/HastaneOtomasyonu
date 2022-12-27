package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Helper.DBConnection;
import Helper.Helper;

public class Hasta extends User {
	private String hastaninDoktoru;
	private static DBConnection conn = new DBConnection();
	static Statement st = null;
	static ResultSet rs = null;
	static Connection con = conn.connDb();
	static PreparedStatement preparedStatement = null;


	public Hasta() {
		//
	}
	
	public static void KayitOl(String tcno, String ad, String soyad, String sifre, String dogumTarih) throws SQLException {
		String query = "INSERT INTO user (tcno,ad,soyad,dogumTarih,type,sifre)VALUES(?,?,?,?,?,?)";
        
        try {
        	st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, ad);
			preparedStatement.setString(3, soyad);
			preparedStatement.setString(4, dogumTarih);
			preparedStatement.setString(5, "hasta");
			preparedStatement.setString(6, sifre);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public Hasta(String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super(tcno, ad, soyad, sifre, type, dogumTarih);
	}

	public String getHastaninDoktoru() {
		return hastaninDoktoru; 
	}

	public void setHastaninDoktoru(String hastaninDoktoru) {
		this.hastaninDoktoru = hastaninDoktoru;
	}

}
