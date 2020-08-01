package view; //판매하는 책들이 보이는 창

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controller.BookTableModelChange;
import model.BookDAO;
import model.BookDTO;
import model.MemberDTO;

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
//	private BookDTO bookdto = new BookDTO();
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_all;
	private JTable table_all;
	private JScrollPane scrollPane_sell;
	private JTable table_sell;
	private JScrollPane scrollPane_trade;
	private JTable table_trade;
	private JTabbedPane tabbedPane_1;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JScrollPane scrollPane_9;
	private JScrollPane scrollPane_10;
	private JTable table;
	private JTabbedPane all_tab;
	private JTabbedPane trade_tab;
	private JTabbedPane sell_tab;
	private JScrollPane all_all;
	private JScrollPane trade_all;
	private JScrollPane sell_all;
	private JScrollPane all_kids;
	private JScrollPane trade_kids;
	private JScrollPane sell_kids;
	private JScrollPane all_munjejip;
	private JScrollPane trade_munjejip;
	private JScrollPane sell_munjejip;
	private JTable table_all_all;
	private JTable table_sell_all;
	private JTable table_all_kids;
	private JTable table_all_munjejip;
	private JTable table_all_better;
	private JTable table_all_magazine;
	private JTable table_all_cartoon;
	private JScrollPane all_novel;
	private JScrollPane trade_novel;
	private JScrollPane sell_novel;
	private JTable table_all_novel;
	private JScrollPane sell_better;
	private JScrollPane sell_magazine;
	private JScrollPane sell_cartoon;
	private JScrollPane trade_better;
	private JScrollPane trade_magazine;
	private JScrollPane trade_cartoon;
	

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
	public MainGUI(MemberDTO memdto) {
		initialize(memdto);
		frame.setVisible(true);
	}




	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberDTO memdto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_main_library = new JButton("\uB0B4 \uC11C\uC7AC");
		btn_main_library.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI libray = new LibraryGUI(memdto);
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
		tabbedPane.setBounds(12, 114, 655, 410);
		frame.getContentPane().add(tabbedPane);
		
		//
		
		scrollPane_all = new JScrollPane();
		tabbedPane.addTab("전체", null, scrollPane_all, null);
		scrollPane_all.setViewportView(table_all);
		
		all_tab = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_all.setViewportView(all_tab);
		
		String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"}; // 전체 테이블 컬럼
		all_all = new JScrollPane();
		all_tab.addTab("전체", null, all_all, null);
		
				BookTableModelChange modelCh = new BookTableModelChange(dao.showallbook(memdto.getId()));
				Object[][] data = modelCh.listTypeChange();
			
				table_all_all = new JTable(data, colName);
				table_all_all.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table_all_all.getSelectedRow();
					
						dealtype = (String) table_all_all.getValueAt(index, 0);
						category = (String) table_all_all.getValueAt(index, 1);
					    title = (String) table_all_all.getValueAt(index, 2);
					    writer = (String) table_all_all.getValueAt(index, 3);
					    publisher = (String) table_all_all.getValueAt(index, 4);
					    price = (int) table_all_all.getValueAt(index, 5);
					    			    
					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
					
					    SellwordGUI word = new SellwordGUI(bookdto1);
					}
				});
				all_all.setViewportView(table_all_all);
			

			all_kids = new JScrollPane();
			all_tab.addTab("아동", null, all_kids, null);
				
				BookTableModelChange modelCh1 = new BookTableModelChange(dao.showkidsbook(memdto.getId()));
				Object[][] data1 = modelCh1.listTypeChange();
				
				table_all_kids = new JTable(data1, colName);
				table_all_kids.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table_all_kids.getSelectedRow();
					
						dealtype = (String) table_all_kids.getValueAt(index, 0);
						category = (String) table_all_kids.getValueAt(index, 1);
					    title = (String) table_all_kids.getValueAt(index, 2);
					    writer = (String) table_all_kids.getValueAt(index, 3);
					    publisher = (String) table_all_kids.getValueAt(index, 4);
					    price = (int) table_all_kids.getValueAt(index, 5);
					    			    
					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
					
					    SellwordGUI word = new SellwordGUI(bookdto1);
					}
				});
				all_kids.setViewportView(table_all_kids);
			
			all_novel = new JScrollPane();
			all_tab.addTab("소설", null, all_novel, null);
			
			BookTableModelChange modelCh2 = new BookTableModelChange(dao.shownovel(memdto.getId()));
			Object[][] data2 = modelCh2.listTypeChange();
			
			table_all_novel = new JTable(data2, colName);
			
			table_all_novel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table_all_novel.getSelectedRow();
				
					dealtype = (String) table_all_novel.getValueAt(index, 0);
					category = (String) table_all_novel.getValueAt(index, 1);
				    title = (String) table_all_novel.getValueAt(index, 2);
				    writer = (String) table_all_novel.getValueAt(index, 3);
				    publisher = (String) table_all_novel.getValueAt(index, 4);
				    price = (int) table_all_novel.getValueAt(index, 5);
				    			    
				    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
				
				    SellwordGUI word = new SellwordGUI(bookdto1);
				}
			});
			all_novel.setViewportView(table_all_novel);
			
			JScrollPane all_better = new JScrollPane();
			all_tab.addTab("자기계발", null, all_better, null);
			
			BookTableModelChange modelCh3 = new BookTableModelChange(dao.showbetterthanyesterday(memdto.getId()));
			Object[][] data3 = modelCh2.listTypeChange();
			
			table_all_better = new JTable(data3, colName);
			
			table_all_better.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = table_all_better.getSelectedRow();
				
					dealtype = (String) table_all_better.getValueAt(index, 0);
					category = (String) table_all_better.getValueAt(index, 1);
				    title = (String) table_all_better.getValueAt(index, 2);
				    writer = (String) table_all_better.getValueAt(index, 3);
				    publisher = (String) table_all_better.getValueAt(index, 4);
				    price = (int) table_all_better.getValueAt(index, 5);
				    			    
				    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
				
				    SellwordGUI word = new SellwordGUI(bookdto1);
				}
			});
			
			all_better.setViewportView(table_all_better);
			
		
			all_munjejip = new JScrollPane();
			all_tab.addTab("문제집", null, all_munjejip, null);
				
				BookTableModelChange modelCh4 = new BookTableModelChange(dao.showmunjezip(memdto.getId()));
				Object[][] data4 = modelCh3.listTypeChange();
		
				table_all_munjejip = new JTable(data4, colName);
				
				table_all_munjejip.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table_all_munjejip.getSelectedRow();
					
						dealtype = (String) table_all_munjejip.getValueAt(index, 0);
						category = (String) table_all_munjejip.getValueAt(index, 1);
					    title = (String) table_all_munjejip.getValueAt(index, 2);
					    writer = (String) table_all_munjejip.getValueAt(index, 3);
					    publisher = (String) table_all_munjejip.getValueAt(index, 4);
					    price = (int) table_all_munjejip.getValueAt(index, 5);
					    			    
					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
					
					    SellwordGUI word = new SellwordGUI(bookdto1);
					}
				});
				
				all_munjejip.setViewportView(table_all_munjejip);
				
				JScrollPane all_magazine = new JScrollPane();
				all_tab.addTab("잡지", null, all_magazine, null);
				
				BookTableModelChange modelCh5 = new BookTableModelChange(dao.showmagazine(memdto.getId()));
				Object[][] data5 = modelCh2.listTypeChange();
				
				table_all_magazine = new JTable(data5, colName);
				table_all_magazine.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table_all_magazine.getSelectedRow();
					
						dealtype = (String) table_all_magazine.getValueAt(index, 0);
						category = (String) table_all_magazine.getValueAt(index, 1);
					    title = (String) table_all_magazine.getValueAt(index, 2);
					    writer = (String) table_all_magazine.getValueAt(index, 3);
					    publisher = (String) table_all_magazine.getValueAt(index, 4);
					    price = (int) table_all_magazine.getValueAt(index, 5);
					    			    
					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
					
					    SellwordGUI word = new SellwordGUI(bookdto1);
					}
				});
				all_magazine.setViewportView(table_all_magazine);
				
				JScrollPane all_cartoon = new JScrollPane();
				all_tab.addTab("만화", null, all_cartoon, null);
				
				BookTableModelChange modelCh6 = new BookTableModelChange(dao.showcartoon(memdto.getId()));
				Object[][] data6 = modelCh2.listTypeChange();
				
				table_all_cartoon = new JTable(data6, colName);
				table_all_cartoon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table_all_cartoon.getSelectedRow();
					
						dealtype = (String) table_all_cartoon.getValueAt(index, 0);
						category = (String) table_all_cartoon.getValueAt(index, 1);
					    title = (String) table_all_cartoon.getValueAt(index, 2);
					    writer = (String) table_all_cartoon.getValueAt(index, 3);
					    publisher = (String) table_all_cartoon.getValueAt(index, 4);
					    price = (int) table_all_cartoon.getValueAt(index, 5);
					    			    
					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
					
					    SellwordGUI word = new SellwordGUI(bookdto1);
					}
				});
				all_cartoon.setViewportView(table_all_cartoon);
			
				
//		//////////////////////////////////////////////////////////////////////////////
//		
//				
//		scrollPane_sell = new JScrollPane();
//		tabbedPane.addTab("판매", null, scrollPane_sell, null);
//		scrollPane_sell.setViewportView(table_sell);
				
//		sell_tab = new JTabbedPane(JTabbedPane.TOP);
//		scrollPane_all.setViewportView(sell_tab);
//		
//		String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"}; // 전체 테이블 컬럼
//			sell_all = new JScrollPane();
//			sell_tab.addTab("전체", null, sell_all, null);
//			
//				BookTableModelChange modelCh = new BookTableModelChange(dao.showallbook(memdto.getId()));
//				Object[][] data = modelCh.listTypeChange();
//			
//				table_sell_all = new JTable(data, colName);
//				table_sell_all.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_all.getSelectedRow();
//					
//						dealtype = (String) table_all_all.getValueAt(index, 0);
//						category = (String) table_all_all.getValueAt(index, 1);
//					    title = (String) table_all_all.getValueAt(index, 2);
//					    writer = (String) table_all_all.getValueAt(index, 3);
//					    publisher = (String) table_all_all.getValueAt(index, 4);
//					    price = (int) table_all_all.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				sell_all.setViewportView(table_sell_all);
//			
//
//			sell_kids = new JScrollPane();
//			sell_tab.addTab("아동", null, sell_kids, null);
//				
//				BookTableModelChange modelCh1 = new BookTableModelChange(dao.showkidsbook(memdto.getId()));
//				Object[][] data1 = modelCh1.listTypeChange();
//				
//				table_all_kids = new JTable(data1, colName);
//				table_all_kids.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_kids.getSelectedRow();
//					
//						dealtype = (String) table_all_kids.getValueAt(index, 0);
//						category = (String) table_all_kids.getValueAt(index, 1);
//					    title = (String) table_all_kids.getValueAt(index, 2);
//					    writer = (String) table_all_kids.getValueAt(index, 3);
//					    publisher = (String) table_all_kids.getValueAt(index, 4);
//					    price = (int) table_all_kids.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				sell_kids.setViewportView(table_all_kids);
//			
//			sell_novel = new JScrollPane();
//			sell_tab.addTab("소설", null, sell_novel, null);
//			
//			BookTableModelChange modelCh2 = new BookTableModelChange(dao.shownovel(memdto.getId()));
//			Object[][] data2 = modelCh2.listTypeChange();
//			
//			table_all_novel = new JTable(data2, colName);
//			
//			table_all_novel.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					int index = table_all_novel.getSelectedRow();
//				
//					dealtype = (String) table_all_novel.getValueAt(index, 0);
//					category = (String) table_all_novel.getValueAt(index, 1);
//				    title = (String) table_all_novel.getValueAt(index, 2);
//				    writer = (String) table_all_novel.getValueAt(index, 3);
//				    publisher = (String) table_all_novel.getValueAt(index, 4);
//				    price = (int) table_all_novel.getValueAt(index, 5);
//				    			    
//				    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//				
//				    SellwordGUI word = new SellwordGUI(bookdto1);
//				}
//			});
//			sell_novel.setViewportView(table_all_novel);
//			
//			JScrollPane all_better;
//			sell_better = new JScrollPane();
//			sell_tab.addTab("자기계발", null, sell_better, null);
//			
//			BookTableModelChange modelCh3 = new BookTableModelChange(dao.showbetterthanyesterday(memdto.getId()));
//			Object[][] data3 = modelCh2.listTypeChange();
//			
//			table_all_better = new JTable(data3, colName);
//			
//			table_all_better.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					int index = table_all_better.getSelectedRow();
//				
//					dealtype = (String) table_all_better.getValueAt(index, 0);
//					category = (String) table_all_better.getValueAt(index, 1);
//				    title = (String) table_all_better.getValueAt(index, 2);
//				    writer = (String) table_all_better.getValueAt(index, 3);
//				    publisher = (String) table_all_better.getValueAt(index, 4);
//				    price = (int) table_all_better.getValueAt(index, 5);
//				    			    
//				    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//				
//				    SellwordGUI word = new SellwordGUI(bookdto1);
//				}
//			});
//			
//			sell_better.setViewportView(table_all_better);
//			
//		
//			sell_munjejip = new JScrollPane();
//			sell_tab.addTab("문제집", null, sell_munjejip, null);
//				
//				BookTableModelChange modelCh4 = new BookTableModelChange(dao.showmunjezip(memdto.getId()));
//				Object[][] data4 = modelCh3.listTypeChange();
//		
//				table_all_munjejip = new JTable(data4, colName);
//				
//				table_all_munjejip.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_munjejip.getSelectedRow();
//					
//						dealtype = (String) table_all_munjejip.getValueAt(index, 0);
//						category = (String) table_all_munjejip.getValueAt(index, 1);
//					    title = (String) table_all_munjejip.getValueAt(index, 2);
//					    writer = (String) table_all_munjejip.getValueAt(index, 3);
//					    publisher = (String) table_all_munjejip.getValueAt(index, 4);
//					    price = (int) table_all_munjejip.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				
//				sell_munjejip.setViewportView(table_all_munjejip);
//				
//				JScrollPane all_magazine;
//				sell_magazine = new JScrollPane();
//				sell_tab.addTab("잡지", null, sell_magazine, null);
//				
//				BookTableModelChange modelCh5 = new BookTableModelChange(dao.showmagazine(memdto.getId()));
//				Object[][] data5 = modelCh2.listTypeChange();
//				
//				table_all_magazine = new JTable(data5, colName);
//				table_all_magazine.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_magazine.getSelectedRow();
//					
//						dealtype = (String) table_all_magazine.getValueAt(index, 0);
//						category = (String) table_all_magazine.getValueAt(index, 1);
//					    title = (String) table_all_magazine.getValueAt(index, 2);
//					    writer = (String) table_all_magazine.getValueAt(index, 3);
//					    publisher = (String) table_all_magazine.getValueAt(index, 4);
//					    price = (int) table_all_magazine.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				sell_magazine.setViewportView(table_all_magazine);
//				
//				JScrollPane all_cartoon;
//				sell_cartoon = new JScrollPane();
//				sell_tab.addTab("만화", null, sell_cartoon, null);
//				
//				BookTableModelChange modelCh6 = new BookTableModelChange(dao.showcartoon(memdto.getId()));
//				Object[][] data6 = modelCh2.listTypeChange();
//				
//				table_all_cartoon = new JTable(data6, colName);
//				table_all_cartoon.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_cartoon.getSelectedRow();
//					
//						dealtype = (String) table_all_cartoon.getValueAt(index, 0);
//						category = (String) table_all_cartoon.getValueAt(index, 1);
//					    title = (String) table_all_cartoon.getValueAt(index, 2);
//					    writer = (String) table_all_cartoon.getValueAt(index, 3);
//					    publisher = (String) table_all_cartoon.getValueAt(index, 4);
//					    price = (int) table_all_cartoon.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				sell_cartoon.setViewportView(table_all_cartoon);
//		
//		////////////////////////////////////////////////////////////////////////////////
//		
//				
//				
//				
//				
//				
//				scrollPane_trade = new JScrollPane();
//		tabbedPane.addTab("교환", null, scrollPane_trade, null);
//		scrollPane_trade.setViewportView(table_trade);
//		trade_tab = new JTabbedPane(JTabbedPane.TOP);
//		scrollPane_all.setViewportView(trade_tab);
//		
//		String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"}; // 전체 테이블 컬럼
//			trade_all = new JScrollPane();
//			trade_tab.addTab("전체", null, trade_all, null);
//			
//				BookTableModelChange modelCh = new BookTableModelChange(dao.showallbook(memdto.getId()));
//				Object[][] data = modelCh.listTypeChange();
//			
//				table_all_all = new JTable(data, colName);
//				table_all_all.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_all.getSelectedRow();
//					
//						dealtype = (String) table_all_all.getValueAt(index, 0);
//						category = (String) table_all_all.getValueAt(index, 1);
//					    title = (String) table_all_all.getValueAt(index, 2);
//					    writer = (String) table_all_all.getValueAt(index, 3);
//					    publisher = (String) table_all_all.getValueAt(index, 4);
//					    price = (int) table_all_all.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				trade_all.setViewportView(table_all_all);
//			
//
//			trade_kids = new JScrollPane();
//			trade_tab.addTab("아동", null, trade_kids, null);
//				
//				BookTableModelChange modelCh1 = new BookTableModelChange(dao.showkidsbook(memdto.getId()));
//				Object[][] data1 = modelCh1.listTypeChange();
//				
//				table_all_kids = new JTable(data1, colName);
//				table_all_kids.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_kids.getSelectedRow();
//					
//						dealtype = (String) table_all_kids.getValueAt(index, 0);
//						category = (String) table_all_kids.getValueAt(index, 1);
//					    title = (String) table_all_kids.getValueAt(index, 2);
//					    writer = (String) table_all_kids.getValueAt(index, 3);
//					    publisher = (String) table_all_kids.getValueAt(index, 4);
//					    price = (int) table_all_kids.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				trade_kids.setViewportView(table_all_kids);
//			
//			trade_novel = new JScrollPane();
//			trade_tab.addTab("소설", null, trade_novel, null);
//			
//			BookTableModelChange modelCh2 = new BookTableModelChange(dao.shownovel(memdto.getId()));
//			Object[][] data2 = modelCh2.listTypeChange();
//			
//			table_all_novel = new JTable(data2, colName);
//			
//			table_all_novel.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					int index = table_all_novel.getSelectedRow();
//				
//					dealtype = (String) table_all_novel.getValueAt(index, 0);
//					category = (String) table_all_novel.getValueAt(index, 1);
//				    title = (String) table_all_novel.getValueAt(index, 2);
//				    writer = (String) table_all_novel.getValueAt(index, 3);
//				    publisher = (String) table_all_novel.getValueAt(index, 4);
//				    price = (int) table_all_novel.getValueAt(index, 5);
//				    			    
//				    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//				
//				    SellwordGUI word = new SellwordGUI(bookdto1);
//				}
//			});
//			trade_novel.setViewportView(table_all_novel);
//			
//			JScrollPane all_better;
//			trade_better = new JScrollPane();
//			trade_tab.addTab("자기계발", null, trade_better, null);
//			
//			BookTableModelChange modelCh3 = new BookTableModelChange(dao.showbetterthanyesterday(memdto.getId()));
//			Object[][] data3 = modelCh2.listTypeChange();
//			
//			table_all_better = new JTable(data3, colName);
//			
//			table_all_better.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					int index = table_all_better.getSelectedRow();
//				
//					dealtype = (String) table_all_better.getValueAt(index, 0);
//					category = (String) table_all_better.getValueAt(index, 1);
//				    title = (String) table_all_better.getValueAt(index, 2);
//				    writer = (String) table_all_better.getValueAt(index, 3);
//				    publisher = (String) table_all_better.getValueAt(index, 4);
//				    price = (int) table_all_better.getValueAt(index, 5);
//				    			    
//				    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//				
//				    SellwordGUI word = new SellwordGUI(bookdto1);
//				}
//			});
//			
//			trade_better.setViewportView(table_all_better);
//			
//		
//			trade_munjejip = new JScrollPane();
//			trade_tab.addTab("문제집", null, trade_munjejip, null);
//				
//				BookTableModelChange modelCh4 = new BookTableModelChange(dao.showmunjezip(memdto.getId()));
//				Object[][] data4 = modelCh3.listTypeChange();
//		
//				table_all_munjejip = new JTable(data4, colName);
//				
//				table_all_munjejip.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_munjejip.getSelectedRow();
//					
//						dealtype = (String) table_all_munjejip.getValueAt(index, 0);
//						category = (String) table_all_munjejip.getValueAt(index, 1);
//					    title = (String) table_all_munjejip.getValueAt(index, 2);
//					    writer = (String) table_all_munjejip.getValueAt(index, 3);
//					    publisher = (String) table_all_munjejip.getValueAt(index, 4);
//					    price = (int) table_all_munjejip.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				
//				trade_munjejip.setViewportView(table_all_munjejip);
//				
//				JScrollPane all_magazine;
//				trade_magazine = new JScrollPane();
//				trade_tab.addTab("잡지", null, trade_magazine, null);
//				
//				BookTableModelChange modelCh5 = new BookTableModelChange(dao.showmagazine(memdto.getId()));
//				Object[][] data5 = modelCh2.listTypeChange();
//				
//				table_all_magazine = new JTable(data5, colName);
//				table_all_magazine.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_magazine.getSelectedRow();
//					
//						dealtype = (String) table_all_magazine.getValueAt(index, 0);
//						category = (String) table_all_magazine.getValueAt(index, 1);
//					    title = (String) table_all_magazine.getValueAt(index, 2);
//					    writer = (String) table_all_magazine.getValueAt(index, 3);
//					    publisher = (String) table_all_magazine.getValueAt(index, 4);
//					    price = (int) table_all_magazine.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				trade_magazine.setViewportView(table_all_magazine);
//				
//				JScrollPane all_cartoon;
//				trade_cartoon = new JScrollPane();
//				trade_tab.addTab("만화", null, trade_cartoon, null);
//				
//				BookTableModelChange modelCh6 = new BookTableModelChange(dao.showcartoon(memdto.getId()));
//				Object[][] data6 = modelCh2.listTypeChange();
//				
//				table_all_cartoon = new JTable(data6, colName);
//				table_all_cartoon.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int index = table_all_cartoon.getSelectedRow();
//					
//						dealtype = (String) table_all_cartoon.getValueAt(index, 0);
//						category = (String) table_all_cartoon.getValueAt(index, 1);
//					    title = (String) table_all_cartoon.getValueAt(index, 2);
//					    writer = (String) table_all_cartoon.getValueAt(index, 3);
//					    publisher = (String) table_all_cartoon.getValueAt(index, 4);
//					    price = (int) table_all_cartoon.getValueAt(index, 5);
//					    			    
//					    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
//					
//					    SellwordGUI word = new SellwordGUI(bookdto1);
//					}
//				});
//				trade_cartoon.setViewportView(table_all_cartoon);

		

	}
}


