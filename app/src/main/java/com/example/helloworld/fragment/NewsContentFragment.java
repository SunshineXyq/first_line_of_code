package com.example.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloworld.R;

/**
 * Created by XYQ on 2017/5/28.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void refresh(String title,String content){
        View visiblility_layout = view.findViewById(R.id.visiblility_layout);
        visiblility_layout.setVisibility(View.VISIBLE);
        TextView news_title = (TextView) view.findViewById(R.id.news_title);
        TextView news_content = (TextView) view.findViewById(R.id.news_content);
        news_title.setText(title);
        news_content.setText(content);
    }
}
