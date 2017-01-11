package com.qf.wx.wight;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by 40208 on 2016/12/20.
 */

public class Mylayout extends RelativeLayout {

    private ViewDragHelper viewDragHelper;

    public Mylayout(Context context) {
        this(context, null);
    }

    public Mylayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Mylayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        viewDragHelper = viewDragHelper.create(this,new MyCallback());
    }


    class MyCallback extends ViewDragHelper.Callback{

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return false;
        }


    }


}
