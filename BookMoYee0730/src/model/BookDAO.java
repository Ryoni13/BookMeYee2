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

public class BookDAO {
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
	
	
	public int bookInsert(BookDTO dto) {
		int cnt = 0;
		getConn();
		String sql = "insert into book values(book_titlenumber_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getPublisher());
			psmt.setString(4, dto.getCategory());
			psmt.setInt(5, dto.getPrice());
			psmt.setString(6, dto.getDealtype());
			psmt.setString(7, dto.getId());
			psmt.setString(8, dto.getDealcar());
			psmt.setString(9, dto.getPhoneNumber());
			psmt.setString(10, dto.getLocation());
		
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int bookDelete(String id, String title) {
		int cnt = 0;
		getConn();
		String sql = "delete from book where =? and pw =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, title);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<BookDTO> bookInfo(String id){
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		getConn();
		String sql = "select * from book where id= ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int titleNumber = rs.getInt(1);
				String title =rs.getString(2);
				String writer =rs.getString(3);
				String publisher =rs.getString(4);
				String category =rs.getString(5);
				int price = rs.getInt(6);
				String dealtype = rs.getString(7);
				
			
				bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public ArrayList<BookDTO> showallbook(String id){
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		getConn();
		String sql = "select * from book";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int titleNumber = rs.getInt(1);
				String title =rs.getString(2);
				String writer =rs.getString(3);
				String publisher =rs.getString(4);
				String category =rs.getString(5);
				int price = rs.getInt(6);
				String dealtype = rs.getString(7);
				String memberid = rs.getString(8);
				String dealcar = rs.getString(9);
				String phoneNumber = rs.getString(10);
				String location = rs.getString(11);
			
				bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar, phoneNumber, location));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public ArrayList<BookDTO> showsellbook(String id){
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		getConn();
		String sql = "select * from book where dealcar = '판매'";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int titleNumber = rs.getInt(1);
				String title =rs.getString(2);
				String writer =rs.getString(3);
				String publisher =rs.getString(4);
				String category =rs.getString(5);
				int price = rs.getInt(6);
				String dealtype = rs.getString(7);
				String memberid = rs.getString(8);
				String dealcar = rs.getString(9);
			
				bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public ArrayList<BookDTO> showtradebook(String id){
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		getConn();
		String sql = "select * from book where dealcar = '교환'";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int titleNumber = rs.getInt(1);
				String title =rs.getString(2);
				String writer =rs.getString(3);
				String publisher =rs.getString(4);
				String category =rs.getString(5);
				int price = rs.getInt(6);
				String dealtype = rs.getString(7);
				String memberid = rs.getString(8);
				String dealcar = rs.getString(9);
			
				bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	//카테고리 책들
		public ArrayList<BookDTO> showkidsbook(String id){
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where category = '아동'";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					int titleNumber = rs.getInt(1);
					String title =rs.getString(2);
					String writer =rs.getString(3);
					String publisher =rs.getString(4);
					String category =rs.getString(5);
					int price = rs.getInt(6);
					String dealtype = rs.getString(7);
					String memberid = rs.getString(8);
					String dealcar = rs.getString(9);
				
					bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		
		public ArrayList<BookDTO> showmunjezip(String id){
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where category = '문제집'";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					int titleNumber = rs.getInt(1);
					String title =rs.getString(2);
					String writer =rs.getString(3);
					String publisher =rs.getString(4);
					String category =rs.getString(5);
					int price = rs.getInt(6);
					String dealtype = rs.getString(7);
					String memberid = rs.getString(8);
					String dealcar = rs.getString(9);
				
					bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		
		public ArrayList<BookDTO> shownovel(String id){
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where category = '소설'";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					int titleNumber = rs.getInt(1);
					String title =rs.getString(2);
					String writer =rs.getString(3);
					String publisher =rs.getString(4);
					String category =rs.getString(5);
					int price = rs.getInt(6);
					String dealtype = rs.getString(7);
					String memberid = rs.getString(8);
					String dealcar = rs.getString(9);
				
					bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		
		public ArrayList<BookDTO> showbetterthanyesterday(String id){
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where category = '자기계발서'";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					int titleNumber = rs.getInt(1);
					String title =rs.getString(2);
					String writer =rs.getString(3);
					String publisher =rs.getString(4);
					String category =rs.getString(5);
					int price = rs.getInt(6);
					String dealtype = rs.getString(7);
					String memberid = rs.getString(8);
					String dealcar = rs.getString(9);
				
					bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		
		public ArrayList<BookDTO> showmagazine(String id){
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where category = '잡지'";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					int titleNumber = rs.getInt(1);
					String title =rs.getString(2);
					String writer =rs.getString(3);
					String publisher =rs.getString(4);
					String category =rs.getString(5);
					int price = rs.getInt(6);
					String dealtype = rs.getString(7);
					String memberid = rs.getString(8);
					String dealcar = rs.getString(9);
				
					bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		
		public ArrayList<BookDTO> showcartoon(String id){
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where category = '만화'";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					int titleNumber = rs.getInt(1);
					String title =rs.getString(2);
					String writer =rs.getString(3);
					String publisher =rs.getString(4);
					String category =rs.getString(5);
					int price = rs.getInt(6);
					String dealtype = rs.getString(7);
					String memberid = rs.getString(8);
					String dealcar = rs.getString(9);
				
					bookList.add(new BookDTO(titleNumber, title, writer, publisher, category, price, dealtype, memberid, dealcar));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;
		}
		//카테고리 책
		
		public ArrayList<BookDTO> showdelivery(String id) {
			ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
			getConn();
			String sql = "select * from book where dealtype= '배달'";

			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while (rs.next()) {
					String title = rs.getString(2);
					String writer = rs.getString(3);
					String publisher = rs.getString(4);
					String category = rs.getString(5);

					bookList.add(new BookDTO(title, writer, publisher, category));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bookList;

		}
		
		
		
		public class showBookTable {
			ArrayList<BookDTO> bookList;
			
			public Object[][] listTypeChange(){
				Object[][] data= new Object[bookList.size()][8];
				
				for(int i = 0; i<data.length; i++) {
					data[i][0] = bookList.get(i).getTitleNum();
					data[i][1] = bookList.get(i).getTitle();
					data[i][2] = bookList.get(i).getWriter();
					data[i][3] = bookList.get(i).getPublisher();
					data[i][4] = bookList.get(i).getPrice();
					data[i][5] = bookList.get(i).getCategory();
					data[i][6] = bookList.get(i).getDealtype();
					data[i][7] = bookList.get(i).getId();
					
				}
				
				return data;
		}
	}
}
