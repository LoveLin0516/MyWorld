package com.example.myworld.kotlin.classAndobject

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myworld.kotlin.printAllValues
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/8
 * Description:
 */

fun main() {
    TestEnumClass.ProtocolState.TALKING.signal()
    TestEnumClass.ProtocolState.TALKING.name
    TestEnumClass.ProtocolState.ALARM.ordinal

//    Kotlin 中的枚举类也有合成方法允许列出定义的枚举常量以及通过名称获取枚举常量。
//    这些方法的签名如下（假设枚举类的名称是 EnumClass）：
    println(TestEnumClass.ProtocolState.valueOf("TALKING"))
    println(TestEnumClass.ProtocolState.values()[2])

    println(enumValues<TestEnumClass.Color>()[1])
    println(enumValues<TestEnumClass.Color>()[1].ordinal)
    println(enumValues<TestEnumClass.Color>()[1].name)
    println(enumValueOf<TestEnumClass.Color>("RED"))

    printAllValues<TestEnumClass.IntArith>()

}

class TestEnumClass {
    enum class Color(val rgb: Int) {
        RED(0x00ff00),
        GREEN(0xffff00),
        YELLOW(0x00ffff),
//        Hasa(rgb)
    }

    //    匿名类
//    枚举常量还可以声明其带有相应方法以及覆盖了基类方法的匿名类。
    enum class ProtocolState {
        WAITING {
            override fun signal(): ProtocolState {
                return TALKING
            }
        },
        TALKING {
            override fun signal(): ProtocolState {
                return WAITING
            }

        },

        ALARM {
            override fun signal(): ProtocolState = TALKING
        };

        abstract fun signal(): ProtocolState
    }

    //    在枚举类中实现接口
//    一个枚举类可以实现接口（但不能从类继承），可以为所有条目提供统一的接口成员实现，
//    也可以在相应匿名类中为每个条目提供各自的实现。只需将接口添加到枚举类声明中即可，如下所示：
    @RequiresApi(Build.VERSION_CODES.N)
    enum class IntArith : BinaryOperator<Int>, IntBinaryOperator {
        PLUS {
            override fun apply(t: Int, u: Int): Int = t + u
        },

        TIMES {
            override fun apply(t: Int, u: Int): Int = t + u
        };

        override fun applyAsInt(left: Int, right: Int): Int {
            return apply(left, right)
        }
    }

    //    自 Kotlin 1.1 起，可以使用 enumValues<T>() 与 enumValueOf<T>()
//    函数以泛型的方式访问枚举类中的常量 ：
    enum class RGB { GREEN, YELLOW, BLUE }

    inline fun <reified T : Enum<T>> printAllValues() {
        println(enumValues<T>().joinToString { it.name })
    }
}