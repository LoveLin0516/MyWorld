package com.example.myworld.kotlin.classAndobject

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/7
 * Description:
 */

class Box2<T : List<String>>(t: T) {
    var value: T = t
}

fun doSth() {
    val list = ArrayList<String>()
    Box2(list).value
}

class Box<T>(t: T) {
    var value = t
}

// Java
//首先，Java 中的泛型是不型变的，这意味着 List<String> 并不是 List<Object> 的子类型。
//为什么这样？ 如果 List 不是不型变的，它就没比 Java 的数组好到哪去，因为如下代码会通过编译然后导致运行时异常：
//List<String> strs = new ArrayList<String>();
//List<Object> objs = strs; // ！！！此处的编译器错误让我们避免了之后的运行时异常
//objs.add(1); // 这里我们把一个整数放入一个字符串列表
//String s = strs.get(0); // ！！！ ClassCastException：无法将整数转换为字符串

fun main() {
    val box = Box<Int>(1)
    val pen = Box<String>("Hello World")
    val box2 = Box(2)

    val intSource: Source<Int> = object : Source<Int> {
        override fun nextT(): Int {
            return 0
        }
    }
    // 可以赋值给T的父类型
    val source1: Source<Number> = intSource
    val source2: Source<Any> = intSource

    //参数可以传值进T的子类型
    val numberSource: Source3<Number> = object : Source3<Number> {
        override fun lastT(t: Number) {
            println("lastT----->$t")
        }
    }
    numberSource.lastT(123)
    numberSource.lastT(1.0)
}


//为了修正这一点，我们必须声明对象的类型为 Source<? extends Object>，这是毫无意义的，
//因为我们可以像以前一样在该对象上调用所有相同的方法，所以更复杂的类型并没有带来价值。但编译器并不知道。
//
//在 Kotlin 中，有一种方法向编译器解释这种情况。这称为声明处型变：
//我们可以标注 Source 的类型参数 T 来确保它仅从 Source<T> 成员中返回（生产），并从不被消费。
//为此，我们提供 out 修饰符：

//一般原则是：当一个类 C 的类型参数 T 被声明为 out 时，它就只能出现在 C 的成员的输出-位置，
//但回报是 C<Base> 可以安全地作为 C<Derived>的超类。

// 声明处型变：

// 可以赋值给T的父类型
interface Source<out T> {
    fun nextT(): T
}

//Type parameter T is declared as 'in' but occurs in 'out' position in type T
//interface Source2<in T> {
//    fun lastT(): T
//}

//参数可以传进T的子类型
interface Source3<in T> {
    fun lastT(t: T)
}

fun demo(stringSource: Source<String>) {
    val source: Source<Any> = stringSource
}


interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}


//另外除了 out，Kotlin 又补充了一个型变注释：in。
//它使得一个类型参数逆变：只可以被消费而不可以被生产。逆变类型的一个很好的例子是 Comparable：
fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的子类型
    // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
    val y: Comparable<Double> = x // OK！
}

