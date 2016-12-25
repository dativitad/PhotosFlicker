package com.example.administrator.photosflicker.views;

import android.content.Context;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.example.administrator.photosflicker.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 26.12.2016.
 */

public class BetterCircleImageView extends CircleImageView {
    public BetterCircleImageView(Context context) {
        super(context);
    }

    public BetterCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BetterCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void load(String url) {
        Glide.with(getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(this);
    }
}
