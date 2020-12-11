package com.example.snowtam_kk.Controller;

import com.example.snowtam_kk.Model.Geo;
import com.example.snowtam_kk.Model.Snowtam;

import java.util.List;

public interface ApiVolley {
     List<Snowtam> jsonParseSnowtam(String url);
     List<Geo> jsonParseGeo(String url);
}
