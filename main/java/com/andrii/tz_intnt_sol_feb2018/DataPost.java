package com.andrii.tz_intnt_sol_feb2018;

/**
 * Created by Andrii on 13-Feb-18.
 */

public class DataPost {

    private String post_id;
    private String post_name;
    private String post_image;
    private String post_desk;
    private String post_date;
    private String post_user_id;
    private String post_status;

    public DataPost(String post_id, String post_name, String post_image, String post_desk, String post_date, String post_user_id, String post_status) {
        this.post_id = post_id;
        this.post_name = post_name;
        this.post_image = post_image;
        this.post_desk = post_desk;
        this.post_date = post_date;
        this.post_user_id = post_user_id;
        this.post_status = post_status;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public String getPost_image() {
        return post_image;
    }

    public String getPost_desk() {
        return post_desk;
    }

    public String getPost_date() {
        return post_date;
    }

    public String getPost_user_id() {
        return post_user_id;
    }

    public String getPost_status() {
        return post_status;
    }
}
