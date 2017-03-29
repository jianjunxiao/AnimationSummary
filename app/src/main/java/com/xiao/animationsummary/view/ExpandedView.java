package com.xiao.animationsummary.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiao.animationsummary.R;

/**
 * Created by xiaoyanger on 2017/2/25.
 * 可展动画开关闭的View
 */
public class ExpandedView extends FrameLayout {

    private TextView mTvAnswer;
    private boolean isClosed;
    private ImageView mIvIndicator;

    public ExpandedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.expanded_view, this, true);
        LinearLayout llQuestion = (LinearLayout) view.findViewById(R.id.ll_expanded_question);
        llQuestion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                anim();
            }
        });
        mTvAnswer = (TextView) view.findViewById(R.id.tv_expanded_answer);
        mIvIndicator = (ImageView) view.findViewById(R.id.iv_expanded_indicator);
    }

    private void anim() {
        // 指示器旋转
        ValueAnimator valueAnimator1 = isClosed
                ? ValueAnimator.ofFloat(180, 0)
                : ValueAnimator.ofFloat(0, 180);
        valueAnimator1.setDuration(500);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mIvIndicator.setRotation(value);
            }
        });
        valueAnimator1.start();

        // 打开开关闭操作
        final int answerHeight = mTvAnswer.getMeasuredHeight();
        ValueAnimator valueAnimator2 = isClosed
                ? ValueAnimator.ofInt(-answerHeight, 0)
                : ValueAnimator.ofInt(0, -answerHeight);
        valueAnimator2.setDuration(500);
        final MarginLayoutParams params = (MarginLayoutParams) mTvAnswer.getLayoutParams();
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                params.bottomMargin = value;
                mTvAnswer.setLayoutParams(params);
            }
        });
        valueAnimator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isClosed = !isClosed;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator2.start();
    }
}
