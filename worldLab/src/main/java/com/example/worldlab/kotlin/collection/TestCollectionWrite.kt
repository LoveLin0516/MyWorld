package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

fun main(){

    val numbers = mutableListOf(1, 2, 5, 6)
    numbers.addAll(arrayOf(7, 8))
    println(numbers)
    numbers.addAll(2, setOf(3, 4))
    println(numbers)

    val numbers2 = mutableListOf("one", "two")
    numbers2 += "three"
    println(numbers2)
    numbers2 += listOf("four", "five")
    println(numbers2)

    numbers.remove(3)                    // 删除了第一个 `3`
    println(numbers)
    numbers.remove(5)                    // 什么都没删除
    println(numbers)


    //retainAll() 与 removeAll() 相反：它移除除参数集合中的元素之外的所有元素。
    // 当与谓词一起使用时，它只留下与之匹配的元素。
    println(numbers)
    numbers.retainAll { it >= 3 }
    println(numbers)
    numbers.clear()
    println(numbers)

    val numbersSet = mutableSetOf("one", "two", "three", "four")
    numbersSet.removeAll(setOf("one", "two"))
    println(numbersSet)

    val numbers3 = mutableListOf("one", "two", "three", "three", "four")
    numbers3 -= "three"
    println(numbers3)
    numbers3 -= listOf("four", "five")
//numbers -= listOf("four")    // 与上述相同
    println(numbers3)
}