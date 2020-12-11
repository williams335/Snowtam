package com.example.snowtam_kk.Model;



public class Snowtam {


    private String snows;
    private double lat;
    private double longis;

    public Snowtam(String snows, double lat, double longis) {
        this.snows = snows;
        this.lat = lat;
        this.longis = longis;
    }

    public String getSnows() {
        return snows;
    }

    public void setSnows(String snows) {
        this.snows = snows;
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
