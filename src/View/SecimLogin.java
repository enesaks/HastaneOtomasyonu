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
		doktorPhoto.setBounds(266, 60, 145, 165);
		contentPane.add(doktorPhoto);
		
		JLabel hastaLogo = new JLabel(new ImageIcon(getClass().getResource("hasta.png")));
		hastaLogo.setBackground(Color.WHITE);
		hastaLogo.setBounds(74, 60, 145, 165);
		contentPane.add(hastaLogo);
		
		//JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("images.jpeg")));
		
		JButton butonHastaGiris = new JButton("Hasta Giriş");
		butonHastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				HastaLogin hastalogin =new HastaLogin();
				hastalogin.setVisible(true);  
				
				dispose();
			}
		});
		butonHastaGiris.setBounds(74, 235, 137, 39);
		contentPane.add(butonHastaGiris);
		
		JButton butonDoktorGiris = new JButton("Doktor Giriş");
		butonDoktorGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoktorLogin doktorlogin =new DoktorLogin();
				doktorlogin.setVisible(true);  
				
				dispose();
			}
		});
		butonDoktorGiris.setBounds(284, 235, 127, 39);
		contentPane.add(butonDoktorGiris);
		
		JLabel baslik = new JLabel("Medipol Hastanesine Hosgeldiniz");
		baslik.setForeground(Color.RED);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(88, 28, 346, 32);
		contentPane.add(baslik);
	}
}
