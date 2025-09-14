//package com.example.myworld.view;
//
//import android.content.res.TypedArray;
//import android.graphics.Paint;
//import android.graphics.Rect;
//
//import com.example.myworld.R;
//
///**
// * Created by zhuqianglong@bigo.sg on 2020/6/22
// * Description:
// */
//class MyJava {
//    //设置默认的宽和高
//    private static final int DEFUALT_VIEW_WIDTH = 100;
//    private static final int DEFUALT_VIEW_HEIGHT = 100;
//    //要绘制的文字
//    private String mText;
//    //文字颜色
//    private int mTextColor;
//    //文字大小
//    private int mTextSize;
//    //绘制时控制文本绘制范围
//    private Rect mBound;
//    private Paint mPaint;
//    //绘制文本的基坐标
//    private float BaseX, BaseY;
//
//    private void doSth() {
//        //获取自定义属性的值
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0);
//        mText = a.getString(R.styleable.MyTextView_mText);
//        mTextColor = a.getColor(R.styleable.MyTextView_mTextColor, Color.BLACK);
//        mTextSize = (int) a.getDimension(R.styleable.MyTextView_mTextSize, 100);
//        a.recycle();
//        ;
//
//        //初始化画笔
//        init();
//    }
//
//    public void init() {
//
//        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
//
//        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
//
//        int width=10,height=10;//计算自定义View最终的宽和高
//
//        if(widthMode==MeasureSpec.EXACTLY){
//            //如果match_parent或者具体的值，直接赋值
//            width=widthSize;
//        }else if(widthMode==MeasureSpec.AT_MOST){//专门讨论的wrap_content情况
//            //如果是wrap_content，我们要得到控件需要多大的尺寸
//            float textWidth=mBound.width();//文本的宽度
//
//            width= (int) (getPaddingLeft() + textWidth + getPaddingRight());
//        }
//        //高度跟宽度处理方式一样
//        if(heightMode==MeasureSpec.EXACTLY){
//            height=widthSize;
//        }else if(heightMode==MeasureSpec.AT_MOST){
//            float textHeight=mBound.height();
//
//            height=  (int) (getPaddingTop() + textHeight + getPaddingBottom());
//        }
//
//        //保存测量宽度和测量高度
//        setMeasuredDimension(width,height);
//
//    }
//}
