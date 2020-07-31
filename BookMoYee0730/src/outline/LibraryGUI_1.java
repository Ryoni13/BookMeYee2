package outline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class LibraryGUI_1 {

	private JFrame frame;
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LibraryGUI_1 window = new LibraryGUI_1();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.

	/**
	 * Initialize the contents of the frame.
	 */
	public LibraryGUI_1() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 420, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("delivery");
		chckbxNewCheckBox.setBounds(65, 320, 78, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("\uC9C1\uAC70\uB798");
		checkBox.setBounds(247, 320, 61, 23);
		frame.getContentPane().add(checkBox);
		
		btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LibraryGUI lbgui = new LibraryGUI();
			}
		});
		btnNewButton.setBounds(154, 361, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 380, 75);
		frame.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 106, 380, 102);
		frame.getContentPane().add(panel_1);
	}
}
