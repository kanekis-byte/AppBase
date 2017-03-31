package com.taohf.behaviordemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class BehaviorActivity extends AppCompatActivity {

    private FrameLayout mShareView;
    private BottomSheetBehavior<FrameLayout> mSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);

        initView();
    }

    private void initView() {
        mShareView = (FrameLayout) findViewById(R.id.share_view);

        mSheetBehavior = BottomSheetBehavior.from(mShareView);

        mSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        mSheetBehavior.setHideable(true);

    }

    public void jump(View view) {
        startActivity(new Intent(this, NextActivity.class));
    }

    /*public void showBottomSheet(View view) {
        if (mSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            mSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            mSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }*/
}
