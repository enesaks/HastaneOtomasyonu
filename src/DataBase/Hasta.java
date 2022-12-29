package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Helper.DBConnection;
import Helper.Helper;

public class Hasta extends User {
	
	private static DBConnection conn = new DBConnection();
	static Statement st = null;
	static ResultSet rs = null;
	static Connection con = conn.connDb();
	static PreparedStatement preparedStatement = null;


	public Hasta() {
		
	}
	
	public static void KayitOl(String tcno, String ad, String soyad, String sifre, String dogumTarih) throws SQLException {
		String query = "INSERT INTO user (tcno,ad,soyad,dogumTarih,type,sifre)VALUES(?,?,?,?,?,?)";
        
        try {
        	st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, ad);
			preparedStatement.setString(3, soyad);
			preparedStatement.setString(4, sifre);
			preparedStatement.setString(5, "hasta");
			preparedStatement.setString(6, dogumTarih);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void receteEkle(String tcno,String recete) {
		String query = "INSERT INTO receteyaz (tcno,recete)VALUES(?,?)";
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, recete);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void HastaGuncelleme(String Stcno,String tcno,String ad,String soyad,String Sifre,String DogumTarih) throws SQLException {
		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query = "UPDATE `hospital`.`user` SET `tcno` = '"+tcno+"', `ad` = '"+ad+"', `soyad` = '"+soyad+"', `sifre` = '"+Sifre+"', `dogumTarih` = '"+DogumTarih+"' WHERE (`tcno` = '"+Stcno+"')";
		preparedStatement = con.prepareStatement(query);
		
		preparedStatement.executeUpdate();
		
		
	}

	
	
	

	public Hasta(String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super(tcno, ad, soyad, sifre, type, dogumTarih);
	}

	
     public DefaultListModel<String>  hastaList() throws SQLException {
		
		DefaultListModel<String> dflist= new DefaultListModel<String>();
		
		
		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query=("SELECT * FROM user "+" WHERE type='"+"hasta"+"' ");
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			dflist.addElement(rs.getString("tcno"));
			
		}
		return dflist;
     }
}
		


