package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/3
 * Description:
 */

// kotlin接口 方法可以有默认实现？ Java的方法不能有方法体
interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
        println("")
    }
}

interface MyInterface2 {
    val prop: Int // 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface2 {
    override val prop: Int = 29
}


//一个接口可以从其他接口派生，从而既提供基类型成员的实现也声明新的函数与属性。
// 很自然地，实现这样接口的类只需定义所缺少的实现：
interface Named {
    val name: String
}

interface Person10 : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Employee(
    // 不必实现“name”
    override val firstName: String,
    override val lastName: String,
    val position: Int
) : Person10

//解决覆盖冲突
//实现多个接口时，可能会遇到同一方法继承多个实现的问题。例如
interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}