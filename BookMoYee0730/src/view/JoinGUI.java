package view;


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
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

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
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 750, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMembership = new JLabel("membership");
		lblMembership.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembership.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblMembership.setBounds(416, 26, 262, 42);
		frame.getContentPane().add(lblMembership);
		
		JLabel lblID = new JLabel("I       D   :");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblID.setBounds(392, 85, 95, 28);
		frame.getContentPane().add(lblID);
		
		JLabel lblPW = new JLabel("P     W   :");
		lblPW.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPW.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblPW.setBounds(392, 132, 95, 28);
		frame.getContentPane().add(lblPW);
		
		tf_join_id = new JTextField();
		tf_join_id.setColumns(10);
		tf_join_id.setBounds(499, 89, 201, 21);
		frame.getContentPane().add(tf_join_id);
		
		JLabel lblPwConfirm = new JLabel("PW confirm   :");
		lblPwConfirm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPwConfirm.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblPwConfirm.setBounds(355, 179, 132, 28);
		frame.getContentPane().add(lblPwConfirm);
		
		JLabel lblName = new JLabel("NAME   :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblName.setBounds(392, 226, 95, 28);
		frame.getContentPane().add(lblName);
		
		tf_join_name = new JTextField();
		tf_join_name.setColumns(10);
		tf_join_name.setBounds(499, 230, 201, 21);
		frame.getContentPane().add(tf_join_name);
		
		JLabel lblLocation = new JLabel("Location  :");
		lblLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocation.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblLocation.setBounds(392, 320, 95, 28);
		frame.getContentPane().add(lblLocation);
		
		tf_join_location = new JTextField();
		tf_join_location.setColumns(10);
		tf_join_location.setBounds(499, 324, 201, 21);
		frame.getContentPane().add(tf_join_location);
		
		JLabel lblPhonenumber = new JLabel("PhoneNumber :");
		lblPhonenumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhonenumber.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 14));
		lblPhonenumber.setBounds(382, 273, 105, 28);
		frame.getContentPane().add(lblPhonenumber);
		
		tf_join_phoneNumber = new JTextField();
		tf_join_phoneNumber.setColumns(10);
		tf_join_phoneNumber.setBounds(499, 277, 201, 21);
		frame.getContentPane().add(tf_join_phoneNumber);
		
		JButton btn_join = new JButton("membership");
		btn_join.setBackground(new Color(70, 130, 180));
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
		btn_join.setBounds(392, 387, 124, 34);
		frame.getContentPane().add(btn_join);
		
		JButton btn_join_close = new JButton("close");
		btn_join_close.setBackground(new Color(70, 130, 180));
		btn_join_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_join_close.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 15));
		btn_join_close.setBounds(568, 387, 132, 34);
		frame.getContentPane().add(btn_join_close);
		
		pf_join_pwCheck = new JPasswordField();
		pf_join_pwCheck.setBounds(499, 183, 201, 21);
		frame.getContentPane().add(pf_join_pwCheck);
		
		pf_join_pw = new JPasswordField();
		pf_join_pw.setBounds(499, 136, 201, 21);
		frame.getContentPane().add(pf_join_pw);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 359, 491);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SMT055\\Desktop\\lo.png"));
		lblNewLabel.setBounds(69, 123, 218, 220);
		panel.add(lblNewLabel);
	}
}