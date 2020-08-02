package view; //서재 창

import java.awt.EventQueue;
import java.awt.print.Book;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.BookTableModelChange;
import Controller.memberTableChange;
import model.BookDAO;
import model.BookDTO;
import model.MemberDAO;
import model.MemberDTO;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class LibraryGUI<TableModel> {

	private JFrame frame;
	private JTable table;
	private BookDAO dao = new BookDAO();
	
	int titleNumber;
	String title;
	String writer;
	String publisher;
	int price;
	String category;
	String dealtype;
	String id;
	String dealcar;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LibraryGUI window = new LibraryGUI();
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
	public LibraryGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 750, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("My Page");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblNewLabel.setBounds(316, 14, 127, 55);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();//
		scrollPane.setBounds(48, 101, 650, 363);
		frame.getContentPane().add(scrollPane);

		String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"};
		BookTableModelChange modelCh = new BookTableModelChange(dao.bookInfo(dto.getId()));
		Object[][] data = modelCh.listTypeChange();
	    

		table = new JTable(data, colName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				javax.swing.table.TableModel model = table.getModel();
				dealtype = (String) table.getValueAt(index, 0);
				category = (String) table.getValueAt(index, 1);
			    title = (String) table.getValueAt(index, 2);
			    writer = (String) table.getValueAt(index, 3);
			    publisher = (String) table.getValueAt(index, 4);
			    price = (int) table.getValueAt(index, 5);
				
			}
		});
		scrollPane.setViewportView(table);	
		
		Button btn_library_new = new Button("\uCC45 \uB4F1\uB85D");
		btn_library_new.setBackground(new Color(100, 149, 237));
		
		btn_library_new.addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BookInsertGUI bookInsert = new BookInsertGUI(dto);
			}
		});//
		btn_library_new.setBounds(622, 62, 76, 33);
		frame.getContentPane().add(btn_library_new);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.setIcon(new ImageIcon(LibraryGUI.class.getResource("/icon/user2.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MypageGUI myp = new MypageGUI(dto);
			}
		});
		btnNewButton.setBounds(632, 10, 59, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(173, 216, 230));
		btnNewButton_1.setIcon(new ImageIcon(LibraryGUI.class.getResource("/icon/main3.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI(dto);
			}
		});
		
		btnNewButton_1.setBounds(24, 10, 76, 74);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
