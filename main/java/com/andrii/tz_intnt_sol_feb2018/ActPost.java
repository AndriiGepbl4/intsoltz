package com.andrii.tz_intnt_sol_feb2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActPost extends AppCompatActivity {

    private TextView postName;
    private TextView postDesk;
    private TextView postUserId;
    private TextView postDate;
    private ImageView postImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        String postNumber = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            postNumber = extras.getString("post_id");
            //The key argument here must match that used in the other activity
        }

        Log.d("MY_TAG", " " + postNumber);
//
//   String s = getIntent().getStringExtra("EXTRA_SESSION_ID");

        postName = (TextView) findViewById(R.id.post_name);
        postDesk = (TextView) findViewById(R.id.post_desk);
        postUserId = (TextView) findViewById(R.id.post_user_id);
        postDate = (TextView) findViewById(R.id.post_date);
        postImage = (ImageView) findViewById(R.id.post_image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<DataPost> dataPost = api.getPost(postNumber);

        dataPost.enqueue(new Callback<DataPost>(){

            @Override
            public void onResponse(Call<DataPost> call, Response<DataPost> response) {
                DataPost post = response.body();

                if(post.getPost_name().isEmpty()){
                    postName.setVisibility(View.GONE);
                }
                else {
                    postName.setText(post.getPost_name());
                }

                postDesk.setText(post.getPost_desk());
                postUserId.setText(post.getPost_user_id());
                postDate.setText(post.getPost_date());

                Picasso.with(ActPost.this)
                        .load(post.getPost_image())
                        .placeholder(R.mipmap.ic_wallpaper_black_24dp)
                        .into(postImage);
            }

            @Override
            public void onFailure(Call<DataPost> call, Throwable t) {

            }
        });
    }
}
