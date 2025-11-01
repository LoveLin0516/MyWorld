package com.example.myworld.kotlin.begin

/**
 * Created by zhuqianglong@bigo.sg on 2020/7/29
 * Description:
 */


val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010

fun main(){

    // 相等性，同一性
    val b: Int = 200
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b


    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a


    println(boxedB === anotherBoxedB) // false
    println(boxedA === anotherBoxedA) // true

   // 因此较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
//    val bb: Byte = 1 // OK, 字面值是静态检测的
//    val i: Int = bb // 错误

//    这是完整的位运算列表（只用于 Int 与 Long）：
//    shl(bits) – 有符号左移
//    shr(bits) – 有符号右移
//    ushr(bits) – 无符号右移
//    and(bits) – 位与
//    or(bits) – 位或
//    xor(bits) – 位异或
//    inv() – 位非
    val xx = (1 shl 2) and 0x000FF000

    arrayOf(1, 2, 3)
    arrayOfNulls<Int>(100)
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]

    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    when (xx) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }

    when (xx) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    when (xx) {
        in 1..10 -> print("x is in the range")
//        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    var aa:Int =10
    var bb: Int = 20
    for(xx in aa..bb){

    }

    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println(array[i])
    }
    array.forEach {
        println(it)
    }


    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }


}