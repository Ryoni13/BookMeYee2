package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import model.MemberDAO;
import model.MemberDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class LoginGUI {

	private JFrame frame;
	private JTextField tf_login_id;
	MemberDAO dao = new MemberDAO();
	private JPasswordField pf_login_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI login = new LoginGUI();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 750, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel.setBounds(408, 76, 286, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("I     D   :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(408, 169, 95, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		tf_login_id = new JTextField();
		tf_login_id.setBounds(515, 169, 186, 28);
		frame.getContentPane().add(tf_login_id);
		tf_login_id.setColumns(10);
		
		JLabel lblPW = new JLabel("P    W   :");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPW.setBounds(408, 220, 95, 28);
		frame.getContentPane().add(lblPW);
		
		JButton btn_login_login = new JButton("login");
		btn_login_login.setBackground(new Color(100, 149, 237));
		btn_login_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = tf_login_id.getText();
				String pw = pf_login_pw.getText();
				MemberDTO dto = dao.loginSelect(id, pw);
				if(dto == null) {
					JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
					pf_login_pw.setText("");
				}else {
					frame.dispose();
					MainGUI main = new MainGUI(dto);
				}
			}
		});
		btn_login_login.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		btn_login_login.setBounds(418, 296, 126, 34);
		frame.getContentPane().add(btn_login_login);
		
		pf_login_pw = new JPasswordField();
		pf_login_pw.setBounds(515, 221, 186, 28);
		frame.getContentPane().add(pf_login_pw);
		
		JButton btn_login_join = new JButton("membership");
		btn_login_join.setBackground(new Color(100, 149, 237));
		btn_login_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JoinGUI join = new JoinGUI();
			}
		});
		btn_login_join.setFont(new Font("Dialog", Font.PLAIN, 15));
		btn_login_join.setBounds(568, 296, 126, 34);
		frame.getContentPane().add(btn_login_join);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(0, 0, 375, 491);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\SMT055\\Desktop\\lo.png"));
		lblNewLabel_2.setBounds(87, 23, 228, 413);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("회원정보");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowMemberInfo memberInfo = new ShowMemberInfo();
			}
		});
		btnNewButton.setBounds(514, 445, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
	
	}
}
