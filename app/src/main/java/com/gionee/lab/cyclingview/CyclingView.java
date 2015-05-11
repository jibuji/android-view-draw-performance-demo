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
public class CyclingView extends FrameLayout {

    int mTx1 = 0;
    int mTx2 = 0;
    int animationStart = -1;
    public CyclingView(Context context) {
        super(context);
    }

    public CyclingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CyclingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            int measureWidthSize = MeasureSpec.getSize(widthMeasureSpec);
            int widthSpec = MeasureSpec.makeMeasureSpec(measureWidthSize, MeasureSpec.UNSPECIFIED);
            int measureHeightSize = MeasureSpec.getSize(heightMeasureSpec);
            int heightSpec = MeasureSpec.makeMeasureSpec(measureHeightSize, MeasureSpec
                    .UNSPECIFIED);
            measureChildWithMargins(child, widthSpec, 0, heightSpec, 0);
            mTx2 = child.getMeasuredWidth();
        }
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        Log.d("T", "on Measure mTx1=" + mTx1 + ";mTx2=" + mTx2);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
//        super.dispatchDraw(canvas);
        long start = System.currentTimeMillis();
        Log.d("T", "mTx1=" + mTx1 + ";mTx2=" + mTx2);
        if (getChildCount() > 0) {

            View child = getChildAt(0);
            canvas.translate(mTx1, 0);
            child.draw(canvas);
            canvas.translate(mTx2 - mTx1, 0);
            child.draw(canvas);
            canvas.translate(-mTx2, 0);

            --mTx1;
            --mTx2;
            if (mTx1 <= 0 && mTx2 <= 0) {
                if (mTx1 < mTx2) {
                    mTx1 = child.getMeasuredWidth();
                } else {
                    mTx2 = child.getMeasuredWidth();
                }
            }
        }
        Log.d("T", "mTx1=" + mTx1 + ";mTx2=" + mTx2);
        long end = System.currentTimeMillis();
        Log.d("T", "time="+(end - start));
        postInvalidate();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

}
