package com.xiao.animationsummary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class ViewAnimActivity extends AppCompatActivity {

    private View mTargetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);
        init();
    }

    private void init() {
        mTargetView = findViewById(R.id.view_target);
    }

    private void xmlAnim(int xmlViewAnim) {
        Animation alphaAnim = AnimationUtils.loadAnimation(getApplicationContext(), xmlViewAnim);
        mTargetView.startAnimation(alphaAnim);
    }

    public void clickToAlpha(View view) {
//        xmlAnim(view_anim_alpha);
        javaAlphaAnim();
    }

    private void javaAlphaAnim() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(2000);
        mTargetView.startAnimation(alphaAnimation);
    }


    public void clickToRotate(View view) {
//        xmlAnim(R.anim.view_anim_rotate);
        javaRotateAnim();
    }

    private void javaRotateAnim() {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);
        mTargetView.startAnimation(rotateAnimation);
    }

    public void clickToScale(View view) {
//        xmlAnim(R.anim.view_anim_scale);
        javaScaleAnim();
    }

    private void javaScaleAnim() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 0.5f,
                1, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        mTargetView.startAnimation(scaleAnimation);
    }

    public void clickToTranslate(View view) {
//        xmlAnim(R.anim.view_anim_translate);
        javaTranslateAnim();
    }

    private void javaTranslateAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1);
        translateAnimation.setDuration(2000);
        mTargetView.startAnimation(translateAnimation);
    }

    public void clickToSet(View view) {
        javaSetAnim();
    }

    private void javaSetAnim() {

        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(2000);

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 0.5f,
                1, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1);
        translateAnimation.setDuration(2000);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);

        mTargetView.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 动画结束
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重复
            }
        });
    }
}
