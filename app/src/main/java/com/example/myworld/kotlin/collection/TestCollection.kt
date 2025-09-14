package com.example.myworld.kotlin.collection

import com.example.myworld.kotlin.EPageState

/**
 * Created by zhuqianglong@bigo.sg on 2020/10/26
 * Description:
 */

//如你所见，在某些方面，List 与数组（Array）非常相似。
// 但是，有一个重要的区别：数组的大小是在初始化时定义的，永远不会改变;
// 反之，List 没有预定义的大小；作为写操作的结果，可以更改 List 的大小：添加，更新或删除元素。

//Map 的默认实现 – LinkedHashMap – 迭代 Map 时保留元素插入的顺序。
// 反之，另一种实现 – HashMap – 不声明元素的顺序。

fun main() {
//    val numbers = setOf(1, 2, 3, 4)  // LinkedHashSet is the default implementation
//    val numbersBackwards = setOf(4, 3, 2, 1)
//
//    println(numbers.first() == numbersBackwards.first())
//    println(numbers.first() == numbersBackwards.last())
//
//    //还有用于创建没有任何元素的集合的函数：emptyList()、emptySet() 与 emptyMap()。 创建空集合时，应指定集合将包含的元素类型。
//    val empty = emptyList<String>()
//
//    //可以通过其他集合各种操作的结果来创建集合。例如，过滤列表会创建与过滤器匹配的新元素列表：
//    val numbers2 = listOf("one", "two", "three", "four")
//    val longerThan3 = numbers2.filter { it.length > 3 }
//    println(longerThan3)

    // 映射生成转换结果列表：
    val numbers4 = setOf(1, 2, 3)
    println(numbers4.map { it * 3 })
    println(numbers4.mapIndexed { idx, value -> value * idx })

    // 关联生成 Map:
//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.associateWith { it.length })
//
//    val array = arrayOf("one", "two", "three")
//    val valueMap: Map<Int, String> = array.associateBy { it.length }
//    println(valueMap)

    // 另一种构建 Map 的方法是使用函数 associate()，其中 Map 键和值都是通过集合元素生成的。 它需要一个 lambda 函数，该函数返回 Pair：键和相应 Map 条目的值。
    //请注意，associate() 会生成临时的 Pair 对象，这可能会影响性能。 因此，当性能不是很关键或比其他选项更可取时，应使用 associate()。
//    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
//    println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })

    val numbers = mutableListOf("one", "four", "four")
    val mutableListIterator = numbers.listIterator()

    mutableListIterator.next()
    mutableListIterator.add("two")
    mutableListIterator.next()
    mutableListIterator.set("three")
    println(numbers)

    for (i in 1..8 step 2) print(i)

    for (i in 4 downTo 1 step 3) print(i)

    println((1..10).filter { it % 2 == 0 })

//    val oddNumbers = generateSequence(1) { it + 2 } // `it` 是上一个元素
//    println(oddNumbers.take(5).toList())

    val oddNumbers = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(oddNumbers.take(3).toList())

    collectionHandle()
    collectionMap()
}

/**
 * 操作概述
 */
fun collectionHandle(){
    //这些页面中描述的操作将返回其结果，而不会影响原始集合。
    // 例如，一个过滤操作产生一个_新集合_，其中包含与过滤谓词匹配的所有元素。
    // 此类操作的结果应存储在变量中，或以其他方式使用，例如，传到其他函数中。
//    val numbers = listOf("one", "two", "three", "four")
//    numbers.filter { it.length > 3 }  // `numbers` 没有任何改变，结果丢失
//    println("numbers are still $numbers")
//    val longerThan3 = numbers.filter { it.length > 3 } // 结果存储在 `longerThan3` 中
//    println("numbers longer than 3 chars are $longerThan3")

    //对于某些集合操作，有一个选项可以指定 目标 对象。 目标是一个可变集合，该函数将其结果项附加到该可变对象中，而不是在新对象中返回它们。
    // 对于执行带有目标的操作，有单独的函数，其名称中带有 To 后缀，例如，用 filterTo() 代替 filter()
    // 以及用 associateTo() 代替 associate()。 这些函数将目标集合作为附加参数。
//    val numbers = listOf("one", "two", "three", "four")
//    val filterResults = mutableListOf<String>()  // 目标对象
//    numbers.filterTo(filterResults) { it.length > 3 }
//    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
//    println(filterResults) // 包含两个操作的结果

    //为了方便起见，这些函数将目标集合返回了，因此您可以在函数调用的相应参数中直接创建它：
    // 将数字直接过滤到新的哈希集中，
    // 从而消除结果中的重复项
//    val result = numbers.mapTo(HashSet()) { it.length }
//    println("distinct item lengths are $result")


    //对于某些操作，有成对的函数可以执行相同的操作：一个函数就地应用该操作，另一个函数将结果作为单独的集合返回。
    // 例如， sort() 就地对可变集合进行排序，因此其状态发生了变化； sorted() 创建一个新集合，该集合包含按排序顺序相同的元素。
    val numbers = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = numbers.sorted()
    println(numbers == sortedNumbers)  // false
    numbers.sort()
    println(numbers == sortedNumbers)  // true
    println(numbers)
    println(sortedNumbers)
}

fun collectionMap(){
    //如果转换在某些元素上产生 null 值，则可以通过调用 mapNotNull() 函数取代 map() 或
    // mapIndexedNotNull() 取代 mapIndexed() 来从结果集中过滤掉 null 值。
    val numbers = setOf(1, 2, 3)
    println(numbers.mapNotNull { if ( it == 2) null else it * 3 })
    println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

    //映射转换时，有两个选择：转换键，使值保持不变，反之亦然。 要将指定转换应用于键，请使用 mapKeys()；
    // 反过来，mapValues() 转换值。 这两个函数都使用将映射条目作为参数的转换，因此可以操作其键与值。
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })

    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))

//    val colors = listOf("red", "brown", "grey")
//    val animals = listOf("fox", "bear", "wolf")
//
//    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color"})

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())

    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())

//    val containers = listOf(
//        StringContainer(listOf("one", "two", "three")),
//        StringContainer(listOf("four", "five", "six")),
//        StringContainer(listOf("seven", "eight"))
//    )
//    println(containers.flatMap { it.values })

    val numbers2 = listOf("one", "two", "three", "four")

    println(numbers2)
    println(numbers2.joinToString())
    println(numbers2.joinToString("_"))

    val listString = StringBuffer("The list of numbers: ")
    numbers.joinTo(listString,"*")
    println(listString)

//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))
//
//    //对于较大的集合，可能需要指定 limit ——将包含在结果中元素的数量。
//    // 如果集合大小超出 limit，所有其他元素将被 truncated 参数的单个值替换。
//    val numbers = (1..100).toList()
//    println(numbers.joinToString(limit = 10, truncated = "<...>"))
//
//    val numbers = listOf("one", "two", "three", "four")
//    println(numbers.joinToString { "Element: ${it.toUpperCase()}"})
}

