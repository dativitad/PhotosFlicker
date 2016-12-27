package com.example.administrator.photosflicker.adapters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.models.Photo;
import com.example.administrator.photosflicker.views.BetterImageView;
import com.example.administrator.photosflicker.views.BetterRoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 24.12.2016.
 */

public class CardsDataAdapter extends ArrayAdapter<Photo> {

    private List<Photo> photoList;

    public CardsDataAdapter(Context context, List<Photo> photosList) {
        super(context, 0, photosList);
        photoList = photosList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        Photo photo = getItem(position);
        CardDataHolder cardDataHolder;
        View itemView = convertView;

        if (itemView == null) {
            itemView =  LayoutInflater.from(getContext())
                    .inflate(
                            R.layout.item_card_layout,
                            parent,
                            false
                    );
            cardDataHolder = new CardDataHolder(itemView);

            itemView.setTag(cardDataHolder);
        } else {
            cardDataHolder = (CardDataHolder) itemView.getTag();
        }

        cardDataHolder.imageContent.load(photo.composeUrl());
        cardDataHolder.textContent.setText(photo.getTitle());

        return itemView;
    }

    public void removeFirstObject() {
        photoList.remove(0);
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public Photo getItem(int position) {
        return photoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photoList.get(position).getId();
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    public class CardDataHolder {

        @BindView(R.id.imageContent) BetterRoundedImageView imageContent;
        @BindView(R.id.hateIcon) ImageView hateIcon;
        @BindView(R.id.likeIcon) ImageView likeIcon;
        @BindView(R.id.textContent) TextView textContent;

        CardDataHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}
