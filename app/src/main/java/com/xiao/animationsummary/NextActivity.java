package com.xiao.animationsummary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        setStartActivityAnim();
    }

    private void setStartActivityAnim() {
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
    }

    public void back(View view) {
        finish();
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
