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
		frame.setBounds(100, 100, 451, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lb_sellword_category = new JLabel(bookdto.getCategory());
		lb_sellword_category.setBounds(230, 71, 57, 15);
		frame.getContentPane().add(lb_sellword_category);
		
		JLabel lb_sellword_Title = new JLabel(bookdto.getTitle());
		lb_sellword_Title.setBounds(230, 96, 57, 15);
		frame.getContentPane().add(lb_sellword_Title);
		
		JLabel lb_Sellword_Writer = new JLabel(bookdto.getWriter());
		lb_Sellword_Writer.setBounds(230, 121, 57, 15);
		frame.getContentPane().add(lb_Sellword_Writer);
		
		JLabel lb_Sellword_publicher = new JLabel(bookdto.getPublisher());
		lb_Sellword_publicher.setBounds(230, 146, 57, 15);
		frame.getContentPane().add(lb_Sellword_publicher);
		
		JLabel lb_sellword_price = new JLabel(Integer.toString(bookdto.getPrice()));
		lb_sellword_price.setBounds(230, 183, 57, 15);
		frame.getContentPane().add(lb_sellword_price);
		
		
		
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(109, 96, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setBounds(109, 121, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setBounds(109, 146, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel_3.setBounds(109, 71, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4.setBounds(142, 183, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		 String dealtype = null;
         if(bookdto.getDealtype().equals("직거래")) {
        	 System.out.println("만나서 거래");
         }else if(bookdto.getDealtype().equals("배송")) {
        	 System.out.println("편하게 거래");
         }
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(14, 223, 411, 97);
		frame.getContentPane().add(panel);
		
		JLabel lb_sellword_text = new JLabel("\uB0B4\uC6A9");
		panel.add(lb_sellword_text);
		
		JButton btnNewButton = new JButton("\u2190");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnNewButton.setBounds(14, 22, 64, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delivery");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				deliveryGUI delivery = new deliveryGUI(bookdto);
			}
		});
		btnNewButton_1.setBounds(169, 343, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		

		
		
	}
}
