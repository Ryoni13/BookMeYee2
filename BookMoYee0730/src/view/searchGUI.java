package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.BookTableModelChange;
import model.BookDAO;
import model.BookDTO;
import model.MemberDTO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchGUI {
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
   /*public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               searchGUI window = new searchGUI();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }*/

   /**
    * Create the application.
    */
   public searchGUI(MemberDTO dto, String searchText) {
      initialize(dto,searchText);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(MemberDTO dto, String searchText) {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(173, 216, 230));
      frame.setBounds(100, 100, 450, 313);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uAC80\uC0C9 \uACB0\uACFC");
      lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 14));
      lblNewLabel.setBounds(177, 10, 93, 15);
      frame.getContentPane().add(lblNewLabel);
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(173, 216, 230));
      panel.setBounds(12, 42, 410, 197);
      frame.getContentPane().add(panel);
      panel.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(12, 10, 386, 189);
      panel.add(scrollPane);
      String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"};
      BookTableModelChange modelCh = new BookTableModelChange(dao.showsearch(searchText));
      Object[][] data = modelCh.listTypeChange();
       

      JTable table = new JTable(data, colName);
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int index = table.getSelectedRow();
            javax.swing.table.TableModel model = table.getModel();
            String dealtype = (String) table.getValueAt(index, 0);
            String category = (String) table.getValueAt(index, 1);
             String title = (String) table.getValueAt(index, 2);
             String writer = (String) table.getValueAt(index, 3);
             String publisher = (String) table.getValueAt(index, 4);
             int price = (int) table.getValueAt(index, 5);
             BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                  
                SellwordGUI word = new SellwordGUI(bookdto1);
         }
      });
      scrollPane.setViewportView(table);   
      
      JButton btnNewButton = new JButton("\uB2EB\uAE30");
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		frame.dispose();
      	}
      });
      btnNewButton.setBackground(new Color(102, 153, 204));
      btnNewButton.setBounds(167, 249, 97, 23);
      frame.getContentPane().add(btnNewButton);
   }
}
