package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

fun main(){
    // slice() 返回具有给定索引的集合元素列表。
    // 索引既可以是作为区间传入的也可以是作为整数值的集合传入的。
//    val numbers = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers.slice(1..3))
//    println(numbers.slice(0..4 step 2))
//    println(numbers.slice(setOf(3, 5, 0)))
//
//    val numbers2 = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers2.take(3))
//    println(numbers2.takeLast(3))
//    println(numbers2.drop(1))
//    println(numbers2.dropLast(5))

//    val numbers3 = listOf("one", "two", "three", "four", "five", "six")
//    println(numbers3.takeWhile { !it.startsWith('f') })
//    println(numbers3.takeLastWhile { it != "three" })
//    println(numbers3.dropWhile { it.length == 3 })
//    println(numbers3.dropLastWhile { it.contains('i') })

    // 还可以立即对返回的块应用转换。 为此，请在调用 chunked() 时将转换作为 lambda 函数提供。
    // lambda 参数是集合的一块。当通过转换调用 chunked() 时，
    // 这些块是临时的 List，应立即在该 lambda 中使用。
//    val numbers = (0..13).toList()
//    println(numbers.chunked(3))

    //可以检索给定大小的集合元素中所有可能区间。 获取它们的函数称为 windowed()：它返回一个元素区间列表，比如通过给定大小的滑动窗口查看集合，
    // 则会看到该区间。 与 chunked() 不同，windowed() 返回从每个集合元素开始的元素区间（窗口）。 所有窗口都作为单个 List 的元素返回。
    val numbers4 = listOf("one", "two", "three", "four", "five")
    println(numbers4.windowed(3))

    //step 定义两个相邻窗口的第一个元素之间的距离。默认情况下，该值为 1，因此结果包含从所有元素开始的窗口。如果将 step 增加到 2，将只收到以奇数元素开头的窗口：第一个、第三个等。
    //partialWindows 包含从集合末尾的元素开始的较小的窗口。例如，如果请求三个元素的窗口，就不能为最后两个元素构建它们。在本例中，启用 partialWindows 将包括两个大小为2与1的列表。
    val numbers5 = (1..10).toList()
    println(numbers5.windowed(3, step = 2, partialWindows = true))
    println(numbers5.windowed(3) { it.sum() })

    //要构建两个元素的窗口，有一个单独的函数——zipWithNext()。 它创建接收器集合的相邻元素对。 请注意，zipWithNext() 不会将集合分成几对；它为 每个 元素创建除最后一个元素外的对，因此它在 [1, 2, 3, 4] 上的结果为 [[1, 2], [2, 3], [3, 4]]，
    // 而不是 [[1, 2]，[3, 4]]。 zipWithNext() 也可以通过转换函数来调用；它应该以接收者集合的两个元素作为参数。
    val numbers6 = listOf("one", "two", "three", "four", "five")
    println(numbers6.zipWithNext())
    println(numbers6.zipWithNext() { s1, s2 -> s1.length > s2.length})

}