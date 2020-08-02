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
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uAC80\uC0C9 \uACB0\uACFC");
      lblNewLabel.setBounds(178, 10, 57, 15);
      frame.getContentPane().add(lblNewLabel);
      
      JPanel panel = new JPanel();
      panel.setBounds(12, 42, 410, 209);
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
   }
}
