package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Doktor;
import DataBase.Hasta;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;

public class DoktorGenel extends JFrame {
	
	
	
	JInternalFrame iFHastaBilgileri = new JInternalFrame("HASTA BİLGİLERİ");
	JInternalFrame iFCalismaSaatleri = new JInternalFrame("ÇALIŞMA SAATLERİ");
	private JPanel contentPane;
	
	Hasta hasta=new Hasta();
	
	private static Doktor doktor = new Doktor();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorGenel frame = new DoktorGenel(doktor);
					frame.setTitle("Doktor Sayfası");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DoktorGenel(Doktor doktor) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel baslik = new JLabel("HOŞGELDİNİZ DOKTOR <dynamic>");
		baslik.setForeground(Color.BLUE);
		baslik.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		baslik.setBounds(50, 23, 233, 32);
		contentPane.add(baslik);
		
		JButton butonHastaBilgiler = new JButton("Hasta Bilgileri");
		butonHastaBilgiler.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonHastaBilgiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFCalismaSaatleri.setVisible(false);
				iFHastaBilgileri.setVisible(true);
			}
		});
		butonHastaBilgiler.setBounds(50, 93, 144, 38);
		contentPane.add(butonHastaBilgiler);
		
		
		
		JButton butonCalismaSaatleri = new JButton("Çalışma\r\n Saatleri");
		butonCalismaSaatleri.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		butonCalismaSaatleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFCalismaSaatleri.setVisible(true);
				iFHastaBilgileri.setVisible(false);
			}
		});
		butonCalismaSaatleri.setBounds(50, 167, 144, 38);
		contentPane.add(butonCalismaSaatleri);
		
		
		
		iFHastaBilgileri.setBounds(215, 66, 559, 364);
		contentPane.add(iFHastaBilgileri);
		iFHastaBilgileri.getContentPane().setLayout(null);
		
		JList<String> list = new JList<>(hasta.hastaList());

		list.setBounds(55, 22, 432, 290);
		iFHastaBilgileri.getContentPane().add(list);
		
		iFCalismaSaatleri.setBounds(215, 77, 559, 353);
		contentPane.add(iFCalismaSaatleri);
		
		
		
		iFHastaBilgileri.setVisible(true);
		
		
	}
	}

