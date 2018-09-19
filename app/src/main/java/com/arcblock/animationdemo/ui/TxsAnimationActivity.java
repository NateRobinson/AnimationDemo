package com.arcblock.animationdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.arcblock.animationdemo.R;
import com.arcblock.animationdemo.ui.txs.slide.SlideOneActivity;

/**
 * Created by Nate on 2018/9/19
 **/
public class TxsAnimationActivity extends AppCompatActivity {

    private static final String[] types = {"Slide", "Explode", "Fade"};
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private String currentType = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txs_animation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Transition Animation");

        findViewById(R.id.slide_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("type", currentType);
                Intent intent = new Intent(TxsAnimationActivity.this, SlideOneActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        spinner = findViewById(R.id.spinner);
        //将可选内容与ArrayAdapter连接起来
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);

        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //将adapter 添加到spinner中
        spinner.setAdapter(adapter);

        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // ToastUtils.showShort("position=>" + position);
                currentType = types[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
