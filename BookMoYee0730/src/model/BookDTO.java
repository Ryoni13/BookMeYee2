package model;

public class BookDTO {
	
	
	private String title;
	private String writer;
	private String publisher;
	private String category;
	private int price;
	private String dealtype;
	private String id;
	private String dealcar;
	private String PhoneNumber;
	private String location;
	
	
	public BookDTO(int titleNumber, String title, String writer, String publisher, String category, int price,
			String dealtype, String id, String dealcar, String phoneNumber, String location) {
		super();
		this.titleNum = titleNumber;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
		this.dealtype = dealtype;
		this.id = id;
		this.dealcar = dealcar;
		PhoneNumber = phoneNumber;
		this.location = location;
	}
	public BookDTO(int titleNumber, String title, String writer, String publisher, String category, int price,
			String dealtype) {
		super();
		this.titleNum = titleNumber;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
		this.dealtype = dealtype;
		
	}
	public BookDTO(String dealtype2, String category2, String title2, String writer2, String publisher2, int price2) {
		super();
		this.dealtype = dealtype2;
		this.category = category2;
		this.title = title2;
		this.writer = writer2;
		this.publisher = publisher2;
		this.price = price2;
		
		
	}
	public BookDTO(int titleNumber, String title2, String writer2, String publisher2, String category2, int price2,
			String dealtype2, String id, String dealcar2) {
		super();
		this.titleNum = titleNumber;
		this.title = title2;
		this.writer = writer2;
		this.publisher = publisher2;
		this.category = category2;
		this.price = price2;
		this.dealtype = dealtype2;
		this.id = id;
		this.dealcar = dealcar2;
		
		
	}
	
	public BookDTO(String title, String writer, String publisher, String category) {
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.category = category;
	}
	
	
	
	public void setTitleNumer(int titleNumer) {
		this.titleNum = titleNumer;
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
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDealtype(String dealtype) {
		this.dealtype = dealtype;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDealcar(String dealcar) {
		this.dealcar = dealcar;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	private int titleNum;
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
	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
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
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public String getLocation() {
		return location;
	}
	
	
		
		
}

	
