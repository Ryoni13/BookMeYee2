package model;

public class deliveryDTO {
   private int deliveryNumber;
   private String id;
   private String phoneNumber;
   private String title;
   private String location;
   private int deliveryPrice;
public deliveryDTO(int deliveryNumber, String id, String phoneNumber, String title, String location, int deliveryPrice) {
	super();
	this.deliveryNumber = deliveryNumber;
	this.id = id;
	this.phoneNumber = phoneNumber;
	this.title = title;
	this.location = location;
	this.deliveryPrice = deliveryPrice;
}
public int getDeliveryNumber() {
	return deliveryNumber;
}
public String getId() {
	return id;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public String getTitle() {
	return title;
}
public String getLocation() {
	return location;
}
public int getDeliveryPrice() {
	return deliveryPrice;
}
public void setDeliveryNumber(int deliveryNumber) {
	this.deliveryNumber = deliveryNumber;
}
public void setId(String id) {
	this.id = id;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public void setTitle(String title) {
	this.title = title;
}
public void setLocation(String location) {
	this.location = location;
}
public void setDeliveryPrice(int deliveryPrice) {
	this.deliveryPrice = deliveryPrice;
}
   
   
   
 
   
   
   


}