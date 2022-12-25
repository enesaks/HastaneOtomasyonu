package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class HastaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField fldTCHastaGiris;
	private JTextField fldSifreHastaGiris;
	private JPasswordField fldGogumTarihiHastaGiris;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaLogin frame = new HastaLogin();
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
	public HastaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_TCHastaGiris = new JLabel("tc");
		lbl_TCHastaGiris.setBounds(76, 74, 46, 14);
		contentPane.add(lbl_TCHastaGiris);
		
		JLabel lblSifreHastaGiris = new JLabel("sifre");
		lblSifreHastaGiris.setBounds(76, 108, 46, 14);
		contentPane.add(lblSifreHastaGiris);
		
		JLabel lblDogumtarihiHastaGiris = new JLabel("dg");
		lblDogumtarihiHastaGiris.setBounds(76, 150, 46, 14);
		contentPane.add(lblDogumtarihiHastaGiris);
		
		JButton butonGirisHastaGiris = new JButton("giris");
		butonGirisHastaGiris.setBounds(100, 210, 89, 23);
		contentPane.add(butonGirisHastaGiris);
		
		JButton butonKayitOlHastaGiris = new JButton("kayit ol");
		butonKayitOlHastaGiris.setBounds(243, 210, 89, 23);
		contentPane.add(butonKayitOlHastaGiris);
		
		fldTCHastaGiris = new JTextField();
		fldTCHastaGiris.setBounds(243, 71, 86, 20);
		contentPane.add(fldTCHastaGiris);
		fldTCHastaGiris.setColumns(10);
		
		fldSifreHastaGiris = new JTextField();
		fldSifreHastaGiris.setBounds(246, 105, 86, 20);
		contentPane.add(fldSifreHastaGiris);
		fldSifreHastaGiris.setColumns(10);
		
		fldGogumTarihiHastaGiris = new JPasswordField();
		fldGogumTarihiHastaGiris.setBounds(243, 147, 89, 20);
		contentPane.add(fldGogumTarihiHastaGiris);
		
		JLabel baslik = new JLabel("hasta giris ekrani");
		baslik.setBounds(76, 27, 165, 14);
		contentPane.add(baslik);
	}

}
