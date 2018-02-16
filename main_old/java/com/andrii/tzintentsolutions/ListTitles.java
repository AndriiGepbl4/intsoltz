package com.andrii.tzintentsolutions;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListTitles extends AppCompatActivity {

    private final String site = "http://mobile.intent-solutions.com/api/get-posts/";
    private ListView listView;

    ArrayList<Post> posts = new ArrayList<Post>();
    BoxAdapter boxAdapter;
    AdapterView.OnItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_titles);

        listView = (ListView) findViewById(R.id.lv_container);
        new Thread().execute();
    }

    public class Thread extends AsyncTask<Void, Void, String> {
        String fragmentParams = null;

        @Override
        protected String doInBackground(Void... voids) {
            GetJson json = new GetJson();
            return json.getJson(site);
        }

        @Override
        protected void onPostExecute(String jsonStr) {
            super.onPostExecute(jsonStr);

            try {
                JSONArray arrayTitles = new JSONArray(jsonStr);

                for (int i = 0; i < arrayTitles.length(); i++){
                    JSONObject dataJsonObj = arrayTitles.getJSONObject(i);
                    fragmentParams = dataJsonObj.toString();

                    posts.add(new Post(dataJsonObj.getString("product_to_category_id"),
                            dataJsonObj.getString("category_id"),
                            dataJsonObj.getString("post_id"),
                            dataJsonObj.getString("post_name"),
                            dataJsonObj.getString("post_image"),
                            dataJsonObj.getString("post_desk"),
                            dataJsonObj.getString("post_date"),
                            dataJsonObj.getString("post_user_id"),
                            dataJsonObj.getString("post_status")));
                }

                boxAdapter = new BoxAdapter(ListTitles.this, posts);
                listView.setAdapter(boxAdapter);


                itemClickListener = new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        FullTitle.post_id = posts.get(position).postId;

                        Intent intent = new Intent(ListTitles.this, FullTitle.class);
                        startActivity(intent);
                    }
                };

                listView.setOnItemClickListener(itemClickListener);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
