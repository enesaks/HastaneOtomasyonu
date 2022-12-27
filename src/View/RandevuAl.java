package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Doktor;
import Helper.Helper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandevuAl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandevuAl frame = new RandevuAl();
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
	public RandevuAl() {
		setResizable(false);
		setTitle("Hastane Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoşgeldiniz,Sayin ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 22, 264, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cikis Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.showMsg("exit");
				setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnNewButton.setBounds(440, 28, 152, 34);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 89, 580, 298);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Randevu Sistemi", null, panel, null);
		panel.setLayout(null);
		
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
	}
}
