package com.xiao.animationsummary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivityAnimActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_anim);
    setStartActivityAnim();
}

    private void setStartActivityAnim() {
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
    }

    public void goNext(View view) {
        startActivity(new Intent(this, NextActivity.class));
    }

    @Override
    public void finish() {
        super.finish();
        setEndActivityAnim();
    }

    private void setEndActivityAnim() {
        overridePendingTransition(R.anim.activity_left_in, R.anim.activity_right_out);
    }
}
