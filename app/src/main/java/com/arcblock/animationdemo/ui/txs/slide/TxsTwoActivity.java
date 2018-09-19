package com.arcblock.animationdemo.ui.txs.slide;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.arcblock.animationdemo.R;

/**
 * Created by Nate on 2018/9/19
 **/
public class TxsTwoActivity extends AppCompatActivity {

    private String type = "";
    private static final String[] types = {"Slide", "Explode", "Fade"};
    private LinearLayout target_ll;

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

        target_ll = findViewById(R.id.target_ll);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setAllowReturnTransitionOverlap(false);
            // 进入动画
            Transition transition = null;
            switch (type) {
                case "Slide":
                    transition = new Slide(Gravity.LEFT);
                    ((Slide) transition).setMode(Visibility.MODE_IN);
                    transition.setInterpolator(new DecelerateInterpolator());
                    break;
                case "Explode":
                    transition = new Explode();
                    ((Explode) transition).setMode(Visibility.MODE_IN);
                    transition.setInterpolator(new DecelerateInterpolator());
                    break;
                case "Fade":
                    transition = new Fade();
                    ((Fade) transition).setMode(Visibility.MODE_IN);
                    transition.setInterpolator(new DecelerateInterpolator());
                    break;
            }
            if (transition != null) {
                //transition.addTarget(target_ll);
                transition.setDuration(500);
                getWindow().setEnterTransition(transition);
            }

            // 退出动画
            Slide slide = new Slide(Gravity.LEFT);
            slide.setDuration(500);
            slide.setMode(Visibility.MODE_OUT);
            slide.setInterpolator(new DecelerateInterpolator());
            getWindow().setReturnTransition(slide);
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
