package view; //메인 페이지에 있는 책을 눌렀을때 뜨는 책 상세정보 및 판매 버튼

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.BookDTO;
import model.MemberDAO;
import model.MemberDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;



public class SellwordGUI {
	MemberDAO dao = new MemberDAO();

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
		lblNewLabel_3.setBounds(74, 71, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		
		JLabel lb_sellword_category = new JLabel(bookdto.getCategory());
		lb_sellword_category.setBounds(191, 71, 57, 15);
		panel_1.add(lb_sellword_category);
		
		
		
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(74, 108, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lb_sellword_Title = new JLabel(bookdto.getTitle());
		lb_sellword_Title.setBounds(191, 108, 57, 15);
		panel_1.add(lb_sellword_Title);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setBounds(74, 153, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setBounds(74, 191, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4.setBounds(74, 237, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lb_sellword_price = new JLabel(Integer.toString(bookdto.getPrice()));
		lb_sellword_price.setBounds(191, 237, 57, 15);
		panel_1.add(lb_sellword_price);
		
		JLabel lb_Sellword_publicher = new JLabel(bookdto.getPublisher());
		lb_Sellword_publicher.setBounds(191, 191, 57, 15);
		panel_1.add(lb_Sellword_publicher);
		
		JLabel lb_Sellword_Writer = new JLabel(bookdto.getWriter());
		lb_Sellword_Writer.setBounds(191, 153, 57, 15);
		panel_1.add(lb_Sellword_Writer);
		
		JLabel lblNewLabel_5 = new JLabel("\uC0C1\uC138 \uC815\uBCF4");
		lblNewLabel_5.setBounds(144, 10, 57, 15);
		panel_1.add(lblNewLabel_5);
		

		
		
	}
}
