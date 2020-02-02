package com.example.xyzreader.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;

import com.android.volley.toolbox.NetworkImageView;

import static com.android.volley.VolleyLog.TAG;

public class DynamicHeightNetworkImageView extends NetworkImageView {
    private float mAspectRatio = 1.7f;
    private int mOrientation;


    public DynamicHeightNetworkImageView(Context context) {
        super(context);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio, int orientation) {
        mAspectRatio = aspectRatio;
        mOrientation = orientation;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "onMeasure: widthMeasureSpec " + widthMeasureSpec);
        Log.d(TAG, "onMeasure: heightMeasureSpec " + heightMeasureSpec);
        Log.d(TAG, "onMeasure: getMeasuredWidth() " + getWidth());
        Log.d(TAG, "onMeasure: getMeasuredHeight() " + getHeight());
        int measuredHeight = MeasureSpec.getSize(widthMeasureSpec);

        if ((mOrientation == Configuration.ORIENTATION_LANDSCAPE)
               /* && (((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                        != Configuration.SCREENLAYOUT_SIZE_NORMAL)  ||
                        ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                                != Configuration.SCREENLAYOUT_SIZE_SMALL))*/){
            measuredHeight = (int) (measuredHeight / mAspectRatio);
        } else{
            measuredHeight = (int) (measuredHeight * mAspectRatio);

        }

        //mAspectRatio = measuredWidth/measuredHeight;

        int  measuredHeightSpec = MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, measuredHeightSpec);
    }
}
