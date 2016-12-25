package com.example.administrator.photosflicker.models;

import java.util.List;

/**
 * Created by Administrator on 25.12.2016.
 */

public class PhotosPaginatingModel extends BasePaginatingModel {

    private long id;
    private long primary;
    private String owner;
    private String ownername;
    private List<Photo> photo;
    private String title;


    public String getTitle() {
        return title;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public String getOwnername() {
        return ownername;
    }

    public String getOwner() {
        return owner;
    }

    public long getPrimary() {
        return primary;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PhotosPaginatingModel{" +
                "id=" + id +
                ", primary=" + primary +
                ", owner='" + owner + '\'' +
                ", ownername='" + ownername + '\'' +
                ", photo=" + photo +
                ", page=" + page +
                ", pages=" + pages +
                ", perpage=" + perpage +
                ", total=" + total +
                ", title='" + title + '\'' +
                '}';
    }
}
