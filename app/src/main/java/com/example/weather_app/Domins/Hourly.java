package com.example.weather_app.Domins;

public class Hourly {

    private String hour;
    private int temp;
    private String picPath;

    public Hourly(String hour, int temp, String picPath) {
        this.hour = hour;
        this.temp = temp;
        this.picPath = picPath;
    }

    public String getHour() {
        return hour;
    }

    public int getTemp() {
        return temp;
    }

    public String getPicPath() {
        return picPath;
    }
}
