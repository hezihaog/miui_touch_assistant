package com.zh.touchassistant.ext

import android.graphics.Bitmap
import android.support.v4.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Package: me.wally.lvjiguide.ext
 * FileName: ViewExt
 * Date: on 2018/10/3  下午10:50
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

/**
 * 测量View
 */
fun measureView(target: View): IntArray {
    val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    target.measure(w, h)
    val width = target.measuredWidth
    val height = target.measuredHeight
    return intArrayOf(width, height)
}

fun <T : View> Fragment.findView(id: Int): T {
    this.view ?: throw NullPointerException("Fragment view must be not null")
    return this.view!!.findViewById(id)
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setInVisible() {
    this.visibility = View.INVISIBLE
}

//拓展TextView，将TextView中可能有的null文字替换掉
var TextView.noNullText: CharSequence
    get() :CharSequence {
        return this.text.filterNoNull()
    }
    set(value) {
        this.text.filterNoNull()
    }

fun TextView.setTextWithDefault(text: CharSequence?, default: CharSequence = "") {
    if (text.isNull()) {
        this.text = default
    } else {
        this.text = text
    }
}

/**
 * 获取ViewGroup所有的子View集合
 */
fun ViewGroup.getAllChildView(): MutableList<View> {
    val allChildList = mutableListOf<View>()
    val childCount = this.childCount
    for (viewIndex in 0 until childCount) {
        allChildList.add(this.getChildAt(viewIndex))
    }
    return allChildList
}

/**
 * 获取ImageView上的图像
 */
fun ImageView.getImageBitmap(): Bitmap? {
    this.isDrawingCacheEnabled = true
    val bitmap = this.drawingCache
    this.isDrawingCacheEnabled = false
    return bitmap
}