package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Hasta;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HastaGenel extends JFrame {
	JInternalFrame iFRecete = new JInternalFrame("E-Reçete");
	JInternalFrame iFSonuclarim = new JInternalFrame("Sonuçlarım");
	JInternalFrame iFHastaBilgisi = new JInternalFrame("Hasta Bilgisi");
	JInternalFrame iFRandevuAll = new JInternalFrame("Randevu Al");




	private JPanel contentPane;
	static Hasta hasta=new Hasta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaGenel frame = new HastaGenel(hasta);
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
	public HastaGenel(Hasta hasta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butonHastaBilgileri = new JButton("Hasta Bilgileri");
		butonHastaBilgileri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);
				iFSonuclarim.setVisible(false);
				iFHastaBilgisi.setVisible(true);
				iFRandevuAll.setVisible(false);
			}
		});
		butonHastaBilgileri.setBounds(38, 120, 161, 39);
		contentPane.add(butonHastaBilgileri);
		
		JButton butonRandevuAl = new JButton("Randevu Al");
		butonRandevuAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);
				iFSonuclarim.setVisible(false);
				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(true);
			}
		});
		butonRandevuAl.setBounds(38, 180, 161, 44);
		contentPane.add(butonRandevuAl);
		
		JButton butonSonuclarim = new JButton("Sonuçlarım");
		butonSonuclarim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);
				iFSonuclarim.setVisible(true);
				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(false);
			}
		});
		butonSonuclarim.setBounds(38, 250, 161, 44);
		contentPane.add(butonSonuclarim);
		
		JButton butonRecete = new JButton("E-Recete");
		butonRecete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(true);
				iFSonuclarim.setVisible(false);
				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(false);
			}
		});
		butonRecete.setBounds(36, 309, 161, 49);
		contentPane.add(butonRecete);
		
		iFRandevuAll.setBounds(221, 70, 609, 359);
		contentPane.add(iFRandevuAll);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		iFRandevuAll.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 33, 225, 228);
		panel_1.add(scrollPane_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Doktor Listesi");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 10, 127, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Polikinlik Adı");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(245, 49, 92, 27);
		panel_1.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(245, 91, 98, 27);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Doktor Adı");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(245, 152, 92, 13);
		panel_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1_1 = new JButton("Seç");
		btnNewButton_1_1.setBounds(245, 189, 98, 32);
		panel_1.add(btnNewButton_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(381, 33, 184, 228);
		panel_1.add(scrollPane_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Randevu Gün ve Saatleri");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(383, 12, 167, 13);
		panel_1.add(lblNewLabel_4_1);
		
		iFHastaBilgisi.setBounds(221, 70, 609, 359);
		contentPane.add(iFHastaBilgisi);
		iFHastaBilgisi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 593, 1);
		panel.setLayout(null);
		iFHastaBilgisi.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 225, 228);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Doktor Listesi");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 10, 127, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Polikinlik Adı");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(245, 49, 92, 27);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(245, 91, 98, 27);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Doktor Adı");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(245, 152, 92, 13);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Seç");
		btnNewButton_1.setBounds(245, 189, 98, 32);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(381, 33, 184, 228);
		panel.add(scrollPane_1);
		
		JLabel lblNewLabel_4 = new JLabel("Randevu Gün ve Saatleri");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(383, 12, 167, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblAd = new JLabel("AD:");
		lblAd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAd.setBounds(175, 94, 97, 28);
		iFHastaBilgisi.getContentPane().add(lblAd);
		
		JLabel lblNewLabel_5 = new JLabel("SOYAD:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(175, 133, 97, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("T.C. KİMLİK NO:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(175, 177, 97, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DOĞUM TARİHİ:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(175, 223, 97, 28);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_7);
		
		JLabel baslik_hastaBilgileri = new JLabel("HASTA BİLGİLERİ");
		baslik_hastaBilgileri.setFont(new Font("Tahoma", Font.BOLD, 14));
		baslik_hastaBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		baslik_hastaBilgileri.setBounds(20, 33, 563, 50);
		iFHastaBilgisi.getContentPane().add(baslik_hastaBilgileri);
		
		JLabel lblNewLabel = new JLabel(hasta.getAd());
		lblNewLabel.setBounds(308, 83, 200, 50);
		iFHastaBilgisi.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel(hasta.getSoyad());
		lblNewLabel_8.setBounds(308, 122, 200, 50);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(hasta.getTcno());
		lblNewLabel_9.setBounds(308, 166, 200, 50);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(hasta.getDogumTarih());
		lblNewLabel_10.setBounds(308, 212, 200, 50);
		iFHastaBilgisi.getContentPane().add(lblNewLabel_10);
		
		iFSonuclarim.setBounds(221, 70, 609, 359);
		contentPane.add(iFSonuclarim);
		
		
		iFRecete.setBounds(221, 70, 609, 359);
		contentPane.add(iFRecete);
		
		JLabel baslik = new JLabel("HOŞGELDİN "+hasta.getAd());
		baslik.setBounds(38, 10, 547, 50);
		contentPane.add(baslik);
		
		iFHastaBilgisi.setVisible(true);
	}
}
