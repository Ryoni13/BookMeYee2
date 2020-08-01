package view; // È¸¿ø Á¤º¸ º¸±â

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.memberTableChange;
import model.MemberDAO;
import model.MemberDTO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowMemberInfo {

	private JFrame frame;
	private JTable table;
	private MemberDAO dao = new MemberDAO();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowMemberInfo window = new ShowMemberInfo();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ShowMemberInfo() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		label.setBounds(12, 10, 410, 42);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 62, 410, 189);
		frame.getContentPane().add(scrollPane);
		
		String[] colName = {"Name", "ID", "PW", "phoneNumber", "Bread",  "location"};
		
		memberTableChange modelCh = new memberTableChange(dao.memberInfoSelect());
		Object[][] data = modelCh.listTypeChange();
		
		table = new JTable(data, colName);
		scrollPane.setViewportView(table);
		
		JButton btn_showmemberinfo_close = new JButton("\uB2EB\uAE30");
		btn_showmemberinfo_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_showmemberinfo_close.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		btn_showmemberinfo_close.setBounds(225, 271, 189, 34);
		frame.getContentPane().add(btn_showmemberinfo_close);
		
		JButton btn_showmemberinfo_back = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btn_showmemberinfo_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginGUI login = new LoginGUI(); 
			}
		});
		btn_showmemberinfo_back.setFont(new Font("Dialog", Font.PLAIN, 15));
		btn_showmemberinfo_back.setBounds(22, 271, 189, 34);
		frame.getContentPane().add(btn_showmemberinfo_back);
	}
}
