package com.xiao.animationsummary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiao.animationsummary.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoJianjun on 2017/3/24.
 * 适配器
 */
public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<String> contents;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.contents = new ArrayList<>();
    }

    public void addData(String data) {
        contents.add(data);
        notifyDataSetChanged();
    }

    public void addData(List<String> datas) {
        contents.addAll(datas);
        notifyDataSetChanged();
    }

    public void deleteData() {
        if (!contents.isEmpty()) contents.remove(0);
        notifyDataSetChanged();
    }

    public void clear() {
        contents.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        MyViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item, parent, false);
            holder = new MyViewHolder();
            holder.tvContent = (TextView) view.findViewById(R.id.tv_item_content);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (MyViewHolder) view.getTag();
        }
        holder.tvContent.setText(contents.get(position));
        return view;
    }

    private class MyViewHolder {
        TextView tvContent;
    }
}
