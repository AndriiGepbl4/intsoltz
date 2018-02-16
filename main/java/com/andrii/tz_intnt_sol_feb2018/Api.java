package com.andrii.tz_intnt_sol_feb2018;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andrii on 11-Feb-18.
 */

public interface Api {

    String BASE_URL = "http://mobile.intent-solutions.com/api/";

    @GET("get-banner/")
    Call<DataBanner> getBanner();

    @GET("get-posts")
    Call<List<DataListTitles>> getPosts();

    @GET("get-post/?/")
    Call<DataPost> getPost(@Query("post_id") String postId);
//            http://mobile.intent-solutions.com/api/get-post/?post_id=1/
}
