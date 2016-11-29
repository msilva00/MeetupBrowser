package com.example.team23.story;

import android.support.v4.app.Fragment;

public class StoryAcivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new StoryFragment();
    }

}
