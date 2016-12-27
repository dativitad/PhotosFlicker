package com.example.administrator.photosflicker.interfaces;

import com.example.administrator.photosflicker.models.Photo;

/**
 * Created by Administrator on 26.12.2016.
 */

public interface RequestListener {

    void startPhotoFlickerFragment(long photosetId);
    void startDetailsFragment(Photo photoContent);
    boolean popBackStack();
    void hideSplashScreen();
}
