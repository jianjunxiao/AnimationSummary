package com.xiao.animationsummary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xiao.animationsummary.adapter.TransitionAdapter;
import com.xiao.animationsummary.bean.Star;

import java.util.ArrayList;
import java.util.List;

public class TransitionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        init();
    }

    private void init() {
        ListView listView = (ListView) findViewById(R.id.lv_transition);
        TransitionAdapter adapter = new TransitionAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        List<Star> stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Star star = new Star();
            star.setName("赵丽颖");
            star.setImg(R.drawable.girl);
            star.setInfo(getString(R.string.info));
            stars.add(star);
        }
        adapter.addData(stars);
    }

    public void explode(View view) {
        Intent intent = new Intent(this, NextTransitionActivity.class);
        intent.putExtra("flag", "explode");
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public void slide(View view) {
        Intent intent = new Intent(this, NextTransitionActivity.class);
        intent.putExtra("flag", "slide");
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public void fade(View view) {
        Intent intent = new Intent(this, NextTransitionActivity.class);
        intent.putExtra("flag", "fade");
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TransitionAdapter.TransitionViewHolder holder = (TransitionAdapter.TransitionViewHolder) view.getTag();
        View shareViewImg = holder.civImg;
        View shareViewName = holder.tvName;
        Intent intent = new Intent(this, NextTransitionActivity.class);
        intent.putExtra("flag", "share");
        Pair<View,String> pair1 =  Pair.create(shareViewImg, "shareView_img");
        Pair<View,String> pair2 =  Pair.create(shareViewName, "shareView_img");
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                pair1,
                pair2)
                .toBundle());
    }
}
