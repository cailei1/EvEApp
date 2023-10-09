package com.onepiece.eveapp.utils

import android.content.res.Resources
import android.graphics.Point
import android.util.TypedValue
import android.view.View


val View.centerX: Int
    get() {
        val top = this.top
        val left = this.left
        //右下角坐标
        //右下角坐标
        val right = this.right
        val bottom = this.bottom

        //View的 宽

        //View的 宽
        val viewWidth = right - left
        //View的 高
        //View的 高
        val viewHeight = bottom - top
        //中心点的Y坐标
        //中心点的Y坐标
        val centerY = top + viewHeight / 2
        //中心点的X坐标
        //中心点的X坐标
        val centerX = left + viewWidth / 2
        return centerX
    }

val View.centerY: Int
    get() {
        val top = this.top
        val left = this.left
        //右下角坐标
        //右下角坐标
        val right = this.right
        val bottom = this.bottom

        //View的 宽

        //View的 宽
        val viewWidth = right - left
        //View的 高
        //View的 高
        val viewHeight = bottom - top
        //中心点的Y坐标
        //中心点的Y坐标
        val centerY = top + viewHeight / 2
        //中心点的X坐标
        //中心点的X坐标
        val centerX = left + viewWidth / 2
        return centerY
    }


fun View.getCenterPosition(view: View): Point {
    //左上角坐标    (left,top)
    //左上角坐标    (left,top)
    val top = view.top
    val left = view.left
    //右下角坐标
    //右下角坐标
    val right = view.right
    val bottom = view.bottom

    //View的 宽

    //View的 宽
    val viewWidth = right - left
    //View的 高
    //View的 高
    val viewHeight = bottom - top
    //中心点的Y坐标
    //中心点的Y坐标
    val centerY = top + viewHeight / 2
    //中心点的X坐标
    //中心点的X坐标
    val centerX = left + viewWidth / 2

    return Point(centerX, centerY)

}


val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

//使用示例
//// 10.dp
//inline val Double.dp: Int get() = run {
//    return toFloat().dp
//}
//inline val Int.dp: Int get() = run {
//    return toFloat().dp
//}
//inline val Float.dp: Int get() = run {
//    val scale: Float = App.instance().resources.displayMetrics.density
//    return (this * scale + 0.5f).toInt()
//}