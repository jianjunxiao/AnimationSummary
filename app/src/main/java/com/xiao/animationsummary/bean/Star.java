package com.xiao.animationsummary.bean;

/**
 * Created by XiaoJianjun on 2017/3/28.
 */

public class Star {
    private String name;
    private int img;
    private String info;

    public Star(String name, int img, String info) {
        this.name = name;
        this.img = img;
        this.info = info;
    }

    public Star() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
