package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/7
 * Description: 密封类，主要用来被继承用的
 */

//密封类用来表示受限的类继承结构：当一个值为有限几种的类型、而不能有任何其他类型时。
//在某种意义上，他们是枚举类的扩展：枚举类型的值集合也是受限的，
//但每个枚举常量只存在一个实例，而密封类的一个子类可以有可包含状态的多个实例。

// 一个密封类是自身抽象的，它不能直接实例化并可以有抽象（abstract）成员。
// 密封类不允许有非-private 构造函数（其构造函数默认为 private）。

sealed class Expr2()

sealed class Expr(name: String = "") {

}

data class Const(val number: Double) : Expr(name = "")
data class Sum(val e1: Expr, val e2: Expr) : Expr(name = "nihao")
object NotANumber : Expr()

fun main() {
//    一个密封类是自身抽象的，它不能直接实例化并可以有抽象（abstract）成员。
//    密封类不允许有非-private 构造函数（其构造函数默认为 private）。
//    val expr = Expr()
    val const1 = Const(0.toDouble())
}

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}

