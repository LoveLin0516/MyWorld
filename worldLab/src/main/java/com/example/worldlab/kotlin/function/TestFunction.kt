package com.example.myworld.kotlin.function

import com.example.myworld.kotlin.asList
import com.example.myworld.kotlin.reformat

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/9
 * Description:
 */

class TestFunction {

    /**
     * 覆盖方法总是使用与基类型方法相同的默认参数值。
     * 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值：
     */
    open class A {
        open fun foo(i: Int = 0) {}
    }

    class B : A() {
        override fun foo(i: Int) {
            super.foo(i)
        }
    }

    fun foo(bar: Int = 0, baz: Int) {}

    fun reformat(
        str: String,
        normalizeCase: Boolean = true,
        upperCaseFirstLetter: Boolean = true,
        divideByCamelHumps: Boolean = false,
        wordSeparator: Char = ' '
    ) {
/*……*/
    }

    fun printHello(name: String?): Unit {}

    /**
     * 单表达式函数
    当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可：
     */
    fun double(x: Int): Int = x * 2

    /**
     * 可变数量的参数（Varargs）
    函数的参数（通常是最后一个）可以用 vararg 修饰符标记：
     */

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) {
            result.add(t)
        }
        return result
    }

    /**
     * 在函数内部，类型 T 的 vararg 参数的可见方式是作为 T 数组，
     * 即上例中的 ts 变量具有类型 Array <out T>。
     */
    fun <T> asList2(ts: Array<out T>): List<T> {
        val result = ArrayList<T>()
        for (t in ts) {
            result.add(t)
        }
        return result
    }

    /**
     * 泛型函数
    函数可以有泛型参数，通过在函数名前使用尖括号指定：
     */
    fun <T> singleTonList(item: T): List<T> {
        return ArrayList()
//        return arrayListOf(item)
//        return asList(item)
    }

    /**
     * 尾递归函数
    Kotlin 支持一种称为尾递归的函数式编程风格。
    这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。
    当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归
    ，留下一个快速而高效的基于循环的版本：
     */

    val eps = 1E-10 // "good enough", could be 10^-15
    tailrec fun findFixPoint(x: Double = 1.0): Double =
        if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

    /**
     * 这段代码计算余弦的不动点（fixpoint of cosine），这是一个数学常数。 它只是重复地从 1.0 开始调用 Math.cos，直到结果不再改变，
     * 对于这里指定的 eps 精度会产生 0.7390851332151611 的结果。
     * 最终代码相当于这种更传统风格的代码：
     */

    fun findFixPoint2(): Double {
        var x = 1.0
        while (true) {
            val y = Math.cos(x)
            if (Math.abs(x - y) < eps) return x
            x = Math.cos(x)
        }
    }
}

fun main() {
    TestFunction().foo(bar = 10, baz = 1)

    reformat("hello")
    reformat(str = "world")

    val list = TestFunction().asList(1, 2, 3)
    val array = arrayOf("hello", "world", "!", "HI")
    val list2 = TestFunction().asList2(array)
    println("list--->${list.size}")
    println("list2--->${list2.size}")

    /**
     * 当我们调用 vararg-函数时，我们可以一个接一个地传参，例如 asList(1, 2, 3)，
     * 或者，如果我们已经有一个数组并希望将其内容传给该函数，我们使用伸展（spread）操作符（在数组前面加 *）：
     */
    val list3 = asList("nihao ", *array, *array)
    println("list3--->${list3.size}")

    /**
     * 中缀表示法
    标有 infix 关键字的函数也可以使用中缀表示法（忽略该调用的点与圆括号）调用。中缀函数必须满足以下要求：

    它们必须是成员函数或扩展函数；
    它们必须只有一个参数；
    其参数不得接受可变数量的参数且不能有默认值。
     */

    infix fun Int.shl3(x: Int): Int {
        return 0
    }

    // 用中缀表示法调用该函数
    1 shl3 2

    // 等同于这样
    1.shl3(2)


    /**
     * 函数作用域
    在 Kotlin 中函数可以在文件顶层声明，这意味着你不需要像一些语言如 Java、C# 或 Scala 那样需要创建一个类来保存一个函数。
    此外除了顶层函数，Kotlin 中函数也可以声明在局部作用域、作为成员函数以及扩展函数。
     */
    fun doSth() {
        /**
         * 局部函数
        Kotlin 支持局部函数，即一个函数在另一个函数内部：
         */
        fun doSth2() {
//            main()
        }
        doSth2()
    }

}