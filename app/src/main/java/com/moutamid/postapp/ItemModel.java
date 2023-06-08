package com.moutamid.postapp;

import java.util.ArrayList;

public class ItemModel {
    int profile;
    String name, time, location;
    ArrayList<String> images;
    String text;

    public ItemModel(int profile, String name, String time, String location, ArrayList<String> images, String text) {
        this.profile = profile;
        this.name = name;
        this.time = time;
        this.location = location;
        this.images = images;
        this.text = text;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
