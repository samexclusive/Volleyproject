package com.example.hari.volleyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    RequestQueue queue;
    List<Moviedetails> movieDetailsList;
    Movieadapter myAdapter;
    String URLAPI="https://api.themoviedb.org/3/movie/upcoming?api_key=3a8db9365ef8230546828da9de5a39ab&language=en-US&page=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        Cache cache = new DiskBasedCache(getCacheDir(),2048 * 2048);

        Network network = new BasicNetwork(new HurlStack());


        queue = Volley.newRequestQueue(this);
        String Jsonrequest = "https://api.themoviedb.org/3/movie/upcoming?api_key=3a8db9365ef8230546828da9de5a39ab&language=en-US&page=1";

       /* StringRequest stringRequest = new StringRequest(Request.Method.GET, Jsonrequest,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });*/
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Jsonrequest,null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    movieDetailsList= new ArrayList<Moviedetails>();
                    JSONObject jObject = new JSONObject(URLAPI);
                    JSONArray jarray = jObject.getJSONArray("results");

                    for(int i=0;i<jarray.length();i++)
                    {
                        Moviedetails movieDetails = new Moviedetails();
                        JSONObject jobj = jarray.getJSONObject(i);
                        String moviename=jobj.getString("title");
                        String poster = jobj.getString("poster_path");
                        String desc = jobj.getString("overview");
                        movieDetails.setMovietitle(moviename);
                        movieDetails.setDesc(desc);
                        movieDetails.setPoster(poster);
                        movieDetailsList.add(movieDetails);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                myAdapter = new Movieadapter(MainActivity.this, movieDetailsList);
                listView.setAdapter(myAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }
        );
       queue.add(jsonObjectRequest);
    }
}
