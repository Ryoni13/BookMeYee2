package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.BookDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class WriteGUI {

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
	public WriteGUI(BookDTO bookdto) {
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
		
		
		System.out.println(bookdto.getCategory());
		JLabel lb_Write_category = new JLabel(bookdto.getCategory());
		lb_Write_category.setBounds(233, 89, 57, 15);
		frame.getContentPane().add(lb_Write_category);
		
		JLabel lb_Write_book = new JLabel(bookdto.getTitle());
		lb_Write_book.setBounds(233, 130, 57, 15);
		frame.getContentPane().add(lb_Write_book);
		
		JLabel lb_Write_Writer = new JLabel(bookdto.getWriter());
		lb_Write_Writer.setBounds(233, 161, 57, 15);
		frame.getContentPane().add(lb_Write_Writer);
		
		JLabel lb_Write_publicher = new JLabel(bookdto.getPublisher());
		lb_Write_publicher.setBounds(233, 213, 57, 15);
		frame.getContentPane().add(lb_Write_publicher);
		
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(109, 130, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setBounds(109, 161, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setBounds(109, 213, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel_3.setBounds(109, 89, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4.setBounds(109, 254, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JCheckBox cb_sell = new JCheckBox("\uD310\uB9E4");
		cb_sell.setBounds(103, 26, 115, 23);
		frame.getContentPane().add(cb_sell);
		
		JCheckBox cb_frac = new JCheckBox("\uB098\uB214");
		cb_frac.setBounds(252, 26, 115, 23);
		frame.getContentPane().add(cb_frac);
		
		JButton btnNewButton = new JButton("\uC9C1\uAC70\uB798");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //직거래
					
				
			} // 직거래
		});
		btnNewButton.setBounds(79, 335, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCEE4\uB125\uD2B8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //커넥트
			
			
			
			}//커넥트
		});
	
		
		btnNewButton_1.setBounds(239, 335, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uD310\uB9E4 \uBC29\uC2DD");
		lblNewLabel_5.setBounds(175, 298, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		
	}
}
