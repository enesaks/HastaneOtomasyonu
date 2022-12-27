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

	private JPanel contentPane;
	static Hasta hasta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaGenel frame = new HastaGenel();
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
	public HastaGenel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butonHastaBilgisi = new JButton("Hasta bilgisi");
		// HastaGenel'den HastaBilgileri'ne geçiş sağlandı..
		butonHastaBilgisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaBilgileri hBilgi=new HastaBilgileri(hasta);
				hBilgi.setVisible(true);
			}
		});
		butonHastaBilgisi.setBounds(38, 55, 108, 23);
		contentPane.add(butonHastaBilgisi);
		
		JButton butonRandevuAl = new JButton("randevu al");
		butonRandevuAl.setBounds(38, 89, 108, 23);
		contentPane.add(butonRandevuAl);
		
		JButton butonSonuclarHasta = new JButton("sonuclarım");
		butonSonuclarHasta.setBounds(38, 123, 108, 23);
		contentPane.add(butonSonuclarHasta);
		
		JButton butonReceteHasta = new JButton("e recete");
		butonReceteHasta.setBounds(38, 157, 108, 23);
		contentPane.add(butonReceteHasta);
		
		JLabel baslik = new JLabel("Hosgeldiniz");
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		baslik.setBounds(160, 24, 230, 21);
		contentPane.add(baslik);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBorder(null);
		internalFrame.setBounds(155, 62, 944, 602);
		contentPane.add(internalFrame);
		internalFrame.setVisible(true);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
