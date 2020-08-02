package view; //³» Á¤º¸

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.BookDTO;
import model.MemberDTO;
import outline.mypageGUI2;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class MypageGUI {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MypageGUI window = new MypageGUI();
//					//window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param pw 
	 */
	public MypageGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 750, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB0B4 \uC815\uBCF4");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lblNewLabel.setBounds(516, 32, 172, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(463, 82, 73, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_name = new JLabel(dto.getName());
		lbl_name.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lbl_name.setBounds(564, 78, 124, 31);
		frame.getContentPane().add(lbl_name);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC704\uCE58");
		lblNewLabel_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(463, 227, 57, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lbl_location = new JLabel(dto.getLocation());
		lbl_location.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lbl_location.setBounds(564, 227, 104, 36);
		frame.getContentPane().add(lbl_location);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD3F0\uBC88\uD638");
		lblNewLabel_1_2.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(463, 179, 57, 23);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lbl_phone = new JLabel(dto.getPhoneNumber());
		lbl_phone.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lbl_phone.setBounds(564, 180, 104, 20);
		frame.getContentPane().add(lbl_phone);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1_3.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(463, 129, 73, 28);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lbl_id = new JLabel(dto.getId());
		lbl_id.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lbl_id.setBounds(564, 132, 104, 23);
		frame.getContentPane().add(lbl_id);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mypageGUI2 my = new mypageGUI2(dto);
			}
		});
		btnNewButton.setBounds(503, 290, 97, 31);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 379, 381);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(62, 55, 256, 256);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\SMT055\\Desktop\\\u30A2\u30F3\u30B1\u30FC\u30C8\u7528\u7D19\u306E\u30A2\u30A4\u30B3\u30F3\u7D20\u6750.png"));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(12, 3, 67, 58);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI my = new MainGUI(dto);
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\SMT055\\Desktop\\main2.png"));
		
		JButton btnNewButton_2 = new JButton("\uC774\uC804 \uD398\uC774\uC9C0");
		btnNewButton_2.setBackground(new Color(100, 149, 237));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI my = new LibraryGUI(dto);
			}
		});
		btnNewButton_2.setBounds(12, 348, 97, 23);
		panel.add(btnNewButton_2);
	}

}
