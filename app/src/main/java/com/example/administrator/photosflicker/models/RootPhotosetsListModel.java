package com.example.administrator.photosflicker.models;

/**
 * Created by Administrator on 25.12.2016.
 */

public class RootPhotosetsListModel extends BaseRootModel {

    private PhotosetsPaginationModel photosets;

    public PhotosetsPaginationModel getPhotosets() {
        return photosets;
    }

    @Override
    public String toString() {
        return "RootPhotosetsListModel{" +
                "photosets=" + photosets +
                ", stat='" + stat + '\'' +
                '}';
    }
}
