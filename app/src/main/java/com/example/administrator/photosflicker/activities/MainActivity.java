package com.example.administrator.photosflicker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.fragments.DetailPhotoFragment;
import com.example.administrator.photosflicker.fragments.PhotoFlickerFragment;
import com.example.administrator.photosflicker.fragments.PhotosetsFragment;
import com.example.administrator.photosflicker.interfaces.RequestListener;
import com.example.administrator.photosflicker.models.Photo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RequestListener {

    @BindView(R.id.splashScreen) FrameLayout splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

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
    public void startDetailsFragment(Photo photoContent) {

        getSupportFragmentManager()
                .beginTransaction()
                .add(
                        R.id.mainContainer,
                        DetailPhotoFragment.newInstance(photoContent),
                        DetailPhotoFragment.TAG
                )
                .addToBackStack(DetailPhotoFragment.TAG)
                .commit();
    }

    @Override
    public boolean popBackStack() {
        return getSupportFragmentManager().popBackStackImmediate();
    }

    @Override
    public void hideSplashScreen() {
        splashScreen.setVisibility(View.GONE);
    }
}
