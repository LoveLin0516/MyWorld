package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

fun main(){
    //定义一个 Comparator 的一种比较简短的方式是标准库中的 compareBy() 函数。 compareBy() 接受一个 lambda 表达式，该表达式从一个实例产生一个 Comparable 值，并将自定义顺序定义为生成值的自然顺序。 使用 compareBy()，上面示例中的长度比较器如下所示：
    println(listOf("aaa", "bb", "c").sortedWith(compareBy { it.length }))

    //基本的函数 sorted() 和 sortedDescending() 返回集合的元素，这些元素按照其自然顺序升序和降序排序。 这些函数适用于 Comparable 元素的集合。
    val numbers = listOf("one", "two", "three", "four")

    println("Sorted ascending: ${numbers.sorted()}")
    println("Sorted descending: ${numbers.sortedDescending()}")

    //为了按照自定义顺序排序或者对不可比较对象排序，可以使用函数 sortedBy() 和 sortedByDescending()。
    // 它们接受一个将集合元素映射为 Comparable 值的选择器函数，并以该值的自然顺序对集合排序。
    val numbers2 = listOf("one", "two", "three", "four")

    val sortedNumbers = numbers2.sortedBy { it.length }
    println("Sorted by length ascending: $sortedNumbers")
    val sortedByLast = numbers2.sortedByDescending { it.last() }
    println("Sorted by the last letter descending: $sortedByLast")

    //如需为集合排序定义自定义顺序，可以提供自己的 Comparator。 为此，调用传入 Comparator 的 sortedWith() 函数。 使用此函数，按照字符串长度排序如下所示：
    val numbers3 = listOf("one", "two", "three", "four")
    println("Sorted by length ascending: ${numbers3.sortedWith(compareBy { it.length })}")

    val numbers4 = listOf("one", "two", "three", "four")
    println(numbers4.reversed())

    val numbers5 = listOf("one", "two", "three", "four")
    val reversedNumbers = numbers5.asReversed()
    println(reversedNumbers)

   // 如果原始列表是可变的，那么其所有更改都会反映在其反向视图中，反之亦然。

    val numbers6 = mutableListOf("one", "two", "three", "four")
    val reversedNumbers6 = numbers6.asReversed()
    println(reversedNumbers6)
    numbers6.add("five")
    println(reversedNumbers6)

   //最后，shuffled() 函数返回一个包含了以随机顺序排序的集合元素的新的 List。 你可以不带参数或者使用 Random 对象来调用它。

    val numbers7 = listOf("one", "two", "three", "four")
    println(numbers7.shuffled())
}