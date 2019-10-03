package com.example.uicustomviews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //为了显示自定义的标题栏，要将系统自带的标题栏进行隐藏
        androidx.appcompat.app.ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
            actionbar.hide();
    }
}
