package com.example.myworld.kotlin.begin

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/24
 * Description:
 */


fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // 非局部直接返回到 foo() 的调用者
        print(it)
    }
    println("this point is unreachable")
}

fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print(" done with explicit label")
}

fun foo11() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }
    print(" done with implicit label")
}

fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // 局部返回到匿名函数的调用者，即 forEach 循环
        print(value)
    })
    print(" done with anonymous function")

    listOf(1,2,3,4,5).forEach { _ ->
        println("")
    }
}

fun foo3() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
            print(it)
        }
    }
    print(" done with nested loop")
}

fun main(){

    loop@ for (i in 1..100) {
        // ……
    }

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (true) break@loop
        }
    }

    foo()
    foo1()
    foo11()
    foo2()
    foo3()

    val aa=1
    val bb=1

    aa.let {
        bb.let {
            if(aa==1 && bb==1){
                return
            }
        }
    }

    println("final result")

}