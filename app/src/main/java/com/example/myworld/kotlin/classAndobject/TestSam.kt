//package com.example.myworld.kotlin.classAndobject
//
///**
// * Created by zhuqianglong@bigo.sg on 2020/9/7
// * Description: 函数式接口，接口中只有一个抽象方法，成员，
// * 可以有多个非抽象的方法，或成员
// * 常见于Lambda表达式
// */
//
//// An interface with only one abstract method is called a functional interface,
//// or a Single Abstract Method (SAM) interface.
//// The functional interface can have several non-abstract members but only one abstract member.
//
//fun interface KRunnable {
//    fun invoke()
//}
//
//fun interface IntPredicate {
//    fun accept(i: Int): Boolean
//}
//
//// Creating an instance of a class
//val isEven = object : IntPredicate {
//    override fun accept(i: Int): Boolean {
//        return i % 2 == 0
//    }
//}
//
//fun main(){
//    println("Is 7 even? - ${isEven.accept(7)}")
//}
//
//val isEven = IntPredicate { it % 2 == 0 }