package com.example.snowtam_kk.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.snowtam_kk.Adapter.SnowtamAdapter;
import com.example.snowtam_kk.Controller.ApiVolley;
import com.example.snowtam_kk.Model.Geo;
import com.example.snowtam_kk.Model.Snowtam;
import com.example.snowtam_kk.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ListSnowtams extends AppCompatActivity implements ApiVolley {

    //private TextView mTextView;
    private RequestQueue mQueue;
    private List<Snowtam> snowtamList;
    private List<Geo> geoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_snowtams);

        //mTextView = (TextView) findViewById(R.id.text);

        Intent intent = getIntent();
        snowtamList = new ArrayList<>();
        geoList = new ArrayList<>();



        ArrayList<String> ap1 = (ArrayList<String>) intent.getSerializableExtra("Aeroports");
        HashMap<Integer, String> ap2 = (HashMap<Integer, String>) intent.getSerializableExtra("Aeros");;
       /* String ap2 = (String) intent.getSerializableExtra("Aeroports2");
        String ap3 = (String) intent.getSerializableExtra("Aeroports3");
        String ap4 = (String) intent.getSerializableExtra("Aeroports4");
        */
        mQueue = Volley.newRequestQueue(this);
        //mTextView.setText("Bonjour "+ ap1.get(0)+ "\n\n");
        /*for (String a : ap1)
            this.snowtamList = jsonParseSnowtam("https://applications.icao.int/dataservices/api/notams-realtime-list?api_key=4d9fb4c0-3b1b-11eb-906e-773d4e58062b&format=json&criticality=1&locations="+a);
    */
        for (String a : ap1)
            snowtamList.add( new Snowtam(a+"B) 2012081235 C) 2103252359", 67.269203186035, 14.365300178528));
        for (String a : ap1)
            this.geoList = jsonParseGeo("https://api.aerisapi.com/places/airports/"+a+"?client_id=Bai5JpsbnHhSXT6YwqAvM&client_secret=EGDLX8uTPHaY2py4BynUfsFmZyeclKElN67jMk79");

        ListView shopListView = findViewById(R.id.listview_ids);
        shopListView.setAdapter(new SnowtamAdapter(this, snowtamList));
        /*
        if (snowtamList.size()!=0 && geoList.size()!=0 && ap1.size()!=0){

            for(int i = 0; i < ap1.size(); i++) {
                snowtamList.get(i).setLat(geoList.get(i).getLat());
                snowtamList.get(i).setLongis(geoList.get(i).getLongis());
            }

            ListView shopListView = findViewById(R.id.listview_ids);
            shopListView.setAdapter(new SnowtamAdapter(this, snowtamList));
        }

         */
    }




    @Override
    public List<Snowtam>  jsonParseSnowtam(String url) {
        final List<Snowtam> snowtams = new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest (Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //JSONArray mJsonArray = new JSONArray(response);

                                JSONObject data = response.getJSONObject(0);

                                String all = data.getString("all");
                                String[] arrOfStr = all.split("\\)");
                                /*int id = data.getInt("id");
                                String email = data.getString("email");*/
                                /*for (String a : arrOfStr)
                                    mTextView.append(a+"\n");
                                 */
                                String snows="";
                                for(int i = 2; i < arrOfStr.length; i++) {
                                    snows=snows+arrOfStr[i];
                                    //mTextView.append(arrOfStr[i]);
                                }

                                snowtams.add(new Snowtam(snows, 0,0));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });
                        mQueue.add(request);
                        return snowtams;
                }

    @Override
    public List<Geo> jsonParseGeo(String url) {
        final List<Geo> geos = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest (Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("response");

                            JSONObject data = jsonObject.getJSONObject("loc");

                            double lat = Double.parseDouble(data.getString("lat"));

                            double longis = Double.parseDouble(data.getString("long"));


                            //mTextView.append("lat: "+String.valueOf(lat)+ "long: "+String.valueOf(longis) + "\n\n");

                            geos.add(new Geo(lat, longis));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
        return geos;
    }


}