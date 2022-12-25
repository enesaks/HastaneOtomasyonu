package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class DoktorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField fldTC;
	private JPasswordField fldSifre;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_TC = new JLabel("tc");
		lbl_TC.setBounds(85, 99, 46, 14);
		contentPane.add(lbl_TC);
		
		JLabel lblSifre = new JLabel("sifre");
		lblSifre.setBounds(85, 140, 46, 14);
		contentPane.add(lblSifre);
		
		JButton butonGiris = new JButton("giris");
		butonGiris.setBounds(175, 192, 89, 23);
		contentPane.add(butonGiris);
		
		fldTC = new JTextField();
		fldTC.setBounds(223, 96, 86, 20);
		contentPane.add(fldTC);
		fldTC.setColumns(10);
		
		fldSifre = new JPasswordField();
		fldSifre.setBounds(223, 137, 89, 20);
		contentPane.add(fldSifre);
		
		JLabel baslik = new JLabel("doktor girisi");
		baslik.setBounds(62, 29, 286, 14);
		contentPane.add(baslik);
	}
}
