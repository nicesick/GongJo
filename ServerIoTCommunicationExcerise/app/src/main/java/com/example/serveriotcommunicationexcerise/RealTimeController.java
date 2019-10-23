package com.example.serveriotcommunicationexcerise;

import android.widget.TextView;

public class RealTimeController {
//    private static TextView inAirView,inTptView,outAirView,outTptView,dustView,ultraDustView,CO2View,humidityView;
    private static String inAir = "G 0";
    private static String inTpt = "Y 0";
    private static String outAir = "R 0";
    private static String outTpt = "G 0";
    private static String dust = "Y 0";
    private static String ultraDust = "R 0";
    private static String CO2 = "G 0";
    private static String humidity = "Y 0";
    private static String total = "G 0";
    private static boolean startUp;

    final int IN_AIR_STANDARD1 = 10,IN_AIR_STANDARD2 = 20;
    final int OUT_AIR_STANDARD1 = 10,OUT_AIR_STANDARD2 = 20;
    final int IN_TEMPERATURE_STANDARD1 = 10,IN_TEMPERATURE_STANDARD2 = 20;
    final int OUT_TEMPERATURE_STANDARD1 = 10,OUT_TEMPERATURE_STANDARD2 = 20;
    final int DUST_STANDARD1 = 10,DUST_STANDARD2 = 20;
    final int ULTRA_DUST_STANDARD1 = 10,ULTRA_DUST_STANDARD2 = 20;
    final int CO2_STANDARD1 = 10,CO2_STANDARD2 = 20;
    final int HUMIDITY_STANDARD1 = 10,HUMIDITY_STANDARD2 = 20;
    final int TOTAL_STANDARD1 = 10,TOTAL_STANDARD2 = 20;

    final String red = "R ", yellow = "Y ",green = "G " ;

    public static String getTotal() {
        return total;
    }

    public static void setTotal(String total) {
        RealTimeController.total = total;
    }
    public static String getInAir() {
        return inAir;
    }

    public static String getInTpt() {
        return inTpt;
    }

    public static String getOutAir() {
        return outAir;
    }

    public static String getOutTpt() {
        return outTpt;
    }

    public static String getDust() {
        return dust;
    }

    public static String getUltraDust() {
        return ultraDust;
    }

    public static String getCO2() {
        return CO2;
    }

    public static String getHumidity() {
        return humidity;
    }

    public void setInAir(String inAir) {
        RealTimeController.inAir = inAir;
    }

    public void setInTpt(String inTpt) {
        RealTimeController.inTpt = inTpt;
    }

    public void setOutAir(String outAir) {
        RealTimeController.outAir = outAir;
    }

    public void setOutTpt(String outTpt) {
        RealTimeController.outTpt = outTpt;
    }

    public void setDust(String dust) {
        RealTimeController.dust = dust;
    }

    public void setUltraDust(String ultraDust) {
        RealTimeController.ultraDust = ultraDust;
    }

    public void setCO2(String CO2) {
        RealTimeController.CO2 = CO2;
    }

    public void setHumidity(String humidity) {
        RealTimeController.humidity = humidity;
    }

    public void setValues(String id, String data) {
        if (id.equals("00020020")) {
            this.setCO2(checkDanger(Integer.parseInt(data),CO2_STANDARD1,CO2_STANDARD2));
        }

        else if (id.equals("00020030")) {
            this.setDust(checkDanger(Integer.parseInt(data),DUST_STANDARD1,DUST_STANDARD2));
        }

        else if (id.equals("00020035")) {
            this.setUltraDust(checkDanger(Integer.parseInt(data),ULTRA_DUST_STANDARD1,ULTRA_DUST_STANDARD2));
        }

        else if (id.equals("00020040")) {
            this.setInTpt(checkDanger(Integer.parseInt(data) - 40,IN_TEMPERATURE_STANDARD1,IN_TEMPERATURE_STANDARD2));
        }

        else if (id.equals("00020045")) {
            this.setHumidity(checkDanger(Integer.parseInt(data),HUMIDITY_STANDARD1,HUMIDITY_STANDARD2));
        }
    }
    public String checkDanger(int data, int standard1,int standard2){
        String orderData;
        if(data > standard1){
            orderData = red;
        }else if(data > standard2){
            orderData = yellow;
        }else {
            orderData = green;
        }
        orderData += data;
        return orderData;
    }
}