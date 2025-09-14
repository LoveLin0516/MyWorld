@file:Suppress("IfThenToSafeAccess")

package com.example.myworld.kotlin.begin

/**
 *
 * 接口中伴生对象的 @JvmStatic 与 @JvmField
对于 Kotlin 1.3，可以使用注解 @JvmStatic 与 @JvmField 标记接口的 companion 对象成员。在类文件中会将这些成员提升到相应接口中并标记为 static。

例如，以下 Kotlin 代码：

interface Foo {
companion object {
@JvmField
val answer: Int = 42
​
@JvmStatic
fun sayHello() {
println("Hello, world!")
}
}
}
相当于这段 Java 代码：

interface Foo {
public static int answer = 42;
public static void sayHello() {
// ……
}
}
 */


/**
 * Created by zhuqianglong@bigo.sg on 2020/7/10
 * Description:
 */
fun countFirst(s: Any): Int {
    val firstChar = (s as? CharSequence)?.firstOrNull()
    if (firstChar != null)
        return s.count { it == firstChar } // s: Any 会智能转换为 CharSequence

    val firstItem = (s as? Iterable<*>)?.firstOrNull()
    if (firstItem != null)
        return s.count { it == firstItem } // s: Any 会智能转换为 Iterable<*>
    return -1
}

fun String?.isNotNull(): Boolean = this != null

fun foo(s: String?) {
    if (s.isNotNull()) s?.length // 没有智能转换 :(
}


fun foo2(s: String?) {
    if (s != null) s.length
}

fun bar(x: String?) {
    if (!x.isNullOrEmpty()) {
        println("length of '$x' is ${x.length}") // 哇，已经智能转换为非空！
    }
}

interface Foo {
    companion object {
        @JvmField
        val answer: Int = 42

//        @JvmStatic
//        fun sayHello() {
//            println("Hello, world!")
//        }
    }
}

internal interface Foo2 {
    companion object {
        const val answer = 42
        fun sayHello() {
            // ……
        }
    }
}

annotation class Foo3 {
    enum class Direction { UP, DOWN, LEFT, RIGHT }

    annotation class Bar

    companion object {
        fun foo(): Int = 42
        val bar: Int = 42
    }
}

/**
 * Kotlin 1.3 引入了一种新的声明方式——inline class。内联类可以看作是普通类的受限版，尤其是内联类必须有且只有一个属性：
 *
 * Kotlin 编译器会使用此限制来积极优化内联类的运行时表示，
 * 并使用底层属性的值替换内联类的实例，
 * 其中可能会移除构造函数调用、GC 压力，以及启用其他优化：
 */
inline class Name(val s: String)


fun main() {
    val string = "abacaba"
    val countInString = countFirst(string)
    println("called on \"$string\": $countInString")

    val list = listOf(1, 2, 3, 1, 2)
    val countInList = countFirst(list)
    println("called on $list: $countInList")

    // 下一行不会调用构造函数，并且
    // 在运行时，“name”只包含字符串 "Kotlin"
    val name = Name("Kotlin")
    println(name.s)

    val keys = 'a'..'f'
    val map = keys.associateWith { it.toString().repeat(5).capitalize() }
    map.forEach { println(it) }

    fun printAllUppercase(data: List<String>) {
        val result = data
            .filter { it.all { c -> c.isUpperCase() } }
            .ifEmpty { listOf("<no uppercase>") }
        result.forEach { println(it) }
    }

    printAllUppercase(listOf("foo", "Bar"))
    printAllUppercase(listOf("FOO", "BAR"))

    val s = "    \n"
    println(s.ifBlank { "<blank>" })
    println(s.ifEmpty { null })
}
