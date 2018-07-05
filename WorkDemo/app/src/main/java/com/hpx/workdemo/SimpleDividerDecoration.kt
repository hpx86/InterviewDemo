package com.hpx.workdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SimpleDividerDecoration: RecyclerView.ItemDecoration{

    private  var dividerHeight:Int = 0
    private  var  dividerPaint: Paint

    /**Kotlin 构造方法
     * https://www.cnblogs.com/mauiie/p/Constructor.html
     */
    constructor(context: Context){

        dividerPaint = Paint()
        dividerPaint.color = context.resources.getColor(R.color.color_gray)
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
    }


    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent:RecyclerView, state:RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = dividerHeight
    }

    @Override
    override fun onDraw(c: Canvas, parent:RecyclerView, state:RecyclerView.State) {
        var childCount = parent.getChildCount()
        var left:Float = parent.paddingLeft.toFloat()
        var right:Float = (parent.width - parent.paddingRight).toFloat()

        var max:Int = childCount - 1
        /**
         * Kotlin 循环控制
         * http://www.runoob.com/kotlin/kotlin-loop-control.html
         */
        loop@ for (i in 0..max){
            var view=parent.getChildAt(i)
            var  top:Float = view.bottom.toFloat()
            var bottom:Float = (view.bottom + dividerHeight).toFloat()
            c.drawRect(left, top, right, bottom, dividerPaint)
        }
        /*for ( i:Int= 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, dividerPaint);
        }*/
    }

    /*作者：小武站台
    链接：https://www.jianshu.com/p/b46a4ff7c10a
    來源：简书
    简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。*/
}