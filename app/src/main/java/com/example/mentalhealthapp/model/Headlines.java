package com.example.mentalhealthapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Headlines { // class for article headlines

    @SerializedName("status")
    @Expose
    private String status; // headlines status

    @SerializedName("totalResults")
    @Expose
    private String totalResults; // total headlines

    @SerializedName("articles")
    @Expose
    private List<Articles> articles; // total articles

    // getters and setters

    public String getStatus() {
        return status;
    }

    public List<Articles> getArticles() {
        return articles;
    }

}
