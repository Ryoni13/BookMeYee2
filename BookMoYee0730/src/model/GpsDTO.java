package model;

public class GpsDTO {
	
	private String location;
	private double latitude;
	private double longitude;
	public GpsDTO(String location, double latitude, double longitude) {
		super();
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
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
