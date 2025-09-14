package com.example.myworld.kotlin.collection

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Created by zhuqianglong@bigo.sg on 2020/11/14
 * Description:
 */

@RequiresApi(Build.VERSION_CODES.N)
fun main(){
//    getOrElse() 与 list 的工作方式相同：对于不存在的键，其值由给定的 lambda 表达式返回。
//    getOrDefault() 如果找不到键，则返回指定的默认值。
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap.get("one"))
    println(numbersMap["one"])
    println(numbersMap.getOrDefault("four", 10))
    println(numbersMap.getOrElse("four",{
        11
    }))
    println(numbersMap["five"])            // null
    //numbersMap.getValue("six")      // exception!

    println(numbersMap.keys)
    println(numbersMap.values)

    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
    println(filteredMap)

    val numbersMap2 = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredKeysMap = numbersMap2.filterKeys { it.endsWith("1") }
    val filteredValuesMap = numbersMap2.filterValues { it < 10 }

    println(filteredKeysMap)
    println(filteredValuesMap)


    //由于需要访问元素的键，plus（+）与 minus（-）运算符对 map 的作用与其他集合不同。 plus 返回包含两个操作数元素的
    // Map ：左侧的 Map 与右侧的 Pair 或另一个 Map 。 当右侧操作数中有左侧 Map 中已存在的键时，该条目将使用右侧的值。
    val numbersMap3 = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap3 + Pair("four", 4))
    println(numbersMap3 + Pair("one", 10))
    println(numbersMap3 + mapOf("five" to 5, "one" to 11))

    val numbersMap4 = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap4 - "one")
    println(numbersMap4 - listOf("two", "four"))

    val numbersMap5 = mutableMapOf("one" to 1, "two" to 2)
    numbersMap5.put("three", 3)
    println(numbersMap5)

    //要一次添加多个条目，请使用 putAll() 。它的参数可以是 Map 或一组 Pair ： Iterable 、 Sequence 或 Array
    val numbersMap6 = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMap6.putAll(setOf("four" to 4, "five" to 5))
    println(numbersMap6)

    //如果给定键已存在于 Map 中，则 put() 与 putAll() 都将覆盖值。 因此，可以使用它们来更新 Map 条目的值。

    val numbersMap7 = mutableMapOf("one" to 1, "two" to 2)
    val previousValue = numbersMap7.put("one", 11)
    println("value associated with 'one', before: $previousValue, after: ${numbersMap["one"]}")
    println(numbersMap7)

    //plusAssign （+=） 操作符。
    //[] 操作符为 set() 的别名。
    val numbersMap8 = mutableMapOf("one" to 1, "two" to 2)
    numbersMap8["three"] = 3     // 调用 numbersMap.set("three", 3)
    numbersMap8 += mapOf("four" to 4, "five" to 5)
    println(numbersMap8)

    // 要从可变 Map 中删除条目，请使用 remove() 函数。 调用 remove() 时，可以传递键或整个键值对。 如果同时指定键和值，则仅当键值都匹配时，才会删除此的元素。
    val numbersMap9 = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMap9.remove("one")
    println(numbersMap9)
    numbersMap9.remove("three", 4)            //不会删除任何条目
    println(numbersMap9)

    //还可以通过键或值从可变 Map 中删除条目。 在 Map 的 .keys 或 .values 中调用 remove()
    // 并提供键或值来删除条目。 在 .values 中调用时， remove() 仅删除给定值匹配到的的第一个条目。

    val numbersMap10 = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "threeAgain" to 3)
    numbersMap10.keys.remove("one")
    println(numbersMap10)
    numbersMap10.values.remove(3)
    println(numbersMap10)


    //minusAssign （-=） 操作符也可用于可变 Map 。
    val numbersMap11 = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMap11 -= "two"
    println(numbersMap11)
    numbersMap11 -= "five"             //不会删除任何条目
    println(numbersMap11)

}