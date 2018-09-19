package com.arcblock.animationdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arcblock.animationdemo.R;
import com.blankj.utilcode.util.ActivityUtils;

/**
*  Created by Nate on 2018/9/19
**/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.txs_ani_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(TxsAnimationActivity.class);
            }
        });
    }
}
