package com.example.administrator.photosflicker.interfaces;

import com.example.administrator.photosflicker.models.RootPhotosModel;
import com.example.administrator.photosflicker.models.RootPhotosetsListModel;
import com.example.administrator.photosflicker.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 24.12.2016.
 */

public interface RestAPI {

    @GET(Constants.REST)
    Call<RootPhotosetsListModel> getPhotosetsList (
            @Query(Constants.METHOD) String method
    );

    @GET(Constants.REST)
    Call<RootPhotosModel> getPhotosetPhotos (
            @Query(Constants.METHOD) String method,
            @Query(Constants.PHOTOSET_ID) long photosetId
    );
}
