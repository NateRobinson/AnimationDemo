package com.arcblock.animationdemo.ui.txs.shareelement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcblock.animationdemo.R;

public class ShareElementOneActivity  extends AppCompatActivity{

    private ImageView icon_iv;
    private TextView title_tv;
    private TextView desc_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_one);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Share-Elements-One");

        icon_iv = findViewById(R.id.icon_iv);
        title_tv = findViewById(R.id.title_tv);
        desc_tv = findViewById(R.id.desc_tv);

        findViewById(R.id.item_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareElementOneActivity.this, ShareElementTwoActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    Pair<View, String> shareViewOne = new Pair<>((View)icon_iv, "icon");
                    Pair<View, String> shareViewTwo = new Pair<>((View)title_tv, "title");
                    Pair<View, String> shareViewThree = new Pair<>((View)desc_tv, "desc");
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(ShareElementOneActivity.this, shareViewOne, shareViewTwo, shareViewThree);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
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
