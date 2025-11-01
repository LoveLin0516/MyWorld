package com.example.myworld.kotlin

import com.example.myworld.kotlin.begin.MapAlias
import java.util.regex.Pattern

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/11
 * Description: 测试泛型
 */
enum class Person {
    MAN,
    WOMAN,
    ALL
}

enum class EPageState(val state: Int) {

    STATE_NONE(0), //空页面

    STATE_LOADING(1), //加载中

    STATE_SEARCH_EMPTY_OR_FAILED(2), //搜索无结果

    STATE_NO_NETWORK(3); //没有网

    companion object {
        private val valueMap: Map<Int, EPageState> = values().associateBy { it.state }
        fun generate(type: Int): EPageState {
            return valueMap[type] ?: STATE_NONE
        }
    }

}

enum class RGB { RED, GREEN, BLUE }

typealias MapAlias2 = Map<String, String>

inline fun <reified T : Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString { it.name })
}

inline fun <reified T : Enum<T>> printAllValues2() {
    println(enumValues<T>().joinToString("。") { it.ordinal.toString() })
}

fun main(args: Array<String>) {
//    printAllValues<RGB>() // 输出 RED, GREEN, BLUE
//    printAllValues2<RGB>()
//    val port = System.getenv("PORT")?.toIntOrNull() ?: 80
//    val port2 = System.getenv("Proxy")?.toIntOrNull() ?: 100
//    println("port---->$port")
//    println("port2---->$port2")
//
//    val map: MapAlias = mapOf("1" to "One", "2" to "Two", "3" to "Three")
//    val map2 = HashMap<String, String>()
//
//
//    map.onEach { println("it.key---->${it.key}") }
//        .filter { it.key == "1" }
//        .forEach {
//            println("it.key---->${it.key}")
//        }
//
//    val aa = EPageState.generate(1)
//

}

