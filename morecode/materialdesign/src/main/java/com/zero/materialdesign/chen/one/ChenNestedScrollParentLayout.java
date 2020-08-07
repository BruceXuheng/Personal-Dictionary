package com.zero.materialdesign.chen.one;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;

/**
 * @description:
 * @Date: 2020/8/6
 */
public class ChenNestedScrollParentLayout extends LinearLayout implements NestedScrollingParent {

    private NestedScrollingParentHelper parent;
    private String Tag = "ChenNestedScrollParentLayout";

    public ChenNestedScrollParentLayout(Context context) {
        super(context);
        init(context);
    }

    public ChenNestedScrollParentLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ChenNestedScrollParentLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ChenNestedScrollParentLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context) {
        parent = new NestedScrollingParentHelper(this);
    }


    @Override
    public void scrollTo(int x, int y) {
        View head = getChildAt(0);
        if (y < 0) {
            y = 0;
        }
        if (y > head.getHeight()) {
            y = head.getHeight();
        }
        if (y != getScrollY()) {
            super.scrollTo(x, y);
        }

    }


    /**
     * @param child
     * @param target
     * @param nestedScrollAxes 嵌套滑动的坐标系，也就是用来判断X轴滑动还是Y轴滑动，这里可以根据需要返回true和false
     * @return 返回false就没法滑动了
     */
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.i(Tag, "onStartNestedScroll--" + "child:" + child + ",target:" + target + ",nestedScrollAxes:" + nestedScrollAxes);

        return true;
    }


    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        Log.i(Tag, "onNestedScrollAccepted" + "child:" + child + ",target:" + target + ",nestedScrollAxes:" + nestedScrollAxes);
        parent.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        Log.i(Tag, "onStopNestedScroll--target:" + target);
        parent.onStopNestedScroll(target);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.i(Tag, "onNestedScroll--" + "target:" + target + ",dxConsumed" + dxConsumed + ",dyConsumed:" + dyConsumed
                + ",dxUnconsumed:" + dxUnconsumed + ",dyUnconsumed:" + dyUnconsumed);
    }


    /**
     * 在滑动之前会被调用，他的作用就是子类在滑动的时候，分发一下，是否有父类需要消费滑动，这个时候，父类就可以根据自己的业务逻辑进行消费部分和全部消费
     *
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        boolean show = showImg(dy);
        boolean hide = hideImg(dy);
//        Log.i("onMeasure","show: " + show + ", hide: " + hide);
        if(show||hide){//1.作业 消费过头
            consumed[1] = dy;//全部消费
            scrollBy(0, dy);
            Log.i(Tag,"Parent滑动："+dy);
        }
        Log.i(Tag, "onNestedPreScroll--getScrollY():" + getScrollY() + ",dx:" + dx + ",dy:" + dy + ",consumed:" + consumed[1]);
    }

    private boolean showImg(int dy){
        View view =getChildAt(0);
        Log.i(Tag,"showImg: " + dy + " height: " + view.getHeight() + " getScrollY: " + getScrollY() + " can: " + view.canScrollVertically(-1));
        if(dy <0 && getScrollY() >0 && !view.canScrollVertically(-1)){
            return true;
        }
        return false;
    }

    private boolean hideImg(int dy){
        View view =getChildAt(0);
        Log.i(Tag,"hideImg: " + dy + " height: " + view.getHeight() + " getScrollY: " + getScrollY() + " can: " + view.canScrollVertically(-1));
        if(dy > 0 && getScrollY() < view.getHeight()){
            return true;
        }
        return false;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.i(Tag, "onNestedFling--target:" + target);
        return true;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.i(Tag, "onNestedPreFling--target:" + target);
        return true;
    }
}
