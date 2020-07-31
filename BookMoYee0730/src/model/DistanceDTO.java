package model;

public class DistanceDTO {
	private String location;
	private String latitude;
	private String longitude;
	
	public DistanceDTO(String location, String latitude, String longitude) {
		super();
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	
}
