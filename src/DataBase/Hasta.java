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
	private DBConnection conn = new DBConnection();

	Statement st = null;
	ResultSet rs = null;
	Connection con = conn.connDb();
	PreparedStatement preparedStatement = null;

	public Hasta() {

	}

	public Hasta(int id, String tcno, String ad, String soyad, String sifre, String type, String dogumTarih) {
		super(id, tcno, ad, soyad, sifre, type, dogumTarih);
	}
	
		//	HastaKayıtOl panelinde alınacak bilgileri kayıt adı altında burada yazdım..Sorun şu kayıt edilen hastanın bilgileri
		// 	veri tabanında gözükmüyor.Ve tekrar giriş ekranına gelince hasta bulunamıyor..
	public boolean kayıt(String ad, String soyad, String tcno, String dogumTarih, String sifre) throws SQLException {
		int key = 0;
		boolean duplicate = false;
		String query = "INSERT INTO user " + "(ad,soyad,tcno,dogumTarih,sifre,type) VALUES" + "(?,?,?,?,?,?)";
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE tcno = '" + tcno + "'");
			while (rs.next()) {
				duplicate = true;
				Helper.showMsg("Bu TC numarasına ait bir kayıt bulunmaktadır ");
				break;
			}
			if (!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, ad);
				preparedStatement.setString(2, soyad);
				preparedStatement.setString(3, tcno);
				preparedStatement.setString(4, dogumTarih);
				preparedStatement.setString(5, sifre);
				preparedStatement.setString(6, "hasta");
				key = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key == 1) {
			return true;
		} else
			return false;

	}

	public String getHastaninDoktoru() {
		return hastaninDoktoru;
	}

	public void setHastaninDoktoru(String hastaninDoktoru) {
		this.hastaninDoktoru = hastaninDoktoru;
	}

}
