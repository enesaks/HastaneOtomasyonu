package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel doktorPhoto = new JLabel(new ImageIcon(getClass().getResource("doktor.png")));
		doktorPhoto.setBounds(284, 60, 145, 165);
		contentPane.add(doktorPhoto);
		
		JLabel hastaLogo = new JLabel(new ImageIcon(getClass().getResource("hasta.png")));
		hastaLogo.setBackground(Color.WHITE);
		hastaLogo.setBounds(74, 60, 145, 165);
		contentPane.add(hastaLogo);
		
		//JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("images.jpeg")));
		
		JButton butonHastaGiris = new JButton("HASTA GİRİŞ");
		butonHastaGiris.setForeground(new Color(0, 0, 0));
		butonHastaGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonHastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				HastaLogin hastalogin =new HastaLogin();
				hastalogin.setVisible(true);  
				dispose();
			}
		});
		butonHastaGiris.setBounds(74, 236, 145, 39);
		contentPane.add(butonHastaGiris);
		
		JButton butonDoktorGiris = new JButton("DOKTOR GİRİŞ");
		butonDoktorGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonDoktorGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoktorLogin doktorlogin =new DoktorLogin();
				doktorlogin.setVisible(true);  
				
				dispose();
			}
		});
		butonDoktorGiris.setBounds(284, 235, 150, 39);
		contentPane.add(butonDoktorGiris);
		
		JLabel baslik = new JLabel("MEDİPOL HASTANESİNE HOŞGELDİNİZ");
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(69, 31, 402, 32);
		contentPane.add(baslik);
	}
}
