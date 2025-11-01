package com.example.myworld.kotlin.classAndobject

import java.io.File

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/8
 * Description:
 */

typealias FileTable<K> = MutableMap<K, MutableList<File>>

/**
 * 你可以为函数类型提供另外的别名：
 */
typealias MyHandler = (Int, String, String) -> Unit

typealias Predicate<T> = (T) -> Boolean

/**
 * 你可以为内部类和嵌套类创建新名称：
 */
class TestTypeAlias {

    class A {
        inner class Inner
    }

    class B {
        inner class Inner
    }
}

typealias AInner = TestTypeAlias.A.Inner
typealias BInner = TestTypeAlias.B.Inner

/**
 * 类型别名不会引入新类型。 它们等效于相应的底层类型。
 * 当你在代码中添加 typealias Predicate<T> 并使用 Predicate<Int> 时，
 * Kotlin 编译器总是把它扩展为 (Int) -> Boolean。
 * 因此，当你需要泛型函数类型时，你可以传递该类型的变量，反之亦然：
 */

fun main() {

    fun foo(p: Predicate<Int>) = p(42)

    fun foo2(expression: (Int) -> Boolean) {
        expression.invoke(42)
        expression(42)
    }

    fun foo3(handler: MyHandler) = handler.invoke(0, "", "")

    fun foo4(expr: (Int, String, String) -> Unit) {
        expr.invoke(0, "1", "2")
    }

    val f: (Int) -> Boolean = {
        it + 100 > 10
    }
    println(foo(f))

    val p: Predicate<Int> = {
        it > 0
    }
    println(listOf(1, -2).filter(f))
    println(listOf(1, -2).filter(p))

    val m: (Int, String, String) -> Unit =
        { i: Int, s: String, s1: String ->
            println(i.toString() + s + s1)
        }
    val m2: MyHandler = { i, s, s1 ->
        println(i.toString() + s + s1)
    }

    foo3(m)
    foo3(m2)

    foo4(m)
    foo4(m2)

}

