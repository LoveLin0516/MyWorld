package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

class TestAddMinus{
    fun test(){

        //在 Kotlin 中，为集合定义了 plus (+) 和 minus (-) 操作符。
        // 它们把一个集合作为第一个操作数；第二个操作数可以是一个元素或者是另一个集合。 返回值是一个新的只读集合：
        //
        //plus 的结果包含原始集合 和 第二个操作数中的元素。
        //minus 的结果包含原始集合中的元素，但第二个操作数中的元素 除外。 如果第二个操作数是一个元素，那么 minus 移除其在原始集合中的 第一次 出现；如果是一个集合，那么移除其元素在原始集合中的 所有 出现。
        val numbers = listOf("one", "two", "three", "four")

        val plusList = numbers + "five"
        val minusList = numbers - listOf("three", "four")
        println(plusList)
        println(minusList)
    }
}

fun main(){
    TestAddMinus().test()
}