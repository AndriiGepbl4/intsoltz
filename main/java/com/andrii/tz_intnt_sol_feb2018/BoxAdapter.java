package com.andrii.tz_intnt_sol_feb2018;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Andrii on 11-Feb-18.
 */

public class BoxAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    List<DataListTitles> objects;

    BoxAdapter(Context cntxt, List<DataListTitles> posts){
        context = cntxt;
        objects = posts;
        lInflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = lInflater.inflate(R.layout.activity_title_preview, parent, false);
        }

        DataListTitles post = getPost(position);

        ((TextView) view.findViewById(R.id.tvPostName)).setText(post.getPost_name());
        ((TextView) view.findViewById(R.id.tvPostDesk)).setText(post.getPost_desk());
        ((TextView) view.findViewById(R.id.tvPostDate)).setText(post.getPost_date());
        ((TextView) view.findViewById(R.id.tvPostStatus)).setText(post.getPost_status());

        Picasso.with(context)
                .load(post.getPost_image())
                .placeholder(R.mipmap.ic_wallpaper_black_24dp)
                .error(R.mipmap.ic_sms_black_24dp)
                .into((ImageView) view.findViewById(R.id.ivPostImage));

        return view;
    }

    DataListTitles getPost(int position){
        return ((DataListTitles) getItem(position));
    }
}
