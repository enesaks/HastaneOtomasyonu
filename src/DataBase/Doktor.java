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

public class Doktor extends User{
	private static DBConnection conn = new DBConnection();
	private String name;
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
	
	public static void CalismaSaatleri(int doktor_id,String doktor_ad,String date) {
		try {
			String query="INSERT INTO calismasaatleri(doktor_id,doktor_ad,date) VALUES(?,?,?)";
			Connection con = conn.connDb();
			Statement st = con.createStatement();
			preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1,doktor_id);
			preparedStatement.setString(2, doktor_ad);
			preparedStatement.setString(3, date);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Doktor> doktorListe() throws SQLException {
		ArrayList<Doktor> list = new ArrayList<>();
		Doktor obj;
		Connection con = conn.connDb();
		try {

			st = con.createStatement();
			
			rs = st.executeQuery("SELECT * FROM user WHERE type='"+"doktor"+"' ");
			while (rs.next()) {
				obj = new Doktor();
				obj.setName(rs.getString("ad"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return list;

	}
	
	
	public static void Randevu(String tcno, String ad, String soyad, String sifre, String dogumTarih) throws SQLException {
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
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	

}
