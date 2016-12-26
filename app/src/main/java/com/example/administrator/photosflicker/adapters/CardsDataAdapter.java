package com.example.administrator.photosflicker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.models.Photo;
import com.example.administrator.photosflicker.views.BetterImageView;

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
            itemView = LayoutInflater.from(parent.getContext())
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

        return itemView;
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

    public class CardDataHolder {

        @BindView(R.id.imageContent) BetterImageView imageContent;

        CardDataHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}
