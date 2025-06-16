package com.example.weather_app.Domins;

public class TommorrowDomain {
    private String day;
    private String picPath;
    private int maxTemp;
    private int minTemp;
    private String status;

    public TommorrowDomain(String day, String picPath, int maxTemp, int minTemp, String status) {
        this.day = day;
        this.picPath = picPath;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public String getPicPath() {
        return picPath;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public String getStatus() {
        return status;
    }
}
