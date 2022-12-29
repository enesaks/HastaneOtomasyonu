package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Doktor;
import DataBase.Hasta;
import Helper.DBConnection;
import Helper.Helper;

import javax.swing.ImageIcon;
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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class DoktorGenel extends JFrame {
	
	
	
	JInternalFrame iFHastaBilgileri = new JInternalFrame("HASTA BİLGİLERİ");
	JInternalFrame iFReceteOlustur = new JInternalFrame("REÇETE OLUŞTUR");
	
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
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel baslik = new JLabel("HOŞGELDİNİZ DOKTOR "+doktor.getAd()+" "+doktor.getSoyad());
		baslik.setBounds(62, 55, 547, 46);
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Segoe Print", Font.BOLD, 17));
		contentPane.add(baslik);
		
		JButton butonHastaBilgiler = new JButton("Hasta Bilgileri");
		butonHastaBilgiler.setBounds(111, 192, 224, 38);
		butonHastaBilgiler.setFont(new Font("Arial", Font.BOLD, 16));
		butonHastaBilgiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				iFHastaBilgileri.setVisible(true);
				iFReceteOlustur.setVisible(false);
			}
		});
		contentPane.add(butonHastaBilgiler);
		iFHastaBilgileri.setBounds(472, 100, 702, 531);
		contentPane.add(iFHastaBilgileri);
		iFHastaBilgileri.getContentPane().setLayout(null);
		
		JList<String> list = new JList<>(hasta.hastaList());
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBounds(51, 120, 169, 262);
		iFHastaBilgileri.getContentPane().add(list);
		
		JLabel lblAd = new JLabel("AD:");
		lblAd.setFont(new Font("Arial", Font.BOLD, 14));
		lblAd.setBounds(303, 120, 113, 50);
		iFHastaBilgileri.getContentPane().add(lblAd);
		iFHastaBilgileri.getContentPane().add(lblAd);

		
		JLabel lblSoyad = new JLabel("SOYAD:");
		lblSoyad.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoyad.setBounds(303, 181, 113, 50);
		iFHastaBilgileri.getContentPane().add(lblSoyad);
		iFHastaBilgileri.getContentPane().add(lblSoyad);

		
		JLabel lblDogumTarih = new JLabel("DOĞUM TARİHİ:");
		lblDogumTarih.setFont(new Font("Arial", Font.BOLD, 14));
		lblDogumTarih.setBounds(303, 242, 113, 50);
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

		
		JButton butonBilgileriGöster = new JButton("BİLGİLERİ GÖSTER");
		butonBilgileriGöster.setFont(new Font("Segoe Print", Font.BOLD, 13));
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
		butonBilgileriGöster.setBounds(454, 371, 169, 43);
		iFHastaBilgileri.getContentPane().add(butonBilgileriGöster);
		
		JLabel lblNewLabel_2 = new JLabel("Lütfen bir hasta seçiniz.");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(51, 95, 169, 14);
		iFHastaBilgileri.getContentPane().add(lblNewLabel_2);
		
		
		
		JButton butonReceteYaz = new JButton("Reçete Oluştur");
		butonReceteYaz.setFont(new Font("Arial", Font.BOLD, 16));
		butonReceteYaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				iFHastaBilgileri.setVisible(false);
				iFReceteOlustur.setVisible(true);	
		
			}
		});
		butonReceteYaz.setBounds(111, 255, 224, 38);
		contentPane.add(butonReceteYaz);

		
		
		iFReceteOlustur.setBounds(472, 100, 702, 531);
		contentPane.add(iFReceteOlustur);
		iFReceteOlustur.getContentPane().setLayout(null);
		
		//BURAYLA UĞRASICAKSI LİSTE BURDA
		JList receteHastaList = new JList(hasta.hastaList());
		receteHastaList.setFont(new Font("Tahoma", Font.PLAIN, 11));
		receteHastaList.setBounds(51, 120, 169, 262);
		iFReceteOlustur.getContentPane().add(receteHastaList);
		
		JLabel lblNewLabel = new JLabel("Reçeteyi Yazınız.");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel.setBounds(255, 120, 236, 36);
		iFReceteOlustur.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lütfen bir hasta seçiniz.");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(51, 95, 169, 14);
		iFReceteOlustur.getContentPane().add(lblNewLabel_1);
		
		JEditorPane epRecete = new JEditorPane();
		epRecete.setBounds(252, 169, 388, 103);
		iFReceteOlustur.getContentPane().add(epRecete);
		
		JButton btnReceteGonder = new JButton("Gönder");
		btnReceteGonder.setFont(new Font("Segoe Print", Font.BOLD, 14));
		btnReceteGonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(epRecete.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else{
					Helper.showMsg("Reçete başarıyla oluşturuldu.");
					try {
						Connection con = conn.connDb();
						Statement st;
						st = con.createStatement();
						String query=("SELECT * FROM user "+" WHERE tcno='"+receteHastaList.getSelectedValue()+"' ");
						ResultSet rs;
						rs = st.executeQuery(query);
						rs.next();
						Hasta.receteEkle(rs.getString("tcno"), epRecete.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					epRecete.setText(null);
				}
			}
		});
		btnReceteGonder.setBounds(546, 300, 89, 29);
		iFReceteOlustur.getContentPane().add(btnReceteGonder);
		
		
		
		JButton CikisButton = new JButton("Çıkış Yap");
		CikisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.showMsg("İyi günler dileriz sayın "+doktor.getAd() + " " +doktor.getSoyad());
				setVisible(false);
			}
		});
		CikisButton.setBounds(1199, 30, 125, 29);
		contentPane.add(CikisButton);
		
		JLabel arkaplan = new JLabel(new ImageIcon(this.getClass().getResource("arka2.png")));
		arkaplan.setBounds(0, 0, 1184, 711);
		contentPane.add(arkaplan);
		
		
		iFHastaBilgileri.setVisible(true);
		
		
	}
	}

