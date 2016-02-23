package com.meetpeople.lightsoo.mymeeting.Data;

import android.graphics.drawable.Drawable;

/**
 * Created by LG on 2016-02-18.
 */
public class MessageList {

    private Drawable icon;
    private String name;
    private String description;
    private String date;

    public MessageList(Drawable icon, String name, String description, String date){
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getIcon() {
        return icon;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date){
       this.date = date;
    }

    public String getDate(){
        return date;
    }
}
