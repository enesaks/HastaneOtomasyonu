package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class HastaKayıtOl extends JFrame {
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaKayıtOl frame = new HastaKayıtOl();
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
	public HastaKayıtOl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JButton butonHastaKayit = new JButton("Ksyit ol");
		butonHastaKayit.setBounds(267, 205, 102, 27);
		getContentPane().add(butonHastaKayit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 168, 86, 20);
		getContentPane().add(passwordField);
		
		JLabel lblSifreHastaKayit = new JLabel("sifre");
		lblSifreHastaKayit.setBounds(67, 171, 46, 14);
		getContentPane().add(lblSifreHastaKayit);
		
		JLabel lblDogumTarihiHastaKayit = new JLabel("dg");
		lblDogumTarihiHastaKayit.setBounds(67, 146, 46, 14);
		getContentPane().add(lblDogumTarihiHastaKayit);
		
		JLabel lblAdHastaKayit = new JLabel("ad");
		lblAdHastaKayit.setBounds(67, 63, 46, 14);
		getContentPane().add(lblAdHastaKayit);
		
		JLabel lblSoyadHastaKayit = new JLabel("soyad");
		lblSoyadHastaKayit.setBounds(67, 88, 46, 14);
		getContentPane().add(lblSoyadHastaKayit);
		
		JLabel lbl_TCHastaKayit = new JLabel("tc");
		lbl_TCHastaKayit.setBounds(67, 121, 46, 14);
		getContentPane().add(lbl_TCHastaKayit);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(234, 143, 86, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(234, 118, 86, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(234, 85, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(234, 60, 86, 20);
		getContentPane().add(textField_3);
		
		JLabel baslik = new JLabel("hasta kayit ekrani");
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setBounds(112, 11, 223, 14);
		getContentPane().add(baslik);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
