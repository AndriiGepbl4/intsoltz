package com.andrii.tz_intnt_sol_feb2018;

/**
 * Created by Andrii on 11-Feb-18.
 */

public class DataListTitles {

    private String product_to_category_id;
    private String category_id;
    private int post_id; //Ид категории
    private String post_name; // заголовок поста
    private String post_image; //урл на картинку - если нет ставим заглушшку
    private String post_desk; //полное описание поста
    private String post_date; // дата поста
    private String post_user_id;
    private String post_status;

    public DataListTitles(String product_to_category_id, String category_id, int post_id, String post_name, String post_image, String post_desk, String post_date, String post_user_id, String post_status) {
        this.product_to_category_id = product_to_category_id;
        this.category_id = category_id;
        this.post_id = post_id;
        this.post_name = post_name;
        this.post_image = post_image;
        this.post_desk = post_desk;
        this.post_date = post_date;
        this.post_user_id = post_user_id;
        this.post_status = post_status;
    }

    public String getProduct_to_category_id() {
        return product_to_category_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public int getPost_id() {
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
