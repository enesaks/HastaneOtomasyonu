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
	PreparedStatement preparedStatement = null;

	public Hasta() {
		//
	}

	public Hasta(int id, String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super(id, tcno, ad, soyad, sifre, type, dogumTarih);
	}
	
		

	  
	
	public String getHastaninDoktoru() {
		return hastaninDoktoru;
	}

	public void setHastaninDoktoru(String hastaninDoktoru) {
		this.hastaninDoktoru = hastaninDoktoru;
	}

}
