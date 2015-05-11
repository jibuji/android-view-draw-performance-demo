package com.gionee.lab.cyclingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

/**
 * Created by jiengfei on 15-5-11.
 */
public class CyclingView extends View {

    int mTx1 = 0;
    int mTx2 = 0;
    private Drawable mDrawable;

    public CyclingView(Context context) {
        super(context);
    }

    public CyclingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CyclingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDrawable(Drawable dr) {
        mDrawable = dr;
        mDrawable.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        Log.d("T", "on Measure mTx1=" + mTx1 + ";mTx2=" + mTx2);
    }

    @Override
    public void draw(Canvas canvas) {
//        super.dispatchDraw(canvas);
        long start = System.currentTimeMillis();
        Log.d("T", "mTx1=" + mTx1 + ";mTx2=" + mTx2);

        Drawable dr = mDrawable;
        canvas.translate(mTx1, 0);
        dr.draw(canvas);
        canvas.translate(mTx2 - mTx1, 0);
        dr.draw(canvas);
        canvas.translate(-mTx2, 0);

        --mTx1;
        --mTx2;
        if (mTx1 <= 0 && mTx2 <= 0) {
            if (mTx1 < mTx2) {
                mTx1 = dr.getIntrinsicWidth();
            } else {
                mTx2 = dr.getIntrinsicWidth();
            }
        }
        Log.d("T", "mTx1=" + mTx1 + ";mTx2=" + mTx2);
        long end = System.currentTimeMillis();
        Log.d("T", "time=" + (end - start), new Exception());
        postInvalidate();
    }

}
