package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Hasta;
import Helper.Helper;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HastaKayıtOl extends JFrame {
	private JPasswordField fld_kayıtSifre;
	private JTextField fld_kayıtDG;
	private JTextField fld_kayıtTC;
	private JTextField fld_kayıtSoyad;
	private JTextField fld_kayıtAd;
	static Hasta hasta=new Hasta();

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null); 
		
		//KayıtOl butonuna basınca olacak opsiyonlar buraya yazıldı..Neden veritabanına veri aktarılmıyor bilmiyorum.

		JButton butonHastaKayit = new JButton("Kayıt ol");
		butonHastaKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaLogin login=new HastaLogin();
				login.setVisible(true);
				dispose();}

			
		});
		butonHastaKayit.setBounds(234, 226, 102, 27);
		getContentPane().add(butonHastaKayit);

		fld_kayıtSifre = new JPasswordField();
		fld_kayıtSifre.setBounds(234, 185, 86, 20);
		getContentPane().add(fld_kayıtSifre);

		JLabel lblSifreHastaKayit = new JLabel("Sifre");
		lblSifreHastaKayit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblSifreHastaKayit.setBounds(67, 180, 112, 24);
		getContentPane().add(lblSifreHastaKayit);

		JLabel lblDogumTarihiHastaKayit = new JLabel("Doğum Tarihi");
		lblDogumTarihiHastaKayit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblDogumTarihiHastaKayit.setBounds(67, 149, 112, 27);
		getContentPane().add(lblDogumTarihiHastaKayit);

		JLabel lblAdHastaKayit = new JLabel("Ad");
		lblAdHastaKayit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblAdHastaKayit.setBounds(67, 63, 112, 14);
		getContentPane().add(lblAdHastaKayit);

		JLabel lblSoyadHastaKayit = new JLabel("Soyad");
		lblSoyadHastaKayit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblSoyadHastaKayit.setBounds(67, 88, 112, 23);
		getContentPane().add(lblSoyadHastaKayit);

		JLabel lbl_TCHastaKayit = new JLabel("TC Numaranız");
		lbl_TCHastaKayit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lbl_TCHastaKayit.setBounds(67, 118, 112, 21);
		getContentPane().add(lbl_TCHastaKayit);

		fld_kayıtDG = new JTextField();
		fld_kayıtDG.setColumns(10);
		fld_kayıtDG.setBounds(234, 155, 86, 20);
		getContentPane().add(fld_kayıtDG);

		fld_kayıtTC = new JTextField();
		fld_kayıtTC.setColumns(10);
		fld_kayıtTC.setBounds(234, 121, 86, 20);
		getContentPane().add(fld_kayıtTC);

		fld_kayıtSoyad = new JTextField();
		fld_kayıtSoyad.setColumns(10);
		fld_kayıtSoyad.setBounds(234, 92, 86, 20);
		getContentPane().add(fld_kayıtSoyad);

		fld_kayıtAd = new JTextField();
		fld_kayıtAd.setColumns(10);
		fld_kayıtAd.setBounds(234, 60, 86, 20);
		getContentPane().add(fld_kayıtAd);

		JLabel baslik = new JLabel("Hasta Kayıt Ekranı");
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(113, 10, 223, 40);
		getContentPane().add(baslik);

		// Geri dön butonu oluşturup HastaLogine dönmesini sağladım..

		JButton butonGeriDön = new JButton("Geri Dön");
		butonGeriDön.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaLogin login = new HastaLogin();
				login.setVisible(true); 
				dispose();
			}
		});
		butonGeriDön.setBounds(66, 226, 102, 27);
		getContentPane().add(butonGeriDön);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
