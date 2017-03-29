package com.xiao.animationsummary.view.temp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XiaoJianjun on 2017/2/27.
 */

public class CircleView extends View {
    private Circle circle;
    private Paint mPaint;

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circle = new Circle(168, Color.RED, 0);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setElevation(circle.getElevation());
        mPaint.setColor(circle.getColor());
        canvas.drawCircle(getMeasuredHeight() / 2, getMeasuredHeight() / 2, circle.getRaduis(), mPaint);
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
        postInvalidate();
    }

    public Circle getCircle() {
        return circle;
    }
}
