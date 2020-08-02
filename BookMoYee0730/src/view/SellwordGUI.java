package view; //¸ÞÀÎ ÆäÀÌÁö¿¡ ÀÖ´Â Ã¥À» ´­·¶À»¶§ ¶ß´Â Ã¥ »ó¼¼Á¤º¸ ¹× ÆÇ¸Å ¹öÆ°

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.memberTableChange;
import model.BookDTO;
import model.DistanceDAO;
import model.MemberDAO;
import model.MemberDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;



public class SellwordGUI {
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WriteGUI window = new WriteGUI();
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
	public SellwordGUI(BookDTO bookdto) {
		initialize(bookdto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BookDTO bookdto) {
		MemberDAO memdao = new MemberDAO();
		DistanceDAO distancedao = new DistanceDAO();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 750, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 String dealtype = null;
         if(bookdto.getDealtype().equals("Á÷°Å·¡")) {
        	 dealtype = "¸¸³ª¼­ °Å·¡ÇØ¿ä";
         }else if(bookdto.getDealtype().equals("¹è¼Û")) {
        	 dealtype = "ÆíÇÏ°Ô °Å·¡ÇØ¿ä";
         }
		
         
         // À§µµ, °æµµ, °Å¸® Â÷ÀÌ
        double latitude = memdao.memberInfoSelect().get(0).getLatitude();
 		double longitude = memdao.memberInfoSelect().get(0).getLongitude();
 		double latitude2 = memdao.memberInfoSelect().get(1).getLatitude();
 		double longitude2 = memdao.memberInfoSelect().get(1).getLongitude();
 		double dis = distancedao.distance(latitude, longitude, latitude2, longitude2, "kilometer");

 		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(396, 37, 310, 265);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_sellword_text = new JLabel("\uB0B4\uC6A9");
		lb_sellword_text.setBounds(143, 5, 24, 15);
		panel.add(lb_sellword_text);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 29, 286, 226);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("\u2190");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI mainGui = new MainGUI(null);
				
			}
		});
		btnNewButton.setBounds(12, 331, 64, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(""+dealtype);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				deliveryGUI delivery = new deliveryGUI(bookdto);
			}
		});
		btnNewButton_1.setBounds(484, 331, 139, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 354, 381);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(124, 152, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		
		JLabel lb_sellword_category = new JLabel(bookdto.getCategory());
		lb_sellword_category.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lb_sellword_category.setBackground(Color.BLACK);
		lb_sellword_category.setForeground(Color.BLACK);
		lb_sellword_category.setBounds(241, 152, 57, 15);
		panel_1.add(lb_sellword_category);
		
		
		
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(124, 189, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lb_sellword_Title = new JLabel(bookdto.getTitle());
		lb_sellword_Title.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lb_sellword_Title.setBackground(Color.BLACK);
		lb_sellword_Title.setForeground(Color.BLACK);
		lb_sellword_Title.setBounds(241, 189, 57, 15);
		panel_1.add(lb_sellword_Title);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(124, 234, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(124, 272, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(124, 318, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lb_sellword_price = new JLabel(Integer.toString(bookdto.getPrice()));
		lb_sellword_price.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lb_sellword_price.setBackground(Color.BLACK);
		lb_sellword_price.setForeground(Color.BLACK);
		lb_sellword_price.setBounds(241, 318, 57, 15);
		panel_1.add(lb_sellword_price);
		
		JLabel lb_Sellword_publicher = new JLabel(bookdto.getPublisher());
		lb_Sellword_publicher.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lb_Sellword_publicher.setBackground(Color.BLACK);
		lb_Sellword_publicher.setForeground(Color.BLACK);
		lb_Sellword_publicher.setBounds(241, 272, 57, 15);
		panel_1.add(lb_Sellword_publicher);
		
		JLabel lb_Sellword_Writer = new JLabel(bookdto.getWriter());
		lb_Sellword_Writer.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lb_Sellword_Writer.setBackground(Color.BLACK);
		lb_Sellword_Writer.setForeground(Color.BLACK);
		lb_Sellword_Writer.setBounds(241, 234, 57, 15);
		panel_1.add(lb_Sellword_Writer);
		
		JLabel lblNewLabel_5 = new JLabel("< \uC0C1\uC138 \uC815\uBCF4 >");
		lblNewLabel_5.setBounds(124, 10, 103, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uD310\uB9E4\uC790");
		lblNewLabel_6.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_6.setBounds(50, 56, 57, 15);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(""+latitude);
		lblNewLabel_7.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_7.setBounds(137, 56, 57, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(""+longitude);
		lblNewLabel_8.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_8.setBounds(229, 56, 57, 15);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uAD6C\uB9E4\uC790");
		lblNewLabel_9.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_9.setBounds(50, 83, 57, 15);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(""+latitude2);
		lblNewLabel_10.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_10.setBounds(137, 83, 57, 15);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(""+longitude2);
		lblNewLabel_11.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_11.setBounds(229, 83, 57, 15);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\uAC70\uB9AC \uCC28\uC774");
		lblNewLabel_12.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_12.setBounds(50, 108, 103, 15);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(""+dis+" KM");
		lblNewLabel_13.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_13.setBounds(147, 108, 151, 15);
		panel_1.add(lblNewLabel_13);
		
//		JLabel lblNewLabel_14 = new JLabel(""+memdao.memberlogininfo(bookdto.getId()).get(1));
		JLabel lblNewLabel_14 = new JLabel(" ");
		System.out.println(" ");
		lblNewLabel_14.setBounds(25, 163, 57, 15);
		panel_1.add(lblNewLabel_14);
		
		
		System.out.println(dis);
		
		
	}
}
