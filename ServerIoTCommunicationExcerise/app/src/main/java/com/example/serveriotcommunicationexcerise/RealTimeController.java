package com.example.serveriotcommunicationexcerise;

import android.widget.TextView;

public class RealTimeController {
//    private static TextView inAirView,inTptView,outAirView,outTptView,dustView,ultraDustView,CO2View,humidityView;
    private static String inAir,inTpt,outAir,outTpt,dust,ultraDust,CO2,humidity;



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
            this.setCO2(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals("00020030")) {
            this.setDust(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals("00020035")) {
            this.setUltraDust(String.valueOf(Integer.parseInt(data)));
        }

        else if (id.equals("00020040")) {
            this.setInTpt(String.valueOf(Integer.parseInt(data) - 40));
        }

        else if (id.equals("00020045")) {
            this.setHumidity(String.valueOf(Integer.parseInt(data)));
        }
    }
}