package com.zh.touchassistant.ext

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.*
import java.util.regex.Pattern

/**
 * Package: me.wally.lvjiguide.ext
 * FileName: StringExt
 * Date: on 2018/10/3  下午10:48
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
/**
 * 拓展StringBuilder的清空
 */
fun java.lang.StringBuilder.clear() {
    this.delete(0, this.length - 1)
}

/**
 * 拓展StringBuffer的清空
 */
fun StringBuffer.clear() {
    this.delete(0, this.length - 1)
}

/**
 * 集合内容拼接，每个元素之间用指定的分隔符分隔，默认分隔符是英文的逗号
 */
fun <E> ArrayList<E>.listToString(separate: String = ","): String {
    val builder = java.lang.StringBuilder()
    for (e in this) {
        builder.append(e.toString())
        builder.append(separate)
    }
    //删除最后一个分隔符
    builder.deleteCharAt(builder.length - 1)
    return builder.toString()
}

/**
 * 判断字符串是否包含文字
 */
fun CharSequence.isContainChinese(): Boolean {
    val pattern = Pattern.compile("[\u4e00-\u9fa5]")
    val matcher = pattern.matcher(this)
    return matcher.find()
}

/**
 * 去掉前后空格和所有的空格
 */
fun CharSequence.trimAndRemoveAllBlank(): CharSequence {
    return this.trim().replace("\\s*".toRegex(), "")
}

fun CharSequence?.filterNoNull(): CharSequence {
    return this?.replace("null".toRegex(), "") ?: ""
}

/**
 * 根据文件路径获取文件的图片Bitmap
 */
fun String.getFilePathImageBitmap(): Bitmap? {
    return BitmapFactory.decodeFile(this)
}