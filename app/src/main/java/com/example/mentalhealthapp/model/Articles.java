package com.example.mentalhealthapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articles { // Class for news articles


    @SerializedName("source")
    @Expose
    private Source source; // source of the article

    @SerializedName("author")
    @Expose
    private String author; // author of the article

    @SerializedName("title")
    @Expose
    private String title; // title of the article

    @SerializedName("description")
    @Expose
    private String description; // article description

    @SerializedName("url")
    @Expose
    private String url; // article url

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage; // article url image

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt; // where the article is published


    // getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

}