  package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Bashekim;
import DataBase.Doktor;
import DataBase.Hasta;
import Helper.DBConnection;
import Helper.Helper;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.JList;

import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;

import javax.swing.JPasswordField;


public class BHGenel extends JFrame {
	
	JInternalFrame iFDoktorBilgi = new JInternalFrame("DoktorBİlgisi");
	JInternalFrame iFDoktorEkle = new JInternalFrame("Doktor Ekle Çıkar");
	JInternalFrame iFNobetSaati = new JInternalFrame("Nobet ayarla");
	Doktor doktor = new Doktor();
	
	private DBConnection conn = new DBConnection();
	private JPanel contentPane;
	 static Bashekim bshekim = new Bashekim();
	 private JTextField tfAd;
	 private JTextField tfSoyad;
	 private JTextField tfTcno;
	 private JTextField tfDogumTarih;
	 private JTextField tfPoliklinik;
	 private JPasswordField tfSifre;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BHGenel frame = new BHGenel(bshekim);
					frame.setTitle("Baş Hekim Sayfası");
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
	public BHGenel(Bashekim bshekim) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton butonDoktorBilgisiBHekim = new JButton("Doktor bilgisi");
		butonDoktorBilgisiBHekim.setBounds(21, 64, 156, 104);
		butonDoktorBilgisiBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorBilgi.setVisible(true);
				iFDoktorEkle.setVisible(false);
				iFNobetSaati.setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(butonDoktorBilgisiBHekim);
		
		JButton butonNobetSaatiBHekim = new JButton("nobet ayarla");
		butonNobetSaatiBHekim.setBounds(21, 446, 156, 104);
		butonNobetSaatiBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorBilgi.setVisible(false);
				iFDoktorEkle.setVisible(false);
				iFNobetSaati.setVisible(true);
			}
		});
		contentPane.add(butonNobetSaatiBHekim);
		
		JButton butonDoktorEkleBHekim = new JButton("Doktor Ekle Çıkar");
		butonDoktorEkleBHekim.setBounds(21, 190, 156, 104);
		butonDoktorEkleBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorEkle.setVisible(true);
				iFDoktorBilgi.setVisible(false);
				iFNobetSaati.setVisible(false);
			}
		});
		contentPane.add(butonDoktorEkleBHekim);
		iFDoktorBilgi.setBounds(794, 488, 80, 62);
		iFDoktorBilgi.addMouseListener(new MouseAdapter() {
			
		});
		iFDoktorBilgi.setBackground(new Color(255, 255, 204));
		iFDoktorBilgi.setEnabled(false);
		iFDoktorBilgi.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 128), null, null, null));
		contentPane.add(iFDoktorBilgi);
		iFDoktorBilgi.getContentPane().setLayout(null);
		
		
		JList<String> list = new JList<>(doktor.doktorList());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new TitledBorder(null, "Doktorlar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBounds(10, 11, 227, 435);
		iFDoktorBilgi.getContentPane().add(list);
	
		
		JLabel lblNewLabel = new JLabel("Ad Soyad : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(248, 72, 206, 27);
		iFDoktorBilgi.getContentPane().add(lblNewLabel);
		
		JLabel lblTcNo = new JLabel("T.C. No : ");
		lblTcNo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTcNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTcNo.setBounds(258, 110, 196, 27);
		iFDoktorBilgi.getContentPane().add(lblTcNo);
		
		JLabel lblPoliklinik = new JLabel("Poliklinik : ");
		lblPoliklinik.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPoliklinik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoliklinik.setBounds(278, 186, 176, 27);
		iFDoktorBilgi.getContentPane().add(lblPoliklinik);
		
		JLabel lblifre = new JLabel("Şifre : ");
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifre.setBounds(268, 148, 186, 27);
		iFDoktorBilgi.getContentPane().add(lblifre);
		
		JLabel lblDogumTarihi = new JLabel("Dogum Tarihi : ");
		lblDogumTarihi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDogumTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDogumTarihi.setBounds(278, 224, 176, 27);
		iFDoktorBilgi.getContentPane().add(lblDogumTarihi);
		
	
		
		JLabel nlTc = new JLabel();
		nlTc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nlTc.setBounds(450, 110, 195, 27);
		iFDoktorBilgi.getContentPane().add(nlTc);
		
		JLabel nlSifre = new JLabel();
		nlSifre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nlSifre.setBounds(450, 154, 195, 27);
		iFDoktorBilgi.getContentPane().add(nlSifre);
		
		JLabel nlPolkilinik = new JLabel();
		nlPolkilinik.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nlPolkilinik.setBounds(450, 192, 195, 21);
		iFDoktorBilgi.getContentPane().add(nlPolkilinik);
		
		JLabel nldDogumtarihi = new JLabel();
		nldDogumtarihi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nldDogumtarihi.setBounds(450, 224, 195, 27);
		iFDoktorBilgi.getContentPane().add(nldDogumtarihi);
		
		JLabel nlAdSoyad = new JLabel();
		nlAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nlAdSoyad.setBounds(450, 72, 195, 27);
		iFDoktorBilgi.getContentPane().add(nlAdSoyad);
		
		JButton btnbilgiler = new JButton("Bilgileri Göster");
		btnbilgiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = conn.connDb();
					Statement st = con.createStatement();
					String query=("SELECT * FROM user "+" WHERE ad='"+list.getSelectedValue()+"' ");
					ResultSet rs;
					rs = st.executeQuery(query);
					rs.next();
					nlAdSoyad.setText(rs.getString("ad").toUpperCase()+" "+rs.getString("soyad").toUpperCase());
					nlTc.setText(rs.getString("tcno"));
					nldDogumtarihi.setText(rs.getString("dogumTarih"));
					nlPolkilinik.setText(rs.getString("Poliklinik"));
					nlSifre.setText(rs.getString("sifre"));
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		btnbilgiler.setBounds(524, 262, 121, 23);
		iFDoktorBilgi.getContentPane().add(btnbilgiler);
		iFDoktorEkle.setBounds(187, 64, 687, 486);
		iFDoktorEkle.setBorder(new EmptyBorder(0, 0, 0, 0));
		iFDoktorEkle.setBackground(new Color(255, 255, 204));
		contentPane.add(iFDoktorEkle);
		iFDoktorEkle.getContentPane().setLayout(null);
		
		DefaultListModel<String> DLmodel =new DefaultListModel<String>();
		DLmodel = doktor.doktorList();
		JList<String> list1 = new JList<String>(DLmodel);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setBorder(new TitledBorder(null, "Doktorlar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list1.setBounds(10, 11, 227, 403);
		
		iFDoktorEkle.getContentPane().add(list1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(284, 47, 374, 304);
		iFDoktorEkle.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad : ");
		lblNewLabel_1.setBounds(10, 0, 145, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_1 = new JLabel("Soyad : ");
		lblNewLabel_1_1.setBounds(10, 47, 145, 36);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_2 = new JLabel("T.C. No : ");
		lblNewLabel_1_2.setBounds(10, 94, 145, 36);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_3 = new JLabel("Sifre : ");
		lblNewLabel_1_3.setBounds(10, 136, 145, 36);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_4 = new JLabel("DogumTarihi :");
		lblNewLabel_1_4.setBounds(10, 178, 145, 36);
		panel.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		tfDogumTarih = new JTextField();
		tfDogumTarih.setBounds(165, 189, 119, 20);
		panel.add(tfDogumTarih);
		tfDogumTarih.setColumns(10);
		
		tfTcno = new JTextField();
		tfTcno.setBounds(165, 105, 119, 20);
		panel.add(tfTcno);
		tfTcno.setColumns(10);
		
		tfSoyad = new JTextField();
		tfSoyad.setBounds(165, 58, 119, 20);
		panel.add(tfSoyad);
		tfSoyad.setColumns(10);
		
		tfAd = new JTextField();
		tfAd.setBounds(165, 11, 119, 20);
		panel.add(tfAd);
		tfAd.setColumns(10);
		
		JButton btnEkle = new JButton("Doktor Ekle");
		btnEkle.setBounds(254, 270, 110, 23);
		panel.add(btnEkle);
		
		tfPoliklinik = new JTextField();
		tfPoliklinik.setColumns(10);
		tfPoliklinik.setBounds(165, 236, 119, 20);
		panel.add(tfPoliklinik);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Polklinik Id :");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4_1.setBounds(10, 225, 145, 36);
		panel.add(lblNewLabel_1_4_1);
		
		tfSifre = new JPasswordField();
		tfSifre.setBounds(165, 147, 119, 20);
		panel.add(tfSifre);
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int c=1;
				if(tfAd.getText().length() == 0 || tfSoyad.getText().length() ==0 || tfDogumTarih.getText().length()==0 || 
						tfSifre.getText().length() == 0 || tfTcno.getText().length()==0||tfPoliklinik.getText().length()==0) {
					Helper.showMsg("fill");	
				}
				else {
					Connection con = conn.connDb();
					try {
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (tfTcno.getText().equals(rs.getString("tcno"))) {
								Helper.showMsg("Aynı Kimlikle Başka Bir Kulanıcı var.");
								
							} else if (tfTcno.getText().length() != 11) {
								Helper.showMsg("Lütfen 11 hane giriniz.");
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
							doktor.KayitOl(tfTcno.getText(), tfAd.getText(), tfSoyad.getText(),
									tfDogumTarih.getText(), tfSifre.getText(),Integer.parseInt(tfPoliklinik.getText()));
							Helper.showMsg("success");
							
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				
					
					tfAd.setText(null);
					tfDogumTarih.setText(null);
					tfPoliklinik.setText(null);
					tfSifre.setText(null);
					tfSoyad.setText(null);
					tfTcno.setText(null);
					
					list1.updateUI();
					try {
						list1.setModel(doktor.doktorList());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		
			}
			

		});
		
		JButton btnKaldir = new JButton("Doktor Çıkar");
		btnKaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
				try {
					Connection con = conn.connDb();
					Statement st;
					st = con.createStatement();
					String query=("SELECT * FROM user "+" WHERE ad='"+list.getSelectedValue()+"' ");
					ResultSet rs;
					rs = st.executeQuery(query);
					rs.next();
					System.out.println(rs.getString("tcno"));
					System.out.println("hello");
					doktor.DoktorKaldir(rs.getString("tcno"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnKaldir.setBounds(117, 425, 110, 23);
		iFDoktorEkle.getContentPane().add(btnKaldir);
		iFNobetSaati.setBounds(794, 488, 80, 62);
		iFNobetSaati.setBackground(new Color(255, 255, 204));
		contentPane.add(iFNobetSaati);
		
		JButton butonDoktorEkleBHekim_1 = new JButton("Poliklinik Ekle Çıkar");
		butonDoktorEkleBHekim_1.setBounds(21, 321, 156, 104);
		contentPane.add(butonDoktorEkleBHekim_1);
		
		iFNobetSaati.setVisible(false);
		iFDoktorEkle.setVisible(false);
		iFDoktorBilgi.setVisible(true);
	}
	
}
