package com.example.mentalhealthapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source { // class for source of the article

    @SerializedName("id")
    @Expose
    private String id; // id of the article

    @SerializedName("name")
    @Expose
    private String name; // name of the article

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
