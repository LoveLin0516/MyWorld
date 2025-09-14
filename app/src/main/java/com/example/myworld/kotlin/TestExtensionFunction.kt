package com.example.myworld.kotlin

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/11
 * Description: 测试扩展函数
 */

class Block {
    lateinit var content: String
}

fun Block.copy() = Block()
    .also {
    it.content = this.content
}

fun Block.copy2() = Block()
    .apply {
    this.content = this@copy2.content
}

fun Block.print() = Block()
    .apply {
    println("block---->${this@print.content}")
}

fun Block.print2() = Block()
    .apply {
    this.content = this@print2.content
    println("block---->${this.content}")
}

fun Block.print3() = Block()
    .apply {
    println("block---->${this.content}")
}

fun Block.print4() {
    println("this.content----->${this.content}")
}


fun main() {
    val block = Block()
    block.content = "hello world"

    val block2 = block.copy()
    println(block2.content)

    println(block2.copy2().content)

    val input = block2.copy2().content
    val keyword = "llo"

    val index = input.indexOf(keyword).takeUnless { it >= 0 } ?: error("keyword not found")
    println("index---->$index")

    val index2 = input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found")
    println("index2---->$index2")

    block2.print()
    block2.print2()
//    block2.print3()
    block2.print4()
}