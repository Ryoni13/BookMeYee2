package Controller;
import java.util.ArrayList;

import model.BookDTO;
import model.MemberDTO;

public class distanceTableModelChange {
		ArrayList<MemberDTO> distanceList;
		
		public distanceTableModelChange(ArrayList<MemberDTO> distanceList) {
			this.distanceList = distanceList;
		}
		
		public Object[][] listTypeChange(){
	Object[][] data= new Object[distanceList.size()][];
	
			System.out.println("å");
			
			for(int i = 0; i<data.length; i++) {
				data[0][0] = distanceList.get(i).getLatitude();
				data[0][1] = distanceList.get(i).getLocation();
				System.out.println(data[0][0]);
			}
			System.out.println(distanceList);
			System.out.println("å");
			return data;
		}
		

}

