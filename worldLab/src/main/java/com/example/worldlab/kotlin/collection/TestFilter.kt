package com.example.myworld.kotlin.collection

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */
class TestFilter {
    fun test() {
        val numbers = listOf("one", "two", "three", "four")
        val longerThan3 = numbers.filter { it.length > 3 }
        println(longerThan3)
        numbers.filterIndexed { index, name ->
            name.length
            true
        }
        numbers.filterNot {
            it.length > 100
        }

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        numbersMap.filter {
            true
        }
        numbersMap.filterKeys {
            it.contains("name")
        }

        val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
        println(filteredMap)

        // 还有一些函数能够通过过滤给定类型的元素来缩小元素的类型：
        //filterIsInstance() 返回给定类型的集合元素。在一个 List<Any> 上被调用时，filterIsInstance<T>() 返回一个 List<T>，从而让你能够在集合元素上调用 T 类型的函数。
        val numbers2 = listOf(null, 1, "two", 3.0, "four")
        println("All String elements in upper case:")
        numbers2.filterIsInstance<String>().forEach {
            println(it.toUpperCase())
        }

        // filterNotNull() 返回所有的非空元素。在一个 List<T?> 上被调用时，filterNotNull()
        // 返回一个 List<T: Any>，从而让你能够将所有元素视为非空对象。
        val numbers3 = listOf(null, "one", "two", null)
        numbers3.filterNotNull().forEach {
            println(it.length)   // 对可空的 String 来说长度不可用
        }

        // 划分
        //另一个过滤函数 – partition() – 通过一个谓词过滤集合并且将不匹配的元素存放在一个单独的列表中。
        // 因此，你得到一个 List 的 Pair 作为返回值：
        // 第一个列表包含与谓词匹配的元素并且第二个列表包含原始集合中的所有其他元素。
        val numbers4 = listOf("one", "two", "three", "four")
        val (match, rest) = numbers4.partition { it.length > 3 }

        println(match)
        println(rest)

        //检验谓词
        //最后，有些函数只是针对集合元素简单地检测一个谓词：
        //
        //如果至少有一个元素匹配给定谓词，那么 any() 返回 true。
        //如果没有元素与给定谓词匹配，那么 none() 返回 true。
        //如果所有元素都匹配给定谓词，那么 all() 返回 true。注意，在一个空集合上使用任何有效的谓词去调用
        // all() 都会返回 true 。这种行为在逻辑上被称为 vacuous truth。
        val numbers5 = listOf("one", "two", "three", "four")

        println(numbers5.any { it.endsWith("e") })
        println(numbers5.none { it.endsWith("a") })
        println(numbers5.all { it.endsWith("e") })

        println(emptyList<Int>().all { it > 5 })   // vacuous truth

        //any() 和 none() 也可以不带谓词使用：在这种情况下它们只是用来检查集合是否为空。
        // 如果集合中有元素，any() 返回 true，否则返回 false；none() 则相反。
        val numbers6 = listOf("one", "two", "three", "four")
        val empty = emptyList<String>()

        println(numbers6.any())
        println(empty.any())

        println(numbers6.none())
        println(empty.none())

    }
}

fun main() {
    TestFilter().test()
}