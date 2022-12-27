  package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataBase.Bashekim;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JList;


public class BHGenel extends JFrame {
	
	JInternalFrame iFDoktorBilgi = new JInternalFrame("DoktorBİlgisi");
	JInternalFrame iFDoktorEkle = new JInternalFrame("Doktor Ekle");
	JInternalFrame iFNobetSaati = new JInternalFrame(" nobet ayarla");

	private JPanel contentPane;
	 static Bashekim bshekim = new Bashekim();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BHGenel frame = new BHGenel(bshekim);
					frame.setTitle("Baş Hekim Sayfası");
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
	public BHGenel(Bashekim bshekim) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butonDoktorBilgisiBHekim = new JButton("Doktor bilgisi");
		butonDoktorBilgisiBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorBilgi.setVisible(true);
				iFDoktorEkle.setVisible(false);
				iFNobetSaati.setVisible(false);
			}
		});
		butonDoktorBilgisiBHekim.setBounds(21, 64, 156, 118);
		contentPane.add(butonDoktorBilgisiBHekim);
		
		JButton butonNobetSaatiBHekim = new JButton("nobet ayarla");
		butonNobetSaatiBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorBilgi.setVisible(false);
				iFDoktorEkle.setVisible(false);
				iFNobetSaati.setVisible(true);
			}
		});
		butonNobetSaatiBHekim.setBounds(21, 432, 156, 118);
		contentPane.add(butonNobetSaatiBHekim);
		
		JButton butonDoktorEkleBHekim = new JButton("doktor ekle çikar");
		butonDoktorEkleBHekim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFDoktorEkle.setVisible(true);
				iFDoktorBilgi.setVisible(false);
				iFNobetSaati.setVisible(false);
			}
		});
		butonDoktorEkleBHekim.setBounds(21, 262, 156, 118);
		contentPane.add(butonDoktorEkleBHekim);
		iFDoktorBilgi.setBackground(new Color(4, 251, 220));
		iFDoktorBilgi.setEnabled(false);
		iFDoktorBilgi.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 128), null, null, null));
		
		iFDoktorBilgi.setBounds(187, 64, 687, 486);
		contentPane.add(iFDoktorBilgi);
		
		JList list = new JList();
		iFDoktorBilgi.getContentPane().add(list, BorderLayout.WEST);
		iFDoktorEkle.setBackground(new Color(4, 251, 220));
		
		
		iFDoktorEkle.setBounds(187, 64, 687, 486);
		contentPane.add(iFDoktorEkle);
		iFNobetSaati.setBackground(new Color(4, 251, 220));
		
		iFNobetSaati.setBounds(187, 64, 687, 486);
		contentPane.add(iFNobetSaati);
		
		iFNobetSaati.setVisible(false);
		iFDoktorEkle.setVisible(false);
		iFDoktorBilgi.setVisible(false);
	}
}
