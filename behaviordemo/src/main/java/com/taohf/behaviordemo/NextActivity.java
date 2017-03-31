package com.taohf.behaviordemo;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public void showDialog(View view) {
        BottomSheetDialog dialog = new BottomSheetDialog(this);

        View contentView = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_share_dialog, null);

        dialog.setContentView(contentView);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        dialog.show();
    }
}
