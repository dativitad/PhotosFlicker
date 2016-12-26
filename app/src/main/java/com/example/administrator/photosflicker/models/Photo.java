package com.example.administrator.photosflicker.models;

import com.example.administrator.photosflicker.utils.Constants;

import java.text.MessageFormat;

/**
 * Created by Administrator on 24.12.2016.
 */

public class Photo {

    private long id;
    private String secret;
    private int server;
    private int farm;
    private String title;
    private int isprimary;
    private int ispublic;
    private int isfriend;
    private int isfamily;

    public String composeUrl() {
        return MessageFormat.format(Constants.PHOTOS_URL, farm, server, id, secret);
    }

    public long getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

    public int getServer() {
        return server;
    }

    public int getFarm() {
        return farm;
    }

    public String getTitle() {
        return title;
    }

    public int getIsprimary() {
        return isprimary;
    }

    public int getIspublic() {
        return ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", secret='" + secret + '\'' +
                ", server=" + server +
                ", farm=" + farm +
                ", title='" + title + '\'' +
                ", isprimary=" + isprimary +
                ", ispublic=" + ispublic +
                ", isfriend=" + isfriend +
                ", isfamily=" + isfamily +
                '}';
    }
}
