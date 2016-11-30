package com.example.team23.story;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;

import java.util.UUID;

public class StoryAcivity extends SingleFragmentActivity {

    private static final String EXTRA_STORY_ID =
            "com.example.team23.story.story_id";

    public static Intent newIntent(Context packageContext, UUID storyId) {
        Intent intent = new Intent(packageContext, StoryAcivity.class);
        intent.putExtra(EXTRA_STORY_ID, storyId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        UUID storyId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_STORY_ID);
        return StoryFragment.newInstance(storyId);
    }

}
