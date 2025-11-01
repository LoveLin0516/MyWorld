package com.example.myworld.kotlin

/**
 * Created by zhuqianglong@bigo.sg on 2020/12/29
 * Description:
 */

/**
【秒懂】byte的取值范围为什么是-128~127？
- https://www.jianshu.com/p/47761557bab0

java基本数据类型取值范围
- https://my.oschina.net/u/635839/blog/715122

无符号整数
- https://baike.baidu.com/item/%E6%97%A0%E7%AC%A6%E5%8F%B7%E6%95%B4%E6%95%B0
 */


fun main(){

//    val source = 40000
//    val result1 : Short = source.toShort()
//    println("result1---->$result1")
//
//    // byte的取值范围为-128~127，占用1个字节（-2的7次方到2的7次方-1）
//    // short的取值范围为-32768~32767，占用2个字节（-2的15次方到2的15次方-1）
//    // int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1）
//    // long的取值范围为（-9223372036854774808~9223372036854774807），占用8个字节（-2的63次方到2的63次方-1）
//
//    //无符号整数常用于表示地址、索引等正整数，它们可以是8位、16位、32位、64位甚至更多。
//    // 8个二进制表示的正整数其取值范围是0~255（-1），
//    // 16位二进制位表示的正整数其取值范围是0~65535（-1），
//    // 32位二进制位表示的正整数其取值范围是0~-1。
//    val source2 = 2147483650000L
//    val result2 : Int = source2.toULong().toInt()
//    val result3 : Int = source2.toInt()
//    println("result2---->$result2")
//    println("result3---->$result3")
//
//    val source4 :Byte = 11111111.toByte()
//    println("result4---->$source4")

    val aa: List<String>?= null
    val bb = aa as? String
    println("bb---->$bb")
}