package Controller;

import java.util.ArrayList;

import model.deliveryDTO;

public class deliveryTableChange {
   ArrayList<deliveryDTO> deliveryList;
   
   public deliveryTableChange(ArrayList<deliveryDTO> connectorList) {
      this.deliveryList = deliveryList;
   }
   
   public Object[][] listTypeChange(){
      Object[][] data= new Object[deliveryList.size()][5];
      
      for(int i = 0; i<data.length; i++) {
         data[i][0] = deliveryList.get(i).getDeliveryNumber();
         data[i][1] = deliveryList.get(i).getId();
         data[i][2] = deliveryList.get(i).getPhoneNumber();
         data[i][3] = deliveryList.get(i).getTitle();
         data[i][4] = deliveryList.get(i).getLocation();
         data[i][5] = deliveryList.get(i).getDeliveryPrice();
         
      }
      
      return data;
   }
   

}
