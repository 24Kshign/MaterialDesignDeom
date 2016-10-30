package com.share.jack.materialdesigndeom.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义ViewPager是否能左右滑动
 * Created by Jack on 16/10/27.
 */
public class NoScrollViewPager extends ViewPager {

    private boolean noScroll = false;   //控制ViewPager是否能左右滑动的标识

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    /**
     * 若返回值为true,ViewPager还会继续消耗手指滑动的事件,若返回值为false,
     * 那么ViewPager就不会消耗掉手指滑动的事件了,转而传递给上层View去处理或者该事件就直接终止了
     *
     * @param arg0
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    /**
     * 若返回值为true,ViewPager还会继续消耗手指滑动的事件,若返回值为false,
     * 那么ViewPager就不会消耗掉手指滑动的事件了,转而传递给上层View去处理或者该事件就直接终止了
     *
     * @param arg0
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }
}
