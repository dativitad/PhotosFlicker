package com.example.administrator.photosflicker.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.photosflicker.R;

/**
 * Created by rabbit on 12/27/16.
 */
public class BetterRoundedImageView extends ImageView {

    private float cornerRadius;

    public BetterRoundedImageView(Context context) {
        super(context);
        init();
    }

    public BetterRoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BetterRoundedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void load(String url) {
        Glide.with(getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(this);
    }

    private void init() {
        cornerRadius = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void draw(Canvas canvas) {
        Path clipPath = new Path();
        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        clipPath.addRoundRect(rect, cornerRadius, cornerRadius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.draw(canvas);
    }
}
