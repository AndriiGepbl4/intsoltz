package com.andrii.tzintentsolutions;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class Banner extends AppCompatActivity {

    private final String site = "http://mobile.intent-solutions.com/api/get-banner/";
    private ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        ivBanner = (ImageView)findViewById(R.id.image_banner);
        ivBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Banner.this, ListTitles.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread().execute();
    }

    class Thread extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            GetJson json = new GetJson();
            String getJson = json.getJson(site);
            return getJson;
        }

        @Override
        protected void onPostExecute(String getJson) {
            super.onPostExecute(getJson);
            try {
                JSONObject dataJsonObject = new JSONObject(getJson);
                String image = dataJsonObject.getString("ads_image");
                new ImageLoaderTask(image, ivBanner).execute();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
