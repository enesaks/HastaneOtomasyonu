package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Bashekim;
import DataBase.Doktor;
import DataBase.Hasta;
import DataBase.Poliklinik;
import Helper.Helper;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;

public class HastaGenel extends JFrame {
	JInternalFrame iFRecete = new JInternalFrame("E-Reçete");
	JInternalFrame iFHastaBilgisi = new JInternalFrame("Hasta Bilgisi");
	JInternalFrame iFRandevuAll = new JInternalFrame("Randevu Al");

	private JPanel contentPane;
	static Hasta hasta = new Hasta();
	static Doktor doktor = new Doktor();
	static Bashekim bashekim = new Bashekim();
	static Poliklinik poliklinik = new Poliklinik();

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
	 * 
	 * @throws SQLException
	 */
	public HastaGenel(Hasta hasta) throws SQLException {
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
				
				iFHastaBilgisi.setVisible(true);
				iFRandevuAll.setVisible(false);
			}
		});
		butonHastaBilgileri.setBounds(38, 118, 161, 44);
		contentPane.add(butonHastaBilgileri);

		JButton butonRandevuAl = new JButton("Randevu Al");
		butonRandevuAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);
				
				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(true);
			}
		});
		butonRandevuAl.setBounds(38, 180, 161, 44);
		contentPane.add(butonRandevuAl);

		JButton butonRecete = new JButton("E-Recete");
		butonRecete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(true);
				
				iFHastaBilgisi.setVisible(false);
				iFRandevuAll.setVisible(false);
			}
		});
		butonRecete.setBounds(38, 250, 161, 49);
		contentPane.add(butonRecete);

		iFRandevuAll.setBounds(221, 70, 609, 359);
		contentPane.add(iFRandevuAll);

		JPanel panel_1 = new JPanel();
		iFRandevuAll.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Doktor Listesi");
		lblNewLabel_1_1.setBounds(10, 130, 127, 13);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Polikinlik Adı");
		lblNewLabel_2_1.setBounds(10, 13, 92, 27);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2_1);

		JComboBox secimPoliklinik = new JComboBox();
		secimPoliklinik.setBounds(10, 50, 133, 27);

		for (int i = 0; i < poliklinik.getList().size(); i++) {
			secimPoliklinik.addItem(poliklinik.getList().get(i).getName());
		}
		panel_1.add(secimPoliklinik);

		JButton btnNewButton_1_1 = new JButton("Seç");
		btnNewButton_1_1.setBounds(10, 84, 127, 36);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(secimPoliklinik.getSelectedIndex());

				try {
					/*
					 * JList<String> list = new
					 * JList<String>(doktor.doktorList2(secimPoliklinik.getSelectedIndex()));
					 * list.setBounds(20, 195, 156, 125); panel_1.add(list);
					 */
					JComboBox secimDoktor = new JComboBox();
					secimDoktor.setBounds(10, 166, 133, 27);
					for (int i = 0; i < doktor.doktorList2(secimPoliklinik.getSelectedIndex()).size(); i++) {
						secimDoktor.addItem(doktor.doktorList2(i).get(i));
					}
					panel_1.add(secimDoktor);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// JOptionPane.showMessageDialog(null,"Butona
				// Tıklandı","Bilgi",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_4_1 = new JLabel("Randevu Gün ve Saatleri");
		lblNewLabel_4_1.setBounds(383, 12, 167, 13);
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4_1);

		JButton btnNewButton = new JButton("Onayla");
		btnNewButton.setBounds(10, 287, 127, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel_1.add(btnNewButton);

		JList<String> list1 = new JList<>(doktor.doktorList());
		list1.setBounds(170, 45, 201, 83);
		panel_1.add(list1);

		JLabel lblNewLabel_11 = new JLabel("Doktor Listesi");
		lblNewLabel_11.setBounds(170, 15, 156, 27);
		lblNewLabel_11.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_11);

	
		  JComboBox secimDoktor = new JComboBox();
		  secimDoktor.setBounds(10, 166, 133, 27);
		  for(int i=0;i<doktor.doktorList2(secimPoliklinik.getSelectedIndex()).size();i++) {
		  secimDoktor.addItem(doktor.doktorList2(i).get(i)); }
		  panel_1.add(secimDoktor);
		  
		  JComboBox comboBox_2 = new JComboBox();
		  comboBox_2.setBounds(383, 84, 182, 22);
		  comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00"}));
		  panel_1.add(comboBox_2);
		  
		  JComboBox comboBox_1 = new JComboBox();
		  comboBox_1.setBounds(383, 53, 182, 20);
		  comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1 Ocak 2023", "2 Ocak 2023", "3 Ocak 2023"}));
		  panel_1.add(comboBox_1);
		  
		 

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

		iFRecete.setBounds(221, 70, 609, 359);
		contentPane.add(iFRecete);

		JLabel baslik = new JLabel("HOŞGELDİN " + hasta.getAd() + " " + hasta.getSoyad());
		baslik.setBounds(38, 10, 547, 50);
		contentPane.add(baslik);

		JButton CikisYap = new JButton("Çıkış Yap");
		CikisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.showMsg("Sağlıklı günler dileriz " + hasta.getAd() + " " + hasta.getSoyad());
				setVisible(false);
			}
		});
		CikisYap.setBounds(638, 25, 148, 35);
		contentPane.add(CikisYap);

		iFHastaBilgisi.setVisible(true);
	}
}
