package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class SecimLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	 
	  
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecimLogin frame = new SecimLogin();
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
	public SecimLogin() {
		
		LocalDateTime tarih = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm");
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel baslik = new JLabel("HASTANEMİZE HOŞGELDİNİZ");
		baslik.setForeground(new Color(0, 51, 102));
		baslik.setFont(new Font("Segoe Print", Font.BOLD, 27));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(-17, 51, 515, 96);
		contentPane.add(baslik);
		
		JLabel lblNewLabel = new JLabel("Giriş Tarihi: "+dtf.format(tarih));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel.setBounds(959, 11, 296, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnhastaGiris  = new JButton(new ImageIcon(this.getClass().getResource("hasta.png")));
		btnhastaGiris.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnhastaGiris.setBackground(new Color(255, 255, 255));
		
		
		
		  getContentPane().add(btnhastaGiris); 
		btnhastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaLogin hastalogin =new HastaLogin();
				hastalogin.setVisible(true);  
				dispose();
			}
		});
		btnhastaGiris.setBounds(390, 235, 121, 135);
		contentPane.add(btnhastaGiris);
		
		JButton btnDoktorGiris  = new JButton(new ImageIcon(this.getClass().getResource("doktor.png")));
		btnDoktorGiris.setBorder(UIManager.getBorder("Tree.editorBorder"));
		btnDoktorGiris.setBackground(new Color(255, 255, 255));
		
		getContentPane().add(btnDoktorGiris);
		
		btnDoktorGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoktorLogin doktorlogin =new DoktorLogin();
				doktorlogin.setVisible(true);  
				
				dispose();
			}
		});
		btnDoktorGiris.setBounds(693, 235, 121, 135);
		contentPane.add(btnDoktorGiris);
		
		JLabel lblHastaGiris = new JLabel("HASTA GİRİŞ");
		lblHastaGiris.setForeground(new Color(0, 0, 102));
		lblHastaGiris.setFont(new Font("Arial", Font.BOLD, 26));
		lblHastaGiris.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaGiris.setBounds(337, 381, 231, 48);
		contentPane.add(lblHastaGiris);
		
		JLabel lblDoktorGiri = new JLabel("DOKTOR GİRİŞ");
		lblDoktorGiri.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoktorGiri.setForeground(new Color(0, 0, 102));
		lblDoktorGiri.setFont(new Font("Arial", Font.BOLD, 26));
		lblDoktorGiri.setBounds(638, 381, 231, 48);
		contentPane.add(lblDoktorGiri);
		
		JLabel arkaplan = new JLabel(new ImageIcon(this.getClass().getResource("arka.jpg")));
		arkaplan.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 204, 255), null, null, null));
		arkaplan.setBounds(-91, 0, 1427, 740);
		contentPane.add(arkaplan);
		
	
		
		
			

	} 
}
