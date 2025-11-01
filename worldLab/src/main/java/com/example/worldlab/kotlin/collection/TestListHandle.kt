package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

fun main(){
    val numbers = mutableListOf(1, 2, 3, 4)
    println(numbers.get(0))
    println(numbers[0])
//    numbers.get(5)                         // exception!
    println(numbers.getOrNull(5))             // null
    println(numbers.getOrElse(5) {
        11
    })

    //indexOfFirst() 返回与谓词匹配的第一个元素的索引，如果没有此类元素，则返回 -1。
    //indexOfLast() 返回与谓词匹配的最后一个元素的索引，如果没有此类元素，则返回 -1。
    println(numbers.indexOfFirst { it > 2})
    println(numbers.indexOfLast { it % 2 == 1})

    //还有另一种搜索列表中元素的方法——二分查找算法。 它的工作速度明显快于其他内置搜索功能，
    // 但要求该列表按照一定的顺序（自然排序或函数参数中提供的另一种排序）按升序排序过。 否则，结果是不确定的。
    val numbers2 = mutableListOf("one", "two", "three", "four")
    numbers2.sort()
    println(numbers2)
    println(numbers2.binarySearch("two"))  // 3
    println(numbers2.binarySearch("z")) // -5
    println(numbers2.binarySearch("two", 0, 2))  // -3

    //Comparator 二分搜索
    //如果列表元素不是 Comparable，则应提供一个用于二分搜索的 Comparator。
    // 该列表必须根据此 Comparator 以升序排序。来看一个例子：
//    val productList = listOf(
//        Product("WebStorm", 49.0),
//        Product("AppCode", 99.0),
//        Product("DotTrace", 129.0),
//        Product("ReSharper", 149.0))
//
//    println(productList.binarySearch(Product("AppCode", 99.0), compareBy<Product> { it.price }.thenBy { it.name }))


//    fun priceComparison(product: Product, price: Double) = sign(product.price - price).toInt()
//    val productList = listOf(
//        Product("WebStorm", 49.0),
//        Product("AppCode", 99.0),
//        Product("DotTrace", 129.0),
//        Product("ReSharper", 149.0))
//
//    println(productList.binarySearch { priceComparison(it, 99.0) })

//    val numbers = mutableListOf("one", "five", "three")
//    numbers[1] =  "two"
//    println(numbers)

    // fill() 简单地将所有集合元素的值替换为指定值。
    val numbers3 = mutableListOf(1, 2, 3, 4)
    numbers3.fill(3)
    println(numbers3)

    numbers.removeAt(1)
    println(numbers)

//    val numbers4 = mutableListOf(1, 2, 3, 4, 3)
//    numbers4.removeFirst()
//    numbers4.removeLast()
//    println(numbers4)
//
//    val empty = mutableListOf<Int>()
//    // empty.removeFirst() // NoSuchElementException: List is empty.
//    empty.removeFirstOrNull() //null

    val numbers5 = mutableListOf("one", "two", "three", "four")

    numbers5.sort()
    println("Sort into ascending: $numbers5")
    numbers5.sortDescending()
    println("Sort into descending: $numbers5")

    numbers5.sortBy { it.length }
    println("Sort into ascending by length: $numbers5")
    numbers5.sortByDescending { it.last() }
    println("Sort into descending by the last letter: $numbers5")

    numbers5.sortWith(compareBy<String> { it.length }.thenBy { it })
    println("Sort by Comparator: $numbers5")

    numbers5.shuffle()
    println("Shuffle: $numbers")

    numbers5.reverse()
    println("Reverse: $numbers")
}

//比较函数二分搜索
data class Product(val name: String, val price: Double)