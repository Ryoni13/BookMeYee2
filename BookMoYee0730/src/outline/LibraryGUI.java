package outline;

import java.awt.EventQueue;
import java.awt.print.Book;
import java.util.ArrayList;

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

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class LibraryGUI {

	private JFrame frame;
	private JTable table;
	private BookDAO dao = new BookDAO();
	private JTable table_1;
	
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
	public LibraryGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB0B4 \uC11C\uC7AC");
		lblNewLabel.setBounds(339, 44, 56, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("책 모이");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				bookMainGUI lbgui1 = new bookMainGUI();
			}
		});
		btnNewButton.setBounds(12, 10, 50, 50);
		frame.getContentPane().add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 76, 710, 375);
		frame.getContentPane().add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("청소년", null, scrollPane_1, null);
		
		table_1 = new JTable();
		table_1.setBackground(Color.WHITE);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				String f = (String) model.getValueAt(index, 0);
				LibraryGUI_1  lbGUI= new LibraryGUI_1();
			}
		});
		scrollPane_1.setColumnHeaderView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("소설", null, scrollPane_2, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("문제집", null, scrollPane_3, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_4, null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_5, null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_6, null);
		
		JButton btnNewButton_1 = new JButton("정보수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mypageGUI lbgui1 = new mypageGUI();
			}
		});
		btnNewButton_1.setBounds(625, 10, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton button = new JButton("추가");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LibraryGUI_2 lbgui2 = new LibraryGUI_2();
			}
		});
		button.setBounds(625, 44, 97, 23);
		frame.getContentPane().add(button);
		
		
			
		
	}
}
