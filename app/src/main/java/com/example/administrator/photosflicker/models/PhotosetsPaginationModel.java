package com.example.administrator.photosflicker.models;

import java.util.List;

/**
 * Created by Administrator on 25.12.2016.
 */

public class PhotosetsPaginationModel extends BasePaginatingModel {

    private List<Photoset> photoset;

    public List<Photoset> getPhotoset() {
        return photoset;
    }

    @Override
    public String toString() {
        return "PhotosetsPaginationModel{" +
                "photoset=" + photoset +
                ", page=" + page +
                ", pages=" + pages +
                ", perpage=" + perpage +
                ", total=" + total +
                '}';
    }
}
