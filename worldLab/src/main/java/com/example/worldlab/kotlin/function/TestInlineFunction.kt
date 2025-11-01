package com.example.myworld.kotlin.function

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/10
 * Description:
 */
class TestInlineFunction{

    /**
     * 在 Kotlin 中，我们只能对具名或匿名函数使用正常的、非限定的 return 来退出。
     * 这意味着要退出一个 lambda 表达式，我们必须使用一个标签，
     * 并且在 lambda 表达式内部禁止使用裸 return，因为 lambda 表达式不能使包含它的函数返回：
     */
    fun ordinaryFunction(block: () -> Unit) {
        println("hi!")
    }
    fun foo() {
        ordinaryFunction {
            return@ordinaryFunction // 错误：不能使 `foo` 在此处返回
        }
    }

    /**
     * 但是如果 lambda 表达式传给的函数是内联的，该 return 也可以内联，所以它是允许的：
     */
    inline fun inlined(block: () -> Unit) {
        println("hi!")
    }
    fun foo2() {
        inlined {
            return // OK：该 lambda 表达式是内联的
        }
    }

    /**
     * 这种返回（位于 lambda 表达式中，但退出包含它的函数）称为非局部返回。
     * 我们习惯了在循环中用这种结构，其内联函数通常包含：
     */
    fun hasZeros(ints: List<Int>): Boolean {
        ints.forEach {
            if (it == 0) return true // 从 hasZeros 返回
        }
        return false
    }

    /**
     * 请注意，一些内联函数可能调用传给它们的不是直接来自函数体、而是来自另一个执行上下文的 lambda 表达式参数，例如来自局部对象或嵌套函数。
     * 在这种情况下，该 lambda 表达式中也不允许非局部控制流。为了标识这种情况，该 lambda 表达式参数需要用 crossinline 修饰符标记:
     */
    inline fun f(crossinline body: () -> Unit) {
        val ff = object: Runnable {
            override fun run() = body()
        }
        // ……
    }
}

fun main() {
    TestInlineFunction().foo()
    TestInlineFunction().foo2()
}