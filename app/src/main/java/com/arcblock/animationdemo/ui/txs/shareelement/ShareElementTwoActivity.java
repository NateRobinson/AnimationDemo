package com.arcblock.animationdemo.ui.txs.shareelement;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionSet;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.BounceInterpolator;

import com.arcblock.animationdemo.R;

public class ShareElementTwoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS); // 必须
        setContentView(R.layout.activity_share_element_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Share-Elements-Two");

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionSet transitionSet = new TransitionSet();
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setInterpolator(new BounceInterpolator());
            changeBounds.setDuration(800);
            transitionSet.addTransition(changeBounds);
            getWindow().setSharedElementEnterTransition(transitionSet);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://返回键的id
                this.onBackPressed();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
