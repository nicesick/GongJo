package com.example.serveriotcommunicationexcerise;

import android.widget.TextView;

import java.sql.Date;

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

    private static String car_id = "서울1234";
    private static String car_speed = "0";
    private static String car_distance = "0";
    private static String car_air = "0";
    private static String car_dust = "0";
    private static String car_finedust = "0";
    private static String car_temp = "0";
    private static String car_ext_temperature = "0";
    private static String car_ext_dust = "0";
    private static String car_ext_finedust = "0";
    private static String car_humidity = "0";
    private static String car_fuel = "0";
    private static String car_bat = "0";
    private static Date car_date = new Date(0);
    private static String car_hms = "0";
    private static String car_lat = "0";
    private static String car_log = "0";
    private static String car_accel_pressure = "0";
    private static String car_brake_pressure = "0";

    private static boolean startUp;
    private static boolean lightOn;

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

    public  String getTotal() {
        return total;
    }

    public  void setTotal(String total) {
        RealTimeController.total = total;
    }
    public  String getInAir() {
        return inAir;
    }

    public  String getInTpt() {
        return inTpt;
    }

    public  String getOutAir() {
        return outAir;
    }

    public  String getOutTpt() {
        return outTpt;
    }

    public  String getDust() {
        return dust;
    }

    public  String getUltraDust() {
        return ultraDust;
    }

    public  String getCO2() {
        return CO2;
    }

    public String getHumidity() {
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

    public String getCar_id() {
        return car_id;
    }

    public static void setCar_id(String car_id) {
        RealTimeController.car_id = car_id;
    }

    public String getCar_speed() {
        return car_speed;
    }

    public void setCar_speed(String car_speed) {
        RealTimeController.car_speed = car_speed;
    }

    public String getCar_distance() {
        return car_distance;
    }

    public void setCar_distance(String car_distance) {
        RealTimeController.car_distance = car_distance;
    }

    public String getCar_air() {
        return car_air;
    }

    public void setCar_air(String car_air) {
        RealTimeController.car_air = car_air;
    }

    public String getCar_dust() {
        return car_dust;
    }

    public void setCar_dust(String car_dust) {
        RealTimeController.car_dust = car_dust;
    }

    public String getCar_finedust() {
        return car_finedust;
    }

    public void setCar_finedust(String car_finedust) {
        RealTimeController.car_finedust = car_finedust;
    }

    public String getCar_temp() {
        return car_temp;
    }

    public void setCar_temp(String car_temp) {
        RealTimeController.car_temp = car_temp;
    }

    public String getCar_ext_temperature() {
        return car_ext_temperature;
    }

    public void setCar_ext_temperature(String car_ext_temperature) {
        RealTimeController.car_ext_temperature = car_ext_temperature;
    }

    public String getCar_ext_dust() {
        return car_ext_dust;
    }

    public void setCar_ext_dust(String car_ext_dust) {
        RealTimeController.car_ext_dust = car_ext_dust;
    }

    public String getCar_ext_finedust() {
        return car_ext_finedust;
    }

    public void setCar_ext_finedust(String car_ext_finedust) {
        RealTimeController.car_ext_finedust = car_ext_finedust;
    }

    public String getCar_humidity() {
        return car_humidity;
    }

    public void setCar_humidity(String car_humidity) {
        RealTimeController.car_humidity = car_humidity;
    }

    public String getCar_fuel() {
        return car_fuel;
    }

    public void setCar_fuel(String car_fuel) {
        RealTimeController.car_fuel = car_fuel;
    }

    public String getCar_bat() {
        return car_bat;
    }

    public void setCar_bat(String car_bat) {
        RealTimeController.car_bat = car_bat;
    }

    public Date getCar_date() {
        return car_date;
    }

    public void setCar_date(Date car_date) {
        RealTimeController.car_date = car_date;
    }

    public String getCar_hms() {
        return car_hms;
    }

    public void setCar_hms(String car_hms) {
        RealTimeController.car_hms = car_hms;
    }

    public String getCar_lat() {
        return car_lat;
    }

    public void setCar_lat(String car_lat) {
        RealTimeController.car_lat = car_lat;
    }

    public String getCar_log() {
        return car_log;
    }

    public void setCar_log(String car_log) {
        RealTimeController.car_log = car_log;
    }

    public String getCar_accel_pressure() {
        return car_accel_pressure;
    }

    public void setCar_accel_pressure(String car_accel_pressure) {
        RealTimeController.car_accel_pressure = car_accel_pressure;
    }

    public String getCar_brake_pressure() {
        return car_brake_pressure;
    }

    public void setCar_brake_pressure(String car_brake_pressure) {
        RealTimeController.car_brake_pressure = car_brake_pressure;
    }

    public  boolean isStartUp() {
        return startUp;
    }

    public  void setStartUp(boolean startUp) {
        RealTimeController.startUp = startUp;
    }

    public  boolean isLightOn() {
        return lightOn;
    }

    public  void setLightOn(boolean lightOn) {
        RealTimeController.lightOn = lightOn;
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