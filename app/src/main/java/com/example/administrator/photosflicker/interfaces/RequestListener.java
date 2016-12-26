package com.example.administrator.photosflicker.interfaces;

/**
 * Created by Administrator on 26.12.2016.
 */

public interface RequestListener {

    void startPhotoFlickerFragment(long photosetId);
    void startDetailsFragment();
    boolean popBackStack();
}
