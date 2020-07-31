package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.MemberDTO;
import outline.mypageGUI2;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 259, 291);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB0B4 \uC815\uBCF4");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel.setBounds(85, 10, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(47, 46, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lbl_name = new JLabel(dto.getName());
		lbl_name.setBounds(105, 46, 104, 15);
		frame.getContentPane().add(lbl_name);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC704\uCE58");
		lblNewLabel_1_1.setBounds(47, 159, 57, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lbl_location = new JLabel(dto.getLocation());
		lbl_location.setBounds(105, 159, 104, 15);
		frame.getContentPane().add(lbl_location);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD3F0\uBC88\uD638");
		lblNewLabel_1_2.setBounds(47, 120, 57, 15);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lbl_phone = new JLabel(dto.getPhoneNumber());
		lbl_phone.setBounds(105, 120, 104, 15);
		frame.getContentPane().add(lbl_phone);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1_3.setBounds(47, 82, 57, 15);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lbl_id = new JLabel(dto.getId());
		lbl_id.setBounds(105, 82, 104, 15);
		frame.getContentPane().add(lbl_id);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mypageGUI2 my = new mypageGUI2(dto);
			}
		});
		btnNewButton.setBounds(63, 200, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
