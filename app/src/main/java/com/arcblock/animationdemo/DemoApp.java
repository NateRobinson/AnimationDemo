package com.arcblock.animationdemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
*  Created by Nate on 2018/9/19
**/
public class DemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
