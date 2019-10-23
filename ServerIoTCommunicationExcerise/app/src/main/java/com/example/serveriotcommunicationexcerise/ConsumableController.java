package com.example.serveriotcommunicationexcerise;

public class ConsumableController {
    private static String airFilter="20", engineOil="20",coolingWater="20",breakOil="20",gearOil="20";
    final String AIR_FILTER_ID = "1", ENGINE_OIL_ID = "2",COOLING_WATER_ID = "3", BREAK_OIL_ID = "4",GEAR_OIL_ID = "5";
    public String getAirFilter() {
        return airFilter;
    }

    public void setAirFilter(String airFilter) {
        ConsumableController.airFilter = airFilter;
    }

    public String getEngineOil() {
        return engineOil;
    }

    public void setEngineOil(String engineOil) {
        ConsumableController.engineOil = engineOil;
    }

    public String getCoolingWater() {
        return coolingWater;
    }

    public void setCoolingWater(String coolingWater) {
        ConsumableController.coolingWater = coolingWater;
    }

    public String getBreakOil() {
        return breakOil;
    }

    public void setBreakOil(String breakOil) {
        ConsumableController.breakOil = breakOil;
    }

    public  String getGearOil() {
        return gearOil;
    }

    public  void setGearOil(String gearOil) {
        ConsumableController.gearOil = gearOil;
    }
    public void setValues(String id, String data){
        switch (id){
            case AIR_FILTER_ID:
                setAirFilter(data);
                break;
            case ENGINE_OIL_ID:
                setEngineOil(data);
                break;
            case GEAR_OIL_ID:
                setGearOil(data);
                break;
            case BREAK_OIL_ID:
                setBreakOil(data);
                break;
            case COOLING_WATER_ID:
                setCoolingWater(data);
                break;
        }
    }
}
