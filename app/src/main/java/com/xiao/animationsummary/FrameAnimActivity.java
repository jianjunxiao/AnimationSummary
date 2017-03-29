package com.xiao.animationsummary;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
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
                start2();
//                start1();
                break;
        }
    }

private void start1() {
    AnimationDrawable ad = new AnimationDrawable();
    for (int i = 0; i < 7; i++) {
        Drawable drawable = getResources().getDrawable(getResources().getIdentifier("ic_fingerprint_" + i, "drawable", getPackageName()));
        ad.addFrame(drawable, 100);
    }
    ad.setOneShot(false);
    mImageView.setImageDrawable(ad);
    ad.start();
}

private void start2() {
    mImageView.setImageResource(R.drawable.frame_anim);
    AnimationDrawable animationDrawable = (AnimationDrawable) mImageView.getDrawable();
    animationDrawable.start();
}
}
