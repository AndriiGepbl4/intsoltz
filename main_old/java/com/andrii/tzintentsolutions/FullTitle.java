package com.andrii.tzintentsolutions;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class FullTitle extends AppCompatActivity {

    private final String site = "http://mobile.intent-solutions.com/api/get-post/?post_id=";
    private final String LOG_TAG = "my_log";

    static String post_id;
    private TextView postName;
    private TextView postDesk;
    private TextView postUserId;
    private TextView postDate;
    private ImageView postImage;

    String getPostName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_title);

        postName = (TextView) findViewById(R.id.post_name);
        postDesk = (TextView) findViewById(R.id.post_desk);
        postUserId = (TextView) findViewById(R.id.post_user_id);
        postDate = (TextView) findViewById(R.id.post_date);
        postImage = (ImageView) findViewById(R.id.post_image);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread().execute();
    }

    public class Thread extends AsyncTask<Void, Void, String > {

        @Override
        protected String doInBackground(Void... voids) {
            GetJson json = new GetJson();
            String getJson = json.getJson(site + post_id);
            return getJson;
        }

        @Override
        protected void onPostExecute(String jsonStr) {
            super.onPostExecute(jsonStr);
            try {
                JSONObject dataJsonObject = new JSONObject(jsonStr);
                postName.setText(dataJsonObject.getString("post_name"));
                postDesk.setText(dataJsonObject.getString("post_desk"));
                postUserId.setText(dataJsonObject.getString("post_user_id"));
                postDate.setText(dataJsonObject.getString("post_date"));

                String image = dataJsonObject.getString("post_image");
                new ImageLoaderTask(image, postImage).execute();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.d(LOG_TAG, jsonStr);
            Log.d(LOG_TAG, "post name " + getPostName);
        }
    }
}
