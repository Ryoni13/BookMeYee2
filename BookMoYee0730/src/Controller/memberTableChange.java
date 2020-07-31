package Controller;

import java.util.ArrayList;

import model.MemberDTO;

public class memberTableChange {
	ArrayList<MemberDTO> memberList;
	
	public memberTableChange(ArrayList<MemberDTO> memberList) {
		this.memberList = memberList;
	}
	
	public Object[][] listTypeChange(){
		Object[][] data= new Object[memberList.size()][8];
		
		for(int i = 0; i<data.length; i++) {
			data[i][0] = memberList.get(i).getName();
			data[i][1] = memberList.get(i).getId();
			data[i][2] = memberList.get(i).getPw();
			data[i][3] = memberList.get(i).getPhoneNumber();
			data[i][4] = memberList.get(i).getBread();
			data[i][5] = memberList.get(i).getLocation();
			data[i][6] = memberList.get(i).getLatitude();
			data[i][7] = memberList.get(i).getLongitude();
			
		}
		
		return data;
	}
	

}
