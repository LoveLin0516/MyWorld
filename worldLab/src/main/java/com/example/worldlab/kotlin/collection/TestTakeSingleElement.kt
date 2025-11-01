package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

fun main(){
    val numbers1 = linkedSetOf("one", "two", "three", "four", "five")
    println(numbers1.elementAt(3))

    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet.elementAt(0)) // 元素以升序存储

    val numbers2 = listOf("one", "two", "three", "four", "five")
    println(numbers2.first())
    println(numbers2.last())

    val numbers3 = listOf("one", "two", "three", "four", "five")
    println(numbers3.elementAtOrNull(5))
    println(numbers3.elementAtOrElse(5) { index -> "The value for index $index is undefined"})


    val numbers4 = listOf("one", "two", "three", "four", "five", "six")
    println(numbers4.first { it.length > 3 })
    println(numbers4.last { it.startsWith("f") })

    val numbers5 = listOf("one", "two", "three", "four", "five", "six")
    println(numbers5.firstOrNull { it.length > 6 })

    //或者，如果别名更适合你的情况，那么可以使用别名：
    //
    //使用 find() 代替 firstOrNull()
    //使用 findLast() 代替 lastOrNull()
    val numbers6 = listOf(1, 2, 3, 4)
    println(numbers6.find { it % 2 == 0 })
    println(numbers6.findLast { it % 2 == 0 })

    val numbers7 = listOf(1, 2, 3, 4)
    println(numbers7.random())

    val numbers8 = listOf("one", "two", "three", "four", "five", "six")
    println(numbers8.contains("four"))
    println("zero" in numbers8)

    println(numbers8.containsAll(listOf("four", "two")))
    println(numbers8.containsAll(listOf("one", "zero")))

    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.isEmpty())
    println(numbers.isNotEmpty())

    val empty = emptyList<String>()
    println(empty.isEmpty())
    println(empty.isNotEmpty())
}