package model;

public class dealDTO {
	
	private int dealNumber;
	private String id;
	private String phoneNumber;
	private String title;
	private String location;
	private int dealprice;
	public dealDTO(int dealNumber, String id, String phoneNumber, String title, String location, int dealprice) {
		super();
		this.dealNumber = dealNumber;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.title = title;
		this.location = location;
		this.dealprice = dealprice;
	}
	public int getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(int dealNumber) {
		this.dealNumber = dealNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDealprice() {
		return dealprice;
	}
	public void setDealprice(int dealprice) {
		this.dealprice = dealprice;
	}
	
	

}
