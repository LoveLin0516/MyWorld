package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/7
 * Description:
 *  在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public。
 *  如果没有显式指定修饰符的话，默认可见性是 public。
 */


//包内使用：
//如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见；
//如果你声明为 private，它只会在声明它的文件内可见；
//如果你声明为 internal，它会在相同模块内随处可见；
//protected 不适用于顶层声明。

// 文件名：example.kt
private fun foo() {} // 在 example.kt 内可见

public var bar: Int = 5 // 该属性随处可见
    private set         // setter 只在 example.kt 内可见

internal var bar2: Int = 10
    private set
    internal get() = field + 10

internal val baz = 6    // 相同模块内可见


//类和接口 中使用
//对于类内部声明的成员：
//
//private 意味着只在这个类内部（包含其所有成员）可见；
//protected—— 和 private一样 + 在子类中可见。
//internal —— 能见到类声明的 本模块内 的任何客户端都可见其 internal 成员；
//public —— 能见到类声明的任何客户端都可见其 public 成员。

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 默认 public

    class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见

    override val b = 5   // “b”为 protected

//    val nested2 = Nested()
}

// 构造函数，参数如果不是val var的，那么在类中无法直接使用
// 使用val var修饰后，可直接使用
class Unrelated(var outer: Outer) {
    fun doSth() {
        outer.d + outer.c
//        outer.a
//        outer.b
        val bb = Outer.Nested()
    }

    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见
}

class C1 private constructor(a: Int) {}

//局部声明
//局部变量、函数和类不能有可见性修饰符。

