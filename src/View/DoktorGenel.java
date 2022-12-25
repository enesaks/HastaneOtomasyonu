package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DoktorGenel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorGenel frame = new DoktorGenel();
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
	public DoktorGenel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butonHastalarimDr = new JButton("Hasta");
		butonHastalarimDr.setBounds(55, 76, 89, 23);
		contentPane.add(butonHastalarimDr);
		
		JButton butonCalismaSaatleriDr = new JButton("calisma saatleri");
		butonCalismaSaatleriDr.setBounds(55, 121, 89, 23);
		contentPane.add(butonCalismaSaatleriDr);
		
		JPanel panel = new JPanel();
		panel.setBounds(162, 31, 262, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel baslik = new JLabel("hosgeldin dr  ...");
		baslik.setBounds(10, 11, 126, 14);
		panel.add(baslik);
	}

}
