package com.example.hari.volleyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hari on 14-06-2017.
 */

public class Movieadapter extends BaseAdapter {
    Context context;
    List<Moviedetails> movieDetailsList;

    public Movieadapter(Context context, List<Moviedetails> moviedetails){
        this.context = context;
        this.movieDetailsList=moviedetails;
    }

    @Override
    public int getCount() {
        return movieDetailsList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;
        TextView title = null;
        RatingBar ratingBar = null;
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_item,parent,false);
        }
        imageView = (ImageView) convertView.findViewById(R.id.imageView);
        title = (TextView) convertView.findViewById(R.id.textView);
        ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar3);
        Glide.with(convertView).load("https://image.tmdb.org/t/p/w500"+movieDetailsList.get(position).getPoster()).into(imageView);
        title.setText(movieDetailsList.get(position).getMovietitle());
        ratingBar.setRating(movieDetailsList.get(position).getRating());
        return convertView;
    }
}
