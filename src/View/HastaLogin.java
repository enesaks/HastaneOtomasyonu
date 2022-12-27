package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Hasta;
import Helper.DBConnection;
import Helper.Helper;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class HastaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField fldTCHastaGiris;
	private JPasswordField fldSifreHastaGiris;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaLogin frame = new HastaLogin();
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
	public HastaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_TCHastaGiris = new JLabel("T.C NUMARASI:");
		lbl_TCHastaGiris.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TCHastaGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lbl_TCHastaGiris.setBounds(76, 85, 113, 17);
		contentPane.add(lbl_TCHastaGiris);

		JLabel lblSifreHastaGiris = new JLabel("ŞİFRE:");
		lblSifreHastaGiris.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifreHastaGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblSifreHastaGiris.setBounds(76, 124, 99, 14);
		contentPane.add(lblSifreHastaGiris);

		JButton butonGirisHastaGiris = new JButton("Giriş Yap");
		butonGirisHastaGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonGirisHastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fldTCHastaGiris.getText().length() == 0 || fldSifreHastaGiris.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					boolean key = true;
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");

						while (rs.next()) {
							if (fldTCHastaGiris.getText().equals(rs.getString("tcno"))
									&& fldSifreHastaGiris.getText().equals(rs.getString("sifre"))) {

								if (rs.getString("type").equals("hasta")) {
									Hasta hasta = new Hasta();
			
									hasta.setAd(rs.getString("ad"));
									hasta.setSoyad(rs.getString("soyad"));
									hasta.setTcno(rs.getString("tcno"));
									hasta.setSifre(rs.getString("sifre"));
									hasta.setType(rs.getString("type"));
									System.out.println(hasta.getAd());
									HastaGenel hGenel = new HastaGenel(hasta);
									// DÜZELTİLECEK
									hGenel.setVisible(true);
									// Diger panele taşımayı sağlar..
									dispose();
									// Önceki paneli kapatır..
									key = false;
								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (key) {
						Helper.showMsg("Böyle bir hasta bulunamadı lütfen kayıt olunuz");
					}
				}
			}
		});
		butonGirisHastaGiris.setBounds(104, 187, 99, 35);
		contentPane.add(butonGirisHastaGiris);

		JButton butonKayitOlHastaGiris = new JButton("Kayıt Ol");
		butonKayitOlHastaGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonKayitOlHastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HastaKayıtOl hKayıt=new HastaKayıtOl();
				hKayıt.setVisible(true);
				dispose();				
			}
		});
		butonKayitOlHastaGiris.setBounds(230, 187, 99, 35);
		contentPane.add(butonKayitOlHastaGiris);

		fldTCHastaGiris = new JTextField();
		fldTCHastaGiris.setBounds(243, 86, 113, 20);
		contentPane.add(fldTCHastaGiris);
		fldTCHastaGiris.setColumns(10);

		JLabel baslik = new JLabel("HASTA GİRİŞ EKRANI");
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		baslik.setBounds(140, 28, 175, 20);
		contentPane.add(baslik);

		fldSifreHastaGiris = new JPasswordField();
		fldSifreHastaGiris.setBounds(243, 124, 113, 19);
		contentPane.add(fldSifreHastaGiris);
		
		
		//photo eklenecek
		JButton geri_butonu = new JButton(new ImageIcon(this.getClass().getResource("return.png")));
		geri_butonu.setBorder(UIManager.getBorder("Tree.editorBorder"));
		geri_butonu.setBackground(Color.LIGHT_GRAY);
		
		
		
		  getContentPane().add(geri_butonu);   
		
		geri_butonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		geri_butonu.setBounds(10, 11, 26, 20);
		contentPane.add(geri_butonu);
	}
}
