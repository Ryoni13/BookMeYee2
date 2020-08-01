package view; // È¸¿ø »èÁ¦

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import model.MemberDAO;
import model.MemberDTO;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberDeleteGUI {

	private JFrame frame;
	private MemberDTO loginMember;
	private JPasswordField pf_delete_pw;
	MemberDAO dao = new MemberDAO();

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// MemberDeleteGUI window = new MemberDeleteGUI();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 * @param pw 
	 */
	public MemberDeleteGUI(MemberDTO dto) {
		loginMember = dto;
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		label.setBounds(12, 23, 410, 42);
		frame.getContentPane().add(label);

		pf_delete_pw = new JPasswordField();
		pf_delete_pw.setBounds(119, 100, 295, 28);
		frame.getContentPane().add(pf_delete_pw);

		JLabel label_2 = new JLabel("\uBE44  \uBC00  \uBC88  \uD638   :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_2.setBounds(12, 100, 95, 28);
		frame.getContentPane().add(label_2);

		JButton button = new JButton("\uD0C8\uD1F4\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw1 = pf_delete_pw.getText();
				if (loginMember.getPw().equals(pw1)) {
					int cnt = dao.memberDelete(loginMember.getId(),loginMember.getPw());
					if (cnt == 0) {
						JOptionPane.showMessageDialog(null, "È¸¿øÅ»Åð ½ÇÆÐ", "È¸¿øÅ»Åð", JOptionPane.ERROR_MESSAGE);
						pf_delete_pw.setText("");
					}else {
						frame.dispose();
						LoginGUI loginGui = new LoginGUI();
						JOptionPane.showMessageDialog(null, "È¸¿øÅ»Åð ¼º°ø");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.", "È¸¿øÅ»Åð", JOptionPane.ERROR_MESSAGE);
					pf_delete_pw.setText("");
				}
			}
		});
		button.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		button.setBounds(51, 146, 156, 34);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\uB2EB\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
//				MainGUI mainGui = new MainGUI();
			}
		});
		button_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		button_1.setBounds(232, 146, 156, 34);
		frame.getContentPane().add(button_1);

		JLabel label_3 = new JLabel("\uC544     \uC774    \uB514   :");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_3.setBounds(12, 63, 95, 28);
		frame.getContentPane().add(label_3);

		JLabel lb_loginId = new JLabel();
		lb_loginId.setText(dto.getId());
		lb_loginId.setBounds(119, 63, 295, 28);
		frame.getContentPane().add(lb_loginId);
	}

}
