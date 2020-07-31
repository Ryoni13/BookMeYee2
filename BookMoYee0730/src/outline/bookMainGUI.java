package outline;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class bookMainGUI {

	private JFrame frame;
	private JTextField tf_main_search;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					bookMainGUI window = new bookMainGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public bookMainGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_main_library = new JButton("\uC11C\uC7AC");
		btn_main_library.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI lbgui = new LibraryGUI();
			}
		});
		btn_main_library.setBounds(240, 10, 66, 23);
		frame.getContentPane().add(btn_main_library);
		
		tf_main_search = new JTextField();
		tf_main_search.setBounds(52, 45, 207, 23);
		frame.getContentPane().add(tf_main_search);
		tf_main_search.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9");
		lblNewLabel.setBounds(15, 43, 31, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 75, 311, 344);
		frame.getContentPane().add(tabbedPane);
		
		JPanel pl_main_exchange = new JPanel();
		tabbedPane.addTab("±³È¯", null, pl_main_exchange, null);
		pl_main_exchange.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 10, 282, 295);
		pl_main_exchange.add(scrollPane_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(panel_5);
		
		JPanel pl_main_share = new JPanel();
		tabbedPane.addTab("³ª´®", null, pl_main_share, null);
		pl_main_share.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 10, 282, 295);
		pl_main_share.add(scrollPane_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panel_4);
		
		JPanel pl__main_purchase = new JPanel();
		tabbedPane.addTab("±¸¸Å", null, pl__main_purchase, null);
		pl__main_purchase.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 282, 295);
		pl__main_purchase.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 38, 29);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("\u25CE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 21));
		btnNewButton.setBounds(262, 45, 66, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
