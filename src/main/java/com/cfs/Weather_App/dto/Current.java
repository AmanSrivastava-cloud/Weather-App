package com.cfs.Weather_App.dto;

import javax.swing.*;

public class Current {

    public int last_updated_epoch;

    public String last_updated;

    public double temp_c;

    public double temp_f;

    public int is_day;

    public Condition condition;

    public double wind_mph;

    public double wind_kph;

    public int wind_degree;

    public String wind_dir;

    public double pressure_mb;

    public double pressure_in;

    public double precip_mm;

    public double precip_in;

    public int humidity;

    public int cloud;

    public double feelslike_c;

    public double feelslike_f;


    public double windchill_c;


    public double windchill_f;

    public double heatindex_c;

    public double heatindex_f;

    public double dewpoint_c;

    public double dewpoint_f;

    public double vis_km;

    public double vis_miles;

    public double uv;

    public double gust_mph;

    public double gust_kph;

    public double short_rad;

    public double diff_rad;

    public double dni;

    public double gti;

    public Current(int last_updated_epoch, String last_updated, double temp_c, double temp_f, int is_day, Condition condition, double wind_mph, double wind_kph, int wind_degree, String wind_dir, double pressure_mb, double pressure_in, double precip_mm, double precip_in, int humidity, int cloud, double feelslike_c, double feelslike_f, double windchill_c, double windchill_f, double heatindex_c, double heatindex_f, double dewpoint_c, double dewpoint_f, double vis_km, double vis_miles, double uv, double gust_mph, double gust_kph, double short_rad, double diff_rad, double dni, double gti) {
        this.last_updated_epoch = last_updated_epoch;
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.is_day = is_day;
        this.condition = condition;
        this.wind_mph = wind_mph;
        this.wind_kph = wind_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.pressure_mb = pressure_mb;
        this.pressure_in = pressure_in;
        this.precip_mm = precip_mm;
        this.precip_in = precip_in;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.windchill_c = windchill_c;
        this.windchill_f = windchill_f;
        this.heatindex_c = heatindex_c;
        this.heatindex_f = heatindex_f;
        this.dewpoint_c = dewpoint_c;
        this.dewpoint_f = dewpoint_f;
        this.vis_km = vis_km;
        this.vis_miles = vis_miles;
        this.uv = uv;
        this.gust_mph = gust_mph;
        this.gust_kph = gust_kph;
        this.short_rad = short_rad;
        this.diff_rad = diff_rad;
        this.dni = dni;
        this.gti = gti;
    }

    public Current() {
    }

    public double getTemp_c() {
        return temp_c;
    }

    public Condition getCondition() {
        return condition;
    }
}

