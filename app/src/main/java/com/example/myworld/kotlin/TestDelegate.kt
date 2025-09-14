package com.example.myworld.kotlin

import kotlin.random.Random

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/11
 * Description: 测试委托属性
 */

//lazy的方式，只会在第一次初始化的时候调用，其他时候不会再调用
private val answer by lazy {
    println("Calculating the answer...")
    45
}

private val answer2 = {
    println("Calculating the answer...")
    45
}

private val answer3 = getAnswer3()

fun getAnswer3(): Int {
    println("Calculating the answer3...")
    return 45
}

private val list by lazy {
    listOf("1", "2", "3")
}

private fun needAnswer() = Random.nextBoolean()

fun main(args: Array<String>? = null) {
    println("The answer is $answer")
    println("The answer is $answer")
    println("The answer is $answer")

    println("The answer is $answer2")
    println("The answer is $answer2")
    println("The answer is $answer2")

    println("The answer3 is $answer3")
    println("The answer3 is $answer3")
    println("The answer3 is $answer3")

//    if (needAnswer()) {
//        println("The answer is $answer")
//    } else {
//        //此时不需要使用这个值，就没有必要初始化，lazy的作用
//        println("Sometimes it has no answer...")
//    }
}
