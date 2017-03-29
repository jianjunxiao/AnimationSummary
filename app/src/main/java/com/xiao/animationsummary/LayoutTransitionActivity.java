package com.xiao.animationsummary;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class LayoutTransitionActivity extends AppCompatActivity {

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition);
        init();
    }

    private void init() {
        mContainer = (LinearLayout) findViewById(R.id.container);
        setLayoutTransition();
    }

    private void setLayoutTransition() {
        LayoutTransition transition = new LayoutTransition();
        // 子View添加到mContainer时的动画
        Animator appearAnim = ObjectAnimator
                .ofFloat(null, "rotationX", 90, 0)
                .setDuration(transition.getDuration(LayoutTransition.APPEARING));
        transition.setAnimator(LayoutTransition.APPEARING, appearAnim);
        // 子Veiw从mContainer中移除时的动画
        Animator disappearAnim = ObjectAnimator
                .ofFloat(null, "rotationX", 0, 90)
                .setDuration(transition.getDuration(LayoutTransition.DISAPPEARING));
        transition.setAnimator(LayoutTransition.DISAPPEARING, disappearAnim);
        // 子Veiw添加到mContainer中时其他子View的动画
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 0);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 0);
        PropertyValuesHolder pvhTranslationY = PropertyValuesHolder
                .ofFloat("translationX", 0, 150, 0);
        Animator changeAppearAnim = ObjectAnimator
                .ofPropertyValuesHolder(mContainer, pvhLeft, pvhTop, pvhTranslationY)
                .setDuration(transition.getDuration(LayoutTransition.CHANGE_APPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeAppearAnim);
        // 子View从mContainer中移除时其他子View的动画
        PropertyValuesHolder outLeft = PropertyValuesHolder.ofInt("left", 0, 0);
        PropertyValuesHolder outTop = PropertyValuesHolder.ofInt("top", 0, 0);
        PropertyValuesHolder pvhTranslationYDis = PropertyValuesHolder
                .ofFloat("translationX", 0, -150, 0);
        ObjectAnimator changeDisAppearAnim = ObjectAnimator
                .ofPropertyValuesHolder(mContainer, outLeft, outTop, pvhTranslationYDis)
                .setDuration(transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeDisAppearAnim);

        mContainer.setLayoutTransition(transition);
    }

    // 添加子View到第0个位置
    public void addData(View view) {
        View child = LayoutInflater.from(this)
                .inflate(R.layout.item, mContainer, false);
        mContainer.addView(child, 0);
    }

    // 移除第0个子View
    public void deleteData(View view) {
        if (mContainer.getChildCount() != 0) mContainer.removeViewAt(0);
    }
}
