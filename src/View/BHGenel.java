  package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Bashekim;

import javax.swing.JLabel;
import javax.swing.JButton;

public class BHGenel extends JFrame {

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
	public BHGenel(Bashekim bshekim) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butonDoktorBilgisiBHekim = new JButton("Doktor bilgisi");
		butonDoktorBilgisiBHekim.setBounds(43, 78, 89, 23);
		contentPane.add(butonDoktorBilgisiBHekim);
		
		JButton butonNobetSaatiBHekim = new JButton("nobet ayarla");
		butonNobetSaatiBHekim.setBounds(43, 112, 89, 23);
		contentPane.add(butonNobetSaatiBHekim);
		
		JButton butonDoktorEkleBHekim = new JButton("doktor ekle çikar");
		butonDoktorEkleBHekim.setBounds(43, 146, 89, 23);
		contentPane.add(butonDoktorEkleBHekim);
		
		JPanel panel = new JPanel();
		panel.setBounds(169, 31, 255, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel baslik = new JLabel("hosegldin bashekim ...");
		baslik.setBounds(22, 11, 107, 14);
		panel.add(baslik);
	}

}
