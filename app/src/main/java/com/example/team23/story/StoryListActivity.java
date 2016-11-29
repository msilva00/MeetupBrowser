package com.example.team23.story;
import android.support.v4.app.Fragment;




public class StoryListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new StoryListFragment();
    }
}
