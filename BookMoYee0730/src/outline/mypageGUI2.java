package outline;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import model.MemberDAO;
import model.MemberDTO;
import view.LoginGUI;
import view.MainGUI;
import view.MemberDeleteGUI;
import view.MypageGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class mypageGUI2 {

	private JFrame frame;
	private JTextField tf_mypage_pw;
	private JTextField tf_mypage_pw2;
	private JTextField tf_mypage_location;
	private JTextField tf_mypage_phone;
	MemberDAO dao = new MemberDAO();
	private JTextField textField;
	private JTextField textField_1;


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
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 751, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC218\uC815 ");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 19));
		lblNewLabel.setBounds(517, 20, 77, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(425, 67, 28, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(425, 140, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		tf_mypage_pw = new JTextField();
		tf_mypage_pw.setBounds(494, 138, 180, 21);
		frame.getContentPane().add(tf_mypage_pw);
		tf_mypage_pw.setColumns(10);
		
		tf_mypage_pw2 = new JTextField();
		tf_mypage_pw2.setBounds(494, 177, 180, 21);
		frame.getContentPane().add(tf_mypage_pw2);
		tf_mypage_pw2.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uBCC0\uACBDPW");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(425, 180, 57, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(425, 99, 57, 15);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uC704\uCE58");
		lblNewLabel_2_3.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(425, 218, 57, 15);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		tf_mypage_location = new JTextField();
		tf_mypage_location.setColumns(10);
		tf_mypage_location.setBounds(494, 216, 180, 21);
		frame.getContentPane().add(tf_mypage_location);
		
		JLabel lblNewLabel_2_4 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		lblNewLabel_2_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2_4.setBounds(425, 258, 106, 19);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		tf_mypage_phone = new JTextField();
		tf_mypage_phone.setColumns(10);
		tf_mypage_phone.setBounds(494, 257, 180, 21);
		frame.getContentPane().add(tf_mypage_phone);
		
		JButton btn_mypage_rectify = new JButton("\uC218\uC815");
		btn_mypage_rectify.setBackground(new Color(100, 149, 237));
		btn_mypage_rectify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw1 = tf_mypage_pw.getText();
				
				if (dto.getPw().equals(pw1)) {
					boolean cnt = dao.editPerson(dto);
					if (cnt == false) {
						JOptionPane.showMessageDialog(null, "수정 실패", "에러", JOptionPane.ERROR_MESSAGE);
						tf_mypage_pw.setText("");
					}else {
						String name = null;
						String id= dto.getId();
						String pw = tf_mypage_pw2.getText();
						String phoneNumber = tf_mypage_phone.getText();
						int bread = 0;
						String location = tf_mypage_location.getText();
						double latitude = 0;
						double longitude = 0;
						int memnum = 0;
						boolean cnt1 = dao.editPerson(new MemberDTO(name, id, pw, phoneNumber, bread, location, latitude, longitude, memnum));
						frame.dispose();
						LoginGUI log = new LoginGUI();
						JOptionPane.showMessageDialog(null, "수정 성공");
					}
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
					tf_mypage_pw.setText("");
				}
			}
			
		});
		btn_mypage_rectify.setBounds(425, 304, 97, 23);
		frame.getContentPane().add(btn_mypage_rectify);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberDeleteGUI mbd = new MemberDeleteGUI(dto);
			}
		});
		btnNewButton.setBounds(577, 304, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField(dto.getName());
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(494, 66, 180, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(dto.getId());
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(494, 97, 180, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 204));
		panel.setBounds(0, 0, 371, 395);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(51, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI my = new MainGUI(dto);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(mypageGUI2.class.getResource("/icon/main3.png")));
		btnNewButton_1.setBounds(12, 10, 83, 73);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(mypageGUI2.class.getResource("/icon/icon2.png")));
		lblNewLabel_3.setBounds(88, 66, 216, 270);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("\u2190");
		btnNewButton_2.setBackground(new Color(100, 149, 237));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MypageGUI my = new MypageGUI(dto);
			}
		});
		btnNewButton_2.setBounds(12, 346, 50, 23);
		panel.add(btnNewButton_2);
	}
}
