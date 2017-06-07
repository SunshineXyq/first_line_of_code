package com.example.helloworld;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by XYQ on 2017/5/21.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        Button btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
        btn_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"EDIT",Toast.LENGTH_LONG).show();
            }
        });
    }
}
