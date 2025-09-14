//package com.example.myworld.view
//
//import android.graphics.Canvas
//import android.graphics.Paint
//import android.graphics.Rect
//import android.view.View
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.StaggeredGridLayoutManager
//import com.yy.sdk.rtl.RtlUtils
//
///**
// * created by kongjie(BG1381) on 2019/12/25
// **/
//
//@Suppress("JoinDeclarationAndAssignment")
//class StaggeredItemDecorationWithoutDraw(private val spanCount: Int, space: Int, color: Int) : RecyclerView.ItemDecoration() {
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
//                    spanCount-1 -> outRect.set(halfSpace, 0, space, space)
//                    else -> outRect.set(space, 0, halfSpace, space)
//                }
//            }
//        }
//    }
//
////    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
////        c.save()
////        val childCount = parent.childCount
////        for (i in 0 until childCount) {
////            val view = parent.getChildAt(i)
////            (view.layoutParams as? StaggeredGridLayoutManager.LayoutParams)?.let { layoutParams ->
////                if (layoutParams.isFullSpan) {
////                    if (hasFooterView && isFooterView(parent, view)) {
////                        return@let
////                    }
////
////                    rect.set(view.left, view.bottom, view.right, view.bottom+space)
////                    c.drawRect(rect, paint)
////                    return@let
////                }
////
////                drawVertical(c, view, layoutParams)
////            }
////        }
////        c.restore()
////    }
//
////    private fun drawVertical(c: Canvas, view: View, layoutParams: StaggeredGridLayoutManager.LayoutParams) {
////        val spanIndex = layoutParams.spanIndex
////        if (StaggeredGridLayoutManager.LayoutParams.INVALID_SPAN_ID != spanIndex) {
////            if (RtlUtils.isRtl()) {
////                when (spanIndex) {
////                    0 -> {
////                        rect.set(view.left, view.bottom, view.right, view.bottom + space)
////                        c.drawRect(rect, paint)
////                    }
////                    else -> {
////                        rect.set(view.left - space, view.top, view.left, view.bottom)
////                        c.drawRect(rect, paint)
////                        rect.set(view.left - space, view.bottom, view.right, view.bottom + space)
////                        c.drawRect(rect, paint)
////                    }
////                }
////            } else {
////                when (spanIndex) {
////                    spanCount - 1 -> {
////                        rect.set(view.left, view.bottom, view.right, view.bottom + space)
////                        c.drawRect(rect, paint)
////                    }
////                    else -> {
////                        rect.set(view.right, view.top, view.right + space, view.bottom)
////                        c.drawRect(rect, paint)
////                        rect.set(view.left, view.bottom, view.right + space, view.bottom + space)
////                        c.drawRect(rect, paint)
////                    }
////                }
////            }
////        }
////    }
//
//    private fun isFooterView(parent: RecyclerView, view: View): Boolean {
//        val position = parent.getChildAdapterPosition(view)
//        if (RecyclerView.NO_POSITION != position) {
//            parent.adapter?.let { adapter ->
//                val total = adapter.itemCount
//                if (position == total-1) {
//                    (adapter as? MediaShareNearByAdapter)?.let { realAdapter ->
//                        return !realAdapter.isFootViewEmpty
//                    }
//                }
//            }
//        }
//        return false
//    }
//}