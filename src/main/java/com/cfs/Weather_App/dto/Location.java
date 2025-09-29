package com.cfs.Weather_App.dto;

public class Location
{

    public String name;

    public String region;

    public String country;

    public double lat;

    public double lon;

    public String tz_id;

    public int localtime_epoch;

    public String localtime;

    public Location(String name, String region, String country, double lat, double lon, String tz_id, int localtime_epoch, String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tz_id = tz_id;
        this.localtime_epoch = localtime_epoch;
        this.localtime = localtime;
    }

    public Location() {
    }

}
