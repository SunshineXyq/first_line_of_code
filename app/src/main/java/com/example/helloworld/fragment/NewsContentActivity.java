package com.example.helloworld.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.helloworld.R;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String news_title = getIntent().getStringExtra("news_title");
        String news_content = getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager
                ().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(news_title,news_content);
    }

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);
    }
}
