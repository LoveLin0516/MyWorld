package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/8
 * Description:
 */
class TestInnerClass {
    class Outer {
        private val bar: Int = 1

        class Nested {
            fun foo() = 2
            fun foo2() = 3
        }
    }

    val demo = Outer.Nested().foo()
}

//内部类
//标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用：
class Outer2 {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }

    val demo = Outer2().Inner().foo()
//    val demo2 = Outer2.Inner().foo()
}


fun main() {

}

//匿名内部类
//使用对象表达式创建匿名内部类实例：
//
//window.addMouseListener(object : MouseAdapter() {
//    ​
//    override fun mouseClicked(e: MouseEvent) { …… }
//    ​
//    override fun mouseEntered(e: MouseEvent) { …… }
//})
//注：对于 JVM 平台, 如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例， 你可以使用带接口类型前缀的lambda表达式创建它：
//
//val listener = ActionListener { println("clicked") }