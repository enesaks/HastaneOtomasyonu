package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.print("enes hanim sistemdeeee");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHasta = new JButton("Hasta Girişi");
		btnHasta.setFont(new Font("Cambria", Font.BOLD, 30));
		btnHasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHasta.setBounds(73, 196, 232, 142);
		contentPane.add(btnHasta);
		
		JButton btnDoktorGirii = new JButton("Doktor Girişi");
		btnDoktorGirii.setFont(new Font("Cambria", Font.BOLD, 30));
		btnDoktorGirii.setBounds(381, 196, 232, 142);
		contentPane.add(btnDoktorGirii);
	}
}
