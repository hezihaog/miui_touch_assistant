package com.zh.touchassistant.ext


/**
 * Package: me.wally.imageloader
 * FileName: ImageExt
 * Date: on 2018/10/9  下午5:11
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
fun Any?.isNull(): Boolean {
    return this == null
}

fun Any?.isNotNull(): Boolean {
    return !isNull()
}