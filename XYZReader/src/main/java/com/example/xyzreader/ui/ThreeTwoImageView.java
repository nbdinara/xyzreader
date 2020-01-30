package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatImageView;

public class ThreeTwoImageView extends AppCompatImageView {

    public ThreeTwoImageView (Context context){
        super(context);
    }

    public ThreeTwoImageView (Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public ThreeTwoImageView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec){
        int threeTwoHeight = MeasureSpec.getSize(widthSpec) * 2/3;
        int threeTwoHeightSpec = MeasureSpec.makeMeasureSpec(threeTwoHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthSpec, threeTwoHeightSpec);
    }
}
