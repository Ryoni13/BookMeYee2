package Controller;

import java.util.ArrayList;

import model.BookDTO;

public class BookTableModelChange1 {
	
	ArrayList<BookDTO> bookList1;		
	public BookTableModelChange1(ArrayList<BookDTO> bookList1) {
		this.bookList1 = bookList1;
	}
	
	public Object[][] listTypeChange1(){
		Object[][] data= new Object[bookList1.size()][9];
		
		for(int i = 0; i<data.length; i++) {
			data[i][0] = bookList1.get(i).getTitle();
			data[i][1] = bookList1.get(i).getWriter();
			data[i][2] = bookList1.get(i).getPublisher();
			data[i][3] = bookList1.get(i).getCategory();
			
			
		}
		
		return data;
	}	

}
