package com.example.helloworld;

import android.widget.ImageView;

/**
 * Created by XYQ on 2017/5/21.
 */

public class Fruit {
    private String name;
    private int imageViewId;

    public Fruit(String name,int imageViewId) {
        this.name = name;
        this.imageViewId = imageViewId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageViewId() {
        return imageViewId;
    }

    public void setImageViewId(int imageViewId) {
        this.imageViewId = imageViewId;
    }
}
