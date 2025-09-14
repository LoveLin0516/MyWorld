package com.example.myworld.kotlin.function

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import java.lang.Exception

/**
 * Created by zhuqianglong@bigo.sg on 2020/10/22
 * Description:
 * https://juejin.im/post/6844903833596854279
 */


inline fun <T : Activity> Activity.startActivity(context: Context, clazz: Class<T>) {
    this.startActivity(Intent(this, clazz))
}

inline fun <reified T : Activity> Activity.startActivity2(context: Context) {
    this.startActivity(Intent(context, T::class.java))
}

object TestReified {

}

fun <T> Bundle.getDataOrNull(key: String): T? {
    return this.getSerializable(key) as? T
}

inline fun <reified T> getData(key: String): T? {
    val clazz = T::class.java
    if (clazz.isInstance(key)) {
        return key as T
    }
    return null
}

const val DATA_KEY = "data_key"

// Function
fun <T> Bundle.getDataOrNull(clazz: Class<T>): T? {
    val data = getSerializable(DATA_KEY)
    return if (clazz.isInstance(data)) {
        data as T
    } else {
        null
    }
}


fun <T> Map<String, String>.getDataOrNull2(key: String): T? {
    return this[key] as? T
}

inline fun <reified T> Map<String, String>.getDataOrNull(key: String): T? {
    return this[key] as? T
}

//fun Resources.dpToPx(value: Int): Float {
//    return TypedValue.applyDimension(
//        TypedValue.COMPLEX_UNIT_DIP,
//        value.toFloat(), displayMetrics
//    )
//}
//
//fun Resources.dpToPx2(value: Int): Int {
//    val floatValue: Float = dpToPx(value)
//    return floatValue.toInt()
//}

inline fun <reified T> Resources.dpToPx(value: Int): T {
    val result = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(), displayMetrics
    )
    return when (T::class) {
        Float::class -> result as T
        String::class -> result.toString() as T
        Int::class -> result.toInt() as T
        else -> throw Exception("lalala")
    }
}

inline fun <reified T> String.testClass(value: Int): T {
    return when (T::class) {
        Float::class -> {
            println("1---->")
            value.toFloat() as T
        }
        String::class -> {
            println("2---->")
            value.toString() as T
        }
        Int::class -> {
            println("3---->")
            value as T
        }
        else -> {
            println("4---->")
            throw Exception("lalala")
        }
    }
}

//inline fun <reified T> String.testClass2(value: Int): T {
//    return when (T::class) {
//        Float::class.java -> {
//            println("1---->")
//            value as T
//        }
//        String::javaClass -> {
//            println("2---->")
//            value.toString() as T
//        }
//        Int::class -> {
//            println("3---->")
//            value.toInt() as T
//        }
//        else -> {
//            println("4---->")
//            throw Exception("lalala")
//        }
//    }
//}

fun <T> String.testClass3(value: Int, clazz: Class<T>): T {
    return when (clazz) {
        Float::class.java -> {
            println("1---->")
            value as T
        }
        String::class.java -> {
            println("2---->")
            value.toString() as T
        }
        Int::class.java -> {
            println("3---->")
            value.toInt() as T
        }
        else -> {
            println("4---->")
            throw Exception("lalala")
        }
    }
}


fun main() {
//    val bundle = Bundle().apply {
//        putString("test", "123456")
//    }
//    val value = bundle.getDataOrNull<String>("test")
//    val value2: Int? = bundle.getDataOrNull<Int>("test")

    val map = mapOf<String, String>("1" to "One", "2" to "Two", "3" to "Three")
    val value1 = map.getDataOrNull<String>("1")
    val value2 = map.getDataOrNull<Int>("1")
    println("value1--->${value1}")
    println("value1--->${value2}")

    "Hello World".testClass<Float>(1)
    "Hello World".testClass<String>(1)
    "Hello World".testClass<Int>(1)
    "Hello World".testClass<Any>(1)

    "Hello World".testClass3<Float>(1, Float::class.java)
    "Hello World".testClass3<String>(1, String::class.java)
    "Hello World".testClass3<Int>(1, Int::class.java)
    "Hello World".testClass3<Any>(1, Any::class.java)

    val activity: Activity? = null
    activity?.startActivity2<Activity>(activity)
    activity?.startActivity<Activity>(activity, Activity::class.java)
}