package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.DefaultListModel;

import Helper.DBConnection;

public class Doktor extends User{
	private DBConnection conn = new DBConnection();

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

}
