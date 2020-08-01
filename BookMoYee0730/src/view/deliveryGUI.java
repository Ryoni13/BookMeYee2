package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


import Controller.BookTableModelChange1;

import model.BookDAO;
import model.BookDTO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deliveryGUI {
	private BookDAO dao = new BookDAO();
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTable table;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JScrollPane scrollPane_2;
	private JPanel panel_3;
	private JScrollPane scrollPane_3;
	private JPanel panel_4;
	private JScrollPane scrollPane_4;
	private JButton btnNewButton;
	private JTable table_1;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					deleveryGUI window = new deleveryGUI();
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
	public deliveryGUI(BookDTO bookdto) {
		initialize(bookdto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BookDTO bookdto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(tabbedPane);
		
		BookDAO dao = new BookDAO();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("대기목록", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 429, 432);
		panel_2.add(scrollPane);
		
		String[] colName = {"제목","작가","출판사","카테고리"};
		BookTableModelChange1 modelCh =new BookTableModelChange1(dao.showdelivery(bookdto.getId()));
		Object[][] data = modelCh.listTypeChange1();
		
		table = new JTable(data,colName);
		scrollPane.setViewportView(table);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);	
		tabbedPane.addTab("배달내역", null, panel_3, null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 429, 432);
		panel_3.add(scrollPane_3);
		
		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("기타", null, panel_4, null);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 429, 432);
		panel_4.add(scrollPane_4);
		
		table_2 = new JTable();
		scrollPane_4.setViewportView(table_2);
		
		btnNewButton = new JButton("닫기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(168, 273, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		

		
	}

}
