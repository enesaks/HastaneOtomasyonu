package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.DefaultListModel;

import Helper.DBConnection;

public class Doktor extends User{
	private static DBConnection conn = new DBConnection();
	static PreparedStatement preparedStatement = null;
	
	static Statement st = null;
	static ResultSet rs = null;
	static Connection con = conn.connDb();

	public Doktor(String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super( tcno, ad, soyad, sifre, type, dogumTarih);
	
	}
	public Doktor() {  
		
	} 
	
	public DefaultListModel<String>  doktorList( ) throws SQLException {
		
		DefaultListModel<String> dflist= new DefaultListModel<String>();
		
		
		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query=("SELECT * FROM user "+" WHERE type='"+"doktor"+"' ");
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			dflist.addElement(rs.getString("ad"));
		}

		return dflist;
	}
	public void DoktorGuncelleme(String Stcno,String tcno,String ad,String soyad,String Sifre,String DogumTarih,String Poliklinik) throws SQLException {
		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query = "UPDATE `hospital`.`user` SET `tcno` = '"+tcno+"', `ad` = '"+ad+"', `soyad` = '"+soyad+"', `sifre` = '"+Sifre+"', `dogumTarih` = '"+DogumTarih+"', `poliklinik` = '"+Poliklinik+"' WHERE (`tcno` = '"+Stcno+"')";
		preparedStatement = con.prepareStatement(query);
		
		preparedStatement.executeUpdate();
		
		
	}
public DefaultListModel<String>  doktorList2(int id) throws SQLException {
		
		DefaultListModel<String> dflist= new DefaultListModel<String>();
		

		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query=("SELECT * FROM user "+" WHERE poliklinik='"+id+"' ");
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			dflist.addElement(rs.getString("ad"));
		}

		return dflist;
	}
	
	public static void KayitOl(String tcno, String ad, String soyad, String sifre, String dogumTarih,int poliklinik) throws SQLException {
		String query = "INSERT INTO user (tcno,ad,soyad,dogumTarih,type,sifre,poliklinik)VALUES(?,?,?,?,?,?,?)";
        
        try {
        	st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, tcno);
			preparedStatement.setString(2, ad);
			preparedStatement.setString(3, soyad);
			preparedStatement.setString(4, sifre);
			preparedStatement.setString(5, "doktor");
			preparedStatement.setString(6, dogumTarih);
			preparedStatement.setInt(7, poliklinik);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	public static void DoktorKaldir(String tcno) {
		
		try {
			String query = "DELETE FROM `hospital`.`user` WHERE (`tcno` = '2')";
			Connection con = conn.connDb();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
