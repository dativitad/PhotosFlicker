package com.example.administrator.photosflicker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.fragments.DetailPhotoFragment;
import com.example.administrator.photosflicker.fragments.PhotoFlickerFragment;
import com.example.administrator.photosflicker.fragments.PhotosetsFragment;
import com.example.administrator.photosflicker.interfaces.RequestListener;
public class MainActivity extends AppCompatActivity implements RequestListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPhotosetsFragment();
    }

    public void startPhotosetsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(
                        R.id.mainContainer,
                        new PhotosetsFragment(),
                        PhotosetsFragment.TAG
                )
                .commit();
    }

    @Override
    public void startPhotoFlickerFragment(long photosetId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(
                        R.id.mainContainer,
                        PhotoFlickerFragment.newInstance(photosetId),
                        PhotoFlickerFragment.TAG
                )
                .addToBackStack(PhotoFlickerFragment.TAG)
                .commit();
    }

    @Override
    public void startDetailsFragment() {

        getSupportFragmentManager()
                .beginTransaction()
                .add(
                        R.id.mainContainer,
                        new DetailPhotoFragment(),
                        DetailPhotoFragment.TAG
                )
                .addToBackStack(DetailPhotoFragment.TAG)
                .commit();
    }

    @Override
    public boolean popBackStack() {
        return getSupportFragmentManager().popBackStackImmediate();
    }
}
