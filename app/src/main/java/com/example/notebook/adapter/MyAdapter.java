package com.example.notebook.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notebook.R;
import com.example.notebook.entity.User;

import java.util.List;

/**
 * Created by lenovo on 2018/10/14.
 */

public class MyAdapter extends ArrayAdapter<User> {
    int resource;
    public MyAdapter(Context context, int resource, List<User> list){
        super(context,resource,list);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource,parent,false);

            holder = new ViewHolder();
            holder.tv_name = convertView.findViewById(R.id.item_name);
            holder.tv_phone = convertView.findViewById(R.id.item_phone);
            holder.tv_time = convertView.findViewById(R.id.item_time);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_name.setText(user.getName());
        holder.tv_phone.setText(user.getPhone());
        holder.tv_time.setText(user.getTime());
        return convertView;
    }

    class ViewHolder{
        TextView tv_name;
        TextView tv_phone;
        TextView tv_time;
    }
}
