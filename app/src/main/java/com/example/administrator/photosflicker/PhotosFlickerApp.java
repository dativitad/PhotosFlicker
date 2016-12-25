package com.example.administrator.photosflicker;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 25.12.2016.
 */

public class PhotosFlickerApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

    }

    public static Context getAppContext() {
        return sContext;
    }
}
