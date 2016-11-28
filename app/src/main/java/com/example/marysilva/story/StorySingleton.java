package com.example.marysilva.story;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//In Crime app this would be CrimeLab.java
public class StorySingleton {
    private static StorySingleton sStrorySingleton;

    private List<Story> mStories;

    public static StorySingleton get(Context context){
        if(sStrorySingleton == null){
            sStrorySingleton = new StorySingleton(context);
        }
        return sStrorySingleton;
    }
    private StorySingleton(Context context){
        mStories = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Story story = new Story();
            story.setName("Story #" + i);
            //story.setDescription("Name, Description, etc. for Story #" + i);
            mStories.add(story);
        }
    }

    public List<Story> getStories() {
        return mStories;
    }

    //TODO: Create a search widget - Tony?

    public Story getStory(UUID id){
        for(Story story: mStories){
            if(story.getId().equals(id)){
                return story;
            }
        }
        return null;
    }
}
