package com.xiao.animationsummary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;

import com.xiao.animationsummary.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class LayoutAnimationActivity extends AppCompatActivity {

    private ListView mListView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        init();
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.container);
        mAdapter = new MyAdapter(this);
        mListView.setAdapter(mAdapter);
        setLayoutAnimation();
    }

    private void setLayoutAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.layout_item_anim_set);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        mListView.setLayoutAnimation(controller);
    }

    public void addData(View view) {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("列表数据——>" + i);
        }
        mAdapter.addData(datas);
    }
}
