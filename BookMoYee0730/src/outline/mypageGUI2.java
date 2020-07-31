package outline;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import model.MemberDTO;
import view.MemberDeleteGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mypageGUI2 {

	private JFrame frame;
	private JTextField tf_mypage_pw;
	private JTextField tf_mypage_pw2;
	private JTextField tf_mypage_location;
	private JTextField tf_mypage_phone;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mypageGUI window = new mypageGUI();
//					window.frame.setVisible(true);
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
	public mypageGUI2(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC218\uC815 ");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lblNewLabel.setBounds(133, 0, 77, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 40, 28, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel pl_mypage_name = new JPanel();
		pl_mypage_name.setBackground(Color.WHITE);
		pl_mypage_name.setBounds(91, 36, 180, 21);
		frame.getContentPane().add(pl_mypage_name);
		
		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 100, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		tf_mypage_pw = new JTextField();
		tf_mypage_pw.setBounds(91, 98, 180, 21);
		frame.getContentPane().add(tf_mypage_pw);
		tf_mypage_pw.setColumns(10);
		
		tf_mypage_pw2 = new JTextField();
		tf_mypage_pw2.setBounds(91, 129, 180, 21);
		frame.getContentPane().add(tf_mypage_pw2);
		tf_mypage_pw2.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("PW\uD655\uC778");
		lblNewLabel_2_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(22, 132, 57, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(22, 69, 57, 15);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uC704\uCE58");
		lblNewLabel_2_3.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(22, 162, 57, 15);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		tf_mypage_location = new JTextField();
		tf_mypage_location.setColumns(10);
		tf_mypage_location.setBounds(91, 160, 180, 21);
		frame.getContentPane().add(tf_mypage_location);
		
		JLabel lblNewLabel_2_4 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		lblNewLabel_2_4.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_2_4.setBounds(22, 194, 106, 19);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		tf_mypage_phone = new JTextField();
		tf_mypage_phone.setColumns(10);
		tf_mypage_phone.setBounds(91, 193, 180, 21);
		frame.getContentPane().add(tf_mypage_phone);
		
		JButton btn_mypage_rectify = new JButton("\uC218\uC815");
		btn_mypage_rectify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_mypage_rectify.setBounds(22, 234, 97, 23);
		frame.getContentPane().add(btn_mypage_rectify);
		
		JPanel pl_mypage_id = new JPanel();
		pl_mypage_id.setBackground(Color.WHITE);
		pl_mypage_id.setBounds(91, 67, 179, 21);
		frame.getContentPane().add(pl_mypage_id);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberDeleteGUI mbd = new MemberDeleteGUI(dto);
			}
		});
		btnNewButton.setBounds(174, 234, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
