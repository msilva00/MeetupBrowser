package com.example.team23.story;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

//In Crime app this would be CrimeLab.java
public class StorySingleton {
    private static StorySingleton sStorySingleton;

    private List<Story> mStories;

    public static StorySingleton get(Context context){
        if(sStorySingleton == null){
            sStorySingleton = new StorySingleton(context);
        }
        return sStorySingleton;
    }
    private StorySingleton(Context context){
        mStories = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Story story = new Story();
            story.setName("Story #" + i);
            story.setDescription("Name, Description, etc. for Story #" + i);
            mStories.add(story);
        }
    }

    public List<Story> getStories() {
        return mStories;
    }

    //TODO: Create a search widget - Tony?


    //method for search through cards and finding the right match
    //array list
    //iterator
    //get what your searching for in a  variable
    //make new adapter
    //set recycle view to new adapter

    public ArrayList<Story> searchStory(String s){
        ArrayList<Story> searchList = new ArrayList<>();
        for(int i = 0; i < mStories.size(); i++){
            if(mStories.get(i).getName().contains(s)){
                searchList.add(mStories.get(i));
            }
        }
        return searchList;
    }

    public Story getStory(UUID id){
        for(Story story: mStories){
            if(story.getId().equals(id)){
                return story;
            }
        }
        return null;
    }
}
