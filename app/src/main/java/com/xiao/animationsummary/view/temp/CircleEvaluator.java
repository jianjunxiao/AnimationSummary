package com.xiao.animationsummary.view.temp;

import android.animation.TypeEvaluator;
import android.graphics.Color;

/**
 * Created by XiaoJianjun on 2017/2/27.
 */

public class CircleEvaluator implements TypeEvaluator<Circle> {

    private Circle mCircle;

    public CircleEvaluator() {
        mCircle = new Circle();
    }

    @Override
    public Circle evaluate(float fraction, Circle startValue, Circle endValue) {

        int startRaduis = startValue.getRaduis();
        int endRaduis = endValue.getRaduis();
        int raduis = (int) (startRaduis + fraction * (endRaduis - startRaduis));

        int startColor = startValue.getColor();
        int endColor = endValue.getColor();
        int startColorRed = Color.red(startColor);
        int startColorGreen = Color.green(startColor);
        int startColorBlue = Color.blue(startColor);
        int endColorRed = Color.red(endColor);
        int endColorGreen = Color.green(endColor);
        int endColorBlue = Color.blue(endColor);
        int colorRed = (int) (startColorRed + fraction * (endColorRed - startColorRed));
        int colorGreen = (int) (startColorGreen + fraction * (endColorGreen - startColorGreen));
        int colorBlue = (int) (startColorBlue + fraction * (endColorBlue - startColorBlue));
        int color = Color.rgb(colorRed, colorGreen, colorBlue);

        int startElevation = startValue.getElevation();
        int endElevation = endValue.getElevation();
        int elevation = (int) (startElevation + fraction * (endElevation - startElevation));

        mCircle.setRaduis(raduis);
        mCircle.setColor(color);
        mCircle.setElevation(elevation);

        return mCircle;
    }
}
