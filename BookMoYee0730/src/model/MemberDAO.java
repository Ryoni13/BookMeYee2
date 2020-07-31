package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public MemberDTO loginSelect(String id, String pw) {
		MemberDTO dto = null;
		getConn();
		String sql = "select * from membertable where id=? and pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setString(2,pw);
			rs=psmt.executeQuery();
			while(rs.next()) {
				int memnum = rs.getInt(1);
				String name = rs.getString(2);
				String loginId = rs.getString(3);
				String loginPw = rs.getString(4);
				String phoneNumber = rs.getString(5);
				int bread = rs.getInt(6);
				String location = rs.getString(7);
				double latitude = rs.getDouble(8);
				double longitude = rs.getDouble(9);
				dto = new MemberDTO(memnum, name, loginId, loginPw, phoneNumber, bread, location, latitude, longitude);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	public int joinInsert(MemberDTO dto) {
		int cnt = 0;
		getConn();
		String sql = "insert into membertable values(MEM_SEQ.NEXTVAL, ?,?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());
			psmt.setString(4, dto.getPhoneNumber());
			psmt.setInt(5, dto.getBread());
			psmt.setString(6, dto.getLocation());
			psmt.setDouble(7, dto.getLatitude());
			psmt.setDouble(8, dto.getLongitude());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int memberDelete(String id, String pw) {
		int cnt = 0;
		getConn();
		String sql = "delete from membertable where id=? and pw =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<MemberDTO> memberInfoSelect() {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		getConn();
		String sql = "select * from membertable";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int memnum = rs.getInt(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String pw = rs.getString(4);
				String phoneNumber = rs.getString(5);
				int bread = rs.getInt(6);
				String location = rs.getString(7);
				double latitude = rs.getFloat(8);
				double longitude = rs.getFloat(9);
				memberList.add(new MemberDTO(memnum, name, id, pw, phoneNumber, bread, location, latitude, longitude));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
}
