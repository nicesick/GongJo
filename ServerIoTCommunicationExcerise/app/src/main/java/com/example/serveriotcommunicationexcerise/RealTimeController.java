package com.example.serveriotcommunicationexcerise;

import android.widget.TextView;

import java.sql.Date;

public class RealTimeController {
    SoundPlayClass soundPlayClass = new SoundPlayClass();

    private static final String CAR_ON_ID = "00000000";
    private static final String CAR_SPEED_ID = "00010010";
    private static final String CAR_DISTANCE_ID = "00010015";
    private static final String CAR_AIR_ID = "00020020";
    private static final String CAR_DUST_ID = "00020030";
    private static final String CAR_FINEDUST_ID = "00020035";
    private static final String CAR_TEMP_ID = "00020040";
    private static final String CAR_EXT_TEMPERATURE_ID = "00020060";
    private static final String CAR_EXT_DUST_ID = "00020050";
    private static final String CAR_EXT_FINEDUST_ID = "00020055";
    private static final String CAR_HUMIDITY_ID = "00020045";
    private static final String CAR_FUEL_ID = "00010050";
    private static final String CAR_BAT_ID = "00010055";
    private static final String CAR_ACCEL_PRESSURE_ID = "00030090";
    private static final String CAR_BRAKE_PRESSURE_ID = "00030095";

    private static final String CAR_RIGHT_SEAT_PRESURE = "00041010";
    private static final String CAR_RIGHT_BUCKLE_PRESURE = "00041040";
    private static final String CAR_RIGHT_BACK_PRESURE = "00041030";
    private static final String CAR_LEFT_SEAT_PRESURE = "00041020";
    private static final String CAR_LEFT_BUCKLE_PRESURE = "00042040";
    private static final String CAR_LEFT_BACK_PRESURE = "00042030";

    private static final String CAR_START_UP = "00020010";
    private static final String CAR_LIGHT_ON = "00020015";

    private int rightSeatPresure = 0;
    private int rightBucklePresure = 0;
    private int rightBackPresure = 0;
    private int leftSeatPresure = 0;
    private int leftBucklePresure = 0;
    private int leftBackPresure = 0;

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
    private static String outDUst = "Y 0";
    private static String outUltraDust = "R 0";

    public  String getOutDUst() {
        return outDUst;
    }

    public  void setOutDUst(String outDUst) {
        RealTimeController.outDUst = outDUst;
    }

    public  String getOutUltraDust() {
        return outUltraDust;
    }

    public  void setOutUltraDust(String outUltraDust) {
        RealTimeController.outUltraDust = outUltraDust;
    }

    private static String car_id = "서울1234";
    private static String car_on = "on";
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

    private static String startUp = "0";
    private static String lightOn = "0";

    private final int IN_AIR_STANDARD1 = 20;
    private final int IN_AIR_STANDARD2 = 10;
    private final int OUT_AIR_STANDARD1 = 10;
    private final int OUT_AIR_STANDARD2 = 20;
    private final int IN_TEMPERATURE_STANDARD1 = 30;
    private final int IN_TEMPERATURE_STANDARD2 = 10;
    private final int OUT_TEMPERATURE_STANDARD1 = 10;
    private final int OUT_TEMPERATURE_STANDARD2 = 20;

    private final int DUST_STANDARD1 = 150;
    private final int DUST_STANDARD2 = 80;
    private final int ULTRA_DUST_STANDARD1 = 100;
    private final int ULTRA_DUST_STANDARD2 = 50;
    private final int AIR_STANDARD1 = 2000;
    private final int AIR_STANDARD2 = 1000;
    private final int HUMIDITY_STANDARD1 = 10;
    private final int HUMIDITY_STANDARD2 = 20;
    private final int TOTAL_STANDARD1 = 6;
    private final int TOTAL_STANDARD2 = 4;

    private final int RIGHT_BACK_STANDARD = 30;
    private final int RIGHT_SEAT_STANDARD = 30;
    private final int RIGHT_BUCKLE_STANDARD = 10;
    private final int LEFT_BACK_STANDARD = 30;
    private final int LEFT_SEAT_STANDARD = 30;
    private final int LEFT_BUCKLE_STANDARD = 10;


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

    public int getRightSeatPresure() {
        return rightSeatPresure;
    }

    public void setRightSeatPresure(int rightSeatPresure) {
        this.rightSeatPresure = rightSeatPresure;
    }

    public int getRightBucklePresure() {
        return rightBucklePresure;
    }

    public void setRightBucklePresure(int rightBucklePresure) {
        this.rightBucklePresure = rightBucklePresure;
    }

    public int getRightBackPresure() {
        return rightBackPresure;
    }

    public void setRightBackPresure(int rightBackPresure) {
        this.rightBackPresure = rightBackPresure;
    }

    public int getLeftSeatPresure() {
        return leftSeatPresure;
    }

    public void setLeftSeatPresure(int leftSeatPresure) {
        this.leftSeatPresure = leftSeatPresure;
    }

    public int getLeftBucklePresure() {
        return leftBucklePresure;
    }

    public void setLeftBucklePresure(int leftBucklePresure) {
        this.leftBucklePresure = leftBucklePresure;
    }

    public int getLeftBackPresure() {
        return leftBackPresure;
    }

    public void setLeftBackPresure(int leftBackPresure) {
        this.leftBackPresure = leftBackPresure;
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

    public void setCar_id(String car_id) {
        RealTimeController.car_id = car_id;
    }

    public String getCar_on() {
        return car_on;
    }

    public void setCar_on(String car_on) {
        RealTimeController.car_on = car_on;
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
    void checkSeatRightBelt(){
        if(rightBackPresure>RIGHT_BACK_STANDARD && rightSeatPresure > RIGHT_SEAT_STANDARD && rightBucklePresure < RIGHT_BUCKLE_STANDARD){
            playSeatRightBelt();
        }
    }
    void playSeatRightBelt(){
        soundPlayClass.playRightAlarm();
    }
    void checkSeatLeftBelt(){
        if(leftBackPresure>LEFT_BACK_STANDARD && leftSeatPresure > LEFT_SEAT_STANDARD && leftBucklePresure < LEFT_BUCKLE_STANDARD){
            playSeatLeftBelt();
        }
    }
    void playSeatLeftBelt(){
        soundPlayClass.playLeftAlarm();
    }
    void checkSeatBelt(){
        checkSeatLeftBelt();
        checkSeatRightBelt();
    }

    public String getStartUp() {
        return startUp;
    }

    public void setStartUp(String startUp) {
        RealTimeController.startUp = startUp;
    }

    public String getLightOn() {
        return lightOn;
    }

    public void setLightOn(String lightOn) {
        RealTimeController.lightOn = lightOn;
    }

    public void setValues(String id, String data) {
        if (id.equals(CAR_ON_ID)) {
            if (data.equals("0000000000000000")) {
                this.setCar_on("off");
            }

            else if (data.equals("0000000000000001")) {
                this.setCar_on("on");
            }
        }

        else if (id.equals(CAR_SPEED_ID)) {
            this.setCar_speed(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals(CAR_DISTANCE_ID)) {
            this.setCar_distance(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals(CAR_AIR_ID)) {
            this.setCar_air(String.valueOf(Integer.parseInt(data)));
            this.setCO2(checkDanger(Integer.parseInt(data),AIR_STANDARD1,AIR_STANDARD2));
        }

        else if (id.equals(CAR_DUST_ID)) {
            this.setCar_dust(String.valueOf(Integer.parseInt(data)));
            this.setDust(checkDanger(Integer.parseInt(data),DUST_STANDARD1,DUST_STANDARD2));
        }

        else if (id.equals(CAR_FINEDUST_ID)) {
            this.setCar_finedust(String.valueOf(Integer.parseInt(data)));
            this.setUltraDust(checkDanger(Integer.parseInt(data),ULTRA_DUST_STANDARD1,ULTRA_DUST_STANDARD2));
        }

        else if (id.equals(CAR_TEMP_ID)) {
            this.setCar_temp(String.valueOf(Integer.parseInt(data) - 40));
            this.setInTpt(checkDanger(Integer.parseInt(data) - 40,IN_TEMPERATURE_STANDARD1,IN_TEMPERATURE_STANDARD2));
        }

        else if (id.equals(CAR_EXT_TEMPERATURE_ID)) {
            this.setCar_ext_temperature(String.valueOf(Integer.parseInt(data)));
            setOutTpt(String.valueOf(Integer.parseInt(data)-40));
        }

        else if (id.equals(CAR_EXT_DUST_ID)) {
            this.setCar_ext_dust(String.valueOf(Integer.parseInt(data)));
            setOutDUst(checkDanger(Integer.parseInt(data),DUST_STANDARD1,DUST_STANDARD2));
        }

        else if (id.equals(CAR_EXT_FINEDUST_ID)) {
            this.setCar_ext_finedust(String.valueOf(Integer.parseInt(data)));
            this.setOutUltraDust(checkDanger(Integer.parseInt(data),ULTRA_DUST_STANDARD1,ULTRA_DUST_STANDARD2));
        }

        else if (id.equals(CAR_HUMIDITY_ID)) {
            this.setCar_humidity(String.valueOf(Integer.parseInt(data)));
            this.setHumidity(checkDanger(Integer.parseInt(data),HUMIDITY_STANDARD1,HUMIDITY_STANDARD2));
        }

        else if (id.equals(CAR_FUEL_ID)) {
            this.setCar_fuel(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals(CAR_BAT_ID)) {
            this.setCar_bat(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals(CAR_ACCEL_PRESSURE_ID)) {
            this.setCar_accel_pressure(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals(CAR_BRAKE_PRESSURE_ID)) {
            this.setCar_brake_pressure(String.valueOf(Integer.parseInt(data)));
        }
        else if(CAR_RIGHT_BACK_PRESURE.equals(id)){
            setRightBackPresure(Integer.parseInt(id));
        }
        else if(CAR_RIGHT_BUCKLE_PRESURE.equals(id)){
            setRightBucklePresure(Integer.parseInt(id));
        }
        else if(CAR_RIGHT_SEAT_PRESURE.equals(id)){
            setRightSeatPresure(Integer.parseInt(id));
        }
        else if(CAR_LEFT_BACK_PRESURE.equals(id)){
            setLeftBackPresure(Integer.parseInt(id));
        }
        else if(CAR_LEFT_BUCKLE_PRESURE.equals(id)){
            setLeftBucklePresure(Integer.parseInt(id));
        }
        else if(CAR_LEFT_SEAT_PRESURE.equals(id)){
            setLeftSeatPresure(Integer.parseInt(id));
        }
        else if(CAR_START_UP.equals(id)){
            setStartUp(String.valueOf(Integer.parseInt(data)));
        }
        else if(CAR_LIGHT_ON.equals(id)){
            setLightOn(String.valueOf(Integer.parseInt(data)));
        }
        checkSeatBelt();

        setInAir(checkInAverageAirCondition(getDust(),getUltraDust(),getCO2()));
        setOutAir(checkOutAverageAirCondition(getOutDUst(),getOutUltraDust()));
        setTotal(calTotalAir());
/*        if (id.equals("00020020")) {
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
        }*/
    }
    String checkInAverageAirCondition(String dust,String ultraDust,String CO2){
        String orderData;
        if(dust.charAt(0)=='R' || ultraDust.charAt(0)=='R' || CO2.charAt(0)=='R'){
            orderData = red+ "매우 나쁨";
        }
        else if(dust.charAt(0)=='Y' || ultraDust.charAt(0)=='Y' || CO2.charAt(0)=='Y') {
            orderData = yellow + "나쁨";
        }
        else{
            orderData = green + "좋음";
        }
        return orderData;
    }

    String checkOutAverageAirCondition(String dust,String ultraDust){
        String orderData;
        if(dust.charAt(0)=='R' || ultraDust.charAt(0)=='R' ){
            orderData = red+ "매우 나쁨";
        }
        else if(dust.charAt(0)=='Y' || ultraDust.charAt(0)=='Y') {
            orderData = yellow + "나쁨";
        }
        else{
            orderData = green + "좋음";
        }
        return orderData;
    }
    String calTotalAir(){
        int val=0;
        if(getDust().charAt(0)=='Y') val+=2;
        else if(getDust().charAt(0)=='R') val+=4;

        if(getUltraDust().charAt(0)=='Y') val+=2;
        else if(getUltraDust().charAt(0)=='R') val+=4;

        if(getCO2().charAt(0)=='Y') val+=2;
        else if(getCO2().charAt(0)=='R') val+=4;

        if(val >= 10) val = 10;

        if(getOutDUst().charAt(0)=='Y') val-=2;
        else if(getOutDUst().charAt(0)=='R') val-=4;

        if(getOutUltraDust().charAt(0)=='Y') val-=3;
        else if(getOutUltraDust().charAt(0)=='R') val-=5;

        String answer;
        if(val < 0) val = 0;
        if(val < 4) answer = green + val;
        else if(val < 7) answer = yellow + val;
        else answer = red + val;
        return answer;
    }


    public String checkDanger(int data, int standard1,int standard2){
        String orderData;

        if(data > standard1){
            orderData = red;
        }
        else if(data > standard2){
            orderData = yellow;
        }
        else {
            orderData = green;
        }

        orderData += data;

        return orderData;
    }
}