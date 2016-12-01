package com.example.team23.story;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StoryListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private StoryAdapter mAdapter;
    private SearchView mSearchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_list, container, false);

        mRecyclerView = (RecyclerView) view
                .findViewById(R.id.story_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mSearchView = (SearchView) view.findViewById(R.id.search_view);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                StorySingleton storyLab = StorySingleton.get(getActivity());
                List<Story> stories = storyLab.getStories();
                for(int i = 0; i < stories.size(); i++){
                    if(!stories.get(i).getName().toLowerCase().equals(s)){
                        stories.remove(i);
                    }
                }
                if (mAdapter == null) {
                    mAdapter = new StoryAdapter(stories);
                    mRecyclerView.setAdapter(mAdapter);
                }
                else {
                    mAdapter.notifyDataSetChanged();
                }
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("TAGG",s);

                return false;
            }
        });
/*
        searchView = (SearchView) view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("TAGG",newText);

                return false;
            }
        });

*/
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        StorySingleton storyLab = StorySingleton.get(getActivity());
        List<Story> stories = storyLab.getStories();

        if (mAdapter == null) {
            mAdapter = new StoryAdapter(stories);
            mRecyclerView.setAdapter(mAdapter);
        }
        else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class StoryHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mStoryTextView;
        private TextView mDescriptionTextView;


        private Story mStory;

        public StoryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mStoryTextView = (TextView) itemView.findViewById(R.id.list_item_story_title_text_view);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.description);

        }

        public void bindStory(Story story) {
            mStory = story;
            mStoryTextView.setText(mStory.getName());
            mDescriptionTextView.setText(mStory.getDescription().toString());

        }

        @Override
        public void onClick(View v) {
            Intent intent = StoryAcivity.newIntent(getActivity(), mStory.getId());
            startActivity(intent);
        }
    }

    private class StoryAdapter extends RecyclerView.Adapter<StoryHolder> {

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
}
