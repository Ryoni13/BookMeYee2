package model;

public class MemberDTO {
	private int memnum;
	private String name;
	private String id;
	private String pw;
	private String phoneNumber;
	private int bread;
	private String location;
	private double latitude;
	private double longitude;
	
	public MemberDTO(int memnum, String name, String id, String pw, String phoneNumber, int bread, String location, double latitude,
			double longitude) {
		super();
		this.memnum = memnum;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phoneNumber = phoneNumber;
		this.bread = bread;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public MemberDTO(String name, String id, String pw, String phoneNumber, int bread, String location, double latitude,
			double longitude) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phoneNumber = phoneNumber;
		this.bread = bread;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public MemberDTO(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public int getmemnum() {
		return memnum;
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getBread() {
		return bread;
	}

	public String getLocation() {
		return location;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	
}