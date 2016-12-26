package com.example.administrator.photosflicker.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout;

import com.example.administrator.photosflicker.R;

/**
 * Created by rabbit on 12/26/16.
 */
public class BetterRoundedLayout extends FrameLayout {

    private float cornerRadius;

    public BetterRoundedLayout(Context context) {
        super(context);
        init();
    }

    public BetterRoundedLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BetterRoundedLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        cornerRadius = getResources().getDimensionPixelSize(R.dimen.twenty_five_dp);
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
