package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Controller.BookTableModelChange;
import model.BookDAO;
import model.BookDAO.showBookTable;
import model.MemberDTO;

import javax.swing.JLabel;
import javax.swing.JTable;

public class MainGUI {

	private JFrame frame;
	private JTextField textField_search;
	
	int titleNumber;
	String title;
	String writer;
	String publisher;
	int price;
	String category;
	String dealtype;
	String id;
	String dealcar;
	
	private BookDAO dao = new BookDAO();
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JTable table_all;
	private JScrollPane scrollPane_1;
	private JTable table_sell;
	private JScrollPane scrollPane_2;
	private JTable table_trade;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					main_2 window = new main_2();
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
	public MainGUI(MemberDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_main_library = new JButton("\uB0B4 \uC11C\uC7AC");
		btn_main_library.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI libray = new LibraryGUI(dto);
			}
		});
		btn_main_library.setBounds(326, 10, 97, 23);
		frame.getContentPane().add(btn_main_library);
		
		textField_search = new JTextField();
		textField_search.setBounds(97, 78, 281, 21);
		frame.getContentPane().add(textField_search);
		textField_search.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9");
		lblNewLabel.setBounds(44, 81, 40, 15);
		frame.getContentPane().add(lblNewLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 114, 414, 432);
		frame.getContentPane().add(tabbedPane);
		

		
		
		
		//////////////////////////////////////////////////////////////////////////////
		scrollPane = new JScrollPane();
		tabbedPane.addTab("전체", null, scrollPane, null);
		
		String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"};
		BookTableModelChange modelCh = new BookTableModelChange(dao.showallbook(dto.getId()));
		Object[][] data = modelCh.listTypeChange();//걍뜨는 테이블
		table_all = new JTable(data, colName);

		scrollPane.setViewportView(table_all);
		
		//////////////////////////////////////////////////////////////////////////////
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("판매", null, scrollPane_1, null);
		
		String[] colName1 = {"정완", "주희", "문형" ,"저자", "출판사", "가격"};
		BookTableModelChange modelCh1 = new BookTableModelChange(dao.showsellbook(dto.getId()));
		Object[][] data1 = modelCh1.listTypeChange();
		table_sell = new JTable(data1,colName1);
		
		scrollPane_1.setViewportView(table_sell);
		
		
		////////////////////////////////////////////////////////////////////////////////
		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("교환", null, scrollPane_2, null);
		
		String[] colName2 = {"리현", "향선", "문형" ,"저자", "출판사", "가격"};
		BookTableModelChange modelCh2 = new BookTableModelChange(dao.showtradebook(dto.getId()));
		Object[][] data2 = modelCh2.listTypeChange();
		
		table_trade = new JTable(data2,colName2);
		
		scrollPane_2.setViewportView(table_trade);
		
		////////////////////////////////////////////////////////////////////////////////

		
	}
}
