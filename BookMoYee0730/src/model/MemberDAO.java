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
				String name = rs.getString(1);
				String loginid = rs.getString(2);
				String loginpw = rs.getString(3);
				String phoneNumber = rs.getString(4);
				int bread = rs.getInt(5);
				String location = rs.getString(6);
				double latitude = rs.getDouble(7);
				double longitude = rs.getDouble(8);
				int memnum = rs.getInt(9);
				dto = new MemberDTO(name,loginid, loginpw, phoneNumber, bread, location, latitude, longitude);
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
		String sql = "insert into membertable values(?,?,?,?,?,?,?,?,MEMNUM_SEQ.NEXTVAL)";
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
				String name = rs.getString(1);
				String loginid = rs.getString(2);
				String loginpw = rs.getString(3);
				String phoneNumber = rs.getString(4);
				int bread = rs.getInt(5);
				String location = rs.getString(6);
				double latitude = rs.getDouble(7);
				double longitude = rs.getDouble(8);
				int memnum = rs.getInt(9);
				memberList.add(new MemberDTO(name,loginid, loginpw, phoneNumber, bread, location, latitude, longitude));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	public boolean editPerson(MemberDTO dto){
		 int cnt = 0;
			getConn();
			String sql = "update membertable set pw=?, PhoneNumber=?, Location=? where id = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getPw());
				psmt.setString(2, dto.getPhoneNumber());
				psmt.setString(3, dto.getLocation());
				psmt.setString(4, dto.getId());
				
				
				cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
	    }
}
