package com.taohf.appbase.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.taohf.appbase.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_layout);
    }
}
