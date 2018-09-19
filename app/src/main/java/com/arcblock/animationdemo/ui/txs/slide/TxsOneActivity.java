package com.arcblock.animationdemo.ui.txs.slide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.arcblock.animationdemo.R;
import com.blankj.utilcode.util.ActivityUtils;

/**
 * Created by Nate on 2018/9/19
 **/
public class TxsOneActivity extends AppCompatActivity {

    private String type = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_one);

        if (getIntent() != null) {
            type = getIntent().getExtras().getString("type");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Transition-Slide-One");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setAllowReturnTransitionOverlap(false);

            // 从 one 进入 two 页面， one 页面的动画
            Slide transition = null;
            transition = new Slide(Gravity.LEFT);
            transition.setDuration(5000);
            transition.setInterpolator(new DecelerateInterpolator());
            transition.setMode(Visibility.MODE_OUT);
            getWindow().setExitTransition(transition);

        }

        findViewById(R.id.go_to_next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    Bundle bundle = new Bundle();
                    bundle.putString("type", type);
                    Intent intent = new Intent(TxsOneActivity.this, TxsTwoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(TxsOneActivity.this).toBundle());
                } else {
                    ActivityUtils.startActivity(TxsTwoActivity.class);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://返回键的id
                this.finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
