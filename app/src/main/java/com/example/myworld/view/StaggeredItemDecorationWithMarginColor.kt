//package com.example.myworld.view
//
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.Rect
//import android.view.View
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.StaggeredGridLayoutManager
//import sg.bigo.discover.R
//
///**
// * Created by zhuqianglong@bigo.sg on 2020/7/14
// * Description: kiki马甲包，产品要求修改瀑布流样式，左中右都要有间距
// */
//
//@Suppress("JoinDeclarationAndAssignment")
//class StaggeredItemDecorationWithMarginColor(private val spanCount: Int, space: Int, color: Int) : RecyclerView.ItemDecoration() {
//    private val halfSpace: Int
//    private val space: Int
//    private val paint: Paint
//    private val rect: Rect = Rect()
//    private var hasFooterView: Boolean = false
//
//    init {
//        var halfSpace = space shr 1
//        if (0 == halfSpace) {
//            halfSpace = 1
//        }
//        this.halfSpace = halfSpace
//        this.space = halfSpace shl 1
//        paint = Paint()
//        paint.color = color
//        paint.isAntiAlias = true
//        paint.style = Paint.Style.FILL
//    }
//
//    fun setHasFooterView(hasFooterView: Boolean) {
//        this.hasFooterView = hasFooterView
//    }
//
//    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
//        (view.layoutParams as? StaggeredGridLayoutManager.LayoutParams)?.let { layoutParams ->
//            if (layoutParams.isFullSpan) {
//                if (hasFooterView && isFooterView(parent, view)) {
//                    return@let
//                }
//
//                outRect.set(0, 0, 0, space)
//                return@let
//            }
//
//            val spanIndex = layoutParams.spanIndex
//            if (StaggeredGridLayoutManager.LayoutParams.INVALID_SPAN_ID != spanIndex) {
//                when (spanIndex) {
//                    0 -> outRect.set(space, 0, halfSpace, space)
//                    spanCount - 1 -> outRect.set(halfSpace, 0, space, space)
//                    else -> outRect.set(space, 0, halfSpace, space)
//                }
//            }
//        }
//    }
//
//    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
//        c.save()
//        val childCount = parent.childCount
//        for (i in 0 until childCount) {
//            val view = parent.getChildAt(i)
//            (view.layoutParams as? StaggeredGridLayoutManager.LayoutParams)?.let { layoutParams ->
//                if (layoutParams.isFullSpan) {
//                    if (hasFooterView && isFooterView(parent, view)) {
//                        return@let
//                    }
//                    //如果是占据一整行的ViewHolder的，而且不是FootView，那么只需要在底部，向下space的
//                    // 区域进行绘制即可
//                    rect.set(view.left, view.bottom, view.right, view.bottom + space)
//                    c.drawRect(rect, paint)
//                    return@let
//                }
//
//                drawVertical(c, view, layoutParams)
//            }
//        }
//        c.restore()
//    }
//
//    private fun drawVertical(c: Canvas, view: View, layoutParams: StaggeredGridLayoutManager.LayoutParams) {
//        val spanIndex = layoutParams.spanIndex
//        if (StaggeredGridLayoutManager.LayoutParams.INVALID_SPAN_ID != spanIndex) {
//            when (spanIndex) {
//                spanCount - 1 -> {
//                    //右边Item的下方间距，分割线绘制，对应示意图中的红色区域，4
//                    paint.color= Color.RED
//                    rect.set(view.left, view.bottom, view.right + space, view.bottom + space)
//                    c.drawRect(rect, paint)
//                    //右边Item的右边间距，分割线绘制，对应示意图中的黄色区域，5
//                    paint.color= Color.YELLOW
//                    rect.set(view.right, view.top, view.right + space, view.bottom)
//                    c.drawRect(rect, paint)
//                }
//                else -> {
//                    //左边Item的左边间距，分割线绘制，对应示意图中的灰色区域，1
//                    paint.color= Color.GRAY
//                    rect.set(view.left - space, view.top, view.left, view.bottom)
//                    c.drawRect(rect, paint)
//                    //左边Item的下方间距，分割线绘制，对应示意图中的蓝色区域，2
//                    paint.color= Color.BLUE
//                    rect.set(view.left - space, view.bottom, view.right + space, view.bottom + space)
//                    c.drawRect(rect, paint)
//                    //两个Item的中间间距，分割线绘制，对应示意图中绿色区域，3
//                    paint.color= Color.GREEN
//                    rect.set(view.right, view.top, view.right + space, view.bottom)
//                    c.drawRect(rect, paint)
//
//                }
//            }
//        }
//    }
//
//    private fun isFooterView(parent: RecyclerView, view: View): Boolean {
//        return false
//    }
//}