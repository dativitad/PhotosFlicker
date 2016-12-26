package com.example.administrator.photosflicker.models;

import com.example.administrator.photosflicker.utils.Constants;

/**
 * Created by Administrator on 24.12.2016.
 */

public class Photoset {

    private long id;
    private long primary;
    private String secret;
    private int server;
    private int farm;
    private int photos;
    private int videos;
    private Content title;
    private Content description;
    private int needs_interstitial;
    private int visibility_can_see_set;
    private int count_views;
    private int count_comments;
    private int can_comment;
    private String date_create;
    private String date_update;

    public String composeUrl() {
        return String.format(Constants.PHOTOS_URL, farm, server, primary, secret, Constants.MEDIUM_SIZE);
    }

    public long getId() {
        return id;
    }

    public long getPrimary() {
        return primary;
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

    public int getPhotos() {
        return photos;
    }

    public int getVideos() {
        return videos;
    }

    public Content getTitle() {
        return title;
    }

    public Content getDescription() {
        return description;
    }

    public int getNeeds_interstitial() {
        return needs_interstitial;
    }

    public int getVisibility_can_see_set() {
        return visibility_can_see_set;
    }

    public int getCount_views() {
        return count_views;
    }

    public int getCount_comments() {
        return count_comments;
    }

    public int getCan_comment() {
        return can_comment;
    }

    public String getDate_create() {
        return date_create;
    }

    public String getDate_update() {
        return date_update;
    }

    @Override
    public String toString() {
        return "Photoset{" +
                "id=" + id +
                ", primary=" + primary +
                ", secret='" + secret + '\'' +
                ", server=" + server +
                ", farm=" + farm +
                ", photos=" + photos +
                ", videos=" + videos +
                ", title=" + title +
                ", description=" + description +
                ", needs_interstitial=" + needs_interstitial +
                ", visibility_can_see_set=" + visibility_can_see_set +
                ", count_views=" + count_views +
                ", count_comments=" + count_comments +
                ", can_comment=" + can_comment +
                ", date_create='" + date_create + '\'' +
                ", date_update='" + date_update + '\'' +
                '}';
    }
}
