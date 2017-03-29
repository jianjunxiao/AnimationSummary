package com.xiao.animationsummary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

public class NextTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        switch (getIntent().getStringExtra("flag")) {
            case "explode":
                getWindow().setEnterTransition(new Explode());
                getWindow().setExitTransition(new Explode());
                break;
            case "slide":
                getWindow().setEnterTransition(new Slide());
                getWindow().setExitTransition(new Slide());
                break;
            case "fade":
                getWindow().setEnterTransition(new Fade());
                getWindow().setExitTransition(new Fade());
                break;
            case "share":
                break;
        }
        setContentView(R.layout.activity_next_transition);
    }
}
