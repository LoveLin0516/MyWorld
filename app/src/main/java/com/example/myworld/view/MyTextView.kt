package com.example.myworld.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.myworld.R

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/22
 * Description:
 *
- Andoid自定义View的OnMeasure详解和自定义属性
- https://blog.csdn.net/tuke_tuke/article/details/73302595/
- Android自定义ViewGroup的OnMeasure和onLayout详解
- https://blog.csdn.net/tuke_tuke/article/details/73379123
 *
 */
class MyTextView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatTextView(context, attrs, defStyleAttr) {

    //设置默认的宽和高
    private val DEFUALT_VIEW_WIDTH = 100
    private val DEFUALT_VIEW_HEIGHT = 100

    //要绘制的文字
    private var mText: String? = null

    //文字颜色
    private var mTextColor = 0

    //文字大小
    private var mTextSize = 0

    //绘制时控制文本绘制范围
    private var mBound: Rect? = null
    private lateinit var mPaint: Paint

    //绘制文本的基坐标
    private var BaseX = 0f //绘制文本的基坐标
    private var BaseY = 0f

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        //获取自定义属性的值
        val a =
            context!!.obtainStyledAttributes(attrs, R.styleable.MyTextView, defStyleAttr, 0)
        mText = a.getString(R.styleable.MyTextView_mText)
        mTextColor = a.getColor(R.styleable.MyTextView_mTextColor, Color.BLACK)
        mTextSize = a.getDimension(R.styleable.MyTextView_mTextSize, 100f).toInt()
        a.recycle()

        //初始化画笔
        init()
    }


    private fun init() {
        //设置画笔的文字大小和颜色


        //设置画笔的文字大小和颜色
        mPaint = Paint()
        mPaint.setTextSize(mTextSize.toFloat())
        mPaint.setColor(mTextColor)
        mPaint.setTypeface(Typeface.DEFAULT_BOLD)

        mBound = Rect()
        mPaint.getTextBounds(mText, 0, mText!!.length, mBound)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //绘制文字
        BaseX = (width / 2 - mBound!!.width() / 2).toFloat()
        BaseY = (height / 2 + mBound!!.height() / 2).toFloat()
        canvas!!.drawText(mText, BaseX, BaseY, mPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        var width = 10
        var height = 10 //计算自定义View最终的宽和高


        if (widthMode == MeasureSpec.EXACTLY) {
            //如果match_parent或者具体的值，直接赋值
            width = widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) { //专门讨论的wrap_content情况
            //如果是wrap_content，我们要得到控件需要多大的尺寸
            val textWidth = mBound!!.width().toFloat() //文本的宽度
            width = (paddingLeft + textWidth + paddingRight).toInt()
        }
        //高度跟宽度处理方式一样
        //高度跟宽度处理方式一样
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize
        } else if (heightMode == MeasureSpec.AT_MOST) {
            val textHeight = mBound!!.height().toFloat()
            height = (paddingTop + textHeight + paddingBottom).toInt()
        }

        //保存测量宽度和测量高度

        //保存测量宽度和测量高度
        setMeasuredDimension(width, height)
    }

}