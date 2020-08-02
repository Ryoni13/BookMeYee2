package view; // È¸¿ø »èÁ¦

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import model.MemberDAO;
import model.MemberDTO;
import outline.mypageGUI2;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 750, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		label.setBounds(402, 54, 320, 42);
		frame.getContentPane().add(label);

		pf_delete_pw = new JPasswordField();
		pf_delete_pw.setBounds(564, 179, 147, 28);
		frame.getContentPane().add(pf_delete_pw);

		JLabel label_2 = new JLabel("\uBE44  \uBC00  \uBC88  \uD638   :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_2.setBounds(414, 178, 121, 28);
		frame.getContentPane().add(label_2);

		JButton button = new JButton("\uD0C8\uD1F4\uD558\uAE30");
		button.setBackground(new Color(100, 149, 237));
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
		button.setBounds(414, 252, 126, 34);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\uB2EB\uAE30");
		button_1.setBackground(new Color(100, 149, 237));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI mainGui = new MainGUI(dto);
			}
		});
		button_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		button_1.setBounds(575, 252, 136, 34);
		frame.getContentPane().add(button_1);

		JLabel label_3 = new JLabel("\uC544     \uC774    \uB514   :");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_3.setBounds(428, 122, 95, 28);
		frame.getContentPane().add(label_3);

		JLabel lb_loginId = new JLabel();
		lb_loginId.setText(dto.getId());
		lb_loginId.setBounds(566, 122, 156, 28);
		frame.getContentPane().add(lb_loginId);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 372, 381);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI mainGui = new MainGUI(dto);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\SMT055\\Desktop\\main2.png"));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(12, 10, 67, 65);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SMT055\\Downloads\\\u30B4\u30DF\u7BB1\u306E\u30D5\u30EA\u30FC\u30A2\u30A4\u30B3\u30F3.png"));
		lblNewLabel.setBounds(58, 21, 256, 333);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\uC774\uC804 \uD398\uC774\uC9C0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mypageGUI2 mainGui = new mypageGUI2(dto) ;
			}
		});
		btnNewButton_1.setBackground(new Color(100, 149, 237));
		btnNewButton_1.setBounds(12, 348, 97, 23);
		panel.add(btnNewButton_1);
	}

}
