package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.BookDAO;
import model.BookDTO;
import model.MemberDAO;
import model.MemberDTO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class BookInsertGUI {

	private JFrame frame;
	private JTextField tf_insert_book;
	private JTextField tf_insert_writer;
	private JTextField tf_insert_publicher;
	private JTextField tf_location;
	private JTextField tf_insert_price;
	
	double latitude;
	double longitude;
	BookDAO dao = new BookDAO();
	String id;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookInsertGUI window = new BookInsertGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param loginid 
	 */
	public BookInsertGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 377, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel.setBounds(24, 42, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setBounds(24, 80, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setBounds(24, 118, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC7A5\uC18C");
		lblNewLabel_3.setBounds(24, 156, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		tf_insert_book = new JTextField();
		tf_insert_book.setBounds(105, 43, 116, 21);
		frame.getContentPane().add(tf_insert_book);
		tf_insert_book.setColumns(10);
		
		tf_insert_writer = new JTextField();
		tf_insert_writer.setColumns(10);
		tf_insert_writer.setBounds(105, 77, 116, 21);
		frame.getContentPane().add(tf_insert_writer);
		
		tf_insert_publicher = new JTextField();
		tf_insert_publicher.setColumns(10);
		tf_insert_publicher.setBounds(105, 115, 116, 21);
		frame.getContentPane().add(tf_insert_publicher);
		
		tf_location = new JTextField();
		tf_location.setColumns(10);
		tf_location.setBounds(105, 153, 116, 21);
		frame.getContentPane().add(tf_location);
		
		tf_insert_price = new JTextField();
		tf_insert_price.setBounds(105, 191, 116, 21);
		frame.getContentPane().add(tf_insert_price);
		frame.getContentPane().add(tf_insert_price);
		
		JComboBox cbb_insert_categoty = new JComboBox();
		cbb_insert_categoty.setModel(new DefaultComboBoxModel(new String[] {"아동", "소설", "자기계발서", "문제집", "잡지", "만화"}));
		cbb_insert_categoty.setBounds(105, 232, 116, 35);
		frame.getContentPane().add(cbb_insert_categoty);
		
		JLabel lblNewLabel_4 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel_4.setBounds(24, 234, 57, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JCheckBox cb_deal = new JCheckBox("직거래");
		buttonGroup.add(cb_deal);
		cb_deal.setBounds(105, 273, 71, 23);
		frame.getContentPane().add(cb_deal);
		
		JButton btn_bookinsert = new JButton("\uD310\uB9E4 \uB4F1\uB85D");
		btn_bookinsert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
					BufferedReader br = null;
					JSONParser parser = new JSONParser();
					
					String title = tf_insert_book.getText();
					String writer = tf_insert_writer.getText();
					String publisher = tf_insert_publicher.getText();
					int price = Integer.parseInt(tf_insert_price.getText());
					String category = (String) cbb_insert_categoty.getSelectedItem();
					String dealtype = cb_deal.getText();
					String id= dto.getId();
					
					
					int cnt = dao.bookInsert(new BookDTO(category, title, writer, publisher, price, dealtype, id));
					frame.dispose();
					LibraryGUI main = new LibraryGUI(dto);	
			}
		});
		btn_bookinsert.setBounds(252, 517, 97, 23);
		frame.getContentPane().add(btn_bookinsert);
		
		JLabel lblNewLabel_5 = new JLabel("\uAC00\uACA9");
		lblNewLabel_5.setBounds(24, 194, 57, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		JLabel lblNewLabel_6 = new JLabel("\uD310\uB9E4 \uB4F1\uB85D");
		lblNewLabel_6.setBounds(116, 10, 57, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(24, 322, 301, 154);
		frame.getContentPane().add(editorPane);
		
		JLabel label = new JLabel("\uD310\uB9E4\uBC29\uC2DD");
		label.setBounds(23, 277, 57, 15);
		frame.getContentPane().add(label);
		
		
		JCheckBox cb_delivery = new JCheckBox("배달");
		buttonGroup.add(cb_delivery);
		cb_delivery.setBounds(198, 273, 62, 23);
		frame.getContentPane().add(cb_delivery);
		
		JLabel lbl_id = new JLabel(dto.getId());
		lbl_id.setBounds(275, 10, 57, 15);
		frame.getContentPane().add(lbl_id);
	}

	
}
