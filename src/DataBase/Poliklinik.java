package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Helper.DBConnection;

public class Poliklinik {

	private String polikliniIsmi;
	private int id;
	private String name;
	static DBConnection conn = new DBConnection();
	static Statement st = null;
	static ResultSet rs = null;
	static Connection con = conn.connDb();


	PreparedStatement preparedStatement = null;

	public Poliklinik(String polikliniIsmi, int id, String name) {
		super();
		this.polikliniIsmi = polikliniIsmi;
		this.id = id;
		this.name = name;
	}

	public Poliklinik() {
	}
	
	public void polkilinikEkle(String adi,int id) {
		
			String query = "INSERT INTO poliklinik (id,ad)VALUES(?,?)";
	        
	        try {
	        	st = con.createStatement();
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, adi);
				
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
		}
	public DefaultListModel<String>  poliklinikListAD( ) throws SQLException {
		
		DefaultListModel<String> dflist= new DefaultListModel<String>();
		
		
		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query=("SELECT * FROM poliklinik "+" WHERE id");
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			dflist.addElement(rs.getString("ad"));
		}

		return dflist;
	}
		
	public DefaultListModel<String>  poliklinikListId( ) throws SQLException {
		
		DefaultListModel<String> dflist= new DefaultListModel<String>();
		
		
		Connection con = conn.connDb();
		Statement st = con.createStatement();
		String query=("SELECT * FROM poliklinik "+" WHERE id");
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			dflist.addElement(rs.getString("id"));
		}

		return dflist;
	}
	

	public ArrayList<Poliklinik> getList() throws SQLException {
		ArrayList<Poliklinik> list = new ArrayList<>();
		Poliklinik obj;
		Connection con = conn.connDb();
		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM poliklinik");
			while (rs.next()) {
				obj = new Poliklinik();
				obj.setId(rs.getInt("id"));
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolikliniIsmi() {
		return polikliniIsmi;
	}

	public void setPolikliniIsmi(String polikliniIsmi) {
		this.polikliniIsmi = polikliniIsmi;
	}
}
