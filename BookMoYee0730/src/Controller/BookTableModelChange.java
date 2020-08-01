package Controller;
import java.util.ArrayList;

import model.BookDTO;
import model.MemberDTO;

public class BookTableModelChange {
		ArrayList<BookDTO> bookList;
		
		public BookTableModelChange(ArrayList<BookDTO> bookList) {
			this.bookList = bookList;
		}
		
		public Object[][] listTypeChange(){
	Object[][] data= new Object[bookList.size()][10];
			
			for(int i = 0; i<data.length; i++) {
				data[i][0] = bookList.get(i).getTitleNum();
				data[i][1] = bookList.get(i).getCategory();
				data[i][2] = bookList.get(i).getTitle();
				data[i][3] = bookList.get(i).getWriter();
				data[i][4] = bookList.get(i).getPublisher();
				data[i][5] = bookList.get(i).getPrice();
				data[i][6] = bookList.get(i).getId();
				
			}
			
			return data;
		}
		

}

