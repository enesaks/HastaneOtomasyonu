package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Doktor;
import Helper.DBConnection;
import Helper.Helper;
import DataBase.Bashekim;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class DoktorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField fldTC;
	private JPasswordField fldSifre;
	private DBConnection conn = new DBConnection();
	private boolean keyy =false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorLogin frame = new DoktorLogin();
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
	public DoktorLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_TC = new JLabel("TC KİMLİK NO:\r\n");
		lbl_TC.setBounds(74, 95, 128, 23);
		lbl_TC.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		contentPane.add(lbl_TC);
		
		JLabel lblSifre = new JLabel("ŞİFRE:");
		lblSifre.setBounds(74, 140, 113, 14);
		lblSifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		contentPane.add(lblSifre);
		
		JButton butonGiris = new JButton("GİRİŞ");
		butonGiris.setBounds(160, 203, 99, 23);
		butonGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fldTC.getText().length() == 0 && fldSifre.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					 keyy = true;}
					
				
				
				Statement st;
				try {
					Connection con = conn.connDb();
					st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM user");
					Doktor doktor = new Doktor();
					Bashekim bshekim = new DataBase.Bashekim();
					while(rs.next()) {
						
						if(fldTC.getText().equals(rs.getString("tcno")) && fldSifre.getText().equals(rs.getString("sifre")) && rs.getString("type").equals("bashekim")) {
							
							bshekim.setAd(rs.getString("ad"));
							bshekim.setSoyad(rs.getString("soyad"));
							bshekim.setSifre(rs.getString("sifre"));
							bshekim.setTcno(rs.getString("tcno"));
							bshekim.setType(rs.getString("type"));
							bshekim.setDogumTarih(rs.getString("dogumTarih"));
							BHGenel bhGenel = new BHGenel(bshekim);
							bhGenel.setVisible(true); //BAshekimin sayfası gözüksün diye true yapıldı.
							dispose();//Açık olan gui sayfası kapansın diye yapıldı.
							keyy = false;
							break;
							
						}
						else if (fldTC.getText().equals(rs.getString("tcno")) && fldSifre.getText().equals(rs.getString("sifre")) && rs.getString("type").equals("doktor") ) {
						
							doktor.setAd(rs.getString("ad"));
							doktor.setSoyad(rs.getString("soyad"));
							doktor.setSifre(rs.getString("sifre"));
							doktor.setTcno(rs.getString("tcno"));
							doktor.setType(rs.getString("type"));
							doktor.setDogumTarih(rs.getString("dogumTarih"));
							DoktorGenel doktorGenel = new DoktorGenel(doktor);
							doktorGenel.setVisible(true); //BAshekimin sayfası gözüksün diye true yapıldı.
							dispose();//Açık olan gui sayfası kapansın diye yapıldı.
							keyy = false;
							break;
						}
						
						}
						if(keyy) {
							Helper.showMsg("wrong");
							
						}
					}
				 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fldTC.setText(null);
				fldSifre.setText(null);
				}
			
				
			
		});
		contentPane.add(butonGiris);
		
		fldTC = new JTextField();
		fldTC.setBounds(223, 96, 86, 20);
		contentPane.add(fldTC);
		fldTC.setColumns(10);
		
		fldSifre = new JPasswordField();
		fldSifre.setBounds(223, 137, 89, 20);
		contentPane.add(fldSifre);
		
		JLabel baslik = new JLabel("DOKTOR GİRİŞİ");
		baslik.setBounds(161, 24, 113, 31);
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		contentPane.add(baslik);
		
		JButton geri_buton = new JButton(new ImageIcon(this.getClass().getResource("return.png")));
		geri_buton.setBorder(UIManager.getBorder("Tree.editorBorder"));
		geri_buton.setBounds(10, 11, 34, 31);
		contentPane.add(geri_buton);
		
		
		
		geri_buton.setBackground(Color.LIGHT_GRAY);
		
		
		geri_buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SecimLogin hLogin=new SecimLogin();
				hLogin.setVisible(true);
				dispose();
			}
		
		   
		
		});
	}
}
