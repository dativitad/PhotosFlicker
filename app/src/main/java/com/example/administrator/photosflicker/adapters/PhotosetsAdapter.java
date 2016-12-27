package com.example.administrator.photosflicker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.interfaces.RequestListener;
import com.example.administrator.photosflicker.models.Photoset;
import com.example.administrator.photosflicker.views.BetterImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 26.12.2016.
 */

public class PhotosetsAdapter extends RecyclerView.Adapter<PhotosetsAdapter.PhotosetsHolder> {

    private RequestListener requestListener;
    private List<Photoset> photosetsList;

    public PhotosetsAdapter(List<Photoset> photosetsList, RequestListener requestListener) {
        this.photosetsList = photosetsList;
        this.requestListener = requestListener;
    }

    @Override
    public PhotosetsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotosetsHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_photoset,
                        parent,
                        false
                ));
    }

    @Override
    public void onBindViewHolder(PhotosetsHolder holder, int position) {

        Photoset photoset = photosetsList.get(position);

        holder.photosetThumbnail.load(photoset.composeUrl());
        holder.photosetTitle.setText(photoset.getTitle().getContent());
        holder.photosetPhotoCount.setText("photos: "+photoset.getPhotos());

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

        @BindView(R.id.photosetThumbnail) BetterImageView photosetThumbnail;
        @BindView(R.id.photosetTitle) TextView photosetTitle;
        @BindView(R.id.photosetPhotoCount) TextView photosetPhotoCount;

        public PhotosetsHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requestListener.startPhotoFlickerFragment(
                            photosetsList.get(getAdapterPosition())
                                    .getId()
                    );
                }
            });
            ButterKnife.bind(this, itemView);
        }
    }
}
