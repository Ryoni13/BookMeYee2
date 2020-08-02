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

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;


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
   private JTabbedPane tabbedPane_all_tab;
   private JTabbedPane trade_tab;
   private JTabbedPane sell_tab;
   private JScrollPane all_all;
   private JScrollPane trade_all;
   private JScrollPane sell_all;
   private JScrollPane all_kids;
   private JScrollPane trade_kids;
   private JScrollPane sell_kids;
   private JScrollPane all_munjezip;
   private JScrollPane trade_munjezip;
   private JScrollPane sell_munjezip;
   private JTable table_all_all;
   private JTable table_sell_all;
   private JTable table_all_kids;
   private JTable table_all_munjezip;
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
   private JTable table_sell_kids;
   private JTable table_sell_novel;
   private JTable table_sell_better;
   private JTable table_sell_munjiezip;
   private JTable table_sell_magazine;
   private JTable table_sell_cartoon;
   private JTabbedPane tabbedPane_trade_tab;
   private JScrollPane scrollPane_trade_all;
   private JTable table_trade_all;
   private JScrollPane scrollPane_trade_kids;
   private JTable table_trade_kids;
   private JScrollPane scrollPane_trade_novel;
   private JTable table_trade_novel;
   private JScrollPane scrollPane_trade_better;
   private JTable table_trade_better;
   private JScrollPane scrollPane_trade_munjiezip;
   private JTable table_trade_munjiezip;
   private JScrollPane scrollPane_trade_magazine;
   private JTable table_trade_magazine;
   private JScrollPane scrollPane_trade_cartoon;
   private JTable table_trade_cartoon;
  
   

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               main_2 window = new main_2();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

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
      frame.getContentPane().setBackground(new Color(173, 216, 230));
      frame.setBounds(100, 100, 750, 530);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JButton btn_main_library = new JButton("");
      btn_main_library.setBackground(new Color(173, 216, 230));
      btn_main_library.setIcon(new ImageIcon(MainGUI.class.getResource("/icon/mypageicon.png")));
      btn_main_library.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            LibraryGUI libray = new LibraryGUI(memdto);
         }
      });
      btn_main_library.setBounds(653, 10, 69, 47);
      frame.getContentPane().add(btn_main_library);
      
      textField_search = new JTextField();
      textField_search.setBounds(197, 71, 281, 28);
      frame.getContentPane().add(textField_search);
      textField_search.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("\uAC80\uC0C9");
      lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 17));
      lblNewLabel.setBounds(145, 69, 40, 25);
      frame.getContentPane().add(lblNewLabel);
      
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(12, 140, 655, 384);
      tabbedPane.setBackground(new Color(175, 238, 238));
      tabbedPane.setBounds(25, 114, 685, 355);
      frame.getContentPane().add(tabbedPane);
      
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      scrollPane_all = new JScrollPane();//전체탭전체
      tabbedPane.addTab("전체", null, scrollPane_all, null);
      tabbedPane.setBackgroundAt(0, new Color(175, 238, 238));
      scrollPane_all.setViewportView(table_all);
      
      tabbedPane_all_tab = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane_all_tab.setBackground(new Color(175, 238, 238));
      scrollPane_all.setViewportView(tabbedPane_all_tab);
      
      String[] colName = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"}; // 전체 테이블 컬럼
      
            BookTableModelChange modelCh = new BookTableModelChange(dao.showallbook(memdto.getId()));
            Object[][] data = modelCh.listTypeChange();
         all_all = new JScrollPane();
         tabbedPane_all_tab.addTab("전체", null, all_all, null);
         tabbedPane_all_tab.setBackgroundAt(0, new Color(224, 255, 255));
         
            table_all_all = new JTable(data, colName);
            table_all_all.setBackground(Color.WHITE);
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
            
         

         all_kids = new JScrollPane();//전체탭아동
         tabbedPane_all_tab.addTab("아동", null, all_kids, null);
         tabbedPane_all_tab.setBackgroundAt(1, new Color(224, 255, 255));
            
            BookTableModelChange modelCh1 = new BookTableModelChange(dao.kidsAllbook(memdto.getId()));
            Object[][] data1 = modelCh1.listTypeChange();
            
            table_all_kids = new JTable(data1, colName);
            table_all_kids.setBackground(Color.WHITE);
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
            
         
         all_novel = new JScrollPane();//전체탭소설
         tabbedPane_all_tab.addTab("소설", null, all_novel, null);
         tabbedPane_all_tab.setBackgroundAt(2, new Color(224, 255, 255));
         
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
         
         
         
         JScrollPane all_better = new JScrollPane();//전체탭자기계발서
         tabbedPane_all_tab.addTab("자기계발", null, all_better, null);
         tabbedPane_all_tab.setBackgroundAt(3, new Color(224, 255, 255));
         
         BookTableModelChange modelCh3 = new BookTableModelChange(dao.showbetterthanyesterday(memdto.getId()));
         Object[][] data3 = modelCh3.listTypeChange();
         
         table_all_better = new JTable(data3, colName);
         table_all_better.setBackground(Color.WHITE);
         
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
         
         
         
      
         all_munjezip = new JScrollPane();//전체탭문제집
         tabbedPane_all_tab.addTab("문제집", null, all_munjezip, null);
         tabbedPane_all_tab.setBackgroundAt(4, new Color(224, 255, 255));
            
            BookTableModelChange modelCh4 = new BookTableModelChange(dao.showmunjezip(memdto.getId()));
            Object[][] data4 = modelCh4.listTypeChange();
      
            table_all_munjezip = new JTable(data4, colName);
            
            table_all_munjezip.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_all_munjezip.getSelectedRow();
               
                  dealtype = (String) table_all_munjezip.getValueAt(index, 0);
                  category = (String) table_all_munjezip.getValueAt(index, 1);
                   title = (String) table_all_munjezip.getValueAt(index, 2);
                   writer = (String) table_all_munjezip.getValueAt(index, 3);
                   publisher = (String) table_all_munjezip.getValueAt(index, 4);
                   price = (int) table_all_munjezip.getValueAt(index, 5);
                                
                   BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
               
                   SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            
            all_munjezip.setViewportView(table_all_munjezip);
            
            
            
            JScrollPane all_magazine = new JScrollPane();//전체탭잡지
            tabbedPane_all_tab.addTab("잡지", null, all_magazine, null);
            tabbedPane_all_tab.setBackgroundAt(5, new Color(224, 255, 255));
            
            BookTableModelChange modelCh5 = new BookTableModelChange(dao.showmagazine(memdto.getId()));
            Object[][] data5 = modelCh5.listTypeChange();
            
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
            
            
            
            JScrollPane all_cartoon = new JScrollPane();//전체탭만화
            tabbedPane_all_tab.addTab("만화", null, all_cartoon, null);
            tabbedPane_all_tab.setBackgroundAt(6, new Color(224, 255, 255));
            
            BookTableModelChange modelCh6 = new BookTableModelChange(dao.showcartoon(memdto.getId()));
            Object[][] data6 = modelCh6.listTypeChange();
            
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
            ////////////////////////////////////상단판매탭///////////////////////////////////////////////////////
            
//            String[] colName1 = {"거래방식", "카테고리", "책 제목" ,"저자", "출판사", "가격"}; // 전체 테이블 컬럼

            JTabbedPane tabbedPane_sell_tab = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.addTab("판매", null, tabbedPane_sell_tab, null);
            tabbedPane.setBackgroundAt(1, new Color(175, 238, 238));
            
            JScrollPane scrollPane_sell_all = new JScrollPane();
            tabbedPane_sell_tab.addTab("전체", null, scrollPane_sell_all, null);
            tabbedPane_sell_tab.setBackgroundAt(0, new Color(175, 238, 238));
            
            BookTableModelChange modelCh7 = new BookTableModelChange(dao.sellAllbook(memdto.getId()));
            Object[][] data7 = modelCh7.listTypeChange();//판매탭전체
            
            table_sell_all = new JTable(data7, colName);
            table_sell_all.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    int index = table_sell_all.getSelectedRow();
                    
                    dealtype = (String) table_sell_all.getValueAt(index, 0);
                    category = (String) table_sell_all.getValueAt(index, 1);
                    title = (String) table_sell_all.getValueAt(index, 2);
                    writer = (String) table_sell_all.getValueAt(index, 3);
                    publisher = (String) table_sell_all.getValueAt(index, 4);
                    price = (int) table_sell_all.getValueAt(index, 5);
                       
                     ////상세페이지이동//
                     BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                     SellwordGUI word = new SellwordGUI(bookdto1);
                 }
              });
            scrollPane_sell_all.setViewportView(table_sell_all);
            
          
             
            
            
            JScrollPane scrollPane_sell_kids = new JScrollPane();//판매탭아동
            tabbedPane_sell_tab.addTab("아동", null, scrollPane_sell_kids, null);
            tabbedPane_sell_tab.setBackgroundAt(1, new Color(175, 238, 238));
            
            BookTableModelChange modelCh8 = new BookTableModelChange(dao.sellkidsbook(memdto.getId()));
            Object[][] data8 = modelCh8.listTypeChange();
            
            table_sell_kids = new JTable(data8, colName);
            table_sell_kids.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  
                  int index = table_sell_kids.getSelectedRow();
                    
                    dealtype = (String) table_sell_kids.getValueAt(index, 0);
                    category = (String) table_sell_kids.getValueAt(index, 1);
                    title = (String) table_sell_kids.getValueAt(index, 2);
                    writer = (String) table_sell_kids.getValueAt(index, 3);
                    publisher = (String) table_sell_kids.getValueAt(index, 4);
                    price = (int) table_sell_kids.getValueAt(index, 5);
                                  
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_sell_kids.setViewportView(table_sell_kids);
            
            
            
            
            
            
            JScrollPane scrollPane_sell_novel = new JScrollPane();//판매탭소설
            tabbedPane_sell_tab.addTab("소설", null, scrollPane_sell_novel, null);
            tabbedPane_sell_tab.setBackgroundAt(2, new Color(175, 238, 238));
            
            BookTableModelChange modelCh9 = new BookTableModelChange(dao.sellnovel(memdto.getId()));
            Object[][] data9 = modelCh9.listTypeChange();
            
           
            table_sell_novel =new JTable(data9,colName);
            table_sell_novel.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_sell_novel.getSelectedRow();
                    
                    dealtype = (String) table_sell_novel.getValueAt(index, 0);
                    category = (String) table_sell_novel.getValueAt(index, 1);
                    title = (String) table_sell_novel.getValueAt(index, 2);
                    writer = (String) table_sell_novel.getValueAt(index, 3);
                    publisher = (String) table_sell_novel.getValueAt(index, 4);
                    price = (int) table_sell_novel.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_sell_novel.setViewportView(table_sell_novel);
            
            
            
            
            
            
            JScrollPane scrollPane_sell_better = new JScrollPane();//판매탭자기계발서
            tabbedPane_sell_tab.addTab("자기계발서", null, scrollPane_sell_better, null);
            tabbedPane_sell_tab.setBackgroundAt(3, new Color(175, 238, 238));
            
            BookTableModelChange modelCh10 = new BookTableModelChange(dao.sellbetterthanyesterday(memdto.getId()));
            Object[][] data10 = modelCh10.listTypeChange();
            
            table_sell_better = new JTable(data10, colName);
            table_sell_better.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_sell_better.getSelectedRow();
                    
                    dealtype = (String) table_sell_better.getValueAt(index, 0);
                    category = (String) table_sell_better.getValueAt(index, 1);
                    title = (String) table_sell_better.getValueAt(index, 2);
                    writer = (String) table_sell_better.getValueAt(index, 3);
                    publisher = (String) table_sell_better.getValueAt(index, 4);
                    price = (int) table_sell_better.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
                  
               }
            });
            scrollPane_sell_better.setViewportView(table_sell_better);
            
            
            
            
            
            JScrollPane scrollPane_sell_munjiezip = new JScrollPane();//판매탭문제집
            tabbedPane_sell_tab.addTab("문제집", null, scrollPane_sell_munjiezip, null);
            tabbedPane_sell_tab.setBackgroundAt(4, new Color(175, 238, 238));
            
            BookTableModelChange modelCh11 = new BookTableModelChange(dao.sellmunjezip(memdto.getId()));
            Object[][] data11 = modelCh11.listTypeChange();
            
            
            table_sell_munjiezip = new JTable(data11,colName);
            table_sell_munjiezip.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_sell_munjiezip.getSelectedRow();
                    
                    dealtype = (String) table_sell_munjiezip.getValueAt(index, 0);
                    category = (String) table_sell_munjiezip.getValueAt(index, 1);
                    title = (String) table_sell_munjiezip.getValueAt(index, 2);
                    writer = (String) table_sell_munjiezip.getValueAt(index, 3);
                    publisher = (String) table_sell_munjiezip.getValueAt(index, 4);
                    price = (int) table_sell_munjiezip.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_sell_munjiezip.setViewportView(table_sell_munjiezip);
            
            
            
            
            JScrollPane scrollPane_sell_magazine = new JScrollPane();//판매탭잡지
            tabbedPane_sell_tab.addTab("잡지", null, scrollPane_sell_magazine, null);
            tabbedPane_sell_tab.setBackgroundAt(5, new Color(175, 238, 238));
            BookTableModelChange modelCh12 = new BookTableModelChange(dao.sellmagazine(memdto.getId()));
            Object[][] data12 = modelCh12.listTypeChange();
            
            table_sell_magazine = new JTable(data12,colName);
            table_sell_magazine.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_sell_magazine.getSelectedRow();
                    dealtype = (String) table_sell_magazine.getValueAt(index, 0);
                    category = (String) table_sell_magazine.getValueAt(index, 1);
                    title = (String) table_sell_magazine.getValueAt(index, 2);
                    writer = (String) table_sell_magazine.getValueAt(index, 3);
                    publisher = (String) table_sell_magazine.getValueAt(index, 4);
                    price = (int) table_sell_magazine.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_sell_magazine.setViewportView(table_sell_magazine);
            
            
            
            
            JScrollPane scrollPane_sell_cartoon = new JScrollPane();//판매탭만화
            tabbedPane_sell_tab.addTab("만화", null, scrollPane_sell_cartoon, null);
            tabbedPane_sell_tab.setBackgroundAt(6, new Color(175, 238, 238));
            BookTableModelChange modelCh13 = new BookTableModelChange(dao.sellcartoon(memdto.getId()));
            Object[][] data13 = modelCh13.listTypeChange();
            
            table_sell_cartoon = new JTable(data13,colName);
            table_sell_cartoon.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_sell_cartoon.getSelectedRow();
                    dealtype = (String) table_sell_cartoon.getValueAt(index, 0);
                    category = (String) table_sell_cartoon.getValueAt(index, 1);
                    title = (String) table_sell_cartoon.getValueAt(index, 2);
                    writer = (String) table_sell_cartoon.getValueAt(index, 3);
                    publisher = (String) table_sell_cartoon.getValueAt(index, 4);
                    price = (int) table_sell_cartoon.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_sell_cartoon.setViewportView(table_sell_cartoon);
            
            tabbedPane_trade_tab = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.addTab("교환", null, tabbedPane_trade_tab, null);
            tabbedPane.setBackgroundAt(2, new Color(175, 238, 238));
            
            scrollPane_trade_all = new JScrollPane();//교환탭전체
            tabbedPane_trade_tab.addTab("전체", null, scrollPane_trade_all, null);
            tabbedPane_trade_tab.setBackgroundAt(0, new Color(175, 238, 238));
            
            BookTableModelChange modelCh14 = new BookTableModelChange(dao.tradeAllbook(memdto.getId()));
            Object[][] data14 = modelCh14.listTypeChange();
            
            table_trade_all = new JTable(data14,colName);
            table_trade_all.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_all.getSelectedRow();
                    dealtype = (String) table_trade_all.getValueAt(index, 0);
                    category = (String) table_trade_all.getValueAt(index, 1);
                    title = (String) table_trade_all.getValueAt(index, 2);
                    writer = (String) table_trade_all.getValueAt(index, 3);
                    publisher = (String) table_trade_all.getValueAt(index, 4);
                    price = (int) table_trade_all.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
                    
               }
            });
            scrollPane_trade_all.setViewportView(table_trade_all);
            
            scrollPane_trade_kids = new JScrollPane();//교환탭아동
            tabbedPane_trade_tab.addTab("아동", null, scrollPane_trade_kids, null);
            tabbedPane_trade_tab.setBackgroundAt(1, new Color(175, 238, 238));
            BookTableModelChange modelCh15 = new BookTableModelChange(dao.tradekidsbook(memdto.getId()));
            Object[][] data15 = modelCh15.listTypeChange();
            
            table_trade_kids = new JTable(data15,colName);
            table_trade_kids.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_kids.getSelectedRow();
                    dealtype = (String) table_trade_kids.getValueAt(index, 0);
                    category = (String) table_trade_kids.getValueAt(index, 1);
                    title = (String) table_trade_kids.getValueAt(index, 2);
                    writer = (String) table_trade_kids.getValueAt(index, 3);
                    publisher = (String) table_trade_kids.getValueAt(index, 4);
                    price = (int) table_trade_kids.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
                  
               }
            });
            scrollPane_trade_kids.setViewportView(table_trade_kids);
            
            scrollPane_trade_novel = new JScrollPane();//교환탭소설
            tabbedPane_trade_tab.addTab("소설", null, scrollPane_trade_novel, null);
            tabbedPane_trade_tab.setBackgroundAt(2, new Color(175, 238, 238));
            BookTableModelChange modelCh16 = new BookTableModelChange(dao.tradenovel(memdto.getId()));
            Object[][] data16 = modelCh16.listTypeChange();
            
            table_trade_novel = new JTable(data16,colName);
            table_trade_novel.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_novel.getSelectedRow();
                    dealtype = (String) table_trade_novel.getValueAt(index, 0);
                    category = (String) table_trade_novel.getValueAt(index, 1);
                    title = (String) table_trade_novel.getValueAt(index, 2);
                    writer = (String) table_trade_novel.getValueAt(index, 3);
                    publisher = (String) table_trade_novel.getValueAt(index, 4);
                    price = (int) table_trade_novel.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
                  
               }
            });
            scrollPane_trade_novel.setViewportView(table_trade_novel);
            
            scrollPane_trade_better = new JScrollPane();//교환탭자기계발
            tabbedPane_trade_tab.addTab("자기계발", null, scrollPane_trade_better, null);
            tabbedPane_trade_tab.setBackgroundAt(3, new Color(175, 238, 238));
            BookTableModelChange modelCh17 = new BookTableModelChange(dao.tradebetterthanyesterday(memdto.getId()));
            Object[][] data17 = modelCh17.listTypeChange();
            
            table_trade_better = new JTable(data17,colName);
            table_trade_better.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_better.getSelectedRow();
                    dealtype = (String) table_trade_better.getValueAt(index, 0);
                    category = (String) table_trade_better.getValueAt(index, 1);
                    title = (String) table_trade_better.getValueAt(index, 2);
                    writer = (String) table_trade_better.getValueAt(index, 3);
                    publisher = (String) table_trade_better.getValueAt(index, 4);
                    price = (int) table_trade_better.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_trade_better.setViewportView(table_trade_better);
            
            scrollPane_trade_munjiezip = new JScrollPane();//교환탭문제집
            tabbedPane_trade_tab.addTab("문제집", null, scrollPane_trade_munjiezip, null);
            tabbedPane_trade_tab.setBackgroundAt(4, new Color(175, 238, 238));
            BookTableModelChange modelCh18 = new BookTableModelChange(dao.trademunjezip(memdto.getId()));
            Object[][] data18 = modelCh18.listTypeChange();
            
            table_trade_munjiezip = new JTable(data18,colName);
            table_trade_munjiezip.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_munjiezip.getSelectedRow();
                    dealtype = (String) table_trade_munjiezip.getValueAt(index, 0);
                    category = (String) table_trade_munjiezip.getValueAt(index, 1);
                    title = (String) table_trade_munjiezip.getValueAt(index, 2);
                    writer = (String) table_trade_munjiezip.getValueAt(index, 3);
                    publisher = (String) table_trade_munjiezip.getValueAt(index, 4);
                    price = (int) table_trade_munjiezip.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);
               }
            });
            scrollPane_trade_munjiezip.setViewportView(table_trade_munjiezip);
            
            scrollPane_trade_magazine = new JScrollPane();//교환탭잡지
            tabbedPane_trade_tab.addTab("잡지", null, scrollPane_trade_magazine, null);
            tabbedPane_trade_tab.setBackgroundAt(5, new Color(175, 238, 238));
            BookTableModelChange modelCh19 = new BookTableModelChange(dao.trademagazine(memdto.getId()));
            Object[][] data19 = modelCh19.listTypeChange();
            
            table_trade_magazine = new JTable(data19,colName);
            table_trade_magazine.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_magazine.getSelectedRow();
                    dealtype = (String) table_trade_magazine.getValueAt(index, 0);
                    category = (String) table_trade_magazine.getValueAt(index, 1);
                    title = (String) table_trade_magazine.getValueAt(index, 2);
                    writer = (String) table_trade_magazine.getValueAt(index, 3);
                    publisher = (String) table_trade_magazine.getValueAt(index, 4);
                    price = (int) table_trade_magazine.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);   
               }
            });
            scrollPane_trade_magazine.setViewportView(table_trade_magazine);
            
            scrollPane_trade_cartoon = new JScrollPane();//교환탭만화
            tabbedPane_trade_tab.addTab("만화", null, scrollPane_trade_cartoon, null);
            tabbedPane_trade_tab.setBackgroundAt(6, new Color(175, 238, 238));
            BookTableModelChange modelCh20 = new BookTableModelChange(dao.tradecartoon(memdto.getId()));
            Object[][] data20 = modelCh20.listTypeChange();
            
            table_trade_cartoon = new JTable(data20,colName);
            table_trade_cartoon.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  int index = table_trade_cartoon.getSelectedRow();
                    dealtype = (String) table_trade_cartoon.getValueAt(index, 0);
                    category = (String) table_trade_cartoon.getValueAt(index, 1);
                    title = (String) table_trade_cartoon.getValueAt(index, 2);
                    writer = (String) table_trade_cartoon.getValueAt(index, 3);
                    publisher = (String) table_trade_cartoon.getValueAt(index, 4);
                    price = (int) table_trade_cartoon.getValueAt(index, 5);
                    
                    BookDTO bookdto1 = new BookDTO(dealtype, category, title,  writer, publisher, price);
                    SellwordGUI word = new SellwordGUI(bookdto1);   
               }
            });
            scrollPane_trade_cartoon.setViewportView(table_trade_cartoon);
            
            
            
            
            
            
            
            
            
            
            
            JButton btnNewButton = new JButton("");
            btnNewButton.setBackground(new Color(173, 216, 230));
            btnNewButton.setIcon(new ImageIcon(MainGUI.class.getResource("/icon/searchicon.png")));
            btnNewButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent arg0) {
                  searchGUI search = new searchGUI(memdto, textField_search.getText());
                  
                  
               }
            });
            btnNewButton.setBounds(494, 64, 40, 35);
            frame.getContentPane().add(btnNewButton);
            
            JLabel lblNewLabel_1 = new JLabel("");
            lblNewLabel_1.setIcon(new ImageIcon(MainGUI.class.getResource("/icon/main3.png")));
            lblNewLabel_1.setBounds(25, 10, 84, 89);
            frame.getContentPane().add(lblNewLabel_1);

         
            
//      //////////////////////////////////////////////////////////////////////////////


   }
}