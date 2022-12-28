  package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Bashekim;
import DataBase.Doktor;
import Helper.DBConnection;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListModel;
import javax.swing.JTextField;
import java.awt.FlowLayout;


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
	 private JTextField tdTcno;
	 private JTextField tfSifre;
	 private JTextField tfDogumTarih;

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
		
		JList<String> list1 = new JList<String>(doktor.doktorList());
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.setBorder(new TitledBorder(null, "Doktorlar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list1.setBounds(10, 11, 227, 403);
		iFDoktorEkle.getContentPane().add(list1);
		
		JLabel lblNewLabel_1 = new JLabel("Ad : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(301, 93, 145, 36);
		iFDoktorEkle.getContentPane().add(lblNewLabel_1);
		
		tfAd = new JTextField();
		tfAd.setBounds(456, 104, 119, 20);
		iFDoktorEkle.getContentPane().add(tfAd);
		tfAd.setColumns(10);
		
		tfSoyad = new JTextField();
		tfSoyad.setColumns(10);
		tfSoyad.setBounds(456, 151, 119, 20);
		iFDoktorEkle.getContentPane().add(tfSoyad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Soyad : ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(301, 140, 145, 36);
		iFDoktorEkle.getContentPane().add(lblNewLabel_1_1);
		
		tdTcno = new JTextField();
		tdTcno.setColumns(10);
		tdTcno.setBounds(456, 198, 119, 20);
		iFDoktorEkle.getContentPane().add(tdTcno);
		
		JLabel lblNewLabel_1_2 = new JLabel("T.C. No : ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(301, 187, 145, 36);
		iFDoktorEkle.getContentPane().add(lblNewLabel_1_2);
		
		tfSifre = new JTextField();
		tfSifre.setColumns(10);
		tfSifre.setBounds(456, 240, 119, 20);
		iFDoktorEkle.getContentPane().add(tfSifre);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sifre : ");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(301, 229, 145, 36);
		iFDoktorEkle.getContentPane().add(lblNewLabel_1_3);
		
		tfDogumTarih = new JTextField();
		tfDogumTarih.setColumns(10);
		tfDogumTarih.setBounds(456, 282, 119, 20);
		iFDoktorEkle.getContentPane().add(tfDogumTarih);
		
		JLabel lblNewLabel_1_4 = new JLabel("DogumTarihi :");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(301, 271, 145, 36);
		iFDoktorEkle.getContentPane().add(lblNewLabel_1_4);
		
		JButton btnEkle = new JButton("Doktor Ekle");
		btnEkle.setBounds(515, 313, 110, 23);
		iFDoktorEkle.getContentPane().add(btnEkle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(287, 82, 374, 272);
		iFDoktorEkle.getContentPane().add(panel);
		
		JButton btnKaldir = new JButton("Doktor Çıkar");
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
