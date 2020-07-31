package model;

public class BookDTO {
	
	
		private int titleNum;
		private String title;
		private String writer;
		private String publisher;
		private String category;
		private int price;
		private String dealtype;
		private String id;
		private String dealcar;
		
		
		public BookDTO(String id, String dealcar, String category, String title, String writer, String publisher, int price, String dealtype) {
			this.title = title;
			this.writer = writer;
			this.publisher = publisher;
			this.price = price;
			this.category = category;
			this.dealtype = dealtype;
			this.id = id;
			this.dealcar = dealcar;
		}
//
//		
//		public BookDTO(int titleNum, String title, String writer, String publisher, int price, String category,
//				String dealtype, String id, String dealcar) {
//			super();
//			this.titleNum = titleNum;
//			this.title = title;
//			this.writer = writer;
//			this.publisher = publisher;
//			this.price = price;
//			this.category = category;
//			this.dealtype = dealtype;
//			this.id = id;
//			this.dealcar = dealcar;
//		}
//		
//		public BookDTO(int titleNum, String title, String writer, String publisher, int price, String category,
//				String dealtype, String id) {
//			super();
//			this.titleNum = titleNum;
//			this.title = title;
//			this.writer = writer;
//			this.publisher = publisher;
//			this.price = price;
//			this.category = category;
//			this.dealtype = dealtype;
//			this.id = id;
//		}
//
//		public BookDTO(String title, String writer, String publisher, String category, int price, String dealtype) {
//			super();
//			this.title = title;
//			this.writer = writer;
//			this.publisher = publisher;
//			this.category = category;
//			this.price = price;
//			this.dealtype = dealtype;
//			this.id = id;
//		}
//		
//		
//		public BookDTO(String category, String title, String writer, String publisher, int price, String dealtype, String id) {
//			super();
//			this.category = category;
//			this.title = title;
//			this.writer = writer;
//			this.publisher = publisher;
//			this.price = price;
//			this.dealtype = dealtype;
//			this.id = id;
//			this.dealcar = dealcar;
//		}
//		
//		public BookDTO(String category, String title, String writer, String publisher, int price, String dealtype, String id, String dealcar) {
//			super();
//			this.category = category;
//			this.title = title;
//			this.writer = writer;
//			this.publisher = publisher;
//			this.price = price;
//			this.dealtype = dealtype;
//			this.id = id;
//			this.dealcar= dealcar;
//		}


		public BookDTO(int titleNumber, String title, String writer, String publisher, int price, String category,
				String dealtype, String id, String dealcar) {
			super();
//			this.titleNum = titleNum;
//			this.title = title;
//			this.writer = writer;
//			this.publisher = publisher;
//			this.price = price;
//			this.category = category;
//			this.dealtype = dealtype;
//			this.id = id;
//			this.dealcar = dealcar;
		}


		public BookDTO(int titleNumber, String title, String writer, String publisher, String category, int price,
				String dealtype, String memberid) {
			this.titleNum = titleNum;
			this.title = title;
			this.writer = writer;
			this.publisher = publisher;
			this.price = price;
			this.category = category;
			this.dealtype = dealtype;
			this.id = id;
			this.dealcar = dealcar;
		}


		public BookDTO(String category, String title, String writer, String publisher, int price, String dealtype,
				String id, String dealcar) {
			this.titleNum = titleNum;
			this.title = title;
			this.writer = writer;
			this.publisher = publisher;
			this.price = price;
			this.category = category;
			this.dealtype = dealtype;
			this.id = id;
			this.dealcar = dealcar;
		}


		public BookDTO(int titleNumber, String title, String writer, String publisher, String category, int price,
				String dealtype, String memberid, String dealcar) {
			this.titleNum = titleNum;
			this.title = title;
			this.writer = writer;
			this.publisher = publisher;
			this.price = price;
			this.category = category;
			this.dealtype = dealtype;
			this.id = id;
			this.dealcar = dealcar;
		}


		public void setTitleNum(int titleNum) {
			this.titleNum = titleNum;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public void setWriter(String writer) {
			this.writer = writer;
		}


		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}


		public void setPrice(int price) {
			this.price = price;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public void setDealtype(String dealtype) {
			this.dealtype = dealtype;
		}


		public void setId(String id) {
			this.id = id;
		}
		
		public void setDealcar(String dealcar) {
			this.id = dealcar;
		}


		public int getTitleNum() {
			return titleNum;
		}


		public String getTitle() {
			return title;
		}


		public String getWriter() {
			return writer;
		}


		public String getPublisher() {
			return publisher;
		}


		public int getPrice() {
			return price;
		}


		public String getCategory() {
			return category;
		}


		public String getDealtype() {
			return dealtype;
		}


		public String getId() {
			return id;
		}
		
		public String getDealcar() {
			return dealcar;
		}


		
		
		
	
		
		
		
}

	
