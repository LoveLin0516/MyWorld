package com.example.myworld.kotlin.begin

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/10
 * Description: 测试kotlin基础语法相关类
 */

typealias MapAlias = Map<String, String>

sealed class Expr

data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()

data class Obj(val ss:String, val num: Int): Expr(){

}

object NotANumber : Expr()

data class Person(val name: String, val age: Int) {
    var isAdult: Boolean = false
        get() = age > 18
        set(value) {
            field = value && true
        }

    var student: Int = 0
        get() {
            return field+1
        }
    set(value) {
        field = value+2
    }


    fun getIsAdult(): Boolean {
        return age > 18
    }

    val isMan: Boolean
        inline get() {
            return name == "Lucy"
        }
    var height: Int = 0
        set(value) {
            field = value + 10
        }
    var weight = 0L
        set(value) {
            field = 1000L
        }
    var nickName = ArrayList<String>()
        get() {
            return arrayListOf<String>("1", "2", "3")
        }

    var nickNameList: List<String> = ArrayList<String>()
        get() = mutableListOf("1", "2", "3")

    var nickNameList2: List<String> = ArrayList<String>()
        get() = arrayListOf("1", "2", "3")

    var nickNameList3: List<String> = ArrayList<String>()
        get() = listOf("1", "2", "3").toMutableList()

    var nickNameList4: List<String> = ArrayList<String>()
        get() = listOf("1", "2", "3").toList()

    var nickNameList5: List<String> = ArrayList<String>()
        get() {
            return field.filter { it.contains("1") }
        }
}

val map1 : MutableMap<String,String> = HashMap<String, String>().toMutableMap()

val map2: MapAlias = mapOf("1" to "One", "2" to "Two")

val array1: Array<String> = Arrays.asList("1", "2", "3").toTypedArray()
val array2: Array<String> = arrayOf("1", "2", "3")

val list1 = listOf("1", "2", "3")
val list2 = Arrays.asList("1", "2", "3")

fun main(args: Array<String>) {
    TestGeneral.main()
}


object TestGeneral {

    private var action: ((a: String, b: String) -> Unit)? = null

    private var action3: (a:String, b:String) -> Boolean = {aaa, bbb ->

        println("aaa---->$aaa")
        println("bbb---->"+bbb)

        true
    }

    private var action2: ((a: String, b: String, c: Int, d: List<*>) -> Boolean)? = null

    private lateinit var closure: (map: Map<String, String>) -> Boolean

    fun main() {

        TestGeneral.action3.invoke("1", "2");

        if (map1 is MapAlias) {
            println("typealias---->")
        }

        map1.mapKeys {
            it.key
            it.value
            val a = 0
        }
        map1.mapValues {

        }
        map1.forEach {

        }

        map2.mapKeys {
            println("key---->${it.key}")
            println("value---->${it.value}")
        }

        map2.mapValues {
            println("key--2-->${it.key}")
            println("value--2-->${it.value}")
        }

        map2.forEach {
            println("key--3-->${it.key}")
            println("value--3-->${it.value}")
        }

        map2.forEach { (t, u) ->
            println("hello------->")
            run {

            }
        }

        map2.forEach { t, u ->
            run {
                println("hello------->")
            }
        }

        map2.forEach { (t, u) ->
            println("hello------->")
        }


        map2.forEach { _, value -> println("$value!") }


        val flag: Boolean = action3("nihao", "name")

        action = { a: String, b: String ->
            println("a---->$a")
            println("b---->$b")
        }

        action = { a: String, b: String -> {
           0
           }
        }

        doAction(action)

        closure = {
            it.containsKey("test")
        }
        doClosure(closure)

        val person = Person("xiaoming", 20)
        println("person.isMan--->${person.isMan}")
        println("person.isAdult--->${person.isAdult}")
        person.height = 1000
        person.isAdult=true
        println("person.height--->${person.height}")

        map1.also {
            it.keys.size
        }
        map1.apply {
            this.keys.size
        }
        map1.takeIf {
            it.containsKey("test1")
        }?.forEach { _ ->

        }

        val map3 = map1.toMap().toMutableMap()
        val map4 = map1 - "test1"
        val map5 = map1.filter { it.key == "test1" }
        val map6 = map1.filterKeys {
            it == "test1"
        }
        val map7 = map1.filterNot { it.key == "test1" }

        val list1 = listOf("a", "b")
        val list2 = listOf("x", "y", "z")
        val minSize = minOf(list1.size, list2.size)
        val longestList = maxOf(list1, list2, compareBy { it.size })

        val squares = List(10) { index -> index * index }
        val mutable = MutableList(10) { 0 }

        println("squares: $squares")
        println("mutable: $mutable")

        val map = mapOf("key" to 42)
        // 返回不可空 Int 值 42
        val value: Int = map.getValue("key")

        val mapWithDefault = map.withDefault { k -> k.length }
        // 返回 4
        val value2 = mapWithDefault.getValue("key2")

        // map.getValue("anotherKey") // <- 这将抛出 NoSuchElementException

        println("value is $value")
        println("value2 is $value2")

        println(array2.contentToString())
        println(array2.contentDeepToString())
    }

    private fun doAction(sth: ((String, String) -> Unit)?) {
        sth?.invoke("1", "2")
    }

    private fun doAction2(sth: ((a:String, b:String)-> Unit) ){
        sth("1","2")
        sth.invoke("3", "4")
    }

    private fun doClosure(closure: (Map<String, String>) -> Boolean) {
        val map = mapOf("test1" to "Test")
        println("result---->${closure.invoke(map)}")
    }
}

