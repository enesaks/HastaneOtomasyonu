package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Bashekim;
import DataBase.Doktor;
import DataBase.Hasta;
import DataBase.Poliklinik;
import Helper.DBConnection;
import Helper.Helper;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class HastaGenel extends JFrame {
	private DBConnection conn = new DBConnection();
	JInternalFrame iFRecete = new JInternalFrame("E-Reçete");
	JInternalFrame iFHastaBilgisi = new JInternalFrame("Hasta Bilgisi");
	JInternalFrame iFRandevuAll = new JInternalFrame("Randevu Al");

	private JPanel contentPane;
	static Hasta hasta = new Hasta();
	static Doktor doktor = new Doktor();
	static Bashekim bashekim = new Bashekim();
	static Poliklinik poliklinik = new Poliklinik();
	JButton btnPazartesi = new JButton("Pazartesi");
	JComboBox dList = new JComboBox();
	JTextPane textPane = new JTextPane();
	
	protected Component btnPersembe;
	private JTextField fld_gun;
	private JTextField fld_saat;
	private JTextField tfAd;
	private JTextField tfSoyad;
	private JTextField tfTcno;
	private JTextField tfDogumTarihi;
	private JPasswordField tfSifre;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaGenel frame = new HastaGenel(hasta);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public HastaGenel(Hasta hasta) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton butonHastaBilgileri = new JButton("Hasta Bilgileri");
		butonHastaBilgileri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);

				iFHastaBilgisi.setVisible(true);
				iFRandevuAll.setVisible(false);
			}
		});
		butonHastaBilgileri.setBounds(38, 118, 161, 44);
		contentPane.add(butonHastaBilgileri);

		JButton butonRandevuAl = new JButton("Randevu Al");
		butonRandevuAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);

				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(true);
			}
		});
		butonRandevuAl.setBounds(38, 180, 161, 44);
		contentPane.add(butonRandevuAl);

		JButton butonRecete = new JButton("E-Recete");
		butonRecete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = conn.connDb();
					Statement st = con.createStatement();
					String query=("SELECT * FROM receteyaz "+" WHERE tcno='"+hasta.getTcno()+"' ");
					ResultSet rs;
					rs = st.executeQuery(query);
					rs.next();
					textPane.setText(rs.getString("recete"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				iFRecete.setVisible(true);

				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(false);
			}
		});
		butonRecete.setBounds(38, 250, 161, 49);
		contentPane.add(butonRecete);
		iFRandevuAll.setBorder(new LineBorder(new Color(0, 0, 0), 0));

		iFRandevuAll.setBounds(226, 72, 885, 534);
		contentPane.add(iFRandevuAll);

		JPanel panel_1 = new JPanel();
		iFRandevuAll.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Doktor Listesi");
		lblNewLabel_1_1.setBounds(275, 171, 127, 13);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Polikinlik Adı");
		lblNewLabel_2_1.setBounds(275, 79, 92, 27);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2_1);

		JComboBox secimPoliklinik = new JComboBox();
		secimPoliklinik.setBounds(234, 125, 133, 27);
		for (int i = 0; i < poliklinik.getList().size(); i++) {
			secimPoliklinik.addItem(poliklinik.getList().get(i).getName());
			
		}
		panel_1.add(secimPoliklinik);
		
		JComboBox dList = new JComboBox();
		for (int i = 0; i < doktor.doktorListe().size(); i++) {
			dList.addItem(doktor.doktorListe().get(i).getName());
			
		}
		dList.setBounds(234, 200, 133, 27);
		
		panel_1.add(dList);

		JButton btnNewButton_1_1 = new JButton("Seç");
		btnNewButton_1_1.setBounds(502, 301, 127, 36);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(fld_gun.getText());
			
				String poliklinik=(String) secimPoliklinik.getSelectedItem();
				String doktor=(String) dList.getSelectedItem();
				if(fld_gun.getText().length() ==0||fld_saat.getText().length()==0||poliklinik.length()==0||
					doktor.length()==0){
					Helper.showMsg("fill");
		}else {
			
			try {
				Connection con = conn.connDb();
				Statement st=con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM randevu");
				rs.next();
				if(Integer.parseInt(fld_saat.getText())<1||Integer.parseInt(fld_saat.getText())>24 ||Integer.parseInt(fld_gun.getText())<1||Integer.parseInt(fld_gun.getText())>24) {
						Helper.showMsg("Lütfen 0-24 arası bir sayı giriniz");
						fld_saat.setText(null);
						fld_gun.setText(null);
					}
				Doktor.Randevu(poliklinik, doktor, fld_gun.getText(), fld_saat.getText());
				Helper.showMsg("Randevunuz Başarıyla Alındı");
				fld_saat.setText(null);
				fld_gun.setText(null);
					
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
				
			}
		});
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_4_1 = new JLabel("Randevu Gün ve Saatleri");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setBounds(395, 85, 221, 13);
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_11 = new JLabel("Gün giriniz :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(367, 131, 147, 36);
		panel_1.add(lblNewLabel_11);
		
		fld_gun = new JTextField();
		fld_gun.setBounds(532, 142, 97, 19);
		panel_1.add(fld_gun);
		fld_gun.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Saat Giriniz :");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_12.setBounds(367, 197, 147, 27);
		panel_1.add(lblNewLabel_12);
		
		fld_saat = new JTextField();
		fld_saat.setBounds(532, 203, 96, 19);
		panel_1.add(fld_saat);
		fld_saat.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel(hasta.getTcno());
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setBounds(325, 248, 156, 13);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Hasta T.C");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(234, 238, 92, 33);
		panel_1.add(lblNewLabel_14); 
		iFHastaBilgisi.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		
		

		iFHastaBilgisi.setBounds(226, 72, 885, 534);
		contentPane.add(iFHastaBilgisi);
		iFHastaBilgisi.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 593, 1);
		panel.setLayout(null);
		iFHastaBilgisi.getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 225, 228);
		panel.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Doktor Listesi");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 10, 127, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Polikinlik Adı");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(245, 49, 92, 27);
		panel.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(245, 91, 98, 27);
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Doktor Adı");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(245, 152, 92, 13);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Seç");
		btnNewButton_1.setBounds(245, 189, 98, 32);
		panel.add(btnNewButton_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(381, 33, 184, 228);
		panel.add(scrollPane_1);

		JLabel lblNewLabel_4 = new JLabel("Randevu Gün ve Saatleri");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(383, 12, 167, 13);
		panel.add(lblNewLabel_4);

		JLabel lblAd = new JLabel("AD:");
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAd.setBounds(266, 88, 128, 28);
		iFHastaBilgisi.getContentPane().add(lblAd);

		JLabel lblNewLabel_5 = new JLabel("SOYAD:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(266, 127, 128, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("T.C. KİMLİK NO:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(266, 171, 128, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("DOĞUM TARİHİ:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(266, 217, 128, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_7);

		JLabel baslik_hastaBilgileri = new JLabel("HASTA BİLGİLERİ");
		baslik_hastaBilgileri.setFont(new Font("Tahoma", Font.BOLD, 14));
		baslik_hastaBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		baslik_hastaBilgileri.setBounds(157, 29, 563, 50);
		iFHastaBilgisi.getContentPane().add(baslik_hastaBilgileri);
		
		tfAd = new JTextField(hasta.getAd());
		tfAd.setBounds(408, 94, 158, 20);
		iFHastaBilgisi.getContentPane().add(tfAd);
		tfAd.setColumns(10);
		
		tfSoyad = new JTextField(hasta.getSoyad());
		tfSoyad.setColumns(10);
		tfSoyad.setBounds(408, 133, 158, 20);
		iFHastaBilgisi.getContentPane().add(tfSoyad);
		
		tfTcno = new JTextField(hasta.getTcno());
		tfTcno.setColumns(10);
		tfTcno.setBounds(408, 177, 158, 20);
		iFHastaBilgisi.getContentPane().add(tfTcno);
		
		tfDogumTarihi = new JTextField(hasta.getDogumTarih());
		tfDogumTarihi.setColumns(10);
		tfDogumTarihi.setBounds(408, 223, 158, 20);
		iFHastaBilgisi.getContentPane().add(tfDogumTarihi);
		
		
		JLabel lblNewLabel_7_1 = new JLabel("SİFRE: ");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_1.setBounds(266, 256, 128, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_7_1);
		
		JButton btnGuncelle = new JButton("Bilgileri Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfAd.getText().length() == 0 || tfSoyad.getText().length() ==0 || tfDogumTarihi.getText().length()==0 || 
							tfSifre.getText().length() == 0 || tfTcno.getText().length()==0) {
						Helper.showMsg("fill");	
					}
					
					Connection con = conn.connDb();
					Statement st = con.createStatement();
					String query=("SELECT * FROM user "+" WHERE ad='"+hasta.getAd()+"' ");
					ResultSet rs;
					rs = st.executeQuery(query);
					rs.next();
					hasta.HastaGuncelleme(rs.getString("tcno"),tfTcno.getText(), tfAd.getText(),tfSoyad.getText(), tfSifre.getText(), tfDogumTarihi.getText());
					
					String query2=("SELECT * FROM user "+" WHERE ad='"+tfAd.getText()+"' ");
				
					rs = st.executeQuery(query2);
					rs.next();
					Helper.showMsg("Bilgiker Güncellendi.");
					tfAd.setText(rs.getString("ad"));
					tfSoyad.setText(rs.getString("soyad"));
					tfTcno.setText(rs.getString("tcno"));
					tfDogumTarihi.setText(rs.getString("dogumTarih"));
					tfSifre.setText(rs.getString("sifre"));
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuncelle.setBounds(438, 313, 128, 37);
		iFHastaBilgisi.getContentPane().add(btnGuncelle);
		
		tfSifre = new JPasswordField(hasta.getSifre());
		tfSifre.setBounds(408, 262, 158, 20);
		iFHastaBilgisi.getContentPane().add(tfSifre);
		iFRecete.setBorder(new LineBorder(new Color(0, 0, 0), 0));

		iFRecete.setBounds(224, 72, 887, 534);
		contentPane.add(iFRecete);
		iFRecete.getContentPane().setLayout(null);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setEditable(false);
		
		
		textPane.setBounds(241, 127, 421, 170);
		iFRecete.getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("Receteniz");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(106, 127, 170, 43);
		iFRecete.getContentPane().add(lblNewLabel);

		JLabel baslik = new JLabel("HOŞGELDİN " + hasta.getAd() + " " + hasta.getSoyad());
		baslik.setFont(new Font("Tahoma", Font.BOLD, 15));
		baslik.setBounds(38, 10, 547, 50);
		contentPane.add(baslik);

		JButton CikisYap = new JButton("Çıkış Yap");
		CikisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.showMsg("Sağlıklı günler dileriz " + hasta.getAd() + " " + hasta.getSoyad());
				setVisible(false);
			}  
		});
		CikisYap.setBounds(638, 25, 148, 35);
		contentPane.add(CikisYap);
		
		JLabel arkaplan = new JLabel(new ImageIcon(this.getClass().getResource("arka2.png")));
				
		arkaplan.setBounds(0, 0, 1184, 711);
		contentPane.add(arkaplan);

		iFHastaBilgisi.setVisible(true);
	}
}
