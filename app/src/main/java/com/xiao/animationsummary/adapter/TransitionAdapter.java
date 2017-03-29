package com.xiao.animationsummary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiao.animationsummary.R;
import com.xiao.animationsummary.bean.Star;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by XiaoJianjun on 2017/3/28.
 */

public class TransitionAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Star> stars;

    public TransitionAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.stars = new ArrayList<>();
    }

    public void addData(List<Star> stars) {
        this.stars.addAll(stars);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return stars.size();
    }

    @Override
    public Object getItem(int position) {
        return stars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        TransitionViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_transition, parent, false);
            holder = new TransitionViewHolder();
            holder.tvName = (TextView) view.findViewById(R.id.tv_trnsition_name);
            holder.civImg = (CircleImageView) view.findViewById(R.id.civ_transition_img);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (TransitionViewHolder) view.getTag();
        }
        holder.civImg.setImageResource(stars.get(position).getImg());
        holder.tvName.setText(stars.get(position).getName());
        return view;
    }

    public class TransitionViewHolder {
        public TextView tvName;
        public CircleImageView civImg;
    }
}
