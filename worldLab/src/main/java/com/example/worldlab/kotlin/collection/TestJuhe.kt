package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

fun main(){

//    min() 与 max() 分别返回最小和最大的元素；
//    average() 返回数字集合中元素的平均值；
//    sum() 返回数字集合中元素的总和；
//    count() 返回集合中元素的数量；
    val numbers = listOf(6, 42, 10, 4)

    println("Count: ${numbers.count()}")
    println("Max: ${numbers.max()}")
    println("Min: ${numbers.min()}")
    println("Average: ${numbers.average()}")
    println("Sum: ${numbers.sum()}")


    //还有一些通过某些选择器函数或自定义 Comparator 来检索最小和最大元素的函数。
    //
    //maxBy()/minBy() 接受一个选择器函数并返回使选择器返回最大或最小值的元素。
    //maxWith()/minWith() 接受一个 Comparator 对象并且根据此 Comparator 对象返回最大或最小元素。
    val numbers2 = listOf(5, 42, 10, 4)
    val min3Remainder = numbers2.minBy { it % 3 }
    println(min3Remainder)

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWith(compareBy { it.length })
    println(longestString)

    //sumBy() 使用对集合元素调用返回 Int 值的函数。
    //sumByDouble() 与返回 Double 的函数一起使用。
    val numbers3 = listOf(5, 42, 10, 4)
    println(numbers3.sumBy { it * 2 })
    println(numbers3.sumByDouble { it.toDouble() / 2 })

    //Fold 与 reduce
    //对于更特定的情况，有函数 reduce() 和 fold()，它们依次将所提供的操作应用于集合元素并返回累积的结果。 操作有两个参数：先前的累积值和集合元素。
    //
    //这两个函数的区别在于：fold() 接受一个初始值并将其用作第一步的累积值，而 reduce() 的第一步则将第一个和第二个元素作为第一步的操作参数。
    val numbers4 = listOf(5, 2, 10, 4)

    //上面的实例展示了区别：fold() 用于计算加倍的元素之和。 如果将相同的函数传给 reduce()，那么它会返回另一个结果，
    //因为在第一步中它将列表的第一个和第二个元素作为参数，所以第一个元素不会被加倍。
    val sum = numbers4.reduce { sum, element -> sum + element }
    println(sum)
    val sum2 = numbers4.reduce { sum, element -> sum + element*2 }
    println(sum2)
    val sumDoubled = numbers4.fold(2) { sum, element -> sum + element * 2 }
    println(sumDoubled)

    //如需将函数以相反的顺序应用于元素，可以使用函数 reduceRight() 和 foldRight() 它们的工作方式类似于 fold() 和 reduce()，但从最后一个元素开始，然后再继续到前一个元素。
    // 记住，在使用 foldRight 或 reduceRight 时，操作参数会更改其顺序：第一个参数变为元素，然后第二个参数变为累积值。
    val numbers5 = listOf(5, 2, 10, 4)
    val sumDoubledRight = numbers5.foldRight(0) { element, sum -> sum + element * 2 }
    println(sumDoubledRight)

    val numbers6 = listOf(5, 2, 10, 4)
    val sumEven = numbers6.foldIndexed(0) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
    println(sumEven)

    val sumEvenRight = numbers6.foldRightIndexed(0) { idx, element, sum -> if (idx % 2 == 0) sum + element else sum }
    println(sumEvenRight)
}