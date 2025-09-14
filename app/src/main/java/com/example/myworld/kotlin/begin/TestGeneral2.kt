package com.example.myworld.kotlin.begin

import java.math.BigDecimal

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/13
 * Description:
 */

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null
    return obj.length
}

val items = listOf<String>("apple", "banana", "pear")

fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a String"
    else -> "unknown"
}

fun transform(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
}

class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}

object Resource {
    val name = "Name"
}

fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

fun doSth(): Boolean  = TODO()

//inline fun <reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

fun main() {
    println("maxOf--->${maxOf(1, 5)}")
    for (item in items) {
        println(item)
    }
    println("when---->${describe(10000)}")
    println("when---->${describe(10000L)}")

    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fit in range")
    }
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is not in range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, tooo")
    }

    for (x in 1..5) {
        println(x)
    }

    for (x in 1..10 step 2) {
        println(x)
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }

    val items = setOf("apple", "banana", "orange")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("apple", "banana", "orange")
    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    val values = mapOf("1" to 1)
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")
    val mainEmail = items.firstOrNull() ?: ""
    val mainEmail2 = items.first {
        it == ""
    }
    val mainEmail3 = items.firstOrNull {
        it.toInt() > 0
    } ?: "0"

    val turtle = Turtle()
    with(turtle) {
        penDown()
        penUp()
        for (i in 1..10) {
            turn(i.toDouble())
        }
    }
    turtle.apply {
        this.penDown()
        penUp()
        for (i in 1..10) {
            turn(i.toDouble())
        }
    }
    turtle.also {
        it.penDown()
        it.penUp()
        for (i in 1..10) {
            it.turn(i.toDouble())
        }
    }
}