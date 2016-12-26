package com.example.administrator.photosflicker.models;

/**
 * Created by Administrator on 25.12.2016.
 */

public class RootPhotosModel extends BaseRootModel {

    private PhotosPaginatingModel photoset;

    public PhotosPaginatingModel getPhotoset() {
        return photoset;
    }

    @Override
    public String toString() {
        return "RootPhotosModel{" +
                "photoset=" + photoset +
                ", stat='" + stat + '\'' +
                '}';
    }
}
