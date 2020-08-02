package view; //메인 페이지에 있는 책을 눌렀을때 뜨는 책 상세정보 및 판매 버튼

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.BookDTO;
import model.DistanceDAO;
import model.MemberDAO;
import model.MemberDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;



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
         if(bookdto.getDealtype().equals("직거래")) {
        	 System.out.println("만나서 거래");
         }else if(bookdto.getDealtype().equals("배송")) {
        	 System.out.println("편하게 거래");
         }
		
         
         // 위도, 경도, 거리 차이
        double latitude = memdao.memberInfoSelect().get(0).getLatitude();
 		double longitude = memdao.memberInfoSelect().get(0).getLongitude();
 		double latitude2 = memdao.memberInfoSelect().get(1).getLatitude();
 		double longitude2 = memdao.memberInfoSelect().get(1).getLongitude();
 		double dis = distancedao.distance(latitude, longitude, latitude2, longitude2, "kilometer");
 		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(396, 37, 310, 239);
		frame.getContentPane().add(panel);
		
		JLabel lb_sellword_text = new JLabel("\uB0B4\uC6A9");
		panel.add(lb_sellword_text);
		
		JButton btnNewButton = new JButton("\u2190");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI mainGui = new MainGUI(null);
				
			}
		});
		btnNewButton.setBounds(12, 331, 64, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delivery");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				deliveryGUI delivery = new deliveryGUI(bookdto);
			}
		});
		btnNewButton_1.setBounds(515, 312, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 354, 381);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel_3.setBounds(76, 127, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		
		JLabel lb_sellword_category = new JLabel(bookdto.getCategory());
		lb_sellword_category.setBounds(193, 127, 57, 15);
		panel_1.add(lb_sellword_category);
		
		
		
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(76, 164, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lb_sellword_Title = new JLabel(bookdto.getTitle());
		lb_sellword_Title.setBounds(193, 164, 57, 15);
		panel_1.add(lb_sellword_Title);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setBounds(76, 209, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setBounds(76, 247, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4.setBounds(76, 293, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lb_sellword_price = new JLabel(Integer.toString(bookdto.getPrice()));
		lb_sellword_price.setBounds(193, 293, 57, 15);
		panel_1.add(lb_sellword_price);
		
		JLabel lb_Sellword_publicher = new JLabel(bookdto.getPublisher());
		lb_Sellword_publicher.setBounds(193, 247, 57, 15);
		panel_1.add(lb_Sellword_publicher);
		
		JLabel lb_Sellword_Writer = new JLabel(bookdto.getWriter());
		lb_Sellword_Writer.setBounds(193, 209, 57, 15);
		panel_1.add(lb_Sellword_Writer);
		
		JLabel lblNewLabel_5 = new JLabel("< \uC0C1\uC138 \uC815\uBCF4 >");
		lblNewLabel_5.setBounds(124, 10, 103, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uD310\uB9E4\uC790");
		lblNewLabel_6.setBounds(27, 40, 57, 15);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(""+latitude);
		lblNewLabel_7.setBounds(114, 40, 57, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(""+longitude);
		lblNewLabel_8.setBounds(206, 40, 57, 15);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uAD6C\uB9E4\uC790");
		lblNewLabel_9.setBounds(27, 67, 57, 15);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(""+latitude2);
		lblNewLabel_10.setBounds(114, 67, 57, 15);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(""+longitude2);
		lblNewLabel_11.setBounds(206, 67, 57, 15);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\uAC70\uB9AC \uCC28\uC774");
		lblNewLabel_12.setBounds(27, 92, 57, 15);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(""+dis+" KM");
		lblNewLabel_13.setBounds(124, 92, 151, 15);
		panel_1.add(lblNewLabel_13);
		
		
		System.out.println(dis);
		
		
	}
}
