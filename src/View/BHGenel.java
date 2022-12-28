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


public class BHGenel extends JFrame {
	
	JInternalFrame iFDoktorBilgi = new JInternalFrame("DoktorBİlgisi");
	JInternalFrame iFDoktorEkle = new JInternalFrame("Doktor Ekle");
	JInternalFrame iFNobetSaati = new JInternalFrame("Nobet ayarla");
	Doktor doktor = new Doktor();
	
	private DBConnection conn = new DBConnection();
	private JPanel contentPane;
	 static Bashekim bshekim = new Bashekim();

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
		contentPane.setLayout(null);
		
		JButton butonDoktorBilgisiBHekim = new JButton("Doktor bilgisi");
		butonDoktorBilgisiBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorBilgi.setVisible(true);
				iFDoktorEkle.setVisible(false);
				iFNobetSaati.setVisible(false);
			}
		});
		butonDoktorBilgisiBHekim.setBounds(21, 64, 156, 118);
		contentPane.add(butonDoktorBilgisiBHekim);
		
		JButton butonNobetSaatiBHekim = new JButton("nobet ayarla");
		butonNobetSaatiBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorBilgi.setVisible(false);
				iFDoktorEkle.setVisible(false);
				iFNobetSaati.setVisible(true);
			}
		});
		butonNobetSaatiBHekim.setBounds(21, 439, 156, 111);
		contentPane.add(butonNobetSaatiBHekim);
		
		JButton butonDoktorEkleBHekim = new JButton("doktor ekle çikar");
		butonDoktorEkleBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorEkle.setVisible(true);
				iFDoktorBilgi.setVisible(false);
				iFNobetSaati.setVisible(false);
			}
		});
		butonDoktorEkleBHekim.setBounds(21, 193, 156, 118);
		contentPane.add(butonDoktorEkleBHekim);
		iFDoktorBilgi.setBackground(new Color(255, 255, 204));
		iFDoktorBilgi.setEnabled(false);
		iFDoktorBilgi.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 128), null, null, null));
		
		iFDoktorBilgi.setBounds(187, 64, 687, 486);
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
				System.out.print(list.getSelectedValue());
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
		iFDoktorEkle.setBorder(new EmptyBorder(0, 0, 0, 0));
		iFDoktorEkle.setBackground(new Color(255, 255, 204));
		
		
		iFDoktorEkle.setBounds(187, 64, 687, 486);
		contentPane.add(iFDoktorEkle);
		iFNobetSaati.setBackground(new Color(255, 255, 204));
		
		iFNobetSaati.setBounds(187, 64, 687, 486);
		contentPane.add(iFNobetSaati);
		
		iFNobetSaati.setVisible(false);
		iFDoktorEkle.setVisible(false);
		iFDoktorBilgi.setVisible(true);
	}
}
