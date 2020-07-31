package outline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryGUI_2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LibraryGUI_2 window = new LibraryGUI_2();
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
	public LibraryGUI_2() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("책 제목 :");
		lblNewLabel.setBounds(12, 30, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("저자 :");
		label.setBounds(12, 90, 57, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("출판사 :");
		label_1.setBounds(12, 150, 57, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("가격 :");
		label_2.setBounds(12, 210, 57, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uAC8C\uC2DC\uAE00");
		label_3.setBounds(161, 242, 42, 15);
		frame.getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setBounds(12, 300, 340, 125);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI lbgui = new LibraryGUI();
			}
		});
		btnNewButton.setBounds(133, 430, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("책에대한 상태혹은 등록하실책의 관련 내용을 작성주세요");
		lblNewLabel_1.setBounds(27, 278, 310, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 27, 116, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 87, 116, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(81, 147, 116, 21);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(81, 207, 116, 21);
		frame.getContentPane().add(textField_4);
	}
}
