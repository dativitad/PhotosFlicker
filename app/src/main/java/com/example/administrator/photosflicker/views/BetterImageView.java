package com.example.administrator.photosflicker.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.photosflicker.R;

/**
 * Created by Administrator on 25.12.2016.
 */

public class BetterImageView extends ImageView {

    public BetterImageView(Context context) {
        super(context);
    }

    public BetterImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BetterImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void load(String url) {
        Glide.with(getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(this);
    }
}
