package com.example.administrator.photosflicker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.models.Photoset;
import com.example.administrator.photosflicker.views.BetterCircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 26.12.2016.
 */

public class PhotosetsAdapter extends RecyclerView.Adapter<PhotosetsAdapter.PhotosetsHolder> {

    private List<Photoset> photosetsList;

    public PhotosetsAdapter(List<Photoset> photosetsList) {
        this.photosetsList = photosetsList;
    }

    @Override
    public PhotosetsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View listItemView = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_photoset,
                        parent,
                        false
                );
        PhotosetsHolder photosetsHolder = new PhotosetsHolder(listItemView);
        return photosetsHolder;

    }

    @Override
    public void onBindViewHolder(PhotosetsHolder holder, int position) {

        Photoset photoset = photosetsList.get(position);



    }

    @Override
    public long getItemId(int position) {
        return photosetsList.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return photosetsList.size();
    }

    public class PhotosetsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photosetThumbnail) BetterCircleImageView photosetThumbnail;
        @BindView(R.id.photosetTitle) BetterCircleImageView photosetTitle;

        public PhotosetsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
