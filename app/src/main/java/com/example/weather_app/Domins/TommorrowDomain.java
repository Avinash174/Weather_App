package com.example.weather_app.Domins;

public class TommorrowDomain {
    private String day;
    private String picPath;
    private String status;
    private int maxTemp;
    private int minTemp;

    public TommorrowDomain(String day, String picPath, String status, int maxTemp, int minTemp) {
        this.day = day;
        this.picPath = picPath;
        this.status = status;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay() { return day; }
    public String getPicPath() { return picPath; }
    public String getStatus() { return status; }
    public int getMaxTemp() { return maxTemp; }
    public int getMinTemp() { return minTemp; }
}
