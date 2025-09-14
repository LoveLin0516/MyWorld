package com.example.myworld.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/22
 * Description:
 *
 - Andoid自定义View的OnMeasure详解和自定义属性
 - https://blog.csdn.net/tuke_tuke/article/details/73302595/
 - Android自定义ViewGroup的OnMeasure和onLayout详解
 - https://blog.csdn.net/tuke_tuke/article/details/73379123
 */

public class CustomViewGroup extends ViewGroup {

    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测量所有子控件的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //调用系统的onMeasure一般是测量自己(当前ViewGroup)的宽和高
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int mViewGroupWidth = getMeasuredWidth(); //当前ViewGroup的总宽度

        int mPainterPosX = l;//当前绘制光标X坐标
        int mPainterPosY = t;//当前绘制光标Y坐标

        int childCount = getChildCount();//子控件的数量
        //遍历所有子控件，并在其位置上绘制子控件
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            //子控件的宽和高
            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            CustomViewGroup.LayoutParams params = (CustomViewGroup.LayoutParams) childView
                    .getLayoutParams();//在onLayout中就可以获取子控件的mergin值了

            //ChildView占用的width  = width+leftMargin+rightMargin
            //ChildView占用的height = height+topMargin+bottomMargin

            //如果剩余控件不够，则移到下一行开始位置
            if (mPainterPosX + width + params.leftMargin + params.rightMargin > mViewGroupWidth) {
                mPainterPosX = l;
                mPainterPosY += height + params.topMargin + params.bottomMargin;
            }
            //执行childView的绘制
            childView.layout(mPainterPosX + params.leftMargin, mPainterPosY + params.topMargin,
                    mPainterPosX + width + params.leftMargin + params.rightMargin, mPainterPosY + height + params.topMargin + params.bottomMargin);
            //下一次绘制的X坐标
            mPainterPosX += width + params.leftMargin + params.rightMargin;
        }


    }

    //要使子控件的margin属性有效，必须定义静态内部类，继承ViewGroup.MarginLayoutParams
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }
    }

    //要使子控件的margin属性有效，必须重写该函数，返回内部类实例
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new CustomViewGroup.LayoutParams(getContext(), attrs);
    }
}