package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class HastaGenel extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butonHastaBilgisi = new JButton("Hasta bilgisi");
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
		
		JLabel baslik = new JLabel("hosgeldin ...");
		baslik.setBounds(160, 24, 230, 14);
		contentPane.add(baslik);
		
		JPanel panel = new JPanel();
		panel.setBounds(156, 44, 268, 177);
		contentPane.add(panel);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
