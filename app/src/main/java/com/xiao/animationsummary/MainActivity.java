package com.xiao.animationsummary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button btnViewAnim = (Button) findViewById(R.id.btn_view_anim);
        Button btnPropertyAnim = (Button) findViewById(R.id.btn_property_anim);
        Button btnFrameAnim = (Button) findViewById(R.id.btn_frame_anim);
        Button btnTypeEvaluator = (Button) findViewById(R.id.btn_type_evaluator);
        Button btnLayoutAnimation = (Button) findViewById(R.id.btn_layoutanimation);
        Button btnLayoutTransition = (Button) findViewById(R.id.btn_layout_transition);
        Button btnActivityAnim1 = (Button) findViewById(R.id.btn_activity_anim_1);
        Button btnActivityAnim2 = (Button) findViewById(R.id.btn_activity_anim_2);

        btnViewAnim.setOnClickListener(this);
        btnPropertyAnim.setOnClickListener(this);
        btnFrameAnim.setOnClickListener(this);
        btnTypeEvaluator.setOnClickListener(this);
        btnLayoutAnimation.setOnClickListener(this);
        btnLayoutTransition.setOnClickListener(this);
        btnActivityAnim1.setOnClickListener(this);
        btnActivityAnim2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_anim:
                startActivity(new Intent(this, ViewAnimActivity.class));
                break;
            case R.id.btn_property_anim:
                startActivity(new Intent(this, PropertyAnimActivity.class));
                break;
            case R.id.btn_frame_anim:
                startActivity(new Intent(this, FrameAnimActivity.class));
                break;
            case R.id.btn_type_evaluator:
                startActivity(new Intent(this, TypeEvaluatorActivity.class));
                break;
            case R.id.btn_layoutanimation:
                startActivity(new Intent(this, LayoutAnimationActivity.class));
                break;
            case R.id.btn_layout_transition:
                startActivity(new Intent(this, LayoutTransitionActivity.class));
                break;
            case R.id.btn_activity_anim_1:
                startActivity(new Intent(this, ActivityAnimActivity.class));
                break;
            case R.id.btn_activity_anim_2:
                startActivity(new Intent(this, TransitionActivity.class));
                break;
        }
    }
}
