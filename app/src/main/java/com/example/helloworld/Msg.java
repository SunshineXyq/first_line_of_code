package com.example.helloworld;

/**
 * Created by XYQ on 2017/5/21.
 */

class Msg {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private String content;
    private int flag;
    public static final int received = 0;
    public static final int send = 1;

    public Msg(String content, int flag) {
        this.content = content;
        this.flag = flag;
    }
}
