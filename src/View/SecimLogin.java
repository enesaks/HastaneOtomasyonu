package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel doktorPhoto = new JLabel("New label");
		doktorPhoto.setBounds(271, 55, 77, 78);
		contentPane.add(doktorPhoto);
		
		JLabel hastaPhoto = new JLabel("phptp");
		hastaPhoto.setBounds(92, 55, 77, 78);
		contentPane.add(hastaPhoto);
		
		JButton butonHastaGiris = new JButton("New button");
		butonHastaGiris.setBounds(80, 186, 89, 23);
		contentPane.add(butonHastaGiris);
		
		JButton butonDoktorGiris = new JButton("New button");
		butonDoktorGiris.setBounds(259, 186, 89, 23);
		contentPane.add(butonDoktorGiris);
		
		JLabel baslik = new JLabel("hastaneye hosgeldiniz");
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(74, 30, 285, 14);
		contentPane.add(baslik);
	}
}
