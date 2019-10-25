package com.example.serveriotcommunicationexcerise;

public class ConsumableController {
    private static String car_filter="20";
    private static String car_eng_oil="30";
    private static String car_break_oil="40";
    private static String car_accOil="50";
    private static String car_cool_water="60";

    private final String CAR_FILTER_ID = "00030060";
    private final String CAR_ENG_OIL_ID = "00030070";
    private final String CAR_BRAKEOIL_ID = "00030075";
    private final String CAR_ACCOIL_ID = "00030080";
    private final String CAR_COOLWAT_ID = "00030085";

    public String getCar_filter() {
        return car_filter;
    }

    public void setCar_filter(String car_filter) {
        ConsumableController.car_filter = car_filter;
    }

    public String getCar_eng_oil() {
        return car_eng_oil;
    }

    public void setCar_eng_oil(String car_eng_oil) {
        ConsumableController.car_eng_oil = car_eng_oil;
    }

    public String getCar_break_oil() {
        return car_break_oil;
    }

    public void setCar_break_oil(String car_break_oil) {
        ConsumableController.car_break_oil = car_break_oil;
    }

    public String getCar_accOil() {
        return car_accOil;
    }

    public void setCar_accOil(String car_accOil) {
        ConsumableController.car_accOil = car_accOil;
    }

    public String getCar_cool_water() {
        return car_cool_water;
    }

    public void setCar_cool_water(String car_cool_water) {
        ConsumableController.car_cool_water = car_cool_water;
    }

    public void setValues(String id, String data){
        switch (id){
            case CAR_FILTER_ID:
                setCar_filter(String.valueOf(Integer.parseInt(data)));
                break;
            case CAR_ENG_OIL_ID:
                setCar_eng_oil(String.valueOf(Integer.parseInt(data)));
                break;
            case CAR_BRAKEOIL_ID:
                setCar_break_oil(String.valueOf(Integer.parseInt(data)));
                break;
            case CAR_ACCOIL_ID:
                setCar_accOil(String.valueOf(Integer.parseInt(data)));
                break;
            case CAR_COOLWAT_ID:
                setCar_cool_water(String.valueOf(Integer.parseInt(data)));
                break;
        }
    }
}
