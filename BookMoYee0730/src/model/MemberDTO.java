package model;

public class MemberDTO {
	private String name;
	private String id;
	private String pw;
	private String phoneNumber;
	private int bread;
	private String location;
	private double latitude;
	private double longitude;
	private int memnum;
	
	public MemberDTO(String name, String id, String pw, String phoneNumber, int bread, String location, double latitude,
			double longitude, int memnum) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phoneNumber = phoneNumber;
		this.bread = bread;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.memnum = memnum;
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
	
	
	public MemberDTO(String id) {
		this.id = id;
		// TODO Auto-generated constructor stub
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
	
	public int getmemnum() {
		return memnum;
	}
	
}