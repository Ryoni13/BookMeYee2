package krwd;

import java.util.ArrayList;

import model.BookDTO;

public class LocationDistance {
 
    public static void main(String[] args) {
         
        // ų�ι���(Kilo Meter) ����
        double distanceKiloMeter =
            distance(35.152711, 126.843987, 35.125129, 126.878376, "kilometer");
     
        System.out.println(distanceKiloMeter) ;
        System.out.println();

    }
     
    /**
     * �� �������� �Ÿ� ���
     *
     * @param lat1 ���� 1 ����
     * @param lon1 ���� 1 �浵
     * @param lat2 ���� 2 ����
     * @param lon2 ���� 2 �浵
     * @param unit �Ÿ� ǥ�����
     * @return
     */

    
    
    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
         
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }
 
        return (dist);
    }
     
 
    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
 
}


