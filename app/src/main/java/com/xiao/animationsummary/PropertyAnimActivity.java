package com.xiao.animationsummary;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import static android.animation.ObjectAnimator.ofFloat;

public class PropertyAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim);
        init();
    }

    private void init() {
        mImageView = (ImageView) findViewById(R.id.image_view);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_view:
//                startPropertyAnimator();
                startAnimatorSet();
                startValueAnimator();
                break;
        }
    }

    private void startValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(300);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 动画更新过程中的动画值，可以根据动画值的变化来关联对象的属性，实现属性动画
                float value = (float) animation.getAnimatedValue();
                Log.d("ValueAnimator", "动画值：" + value);
            }
        });
    }

    private void startPropertyAnimator() {
        startJavaPropertyAnimator();
        startXmlPropertyAnimator();
    }

    private void startXmlPropertyAnimator() {
        Animator animator = AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.property_animator);
        animator.setTarget(mImageView);
        animator.start();
    }

    private void startJavaPropertyAnimator() {
        ofFloat(mImageView, "rotationY", 0f, 360f)
                .setDuration(2000)
                .start();
    }

    private void startAnimatorSet() {
//        startxmlPropertyAnimatorSet();
        startJavaPropertyAnimatorSet();
    }

    private void startxmlPropertyAnimatorSet() {
        Animator animator = AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.property_animator_set);
        animator.setTarget(mImageView);
        animator.start();
    }

    private void startJavaPropertyAnimatorSet() {
        Animator scaleXAnimator = ObjectAnimator.ofFloat(mImageView, "scaleX", 1, 0.5f);
        scaleXAnimator.setDuration(2000);
        Animator scaleYAnimator = ObjectAnimator.ofFloat(mImageView, "scaleY", 1, 0.5f);
        scaleYAnimator.setDuration(2000);
        Animator rotationXAnimator = ObjectAnimator.ofFloat(mImageView, "rotationX", 0, 360);
        rotationXAnimator.setDuration(2000);
        Animator rotationYAnimator = ObjectAnimator.ofFloat(mImageView, "rotationY", 0, 360);
        rotationYAnimator.setDuration(2000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimator)
                .with(scaleYAnimator)
                .before(rotationXAnimator)
                .after(rotationYAnimator);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // 动画开始
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // 动画结束
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // 动画取消
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // 动画重复
            }
        });
    }
}
