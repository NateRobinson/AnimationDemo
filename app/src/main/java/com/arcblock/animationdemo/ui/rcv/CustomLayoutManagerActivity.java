package com.arcblock.animationdemo.ui.rcv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.arcblock.animationdemo.R;
import com.arcblock.animationdemo.layoutmanager.CustomLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
*  Created by Nate on 2018/9/26
**/
public class CustomLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private CustomAdapter mCustomAdapter;
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_manager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Custom LayoutManager");

        for (int i = 0; i < 30; i++) {
            datas.add("item" + i);
        }

        rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new CustomLayoutManager());

        mCustomAdapter = new CustomAdapter(R.layout.item_of_custom_layout_manager, datas);
        rcv.setAdapter(mCustomAdapter);
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


    private static class CustomAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public CustomAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.item_tv, item);
        }
    }
}
