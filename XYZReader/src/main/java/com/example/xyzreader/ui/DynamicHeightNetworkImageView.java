package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.android.volley.toolbox.NetworkImageView;

import static com.android.volley.VolleyLog.TAG;

public class DynamicHeightNetworkImageView extends NetworkImageView {
    private float mAspectRatio = 1.7f;

    public DynamicHeightNetworkImageView(Context context) {
        super(context);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "onMeasure: widthMeasureSpec " + widthMeasureSpec);
        Log.d(TAG, "onMeasure: heightMeasureSpec " + heightMeasureSpec);
        Log.d(TAG, "onMeasure: getMeasuredWidth() " + getWidth());
        Log.d(TAG, "onMeasure: getMeasuredHeight() " + getHeight());
        //mAspectRatio = measuredWidth/measuredHeight;
        int measuredHeight = MeasureSpec.getSize(widthMeasureSpec);
        measuredHeight = (int) (measuredHeight * mAspectRatio);

        int  measuredHeightSpec = MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, measuredHeightSpec);
    }
}
