package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initFruit();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);     设置水平滚动
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruit() {
        for (int i = 0; i < 5; i++) {
            Fruit a = new Fruit(getRandomLengthName("A"), R.mipmap.ic_launcher);
            fruitList.add(a);
            Fruit b = new Fruit(getRandomLengthName("B"), R.mipmap.ic_launcher);
            fruitList.add(b);
            Fruit c = new Fruit(getRandomLengthName("C"), R.mipmap.ic_launcher);
            fruitList.add(c);
            Fruit d = new Fruit(getRandomLengthName("D"), R.mipmap.ic_launcher);
            fruitList.add(d);
            Fruit e = new Fruit(getRandomLengthName("E"), R.mipmap.ic_launcher);
            fruitList.add(e);
            Fruit f = new Fruit(getRandomLengthName("F"), R.mipmap.ic_launcher);
            fruitList.add(f);
            Fruit g = new Fruit(getRandomLengthName("G"), R.mipmap.ic_launcher);
            fruitList.add(g);
            Fruit h = new Fruit(getRandomLengthName("H"), R.mipmap.ic_launcher);
            fruitList.add(h);
        }
    }

    private String getRandomLengthName(String a) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < length;i++) {
            builder.append(a);
        }
        return builder.toString();
    }

}
