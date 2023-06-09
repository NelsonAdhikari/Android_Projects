package com.aadim.classroom.notebook;

import android.graphics.Color;

public class Note {
    public Note(String title, String des, String category, Integer color, Long id) {
        this.title = title;
        this.des = des;
        this.category = category;
        this.color = color;
        this.id = id;
    }

    String title;
    String des;
    String category;
    Integer color;



    Long id;

    public Note(String title, String des, String category, Integer Color) {
        this.title = title;
        this.des = des;
        this.category = category;
        this.color= Color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getColor() {
        return color;
    }
}
