package com.arcblock.animationdemo.ui.rcv;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcblock.animationdemo.R;
import com.arcblock.animationdemo.snaphelper.GallerySnapHelper;

import java.util.ArrayList;

public class CustomSnapHelperActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<String> mData;
    LinearLayoutManager mLayoutManager;
    GallerySnapHelper mGallerySnapHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap_helper);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Custom SnapHelper");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        initData();
        mRecyclerView.setAdapter(new SnapHelperAdapter(this, mData));
        mGallerySnapHelper = new GallerySnapHelper();
        mGallerySnapHelper.attachToRecyclerView(mRecyclerView);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            mData.add("i=" + i);
        }
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

    private static class SnapHelperAdapter extends RecyclerView.Adapter<SnapHelperAdapter.GalleryViewHoler> {
        LayoutInflater mInflater;
        ArrayList<String> mData;
        int[] imgs = new int[]{R.drawable.jdzz, R.drawable.ccdzz, R.drawable.dfh, R.drawable.dlzs, R.drawable.sgkptt, R.drawable.ttxss, R.drawable.zmq, R.drawable.zzhx};


        public SnapHelperAdapter(Context context, ArrayList<String> data) {
            mInflater = LayoutInflater.from(context);
            mData = data;

        }

        @Override
        public GalleryViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.gallery_item_layout, parent, false);

            return new GalleryViewHoler(view);
        }

        @Override
        public void onBindViewHolder(final GalleryViewHoler holder, int position) {
            holder.mImageView.setImageResource(imgs[position % 8]);
            holder.mTextView.setText(mData.get(position));

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class GalleryViewHoler extends RecyclerView.ViewHolder {
            public ImageView mImageView;
            public TextView mTextView;

            public GalleryViewHoler(View itemView) {
                super(itemView);
                mImageView = (ImageView) itemView.findViewById(R.id.image);
                mTextView = (TextView) itemView.findViewById(R.id.tv_num);
            }
        }
    }
}
