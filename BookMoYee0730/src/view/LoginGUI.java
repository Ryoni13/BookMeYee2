package view; //·Î±×ÀÎ ÇÏ´Â Ã¢

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 17, 410, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544  \uC774  \uB514   :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(12, 70, 95, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		tf_login_id = new JTextField();
		tf_login_id.setBounds(111, 70, 295, 28);
		frame.getContentPane().add(tf_login_id);
		tf_login_id.setColumns(10);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638   :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label.setBounds(12, 108, 95, 28);
		frame.getContentPane().add(label);
		
		JButton btn_login_login = new JButton("\uB85C\uADF8\uC778");
		btn_login_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = tf_login_id.getText();
				String pw = pf_login_pw.getText();
				MemberDTO dto = dao.loginSelect(id, pw);
				if(dto == null) {
					JOptionPane.showMessageDialog(null, "·Î±×ÀÎ ½ÇÆÐ", "·Î±×ÀÎ", JOptionPane.ERROR_MESSAGE);
					pf_login_pw.setText("");
				}else {
					frame.dispose();
					MainGUI mainGUI = new MainGUI(dto);
				}
			}
		});
		btn_login_login.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		btn_login_login.setBounds(12, 176, 126, 34);
		frame.getContentPane().add(btn_login_login);
		
		pf_login_pw = new JPasswordField();
		pf_login_pw.setBounds(111, 108, 295, 28);
		frame.getContentPane().add(pf_login_pw);
		
		JButton btn_login_join = new JButton("\uD68C\uC6D0 \uAC00\uC785");
		btn_login_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JoinGUI join = new JoinGUI();
			}
		});
		btn_login_join.setFont(new Font("Dialog", Font.PLAIN, 15));
		btn_login_join.setBounds(152, 176, 126, 34);
		frame.getContentPane().add(btn_login_join);
		
		JButton btn_login_info = new JButton("\uD68C\uC6D0 \uC815\uBCF4");
		btn_login_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowMemberInfo memberInfo = new ShowMemberInfo();
			}
		});
		btn_login_info.setFont(new Font("Dialog", Font.PLAIN, 15));
		btn_login_info.setBounds(292, 176, 126, 34);
		frame.getContentPane().add(btn_login_info);
	}
}
