package com.xiao.animationsummary;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xiao.animationsummary.view.temp.Circle;
import com.xiao.animationsummary.view.temp.CircleEvaluator;
import com.xiao.animationsummary.view.temp.CircleView;

public class TypeEvaluatorActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleView mCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_evaluator);
        init();
    }

    private void init() {
        mCircleView = (CircleView) findViewById(R.id.circle_view);
        mCircleView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circle_view:
//                start1();
                start2();
                break;
        }
    }

    private void start1() {
        Circle startCircle = new Circle(168, Color.RED, 0);
        Circle middleCircle = new Circle(300, Color.GREEN, 15);
        Circle endCircle = new Circle(450, Color.BLUE, 30);
        ObjectAnimator.ofObject(mCircleView, "circle", new CircleEvaluator(), startCircle, middleCircle, endCircle)
                .setDuration(5000)
                .start();
    }

    private void start2() {
        Circle startCircle = new Circle(168, Color.RED, 0);
        Circle middleCircle = new Circle(300, Color.GREEN, 15);
        Circle endCircle = new Circle(450, Color.BLUE, 30);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CircleEvaluator(), startCircle, middleCircle, endCircle);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Circle circle = (Circle) animation.getAnimatedValue();
                mCircleView.setCircle(circle);
            }
        });
        valueAnimator.start();
    }
}
