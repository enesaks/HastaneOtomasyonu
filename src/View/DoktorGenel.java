package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Doktor;
import DataBase.Hasta;
import Helper.DBConnection;
import Helper.Helper;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;

public class DoktorGenel extends JFrame {
	
	
	
	JInternalFrame iFHastaBilgileri = new JInternalFrame("HASTA BİLGİLERİ");
	JInternalFrame iFCalismaSaatleri = new JInternalFrame("ÇALIŞMA SAATLERİ");
	JInternalFrame iFReceteOlustur = new JInternalFrame("REÇETE OLUŞTUR");
	JInternalFrame iFHastaSonuclari = new JInternalFrame("HASTA SONUÇLARI");
	
	private DBConnection conn = new DBConnection();
	private JPanel contentPane;
	
	
	Hasta hasta=new Hasta();
	
	private static Doktor doktor = new Doktor();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorGenel frame = new DoktorGenel(doktor);
					frame.setTitle("Doktor Sayfası");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DoktorGenel(Doktor doktor) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel baslik = new JLabel("HOŞGELDİNİZ DOKTOR "+doktor.getAd()+" "+doktor.getSoyad());
		baslik.setBounds(50, 23, 547, 32);
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		contentPane.add(baslik);
		
		JButton butonHastaBilgiler = new JButton("Hasta Bilgileri");
		butonHastaBilgiler.setBounds(50, 93, 144, 38);
		butonHastaBilgiler.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonHastaBilgiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFCalismaSaatleri.setVisible(false);
				iFHastaBilgileri.setVisible(true);
				iFHastaSonuclari.setVisible(false);
				iFReceteOlustur.setVisible(false);
			}
		});
		contentPane.add(butonHastaBilgiler);
		
		
		
		JButton butonCalismaSaatleri = new JButton("Çalışma\r\n Saatleri");
		butonCalismaSaatleri.setBounds(50, 167, 144, 38);
		butonCalismaSaatleri.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonCalismaSaatleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFCalismaSaatleri.setVisible(true);
				iFHastaBilgileri.setVisible(false);
				iFHastaSonuclari.setVisible(false);
				iFReceteOlustur.setVisible(false);

			}
		});
		contentPane.add(butonCalismaSaatleri);
		iFHastaBilgileri.setBounds(215, 66, 559, 364);
		contentPane.add(iFHastaBilgileri);
		iFHastaBilgileri.getContentPane().setLayout(null);
		
		JList<String> list = new JList<>(hasta.hastaList());
		list.setBounds(55, 22, 169, 290);
		iFHastaBilgileri.getContentPane().add(list);
		
		JLabel lblAd = new JLabel("AD:");
		lblAd.setBounds(234, 32, 81, 50);
		iFHastaBilgileri.getContentPane().add(lblAd);
		iFHastaBilgileri.getContentPane().add(lblAd);

		
		JLabel lblSoyad = new JLabel("SOYAD:");
		lblSoyad.setBounds(230, 76, 85, 50);
		iFHastaBilgileri.getContentPane().add(lblSoyad);
		iFHastaBilgileri.getContentPane().add(lblSoyad);

		
		JLabel lblDogumTarih = new JLabel("DOĞUM TARİHİ:");
		lblDogumTarih.setBounds(230, 120, 85, 50);
		iFHastaBilgileri.getContentPane().add(lblDogumTarih);
		iFHastaBilgileri.getContentPane().add(lblDogumTarih);
		
		JLabel lbAd = new JLabel("");
		lbAd.setBounds(321, 32, 81, 50);
		iFHastaBilgileri.getContentPane().add(lbAd);
		
		JLabel lbSoyad = new JLabel("");
		lbSoyad.setBounds(321, 76, 81, 50);
		iFHastaBilgileri.getContentPane().add(lbSoyad);
		
		JLabel lbDogumTarihi = new JLabel("");
		lbDogumTarihi.setBounds(321, 120, 81, 50);
		iFHastaBilgileri.getContentPane().add(lbDogumTarihi);
		iFCalismaSaatleri.setBounds(215, 66, 559, 364);
		contentPane.add(iFCalismaSaatleri);

		
		JButton butonBilgileriGöster = new JButton("BİLGİLERİ GÖSTER");
		butonBilgileriGöster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(list.getSelectedValue());
				try {
					Connection con = conn.connDb();
					Statement st = con.createStatement();
					String query=("SELECT * FROM user "+" WHERE tcno='"+list.getSelectedValue()+"' ");
					ResultSet rs;
					rs = st.executeQuery(query);
					rs.next();
					lbAd.setText(rs.getString("ad").toUpperCase());
					lbSoyad.setText(rs.getString("soyad").toUpperCase());
					lbDogumTarihi.setText(rs.getString("dogumTarih"));
					
					
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		butonBilgileriGöster.setBounds(333, 203, 169, 43);
		iFHastaBilgileri.getContentPane().add(butonBilgileriGöster);
		
		
		
		JButton butonReceteYaz = new JButton("Reçete Oluştur");
		butonReceteYaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFCalismaSaatleri.setVisible(false);
				iFHastaBilgileri.setVisible(false);
				iFHastaSonuclari.setVisible(false);
				iFReceteOlustur.setVisible(true);
			}
		});
		butonReceteYaz.setBounds(50, 238, 144, 38);
		contentPane.add(butonReceteYaz);
		
		JButton butonHastaSonuclari = new JButton("Hasta Sonuçları");
		butonHastaSonuclari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFCalismaSaatleri.setVisible(false);
				iFHastaBilgileri.setVisible(false);
				iFHastaSonuclari.setVisible(true);
				iFReceteOlustur.setVisible(false);
			}
		});
		butonHastaSonuclari.setBounds(50, 304, 144, 38);
		contentPane.add(butonHastaSonuclari);

		
		
		iFReceteOlustur.setBounds(215, 66, 559, 364);
		contentPane.add(iFReceteOlustur);
		
		iFHastaSonuclari.setBounds(215, 66, 559, 364);
		contentPane.add(iFHastaSonuclari);
		
		JButton CikisButton = new JButton("Çıkış Yap");
		CikisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.showMsg("İyi günler dileriz sayın "+doktor.getAd() + " " +doktor.getSoyad());
				setVisible(false);
			}
		});
		CikisButton.setBounds(617, 23, 125, 29);
		contentPane.add(CikisButton);
		
		
		
		
		iFHastaBilgileri.setVisible(true);
		
		
	}
	}

