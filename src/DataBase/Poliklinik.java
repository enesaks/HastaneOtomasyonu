package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Poliklinik {

	private String polikliniIsmi;
	private int id;
	private String name;
	DBConnection conn = new DBConnection();

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Poliklinik(String polikliniIsmi, int id, String name) {
		super();
		this.polikliniIsmi = polikliniIsmi;
		this.id = id;
		this.name = name;
	}

	public Poliklinik() {
	}

	public ArrayList<Poliklinik> getList() throws SQLException {
		ArrayList<Poliklinik> list = new ArrayList<>();
		Poliklinik obj;
		Connection con = conn.connDb();
		try {

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic");
			while (rs.next()) {
				obj = new Poliklinik();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
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
