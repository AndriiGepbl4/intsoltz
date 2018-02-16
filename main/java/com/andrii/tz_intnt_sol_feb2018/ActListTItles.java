package com.andrii.tz_intnt_sol_feb2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActListTItles extends AppCompatActivity {

    private ListView lv_container;
    private BoxAdapter boxAdapter;
    private AdapterView.OnItemClickListener itemClickListener;
    private List<DataListTitles> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_titles);

        lv_container = (ListView) findViewById(R.id.lv_container);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<DataListTitles>> dataPosts = api.getPosts();

        dataPosts.enqueue(new Callback<List<DataListTitles>>() {
            @Override
            public void onResponse(Call<List<DataListTitles>> call, Response<List<DataListTitles>> response) {
                posts = response.body();

                String[] postString = new String[posts.size()];
                for (int i = 0; i < posts.size(); i++){
                    postString[i] = posts.get(i).getPost_name();
                }

                boxAdapter = new BoxAdapter(ActListTItles.this, posts);
                lv_container.setAdapter(boxAdapter);

                itemClickListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getBaseContext(), ActPost.class);
                        intent.putExtra("post_id", "" + posts.get(position).getPost_id());
                        startActivity(intent);
                    }
                };

                lv_container.setOnItemClickListener(itemClickListener);
            }

            @Override
            public void onFailure(Call<List<DataListTitles>> call, Throwable t) {

            }
        });
    }}