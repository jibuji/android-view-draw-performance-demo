package com.gionee.lab.cyclingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by jiengfei on 15-5-11.
 */
public class CImageView extends ImageView {
    public CImageView(Context context) {
        super(context);
    }

    public CImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
//        super.draw(canvas);
        Drawable dr = this.getDrawable();
        dr.setBounds(0, 0, this.getWidth(), this.getHeight());
        dr.draw(canvas);
        Log.d("C", "draw");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Log.d("C", "onDraw");
    }
}
