package com.andrii.tz_intnt_sol_feb2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActBanner extends AppCompatActivity {

//    TextView text;
//    TextView tvAdsUrl;
    ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        text = (TextView) findViewById(R.id.text);
//        tvAdsUrl = (TextView) findViewById(R.id.tvAdsUrl);
        ivBanner = (ImageView) findViewById(R.id.ivBanner);
        ivBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActBanner.this, ActListTItles.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<DataBanner> callBanner = api.getBanner();

        callBanner.enqueue(new Callback<DataBanner>() {

            @Override
            public void onResponse(Call<DataBanner> call, Response<DataBanner> response) {
                DataBanner banner = response.body();
//                text.setText(banner.getAds_image());
//                tvAdsUrl.setText(banner.getAds_status());

                Picasso.with(ActBanner.this).load(banner.getAds_image()).into(ivBanner);
            }

            @Override
            public void onFailure(Call<DataBanner> call, Throwable t) {

            }
        });


    }
}
