package com.example.myworld.kotlin.function


/**
 * Created by zhuqianglong@bigo.sg on 2020/9/9
 * Description:
 */

/**
 * Kotlin 函数都是头等的，这意味着它们可以存储在变量与数据结构中、
 * 作为参数传递给其他高阶函数以及从其他高阶函数返回。
 * 可以像操作任何其他非函数值一样操作函数。

为促成这点，作为一门静态类型编程语言的 Kotlin
使用一系列函数类型来表示函数并提供一组特定的语言结构，例如 lambda 表达式。

 */
@Suppress("ALL")

typealias aaaFunction = suspend () -> Int

@Suppress("RedundantIf")
open class TestLambda {

    /**
     * 高阶函数
    高阶函数是将函数用作参数或返回值的函数。
     */
    val onTest: suspend () -> Boolean = {
        true
    }

    val onTest2: aaaFunction = {
        0
    }

    /**
     * 如果有足够信息，编译器可以推断变量的函数类型：
     */
    val onTest3 = { i: Int ->
        i + 2
    }

    /**
     * 如果有足够信息，编译器可以推断变量的函数类型：
     */
    val onTest5 = { it: String, it2: String ->
        ""
    }

    val onTest4: (String) -> String = {
        it
    }

    val onTest6: String.((Int, Int) -> String) -> String = { it: (Int, Int) -> String ->
        this + it(1, 2)
    }

    fun String.doOnTest6(ff: ((Int, Int) -> String)): String {
        return this + ff(1, 2)
    }

    fun doOnTest6() {
        val result = "Hello".onTest6 { i: Int, i1: Int ->
            if (i + i1 > 0) {
                "world"
            } else {
                "world2"
            }
        }
        println("result---->$result")

        val result2 = "Hello".doOnTest6 { i: Int, i1: Int ->
            if (i + i1 > 0) {
                "world"
            } else {
                "world2"
            }
        }
        println("result2---->$result2")
    }

    /**
     * 函数类型实例化
    有几种方法可以获得函数类型的实例：
     */
    class IntTransformer : (Int) -> Int {
        override operator fun invoke(x: Int): Int = TODO()
    }

    val intFunction: (Int) -> Int = IntTransformer()

    val intFunction2: (Int) -> Int = {
        0
    }


    /**
     * 带与不带接收者的函数类型非字面值可以互换，其中接收者可以替代第一个参数，反之亦然。
     * 例如，(A, B) -> C 类型的值可以传给或赋值给期待 A.(B) -> C 的地方，反之亦然：
     */
    val repeatFun: String.(Int) -> String = { times ->
        this.repeat(times)
    }

    fun String.repeatFun(x: Int): String {
        return this.repeat(x)
    }

    val twoParameters: (String, Int) -> String = repeatFun

    fun runTransformation(f: (String, Int) -> String): String {
        return f.invoke("hello", 6)
    }

    val result = runTransformation(repeatFun)

    /**
     * 函数类型实例调用
    函数类型的值可以通过其 invoke(……) 操作符调用：f.invoke(x) 或者直接 f(x)。

    如果该值具有接收者类型，那么应该将接收者对象作为第一个参数传递。
    调用带有接收者的函数类型值的另一个方式是在其前面加上接收者对象， 就好比该值是一个扩展函数：1.foo(2)，
     */
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    fun test() {
        println(stringPlus.invoke("1", "2"))
        println(stringPlus("1", "2"))
//        println("1".stringPlus("2"))
        println(intPlus.invoke(1, 2))
        println(intPlus(1, 2))
        println(1.intPlus(2))
    }

    /**
     * 内联函数
    有时使用内联函数可以为高阶函数提供灵活的控制流。
     */

    /**
     * Lambda 表达式语法
    Lambda 表达式的完整语法形式如下：
     */
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    /**
     * lambda 表达式总是括在花括号中， 完整语法形式的参数声明放在花括号内，并有可选的类型标注， 函数体跟在一个 -> 符号之后。
     * 如果推断出的该 lambda 的返回类型不是 Unit，那么该 lambda 主体中的最后一个（或可能是单个） 表达式会视为返回值。

    如果我们把所有可选标注都留下，看起来如下：
     */
    val sum2 = { x: Int, y: Int -> x + y }
    val sum3 = { x: Int, y: String ->
        x.toString() + y
    }


    /**
     * 传递末尾的 lambda 表达式
    在 Kotlin 中有一个约定：如果函数的最后一个参数是函数，那么作为相应参数传入的 lambda 表达式可以放在圆括号之外：
    这种语法也称为拖尾 lambda 表达式。

    如果该 lambda 表达式是调用时唯一的参数，那么圆括号可以完全省略：
     */
//    val product = items.fold(1) { acc, e -> acc * e }
//    run { println("...") }

    /**
     * it：单个参数的隐式名称
    一个 lambda 表达式只有一个参数是很常见的。

    如果编译器自己可以识别出签名，也可以不用声明唯一的参数并忽略 ->。 该参数会隐式声明为 it：
     */
    val sum4: (Int) -> String = {
        it.toString()
    }

    /**
     * 从 lambda 表达式中返回一个值
    我们可以使用限定的返回语法从 lambda 显式返回一个值。 否则，将隐式返回最后一个表达式的值。

    因此，以下两个片段是等价的：
     */

//    ints.filter {
//        val shouldFilter = it > 0
//        shouldFilter
//    }
//
//    ints.filter {
//        val shouldFilter = it > 0
//        return@filter shouldFilter
//    }

    /**
     * 下划线用于未使用的变量（自 1.1 起）
    如果 lambda 表达式的参数未使用，那么可以用下划线取代其名称：
     */

//    map.forEach { _, value -> println("$value!") }


    /**
     * 匿名函数
    上面提供的 lambda 表达式语法缺少的一个东西是指定函数的返回类型的能力。
    在大多数情况下，这是不必要的。因为返回类型可以自动推断出来。
    然而，如果确实需要显式指定，可以使用另一种语法： 匿名函数 。
     */

    val aa = fun(x: Int, y: Int, z: Int): Int = x + y

    val bb = fun(x: Int, y: Int, z: String): Int {
        return x + y
    }

    /**
     * 这里有一个带有接收者的函数字面值及其类型的示例，其中在接收者对象上调用了 plus
     */
    val sum5: Int.(Int) -> Int = { other -> plus(other) }

    /**
     * 匿名函数语法允许你直接指定函数字面值的接收者类型。
     * 如果你需要使用带接收者的函数类型声明一个变量，并在之后使用它，这将非常有用。
     */
    val sum6 = fun Int.(other: Int): Int = this + other
    val sum7: Int.(other: Int) -> Int = { it ->
        this + it
    }

    fun Int.plus222(other: Int): Int = this + other

    fun doSth2() {
        1.sum5(2)
        1.sum6(2)
        1.sum7(2)
        1.plus222(2)
    }

    val onclick: (() -> Unit?)? = null

    var onLove: ((x: Int, y: Int) -> () -> Boolean)? = null

    lateinit var onWorld: ((a: String, b: String) -> Boolean) -> (value: Boolean) -> Int

    fun doSth() {
        onLove = { i: Int, i1: Int ->
            val sum = i + i1
            val result: () -> Boolean = {
                if (sum > 0) {
                    false
                } else {
                    true
                }
            }
            result
        }
        val finalResult = onLove?.invoke(1, 2)
        println("finalResult--->${finalResult?.invoke()}")

        val input: (a: String, b: String) -> Boolean = { s1: String, s2: String ->
            if (s1.isNotBlank() || s2.isNotBlank()) {
                true
            } else {
                false
            }
        }

        onWorld = { it: (a1: String, b1: String) -> Boolean ->
            val input = it.invoke("1", "")
            val result: ((value: Boolean) -> Int) =
                { it2: Boolean ->
                    if (it2 || input) {
                        1
                    } else {
                        0
                    }
                }
            result
        }

        val finalResult2 = onWorld.invoke(input)
        println("finalResult2--->${finalResult2.invoke(false)}")
    }
}

fun main() {
//    TestLambda().doSth()
    TestLambda().doOnTest6()
    TestLambda().test()
}