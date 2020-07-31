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
   private final ButtonGroup buttonGroup_1 = new ButtonGroup();

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               BookInsertGUI window = new BookInsertGUI();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

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
      lblNewLabel.setBounds(82, 84, 57, 15);
      frame.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
      lblNewLabel_1.setBounds(82, 122, 57, 15);
      frame.getContentPane().add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
      lblNewLabel_2.setBounds(82, 160, 57, 15);
      frame.getContentPane().add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("\uC7A5\uC18C");
      lblNewLabel_3.setBounds(82, 198, 57, 15);
      frame.getContentPane().add(lblNewLabel_3);
      
      tf_insert_book = new JTextField();
      tf_insert_book.setBounds(163, 85, 116, 21);
      frame.getContentPane().add(tf_insert_book);
      tf_insert_book.setColumns(10);
      
      tf_insert_writer = new JTextField();
      tf_insert_writer.setColumns(10);
      tf_insert_writer.setBounds(163, 119, 116, 21);
      frame.getContentPane().add(tf_insert_writer);
      
      tf_insert_publicher = new JTextField();
      tf_insert_publicher.setColumns(10);
      tf_insert_publicher.setBounds(163, 157, 116, 21);
      frame.getContentPane().add(tf_insert_publicher);
      
      tf_location = new JTextField();
      tf_location.setColumns(10);
      tf_location.setBounds(163, 195, 116, 21);
      frame.getContentPane().add(tf_location);
      
      tf_insert_price = new JTextField();
      tf_insert_price.setBounds(163, 233, 116, 21);
      frame.getContentPane().add(tf_insert_price);
      frame.getContentPane().add(tf_insert_price);
      
      JComboBox cbb_insert_categoty = new JComboBox();
      cbb_insert_categoty.setModel(new DefaultComboBoxModel(new String[] {"아동", "소설", "자기계발서", "문제집", "잡지", "만화"}));
      cbb_insert_categoty.setBounds(153, 268, 116, 21);
      frame.getContentPane().add(cbb_insert_categoty);
      
      JLabel lblNewLabel_4 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
      lblNewLabel_4.setBounds(72, 264, 57, 15);
      frame.getContentPane().add(lblNewLabel_4);
      
      JCheckBox cb_insert_deal = new JCheckBox("직거래");
      buttonGroup.add(cb_insert_deal);
      cb_insert_deal.setBounds(140, 303, 71, 23);
      frame.getContentPane().add(cb_insert_deal);
      
      JCheckBox cb_insert_deli = new JCheckBox("배달");
      buttonGroup.add(cb_insert_deli);
      cb_insert_deli.setBounds(233, 303, 62, 23);
      frame.getContentPane().add(cb_insert_deli);
      
      JCheckBox cb_insert_sell = new JCheckBox("판매");
      buttonGroup_1.add(cb_insert_sell);
      cb_insert_sell.setBounds(114, 44, 71, 23);
      frame.getContentPane().add(cb_insert_sell);
      
      JCheckBox cb_insert_buy = new JCheckBox("교환");
      buttonGroup_1.add(cb_insert_buy);
      cb_insert_buy.setBounds(189, 44, 71, 23);
      frame.getContentPane().add(cb_insert_buy);
      
      JCheckBox cb_insert_sha = new JCheckBox("나눔");
      buttonGroup_1.add(cb_insert_sha);
      cb_insert_sha.setBounds(261, 44, 71, 23);
      frame.getContentPane().add(cb_insert_sha);
      
      JButton btn_bookinsert = new JButton("\uD310\uB9E4 \uB4F1\uB85D");
      btn_bookinsert.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
               BufferedReader br = null;
               JSONParser parser = new JSONParser();
               
               
               String id= dto.getId();
               String title = tf_insert_book.getText();
               String writer = tf_insert_writer.getText();
               String publisher = tf_insert_publicher.getText();
               int price = Integer.parseInt(tf_insert_price.getText());
               String category = (String) cbb_insert_categoty.getSelectedItem();
               
               String dealtype = null;
                     if(cb_insert_deal.isSelected()) {
                        dealtype = cb_insert_deal.getText();
                     }else if(cb_insert_deli.isSelected()) {
                        dealtype = cb_insert_deli.getText();
                     }
                     
               String dealcar = null;
                     if(cb_insert_sell.isSelected()) {
                        dealcar = cb_insert_sell.getText();
                     }else if(cb_insert_buy.isSelected()) {
                        dealcar = cb_insert_buy.getText();
                     }
                
               int cnt = dao.bookInsert(new BookDTO(category, title, writer, publisher, price, dealtype, id, dealcar));
               frame.dispose();
               LibraryGUI main = new LibraryGUI(dto);   
         }
      });
      btn_bookinsert.setBounds(129, 543, 97, 23);
      frame.getContentPane().add(btn_bookinsert);
      
      JLabel lblNewLabel_5 = new JLabel("\uAC00\uACA9");
      lblNewLabel_5.setBounds(82, 236, 57, 15);
      frame.getContentPane().add(lblNewLabel_5);
      
      
      JLabel lblNewLabel_6 = new JLabel("\uD310\uB9E4 \uB4F1\uB85D");
      lblNewLabel_6.setBounds(12, 10, 57, 15);
      frame.getContentPane().add(lblNewLabel_6);
      
      JEditorPane editorPane = new JEditorPane();
      editorPane.setBounds(12, 336, 337, 163);
      frame.getContentPane().add(editorPane);
      
      JLabel label = new JLabel("\uD310\uB9E4\uBC29\uC2DD");
      label.setBounds(58, 307, 57, 15);
      frame.getContentPane().add(label);
      
      
      
      JLabel lbl_id = new JLabel(dto.getId());
      lbl_id.setBounds(275, 10, 57, 15);
      frame.getContentPane().add(lbl_id);
      
      JLabel label_1 = new JLabel("\uAC70\uB798 \uC885\uB958");
      label_1.setBounds(45, 48, 57, 15);
      frame.getContentPane().add(label_1);
      
      
   }
}