package com.example.serveriotcommunicationexcerise;

public class ConsumableController {
    private static String car_filter="0";
    private static String car_eng_oil="0";
    private static String car_brakeoil="0";
    private static String car_accoil="0";
    private static String car_coolwat="0";

    private final String CAR_FILTER_ID = "1";
    private final String CAR_ENG_OIL_ID = "2";
    private final String CAR_BRAKEOIL_ID = "3";
    private final String CAR_ACCOIL_ID = "4";
    private final String CAR_COOLWAT_ID = "5";

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

    public String getCar_brakeoil() {
        return car_brakeoil;
    }

    public void setCar_brakeoil(String car_brakeoil) {
        ConsumableController.car_brakeoil = car_brakeoil;
    }

    public String getCar_accoil() {
        return car_accoil;
    }

    public void setCar_accoil(String car_accoil) {
        ConsumableController.car_accoil = car_accoil;
    }

    public String getCar_coolwat() {
        return car_coolwat;
    }

    public void setCar_coolwat(String car_coolwat) {
        ConsumableController.car_coolwat = car_coolwat;
    }

    public void setValues(String id, String data){
        switch (id){
            case CAR_FILTER_ID:
                setCar_filter(data);
                break;
            case CAR_ENG_OIL_ID:
                setCar_eng_oil(data);
                break;
            case CAR_BRAKEOIL_ID:
                setCar_brakeoil(data);
                break;
            case CAR_ACCOIL_ID:
                setCar_accoil(data);
                break;
            case CAR_COOLWAT_ID:
                setCar_coolwat(data);
                break;
        }
    }
}
