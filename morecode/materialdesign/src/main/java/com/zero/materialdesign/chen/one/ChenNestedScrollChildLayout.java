package com.zero.materialdesign.chen.one;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;

/**
 * @description:
 * @Date: 2020/8/6
 */
public class ChenNestedScrollChildLayout extends LinearLayout implements NestedScrollingChild {

   private NestedScrollingChildHelper helper;
    private String Tag = "ChenNestedScrollChildLayout";

    public ChenNestedScrollChildLayout(Context context) {
        super(context);init();
    }

    public ChenNestedScrollChildLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);init();
    }

    public ChenNestedScrollChildLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr); init();
    }

    public ChenNestedScrollChildLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        helper = new NestedScrollingChildHelper(this);
        helper.setNestedScrollingEnabled(true);
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        helper.setNestedScrollingEnabled(enabled);
        Log.i(Tag, "setNestedScrollingEnabled:" + enabled);
    }


    int realHeight = 0;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        realHeight = 0;
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        for(int i = 0; i < getChildCount(); i++){
            View view = getChildAt(i);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec),MeasureSpec.UNSPECIFIED);
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
            Log.i(Tag,"getMeasuredHeight: " + view.getMeasuredHeight());
            realHeight += view.getMeasuredHeight();
        }
        Log.i(Tag,"realHeight: " + realHeight);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),realHeight);
    }

    /**
     * 是否可以嵌套滑动
     *
     * @return
     */
    @Override
    public boolean isNestedScrollingEnabled() {
        Log.i(Tag, "isNestedScrollingEnabled");
        return helper.isNestedScrollingEnabled();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private int mLastTouchX;
    private int mLastTouchY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int[] consumed = new int[2];//[0]:x,[1]:y
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mLastTouchY = (int)(event.getRawY() + .5f);
                int nestedScrollAxis = ViewCompat.SCROLL_AXIS_NONE;

                nestedScrollAxis |= ViewCompat.SCROLL_AXIS_HORIZONTAL;
                startNestedScroll(nestedScrollAxis);
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int x = (int)(event.getRawX() + .5f);
                int y = (int)(event.getRawY() + .5f);
                int dx = mLastTouchX -x;
                int dy = mLastTouchY -y;
                mLastTouchX = x;
                mLastTouchY = y;

                if(dispatchNestedPreScroll(dx,dy,consumed,null)){
                    Log.i("onMeasure","dy: " + dy + ", cosumed: " + consumed[1]);
                    dy -= consumed[1];
                    if(dy == 0){
                        Log.i("onMeasure","dy: " + dy);
                        return true;
                    }
                }else{
                    Log.i("onMeasure","scrollBy: " + dy);
                    scrollBy(0,dy);
                }
                break;
            }

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                stopNestedScroll();
        }
        return true;
    }

    @Override
    public void scrollTo(int x, int y) {
        Log.i("onMeasure","y: " + y + ", getScrollY: " + getScrollY() + ", height: " + getHeight() + ", realHeight: " + realHeight+ ", -- " + (realHeight -getHeight()));
        if (y < 0)
        {
            y = 0;
        }
        if (y > realHeight)
        {
            y = realHeight;
        }
        if ( y != getScrollY())
        {
            Log.e("onMeasure","scrollTo: " + y);
            super.scrollTo(x, y);
        }
    }


}
