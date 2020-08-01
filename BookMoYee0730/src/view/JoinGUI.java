package view; //È¸¿ø°¡ÀÔ ÇÏ´Â Ã¢


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.MemberDAO;
import model.MemberDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JoinGUI {

	private JFrame frame;
	private JTextField tf_join_id;
	private JTextField tf_join_name;
	private JTextField tf_join_location;
	private JTextField tf_join_phoneNumber;
	private JPasswordField pf_join_pwCheck;
	private JPasswordField pf_join_pw;
	MemberDAO dao = new MemberDAO();
	double latitude;
	double longitude;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JoinGUI window = new JoinGUI();
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
	public JoinGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		label.setBounds(11, 10, 410, 42);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC544  \uC774  \uB514   :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_1.setBounds(55, 62, 95, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638   :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_2.setBounds(55, 99, 95, 28);
		frame.getContentPane().add(label_2);
		
		tf_join_id = new JTextField();
		tf_join_id.setColumns(10);
		tf_join_id.setBounds(185, 62, 212, 28);
		frame.getContentPane().add(tf_join_id);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778   :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_3.setBounds(18, 138, 132, 28);
		frame.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("\uC774       \uB984   :");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_5.setBounds(55, 176, 95, 28);
		frame.getContentPane().add(label_5);
		
		tf_join_name = new JTextField();
		tf_join_name.setColumns(10);
		tf_join_name.setBounds(185, 176, 212, 28);
		frame.getContentPane().add(tf_join_name);
		
		JLabel label_6 = new JLabel("\uC704 \uCE58   :");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_6.setBounds(55, 256, 95, 28);
		frame.getContentPane().add(label_6);
		
		tf_join_location = new JTextField();
		tf_join_location.setColumns(10);
		tf_join_location.setBounds(185, 256, 212, 28);
		frame.getContentPane().add(tf_join_location);
		
		JLabel label_7 = new JLabel("\uD578\uB4DC\uD3F0 \uBC88\uD638  :");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		label_7.setBounds(55, 216, 95, 28);
		frame.getContentPane().add(label_7);
		
		tf_join_phoneNumber = new JTextField();
		tf_join_phoneNumber.setColumns(10);
		tf_join_phoneNumber.setBounds(185, 216, 212, 28);
		frame.getContentPane().add(tf_join_phoneNumber);
		
		JButton btn_join = new JButton("\uD68C\uC6D0 \uAC00\uC785");
		btn_join.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				BufferedReader br = null;
				JSONParser parser = new JSONParser();
				
				String id = tf_join_id.getText();
				String pw = pf_join_pw.getText();
				String pwCheck = pf_join_pwCheck.getText();
				String name = tf_join_name.getText();
				String phoneNumber = tf_join_phoneNumber.getText();
				String location = tf_join_location.getText();
				int bread = 20;
				
				try {
					URL url = 
							new URL("https://maps.googleapis.com/maps/api/geocode/json?address="
				            		+ URLEncoder.encode(location, "UTF-8") //±¤ÁÖ
				            		+ "&key=AIzaSyBDQmv4zBxr1GdwxyRDZhvl1i-u32l0hQY");
					br = new BufferedReader(new InputStreamReader(url.openStream()));
					
					JSONObject obj = (JSONObject)parser.parse(br);
					
					
					JSONArray arr = (JSONArray)obj.get("results");
					JSONObject arrResults = (JSONObject)arr.get(0);
					JSONObject geometry = (JSONObject)arrResults.get("geometry");
					JSONObject location2 = (JSONObject)geometry.get("location");	
					
					latitude = (double)location2.get("lat");
					longitude = (double)location2.get("lng");
					
				} catch (MalformedURLException a) {
					System.out.println("[error]"+a.getMessage());
				} catch (IOException a) {
					System.out.println("[error]"+a.getMessage());
				} catch (ParseException a) {
					System.out.println("[error]"+a.getMessage());
				} finally {
					if(br!=null) try {br.close();} catch(IOException a ) {}
				}
				
				if(pw.equals(pwCheck)) {
					int cnt = dao.joinInsert(new MemberDTO(name, id, pw, phoneNumber, bread, location, latitude, longitude));
					if(cnt == 0) {
						System.out.println("½ÇÆÐ");
						JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ ½ÇÆÐ!");
					}else {
						frame.dispose();
						MainGUI main = new MainGUI(null);
						JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ ¼º°ø!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "ºñ¹Ð¹øÈ£ ºÒÀÏÄ¡", "ºñ¹Ð¹øÈ£ È®ÀÎ", JOptionPane.ERROR_MESSAGE);
					pf_join_pwCheck.setText("");
				}	
			}
		});
		
		btn_join.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		btn_join.setBounds(52, 315, 156, 34);
		frame.getContentPane().add(btn_join);
		
		JButton btn_join_close = new JButton("\uB2EB\uAE30");
		btn_join_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_join_close.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		btn_join_close.setBounds(233, 315, 156, 34);
		frame.getContentPane().add(btn_join_close);
		
		pf_join_pwCheck = new JPasswordField();
		pf_join_pwCheck.setBounds(185, 138, 212, 28);
		frame.getContentPane().add(pf_join_pwCheck);
		
		pf_join_pw = new JPasswordField();
		pf_join_pw.setBounds(185, 99, 212, 28);
		frame.getContentPane().add(pf_join_pw);
	}
}
