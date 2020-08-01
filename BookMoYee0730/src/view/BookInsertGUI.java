package view; //서재와 판매 목록에 책 등록하는 창

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
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;

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
   public BookInsertGUI(MemberDTO memberdto) {
      initialize(memberdto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(MemberDTO memberdto) {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(173, 216, 230));
      frame.setBounds(100, 100, 750, 420);
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
      cbb_insert_categoty.setBounds(163, 264, 116, 21);
      frame.getContentPane().add(cbb_insert_categoty);
      
      JLabel lblNewLabel_4 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
      lblNewLabel_4.setBounds(82, 271, 57, 15);
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
      btn_bookinsert.setBackground(new Color(100, 149, 237));
      btn_bookinsert.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
               BufferedReader br = null;
               JSONParser parser = new JSONParser();
               
               int titleNumber = memberdto.getmemnum();
               String title = tf_insert_book.getText();
               String writer = tf_insert_writer.getText();
               String publisher = tf_insert_publicher.getText();
               String category = (String) cbb_insert_categoty.getSelectedItem();
               int price = Integer.parseInt(tf_insert_price.getText());
               String id= memberdto.getId();
               
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
                     
                     String phoneNumber= memberdto.getPhoneNumber();   
                     String location= memberdto.getLocation();   
                     
                
               int cnt = dao.bookInsert(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, id, dealcar, phoneNumber, location));
               frame.dispose();
               LibraryGUI main = new LibraryGUI(memberdto);   
         }
      });
      btn_bookinsert.setBounds(419, 318, 97, 23);
      frame.getContentPane().add(btn_bookinsert);
      
      JLabel lblNewLabel_5 = new JLabel("\uAC00\uACA9");
      lblNewLabel_5.setBounds(82, 236, 57, 15);
      frame.getContentPane().add(lblNewLabel_5);
      
      JEditorPane editorPane = new JEditorPane();
      editorPane.setBounds(409, 44, 279, 264);
      frame.getContentPane().add(editorPane);
      
      JLabel label = new JLabel("\uD310\uB9E4\uBC29\uC2DD");
      label.setBounds(58, 307, 57, 15);
      frame.getContentPane().add(label);
      
      
      
      JLabel lbl_id = new JLabel(memberdto.getId());
      lbl_id.setBounds(275, 10, 57, 15);
      frame.getContentPane().add(lbl_id);
      
      JLabel label_1 = new JLabel("\uAC70\uB798 \uC885\uB958");
      label_1.setBounds(45, 48, 57, 15);
      frame.getContentPane().add(label_1);
      
      JButton btn_cancel = new JButton("\uCDE8\uC18C");
      btn_cancel.setBackground(new Color(100, 149, 237));
      btn_cancel.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		frame.dispose();
			LibraryGUI library = new LibraryGUI(memberdto);//취소버튼누르면 서재로 돌아가기
      	}
      });
      btn_cancel.setBounds(586, 318, 97, 23);
      frame.getContentPane().add(btn_cancel);
      
      JLabel lblNewLabel_7 = new JLabel("\uBA54\uBAA8");
      lblNewLabel_7.setBounds(409, 10, 57, 15);
      frame.getContentPane().add(lblNewLabel_7);
      
      JPanel panel = new JPanel();
      panel.setBackground(SystemColor.activeCaption);
      panel.setBounds(0, 0, 371, 579);
      frame.getContentPane().add(panel);
      panel.setLayout(null);
      
      
      JLabel lblNewLabel_6 = new JLabel("\uD310\uB9E4 \uB4F1\uB85D");
      lblNewLabel_6.setBounds(159, 5, 72, 15);
      panel.add(lblNewLabel_6);
      
      JButton btnNewButton = new JButton("");
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		frame.dispose();
			MainGUI library = new MainGUI(memberdto);
      	}
      });
      btnNewButton.setIcon(new ImageIcon("C:\\Users\\SMT055\\Desktop\\main2.png"));
      btnNewButton.setBackground(SystemColor.activeCaption);
      btnNewButton.setBounds(12, 5, 66, 42);
      panel.add(btnNewButton);
      
      
   }
}