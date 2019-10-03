package com.example.uicustomviews;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.AttributedCharacterIterator;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        //from()方法构造出一个LayoutInflater对象，调用该对象的inflate()方法动态加载布局文件
        //inflate()方法的第一个参数是要加载的布局文件的id，第二个参数是给加载好的布局文件再添加一个父布局
        LayoutInflater.from(context).inflate(R.layout.title, this);

        //为标题栏中的按钮注册点击事件
        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);
        //点击Back按钮销毁当前活动
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
        //点击Edit按钮弹出一段文本
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked Edit button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
