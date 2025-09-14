package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/7
 * Description:
 */

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

val list = mutableListOf(1, 2, 3)

fun String.hello(): String {
    return this + "hello world"
}

fun Int.add(value: Int): Int {
    return this + value
}

fun Int.add(value: Double) = 0

fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {
    list.swap(0, 2)
    list.swap2(0, 2)
    //  扩展是静态解析的
//    扩展不能真正的修改他们所扩展的类。通过定义一个扩展，你并没有在一个类中插入新成员，
//    仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
//
//    我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。
//    这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的。例如：
    open class Shape
    class Rectangle : Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"
    fun printClassName(s: Shape) {
        println(s.getName())
    }
    printClassName(Rectangle())
    Example().printFunctionType()

    //伴生对象的扩展函数
    MyClass.printCompanion()
    MyClass.Companion.printCompanion()

    Connection(Host("kotl.in"), 443).connect()
    // 错误，该扩展函数在 Connection 外不可用
    //Host("kotl.in").printConnectionString(443)
}

//如果一个类定义有一个成员函数与一个扩展函数，而这两个函数又有相同的接收者类型、 相同的名字，
//并且都适用给定的参数，这种情况总是取成员函数。 例如：
class Example {
    fun printFunctionType() {
        println("Class method")
    }
}

fun Example.printFunctionType() {
    println("Extension function")
}

//可空接收者
//注意可以为可空的接收者类型定义扩展。这样的扩展可以在对象变量上调用，
//即使其值为 null，并且可以在函数体内检测 this == null，
//这能让你在没有检测 null 的时候调用 Kotlin 中的toString()：检测发生在扩展函数的内部。
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

//扩展属性
//与函数类似，Kotlin 支持扩展属性：
val <T> List<T>.lastIndex: Int
    get() = size - 1

val <R> List<R>.firstIndex: Int
    get() =
        if (size <= 0) {
            -1
        } else {
            0
        }

//注意：由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
//这就是为什么扩展属性不能有初始化器。他们的行为只能由显式提供的 getters/setters 定义。
//例如:
//val House.number = 1 // 错误：扩展属性不能有初始化器

//伴生对象的扩展
//如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数与属性。
//就像伴生对象的常规成员一样， 可以只使用类名作为限定符来调用伴生对象的扩展成员：
class MyClass {
    companion object {}
}

fun MyClass.Companion.printCompanion() {
    println("hello companion")
}


class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() {
        print(port)
    }

    fun Host.printConnectionString() {
        printHostname()   // 调用 Host.printHostname()
        print(":")
        printPort()   // 调用 Connection.printPort()
    }

    fun connect() {
        /*……*/
        host.printConnectionString()   // 调用扩展函数
    }
}

//对于分发接收者与扩展接收者的成员名字冲突的情况，
//扩展接收者优先。要引用分发接收者的成员你可以使用 限定的 this 语法。

class Connection2 {
    fun Host.getConnectionString() {
        toString()         // 调用 Host.toString()
        this@Connection2.toString()  // 调用 Connection.toString()
    }
}

//声明为成员的扩展可以声明为 open 并在子类中覆盖。
//这意味着这些函数的分发对于分发接收者类型是虚拟的，但对于扩展接收者类型是静态的。
//没搞懂。。。

//open class Base { }
//
//class Derived : Base() { }
//
//open class BaseCaller {
//    open fun Base.printFunctionInfo() {
//        println("Base extension function in BaseCaller")
//    }
//
//    open fun Derived.printFunctionInfo() {
//        println("Derived extension function in BaseCaller")
//    }
//
//    fun call(b: Base) {
//        b.printFunctionInfo()   // 调用扩展函数
//    }
//}
//
//class DerivedCaller: BaseCaller() {
//    override fun Base.printFunctionInfo() {
//        println("Base extension function in DerivedCaller")
//    }
//
//    override fun Derived.printFunctionInfo() {
//        println("Derived extension function in DerivedCaller")
//    }
//}
//
//fun main() {
//    BaseCaller().call(Base())   // “Base extension function in BaseCaller”
//    DerivedCaller().call(Base())  // “Base extension function in DerivedCaller”——分发接收者虚拟解析
//    DerivedCaller().call(Derived())  // “Base extension function in DerivedCaller”——扩展接收者静态解析
//}