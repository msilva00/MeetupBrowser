package com.example.team23.story;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;


public class StoryListFragment extends Fragment {

    private RecyclerView mStoryRecyclerView;
    private StoryAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_list, container, false);

        mStoryRecyclerView = (RecyclerView) view
                .findViewById(R.id.story_recycler_view);
        mStoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){
        StorySingleton storySingleton = StorySingleton.get(getActivity());
        List<Story> stories = storySingleton.getStories();

        mAdapter = new StoryAdapter(stories);
        mStoryRecyclerView.setAdapter(mAdapter);
    }

    public class StoryAdapter extends RecyclerView.Adapter<StoryHolder> {


        private List<Story> mStories;

        public StoryAdapter(List<Story> stories) {
            mStories = stories;
        }

        @Override
        public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_story, parent, false);
            return new StoryHolder(view);
        }
        @Override
        public void onBindViewHolder(StoryHolder holder, int position) {
            Story story = mStories.get(position);
            holder.bindStory(story);
        }

        @Override
        public int getItemCount() {
            return mStories.size();
        }
  }




  private class StoryHolder extends RecyclerView.ViewHolder {

      private TextView mTitleTextView;
      private TextView mDescription;
      private ImageView imageView;

      private Story mStory;

      public StoryHolder(View itemView) {
          super(itemView);
          //itemView.setOnClickListener();

          mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_story_title_text_view);
          mDescription = (TextView) itemView.findViewById(R.id.description);
          imageView = (ImageView) itemView.findViewById(R.id.imageView);
      }


      public void bindStory(Story story) {
          mStory = story;
          mTitleTextView.setText(mStory.getName());
          mDescription.setText(mStory.getDescription());
          //imageView.setImageResource(list.get(position).imageId);
      }
/*
      @Override
      public void onClick(View v) {
          Intent intent = new Intent(getActivity(), StoryAcivity.class);
          startActivity(intent);
      }*/


  }
}
