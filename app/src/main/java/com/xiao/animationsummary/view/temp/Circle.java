package com.xiao.animationsummary.view.temp;

/**
 * Created by XiaoJianjun on 2017/2/27.
 */

public class Circle {

    private int raduis;         // 半径
    private int color;          // 颜色
    private int elevation;      // 高度

    public Circle(int raduis, int color, int elevation) {
        this.raduis = raduis;
        this.color = color;
        this.elevation = elevation;
    }

    public int getRaduis() {
        return raduis;
    }

    public void setRaduis(int raduis) {
        this.raduis = raduis;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }
}
