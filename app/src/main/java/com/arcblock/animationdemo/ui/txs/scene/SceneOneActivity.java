package com.arcblock.animationdemo.ui.txs.scene;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.arcblock.animationdemo.R;

public class SceneOneActivity extends AppCompatActivity {

	private Scene mSceneOne;
	private Scene mSceneTwo;
	private ViewGroup mSceneRoot;
	private boolean isOne = true;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scene);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Scene");

		mSceneRoot = findViewById(R.id.scene_root_fl);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

			mSceneOne = new Scene(mSceneRoot, (ViewGroup) mSceneRoot.findViewById(R.id.container));
			mSceneTwo = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_two, this);

			findViewById(R.id.change_btn).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					isOne = !isOne;
					if (isOne) {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
							ChangeBounds changeBounds = new ChangeBounds();
							changeBounds.setDuration(1000);
							TransitionManager.go(mSceneOne,changeBounds);
						}
					} else {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
							ChangeBounds changeBounds = new ChangeBounds();
							changeBounds.setDuration(1000);
							TransitionManager.go(mSceneTwo,changeBounds);
						}
					}
				}
			});
		}

	}
}
