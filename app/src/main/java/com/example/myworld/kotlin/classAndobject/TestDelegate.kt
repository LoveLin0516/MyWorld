package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/8
 * Description:
 */

class TestDelegate {
    interface Base {
        fun print()
        fun sayHello()
    }

    open class BaseImpl(val x: Int) : Base {
        override fun print() {
            println(x)
        }

        override fun sayHello() {
            println("hello")
        }

        fun sayWorld() {
            println("world")
        }

    }

    /**
     * 有点类似于多重继承
     *
     * Derived 的超类型列表中的 by-子句表示 b 将会在 Derived 中内部存储，
     * 并且编译器将生成转发给 b 的所有 Base 的方法。
     */
    class Derived(b: Base) : Base by b {
        fun doSth() {
            sayHello()
            print()
        }

        /**
         * 覆盖由委托实现的接口成员
        覆盖符合预期：编译器会使用 override 覆盖的实现而不是委托对象中的。
        如果将 override fun printMessage() { print("abc") }
        添加到 Derived，那么当调用 printMessage 时程序会输出“abc”而不是“10”：
         */
        override fun sayHello() {
            println("hello2")
        }
    }
    class Person : Base by BaseImpl(100)

    /**
     * 只有接口才能被委托
     */
//    class Derived2(b2: BaseImpl) : BaseImpl by b2
}

/**
 * 但请注意，以这种方式重写的成员不会在委托对象的成员中调用 ，
 * 委托对象的成员只能访问其自身对接口成员实现：
 *
 *
 *
interface Base {
val message: String
fun print()
}

class BaseImpl(val x: Int) : Base {
override val message = "BaseImpl: x = $x"
override fun print() { println(message) }
}

class Derived(b: Base) : Base by b {
// 在 b 的 `print` 实现中不会访问到这个属性
override val message = "Message of Derived"
}

fun main() {
val b = BaseImpl(10)
val derived = Derived(b)
derived.print()
println(derived.message)
}

BaseImpl: x = 10
Message of Derived

 */
fun main() {

    val b = TestDelegate.BaseImpl(100)
    b.sayHello()
    TestDelegate.Derived(b).print()
    TestDelegate.Derived(b).sayHello()

    TestDelegate.Person().print()
}

