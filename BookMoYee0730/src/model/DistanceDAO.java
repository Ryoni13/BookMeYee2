package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class DistanceDAO {
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
	

	public ArrayList<MemberDTO> showlocation() {
		ArrayList<MemberDTO> distanceList = new ArrayList<MemberDTO>();
		
		getConn();
		String sql = "select * from membertable";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
						float latitude = rs.getFloat(8);
						float longitude = rs.getFloat(9);
						distanceList.add(new MemberDTO(latitude, longitude));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return distanceList;
	}
	
	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
         
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }
 
        return (dist);
    }
 
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
    
    
    
    public static void main(String[] args) {//
    	
    	DistanceDAO dao = new DistanceDAO();
    	double distanceKiloMeter;
    	int max = dao.showlocation().size();
    	
		for (int j = 0; j <= 4; j++) {
			double latitude = dao.showlocation().get(j).getLatitude();
			double longitude = dao.showlocation().get(j).getLongitude();
			for (int i = 0; i <= 4; i++) {
				double latitude1 = dao.showlocation().get(i).getLatitude();
				double longitude1 = dao.showlocation().get(i).getLongitude();
				distanceKiloMeter = distance(latitude, longitude, latitude1, longitude1, "kilometer");
				System.out.println(j+"와"+i+" : "+(float)distanceKiloMeter) ;
			}
			System.out.println("");
		}
    }
    
    
    
//    public static void main(String[] args) {
//    	System.out.println(result(0,2));	
//        }
//
//        public static double result(int j, int i) {
//    	DistanceDAO dao = new DistanceDAO();
//    	double distanceKiloMeter;
//    	
//    		double latitude = dao.showlocation().get(j).getLatitude();
//    		double longitude = dao.showlocation().get(j).getLongitude();
//    		double latitude1 = dao.showlocation().get(i).getLatitude();
//    		double longitude1 = dao.showlocation().get(i).getLongitude();
//    		distanceKiloMeter = distance(latitude, longitude, latitude1, longitude1, "kilometer");
//    		return (double) distanceKiloMeter;
//        }
        

}//마지막 괄호
    
        

