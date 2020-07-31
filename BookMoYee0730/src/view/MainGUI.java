package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import model.MemberDTO;

import javax.swing.JLabel;

public class MainGUI {

	private JFrame frame;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					main_2 window = new main_2();
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
	public MainGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 120, 414, 421);
		frame.getContentPane().add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JTabbedPane tab_main_all = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\uC804\uCCB4", null, tab_main_all, null);
		
		JTabbedPane tab_main_sell = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\uD310\uB9E4", null, tab_main_sell, null);
		
		JTabbedPane tab_main_buy = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\uAD6C\uB9E4", null, tab_main_buy, null);
		
		JTabbedPane tab_main_frac = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\uB098\uB214", null, tab_main_frac, null);
		
		JButton btn_main_library = new JButton("\uB0B4 \uC11C\uC7AC");
		btn_main_library.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI libray = new LibraryGUI(dto);
			}
		});
		btn_main_library.setBounds(326, 10, 97, 23);
		frame.getContentPane().add(btn_main_library);
		
		textField = new JTextField();
		textField.setBounds(97, 78, 281, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9");
		lblNewLabel.setBounds(44, 81, 40, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
