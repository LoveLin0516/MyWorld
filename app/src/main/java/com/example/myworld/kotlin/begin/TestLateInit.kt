package com.example.myworld.kotlin.begin

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/14
 * Description: 测试局部变量lateinit
 */


class Node<T>(val value: T, val next: () -> Node<T>) {

    lateinit var lateinitValue: String

    fun print() {
        println("this::lateinitValue.isInitialized------>${this::lateinitValue.isInitialized}")
        lateinitValue = "hello world"
        println("this::lateinitValue.isInitialized------>${this::lateinitValue.isInitialized}")
    }
}

class Node3<T>(val value: T, val last: (String) -> T) {

}

fun main() {
    lateinit var third: Node<Int>

    val second = Node(2, {
        third
    })
    val first = Node(1, { second })
    third = Node(3, { first })

//    val nodes = generateSequence(first, {
//        it.next.invoke()
//        it.next()
//    })
//    println("Values in the cycle: ${nodes.take(7).joinToString { it.value.toString() }}, ...")

//    println("third.next---->${third.next.invoke()}")
//    println("first.next---->${first.next}")
//    println("second.next()---->${second.next()}")
//    println("third.value---->${third.value}")
//    println("second.value---->${second.value}")
//    println("first.value---->${first.value}")

    third.print()


    lateinit var one: Node3<String>
    val two = Node3<String>("two", {
        one.value + it
    })

    val three = Node3<String>("three", {
        two.value + it
    })

    one = Node3("one", {
        three.value
    })

    println("one----->${one.value}")
    println("two----->${two.value}")
    println("three----->${three.value}")

    println("one----->${one.last}")
    println("two----->${two.last("hello")}")
    println("three----->${three.last.invoke("world")}")

    run {
        println("run----->")
    }
}