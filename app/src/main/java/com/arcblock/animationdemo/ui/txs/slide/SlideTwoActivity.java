package com.arcblock.animationdemo.ui.txs.slide;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.arcblock.animationdemo.R;

/**
 * Created by Nate on 2018/9/19
 **/
public class SlideTwoActivity extends AppCompatActivity {

    private String type = "";
    private static final String[] types = {"Slide", "Explode", "Fade"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS); // 必须

        setContentView(R.layout.activity_slide_two);

        if (getIntent() != null) {
            type = getIntent().getExtras().getString("type");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Transition-Slide-Two");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = null;
            switch (type) {
                case "Slide":
                    transition = new Slide(Gravity.LEFT);
                    transition.setDuration(500);
                    transition.setInterpolator(new BounceInterpolator());
                    break;
                case "Explode":
                    transition = new Explode();
                    transition.setDuration(500);
                    transition.setInterpolator(new DecelerateInterpolator());
                    break;
                case "Fade":
                    transition = new Fade();
                    transition.setDuration(500);
                    transition.setInterpolator(new DecelerateInterpolator());
                    break;
            }
            if (transition != null) {
                getWindow().setEnterTransition(transition);
            }
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

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
    }
}
