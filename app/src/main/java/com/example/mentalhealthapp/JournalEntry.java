package com.example.mentalhealthapp;

public class JournalEntry {
    private int id;
    private String title;
    private String content;
    private int day;

    public JournalEntry(int id, String title, String content, int day, int month, int year) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private int month;
    private int year;

    public JournalEntry(String title, String content, int day, int month, int year) {
        this.title = title;
        this.content = content;
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public int getDay() {
        return day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
