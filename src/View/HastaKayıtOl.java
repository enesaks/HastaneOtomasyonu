package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Hasta;
import Helper.DBConnection;
import Helper.Helper;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class HastaKayıtOl extends JFrame {
	protected static final String String = null;
	private JPasswordField fld_kayıtSifre;
	private JTextField fld_kayıtDG;
	private JTextField fld_kayıtTC;
	private JTextField fld_kayıtSoyad;
	private JTextField fld_kayıtAd;
	private DBConnection conn = new DBConnection();
	static ResultSet rs;
	static Hasta hasta = new Hasta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaKayıtOl frame = new HastaKayıtOl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HastaKayıtOl() {
		getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		// KayıtOl butonuna basınca olacak opsiyonlar buraya yazıldı..Neden veritabanına
		// veri aktarılmıyor bilmiyorum.

		JButton butonHastaKayit = new JButton("Kayıt ol");
		butonHastaKayit.setFont(new Font("Segoe Print", Font.BOLD, 12));
		butonHastaKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c=1;
				if (fld_kayıtAd.getText().length() == 0 || fld_kayıtSoyad.getText().length() == 0
						|| fld_kayıtTC.getText().length() == 0 || fld_kayıtDG.getText().length() == 0
						|| fld_kayıtSifre.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					Connection con = conn.connDb();
					try {
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (fld_kayıtTC.getText().equals(rs.getString("tcno"))) {
								Helper.showMsg("Lütfen aynı kimlikle girme ");
								
							} else if (fld_kayıtTC.getText().length() != 11) {
								Helper.showMsg("Lütfen 11 hane giriniz");
								c = 0; 
								break;
							}

						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(c==1) {

						try {
							Hasta hasta = new Hasta();
							hasta.KayitOl(fld_kayıtTC.getText(), fld_kayıtAd.getText(), fld_kayıtSoyad.getText(),
									fld_kayıtDG.getText(), fld_kayıtSifre.getText());
							Helper.showMsg("success");
							HastaLogin hLog = new HastaLogin();
							// DÜZELTİLECEK
							hLog.setVisible(true);
							// Diger panele taşımayı sağlar..
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					fld_kayıtTC.setText(null);
					fld_kayıtAd.setText(null);
					fld_kayıtSoyad.setText(null);
					fld_kayıtDG.setText(null);
					fld_kayıtSifre.setText(null);

				}

			}

		});
		
		
		
		butonHastaKayit.setBounds(633, 383, 119, 32);
		getContentPane().add(butonHastaKayit);

		fld_kayıtSifre = new JPasswordField();
		fld_kayıtSifre.setBounds(602, 340, 102, 20);
		getContentPane().add(fld_kayıtSifre);

		JLabel lblSifreHastaKayit = new JLabel("Sifre");
		lblSifreHastaKayit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifreHastaKayit.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSifreHastaKayit.setBounds(435, 335, 138, 24);
		getContentPane().add(lblSifreHastaKayit);

		JLabel lblDogumTarihiHastaKayit = new JLabel("Doğum Tarihi");
		lblDogumTarihiHastaKayit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDogumTarihiHastaKayit.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDogumTarihiHastaKayit.setBounds(435, 304, 138, 27);
		getContentPane().add(lblDogumTarihiHastaKayit);

		JLabel lblAdHastaKayit = new JLabel("Ad");
		lblAdHastaKayit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdHastaKayit.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAdHastaKayit.setBounds(435, 222, 138, 14);
		getContentPane().add(lblAdHastaKayit);

		JLabel lblSoyadHastaKayit = new JLabel("Soyad");
		lblSoyadHastaKayit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyadHastaKayit.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSoyadHastaKayit.setBounds(435, 247, 138, 23);
		getContentPane().add(lblSoyadHastaKayit);

		JLabel lbl_TCHastaKayit = new JLabel("TC Numaranız");
		lbl_TCHastaKayit.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TCHastaKayit.setFont(new Font("Arial", Font.PLAIN, 18));
		lbl_TCHastaKayit.setBounds(435, 273, 138, 21);
		getContentPane().add(lbl_TCHastaKayit);

		fld_kayıtDG = new JTextField();
		fld_kayıtDG.setColumns(10);
		fld_kayıtDG.setBounds(602, 310, 102, 20);
		getContentPane().add(fld_kayıtDG);

		fld_kayıtTC = new JTextField();
		fld_kayıtTC.setColumns(10);
		fld_kayıtTC.setBounds(601, 279, 103, 20);
		getContentPane().add(fld_kayıtTC);

		fld_kayıtSoyad = new JTextField();
		fld_kayıtSoyad.setColumns(10);
		fld_kayıtSoyad.setBounds(601, 250, 103, 20);
		getContentPane().add(fld_kayıtSoyad);

		fld_kayıtAd = new JTextField();
		fld_kayıtAd.setColumns(10);
		fld_kayıtAd.setBounds(601, 218, 103, 20);
		getContentPane().add(fld_kayıtAd);

		JLabel baslik = new JLabel("Hasta Kayıt Ekranı");
		baslik.setForeground(new Color(0, 0, 139));
		baslik.setFont(new Font("Segoe Print", Font.BOLD, 22));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(447, 167, 269, 40);
		getContentPane().add(baslik);
		
		
		
		

		// Geri dön butonu oluşturup HastaLogine dönmesini sağladım..

		JButton butonGeriDön = new JButton("Geri Dön");
		butonGeriDön.setFont(new Font("Segoe Print", Font.BOLD, 12));
		butonGeriDön.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaLogin login = new HastaLogin();
				login.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		butonGeriDön.setBounds(446, 383, 138, 32);
		getContentPane().add(butonGeriDön);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(this.getClass().getResource("arka2.png")));
		lblNewLabel.setBounds(0, 0, 1184, 711);
		getContentPane().add(lblNewLabel);
	}
	

	
}
