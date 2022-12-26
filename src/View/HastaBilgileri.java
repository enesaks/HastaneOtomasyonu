package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class HastaBilgileri extends JFrame {

	private JPanel contentPane;
	private JTextField fld_HastaBilgiTC;
	private JTextField fld_HastaBilgiAd;
	private JTextField fld_HastaBilgiDogumTarihi;
	private JTextField fld_HastalıkBilgisi;
	private JTextField fld_HastaBilgiSoyad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaBilgileri frame = new HastaBilgileri();
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
	public HastaBilgileri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hasta Bilgi Ekranı");
		lblNewLabel.setBounds(139, 20, 165, 34);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T.C Numarası");
		lblNewLabel_1.setBounds(10, 92, 79, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ad");
		lblNewLabel_2.setBounds(10, 131, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Doğum Tarihi");
		lblNewLabel_3.setBounds(10, 210, 71, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hastalık Bilgisi");
		lblNewLabel_4.setBounds(10, 247, 71, 13);
		contentPane.add(lblNewLabel_4);
		
		fld_HastaBilgiTC = new JTextField();
		fld_HastaBilgiTC.setBounds(99, 89, 96, 19);
		contentPane.add(fld_HastaBilgiTC);
		fld_HastaBilgiTC.setColumns(10);
		
		fld_HastaBilgiAd = new JTextField();
		fld_HastaBilgiAd.setBounds(99, 128, 96, 19);
		contentPane.add(fld_HastaBilgiAd);
		fld_HastaBilgiAd.setColumns(10);
		
		fld_HastaBilgiDogumTarihi = new JTextField();
		fld_HastaBilgiDogumTarihi.setBounds(99, 207, 96, 19);
		contentPane.add(fld_HastaBilgiDogumTarihi);
		fld_HastaBilgiDogumTarihi.setColumns(10);
		
		fld_HastalıkBilgisi = new JTextField();
		fld_HastalıkBilgisi.setBounds(99, 244, 96, 19);
		contentPane.add(fld_HastalıkBilgisi);
		fld_HastalıkBilgisi.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Soyad");
		lblNewLabel_5.setBounds(10, 175, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		fld_HastaBilgiSoyad = new JTextField();
		fld_HastaBilgiSoyad.setBounds(99, 172, 96, 19);
		contentPane.add(fld_HastaBilgiSoyad);
		fld_HastaBilgiSoyad.setColumns(10);
	}
}
