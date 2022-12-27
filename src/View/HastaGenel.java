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

public class HastaGenel extends JFrame {
	JInternalFrame iFRecete = new JInternalFrame("E-Reçete");
	JInternalFrame iFSonuclarim = new JInternalFrame("Sonuçlarım");
	JInternalFrame iFRandevuAl = new JInternalFrame("Randevu Al");
	JInternalFrame iFHastaBilgisi = new JInternalFrame("Hasta Bilgisi");




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
		setBounds(100, 100, 648, 376);
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
				iFRandevuAl.setVisible(false);
				iFHastaBilgisi.setVisible(true);
			}
		});
		butonHastaBilgileri.setBounds(30, 88, 161, 39);
		contentPane.add(butonHastaBilgileri);
		
		JButton butonRandevuAl = new JButton("Randevu Al");
		butonRandevuAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);
				iFSonuclarim.setVisible(false);
				iFRandevuAl.setVisible(true);
				iFHastaBilgisi.setVisible(false);
			}
		});
		butonRandevuAl.setBounds(30, 148, 161, 44);
		contentPane.add(butonRandevuAl);
		
		JButton butonSonuclarim = new JButton("Sonuçlarım");
		butonSonuclarim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(false);
				iFSonuclarim.setVisible(true);
				iFRandevuAl.setVisible(false);
				iFHastaBilgisi.setVisible(false);
			}
		});
		butonSonuclarim.setBounds(30, 218, 161, 44);
		contentPane.add(butonSonuclarim);
		
		JButton butonRecete = new JButton("E-Recete");
		butonRecete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFRecete.setVisible(true);
				iFSonuclarim.setVisible(false);
				iFRandevuAl.setVisible(false);
				iFHastaBilgisi.setVisible(false);
			}
		});
		butonRecete.setBounds(28, 277, 161, 49);
		contentPane.add(butonRecete);
		
		iFHastaBilgisi.setBounds(221, 88, 401, 238);
		contentPane.add(iFHastaBilgisi);
		
		iFRandevuAl.setBounds(221, 88, 401, 238);
		contentPane.add(iFRandevuAl);
		
		iFSonuclarim.setBounds(221, 88, 401, 238);
		contentPane.add(iFSonuclarim);
		
		
		iFRecete.setBounds(221, 88, 401, 238);
		contentPane.add(iFRecete);
		
		JLabel baslik = new JLabel("HOŞGELDİN "+hasta.getAd().toUpperCase());
		baslik.setBounds(38, 10, 547, 50);
		contentPane.add(baslik);
		
		iFHastaBilgisi.setVisible(true);
	}

	
}
