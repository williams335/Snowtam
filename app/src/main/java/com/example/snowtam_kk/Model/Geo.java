package com.example.snowtam_kk.Model;

public class Geo {

    private double lat;
    private double longis;

    public Geo(double lat, double longis) {
        this.lat = lat;
        this.longis = longis;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongis() {
        return longis;
    }

    public void setLongis(double longis) {
        this.longis = longis;
    }
}
