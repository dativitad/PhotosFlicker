package com.example.administrator.photosflicker.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.photosflicker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 26.12.2016.
 */

public class PhotosetsFragment extends BaseFragment {

    @BindView(R.id.photosetsRecycleView) RecyclerView photosetsRecycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(
                R.layout.fragment_photosets,
                container,
                false
        );

        ButterKnife.bind(this, root);

        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
}
