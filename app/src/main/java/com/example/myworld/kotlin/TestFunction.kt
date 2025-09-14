package com.example.myworld.kotlin

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/15
 * Description: 函数
 */

fun foo(bar: Int = 0, baz: Int) { /*……*/
}

fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /*……*/
    qux.invoke()
}

fun foo(name: String, age: Int = 1, doSth: (String) -> Unit) { /*……*/
    doSth.invoke("hello")
}

fun foo3(name: String, height: Int = 180, doSth: (String) -> Boolean) {
    println("doSth---->${doSth.invoke(name)}")
    println("doSth--2-->${doSth(name)}")
}

fun reformat(
    str: String, normalizeCase: Boolean = true, upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false, wordSeparator: Char = ' '
) {/*……*/

}

fun foo(vararg strings: String) { /*……*/

}

fun foo2(vararg lists: List<String>) {/*……*/

}

fun foo3(lists: List<String>) {/*……*/

}

fun double(x: Int): Int = x * 2

inline fun <reified T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

fun <T> asList2(vararg ts: T): List<T> {
    val list = ArrayList<T>()
    for (t in ts) {
        list.add(t)
    }
    return list
}


@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    foo(baz = 1) // 使用默认值 bar = 0
    foo { println("nanananna---->") }
    foo(1) {

    }

    foo(name = "Lily", age = 1, doSth = {
        println("---->${it}")
    })
    foo(name = "Lily") {
        println("---->${it}")
    }
    foo("Lily") {

    }

    val str = "hello world"

    reformat(
        str, true, true,
        false, '_'
    )

    reformat(
        str,
        normalizeCase = true,
        upperCaseFirstLetter = true,
        divideByCamelHumps = false,
        wordSeparator = '_'
    )

    foo(strings = *arrayOf("a", "b", "c"))
    foo("a", "b", "c")

    foo2(
        lists = *arrayOf(
            listOf<String>(
                "1",
                "2",
                "3"
            )
        )
    )
    foo2(
        listOf<String>("1", "2", "3"),
        listOf<String>("1", "2", "3")
    )
    foo2(
        lists = *arrayOf(
            listOf<String>(
                "1",
                "2",
                "3"
            ), listOf<String>("1", "2", "3")
        )
    )


    foo3(listOf<String>("1", "2", "3"))

    val list = asList(1, 2, 3)

    val list2 =
        asList2(listOf(1), listOf(2), listOf(3))

    foo3("xiaoming", height = 180) {
        it.contains("ming")
    }

    foo3("xiaohong", 170, {
        it.contains("ming")
    })

    val items = (1..5).toMutableList()

    items.shuffle()
    println("Shuffled items: $items")

    println(items.findLast {
        it > 3
    })

    items.replaceAll { it * 2 }
    println("Items doubled: $items")

    items.fill(5)
    println("Items filled with 5: $items")

    items.takeIf {
        it.size > 0
    }?.onEach {

    }?.forEach {

    }

}