package view;

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
		frame.setBounds(100, 100, 486, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB0B4 \uC11C\uC7AC");
		lblNewLabel.setBounds(207, 36, 57, 15);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(23, 71, 420, 515);
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
		
		btn_library_new.addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BookInsertGUI bookInsert = new BookInsertGUI(dto);
			}
		});//
		btn_library_new.setBounds(362, 42, 76, 23);
		frame.getContentPane().add(btn_library_new);
		
		JButton btn_write = new JButton("\uAE00 \uB4F1\uB85D");
		btn_write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				BookDTO bookdto = new BookDTO(titleNumber, title, writer, publisher, price, category, dealtype, id);
				WriteGUI write = new WriteGUI(bookdto);
			}
		});
		btn_write.setBounds(192, 613, 97, 23);
		frame.getContentPane().add(btn_write);
		
		JButton btnNewButton = new JButton("\uB0B4 \uC815\uBCF4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MypageGUI myp = new MypageGUI(dto);
			}
		});
		btnNewButton.setBounds(346, 13, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI(dto);
			}
		});
		btnNewButton_1.setBounds(38, 32, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
