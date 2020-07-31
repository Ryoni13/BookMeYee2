package model;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.net.URLEncoder;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	public class dealDAO {
	   Connection conn = null;
	   PreparedStatement psmt = null;
	   ResultSet rs = null;// �����

	   public void getConnect() {// getConnect method �����=>classnotFound�����
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         // 2.DB����

	         String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";// �� ip�ּ�
	         String user_id = "hr";
	         String user_pw = "hr";

	         conn = DriverManager.getConnection(url, user_id, user_pw);// Connection conn(��������)=>try�� �ٱ��� ����

	         if (conn != null) {
	            System.out.println("���Ἲ��");
	         } else {
	            System.out.println("���� ����");
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } // ����ó��

	   }

	   public void close() {
	      try {
	         if (rs != null) {
	            rs.close();
	         }
	         if (psmt != null) {
	            psmt.close();
	         }
	         if (conn != null) {
	            conn.close();
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();

	      }
	   }
	   public int dealInsert(dealDTO dto) {//�ŷ�����
	      int cnt = 0;
	      getConnect();
	      String sql = "insert into deal values(?,?,?,?,?,?)";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, dto.getDealNumber());
	         psmt.setString(2, dto.getId());
	         psmt.setString(3, dto.getPhoneNumber());
	         psmt.setString(4, dto.getTitle());
	         psmt.setString(5, dto.getLocation());
	         psmt.setInt(6, dto.getDealprice());
	         cnt = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return cnt;
	   }
	}


