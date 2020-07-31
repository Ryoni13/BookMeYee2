package Controller;

import java.util.ArrayList;
import model.dealDTO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class dealTableChange {




		ArrayList<dealDTO> dealList;
		
		public dealTableChange(ArrayList<dealDTO> memberList) {
			this.dealList = dealList;
		}
		
		public Object[][] listTypeChange(){
			Object[][] data= new Object[dealList.size()][6];
			
			for(int i = 0; i<data.length; i++) {
				
				data[i][0] = dealList.get(i).getDealNumber();
				data[i][1] = dealList.get(i).getId();
				data[i][2] = dealList.get(i).getPhoneNumber();
				data[i][3] = dealList.get(i).getTitle();
				data[i][4] = dealList.get(i).getLocation();
				data[i][5] = dealList.get(i).getDealprice();
			}
			
			return data;
		}
		

	}



