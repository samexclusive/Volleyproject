package com.example.hari.volleyproject;

/**
 * Created by hari on 14-06-2017.
 */

public class Moviedetails {
    String Movietitle;
    Long    rating;
    String Desc;
    String poster;
    public String getMovietitle() {
        return Movietitle;
    }

    public Long getRating() {
        return rating;
    }

    public String getDesc() {
        return Desc;
    }

    public String getPoster() {
        return poster;
    }

    public void setMovietitle(String movietitle) {
        Movietitle = movietitle;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


}
