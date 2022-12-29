package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

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
		setBounds(100, 100, 559, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel baslik = new JLabel("MEDİPOL HASTANESİNE HOŞGELDİNİZ");
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(69, 31, 402, 32);
		contentPane.add(baslik);
		
		JLabel lblNewLabel = new JLabel("Giriş Tarihi: "+dtf.format(tarih));
		lblNewLabel.setBounds(10, 319, 189, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnhastaGiris  = new JButton(new ImageIcon(this.getClass().getResource("hasta.png")));
		btnhastaGiris.setBorder(UIManager.getBorder("Tree.editorBorder"));
		btnhastaGiris.setBackground(Color.LIGHT_GRAY);
		
		
		
		  getContentPane().add(btnhastaGiris); 
		btnhastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaLogin hastalogin =new HastaLogin();
				hastalogin.setVisible(true);  
				dispose();
			}
		});
		btnhastaGiris.setBounds(98, 104, 101, 108);
		contentPane.add(btnhastaGiris);
		
		JButton btnDoktorGiris  = new JButton(new ImageIcon(this.getClass().getResource("doktor.png")));
		btnDoktorGiris.setBorder(UIManager.getBorder("Tree.editorBorder"));
		btnDoktorGiris.setBackground(Color.LIGHT_GRAY);
		
		getContentPane().add(btnDoktorGiris);
		
		btnDoktorGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoktorLogin doktorlogin =new DoktorLogin();
				doktorlogin.setVisible(true);  
				
				dispose();
			}
		});
		btnDoktorGiris.setBounds(295, 104, 101, 108);
		contentPane.add(btnDoktorGiris);
		
		JLabel lblHastaGiris = new JLabel("HASTA GİRİŞ");
		lblHastaGiris.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaGiris.setBounds(102, 249, 89, 14);
		contentPane.add(lblHastaGiris);
		
		JLabel lblDoktorGiris = new JLabel("DOKTOR GİRİŞ");
		lblDoktorGiris.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoktorGiris.setBounds(307, 249, 89, 14);
		contentPane.add(lblDoktorGiris);
	} 
}
