package com.andrii.tzintentsolutions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrii on 15-Jan-18.
 */

class BoxAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Post> objects;

    BoxAdapter(Context context, ArrayList<Post> posts){
        ctx = context;
        objects= posts;
        lInflater = (LayoutInflater) ctx.
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

        Post post = getPost(position);

        ((TextView) view.findViewById(R.id.tvPostName)).setText(post.postName);
        ((TextView) view.findViewById(R.id.tvPostDesk)).setText(post.postDesk);
        ((TextView) view.findViewById(R.id.tvPostDate)).setText(post.postDate);
        ((TextView) view.findViewById(R.id.tvPostStatus)).setText(post.postStatus);

        new ImageLoaderTask(post.postImage, (ImageView) view.findViewById(R.id.ivPostImage)).execute();

        return view;
    }

    Post getPost(int position){
        return ((Post) getItem(position));
    }
}
