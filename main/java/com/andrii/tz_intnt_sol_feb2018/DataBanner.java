package com.andrii.tz_intnt_sol_feb2018;

/**
 * Created by Andrii on 11-Feb-18.
 */

public class DataBanner {
    private String ads_status;//показывать или нет рекламу
    private String ads_image; //Ссылка на картинку банера
    private String ads_url;  //урл куда перекидывать пользователя

    public DataBanner(String ads_status, String ads_image, String ads_url) {
        this.ads_status = ads_status;
        this.ads_image = ads_image;
        this.ads_url = ads_url;
    }

    public String getAds_status() {
        return ads_status;
    }

    public String getAds_image() {
        return ads_image;
    }

    public String getAds_url() {
        return ads_url;
    }
}
