package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class addressDAO {
	public static void main(String[] args) {
		BufferedReader br = null;
		JSONParser parser = new JSONParser();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("지역 이름 입력 : ");
		String area = sc.next();	
		 
		// 데이터 가져오기
		try {
			URL url = 
					new URL("https://maps.googleapis.com/maps/api/geocode/json?address="
		            		+ URLEncoder.encode(area, "UTF-8") //광주
		            		+ "&key=AIzaSyBDQmv4zBxr1GdwxyRDZhvl1i-u32l0hQY");
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			JSONObject obj = (JSONObject)parser.parse(br);
			
			
			JSONArray arr = (JSONArray)obj.get("results");
			JSONObject arrResults = (JSONObject)arr.get(0);
			JSONObject geometry = (JSONObject)arrResults.get("geometry");
			JSONObject location = (JSONObject)geometry.get("location");
			
			System.out.println("위도는 "+(Double)location.get("lat"));
			System.out.println("경도는 "+(Double)location.get("lng"));
			
		} catch (MalformedURLException e) {
			System.out.println("[error]"+e.getMessage());
		} catch (IOException e) {
			System.out.println("[error]"+e.getMessage());
		} catch (ParseException e) {
			System.out.println("[error]"+e.getMessage());
		} finally {
			if(br!=null) try {br.close();} catch(IOException e ) {}
		}
	}
}
