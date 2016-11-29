package com.example.team23.story;

import android.widget.ImageView;

import java.util.UUID;



public class Story {
    private UUID mUUID;
    private String mName;
    private String mDescription;
    private ImageView imageView;
    //TODO: A picture field ImageView should work - Worry about this later

    public Story(){
        mUUID = UUID.randomUUID();
        //TODO: add a description to this method - Tony? In the crime
        setDescription("This is a sample.");
        // app example this was the Date field.
    }

    public UUID getId() {
        return mUUID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
