package com.example.administrator.photosflicker.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.models.Photo;
import com.example.administrator.photosflicker.utils.Constants;
import com.example.administrator.photosflicker.views.BetterImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 26.12.2016.
 */
public class DetailPhotoFragment extends BaseFragment {

    public static final String TAG = "DetailPhotoFragment";

    @BindView(R.id.photoContent) BetterImageView photoContent;

    public static DetailPhotoFragment newInstance(Photo photoContent) {

        Bundle args = new Bundle();
        args.putParcelable(Constants.PHOTO_CONTENT, photoContent);
        DetailPhotoFragment fragment = new DetailPhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(
                R.layout.fragment_detail_photo,
                container,
                false
        );

        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Photo photo = getArguments().getParcelable(Constants.PHOTO_CONTENT);

       initData(photo);
    }

    private void initData(Photo photo) {
        photoContent.load(photo.composeUrl());
    }


}
