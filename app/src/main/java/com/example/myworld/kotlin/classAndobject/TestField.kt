package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/3
 * Description:
 */

val simple: Int? = null // 类型 Int、默认 getter、必须在构造函数中初始化
val inferredType = 1 // 类型 Int 、默认 getter

fun main() {
//   Hello.result2= ""
}

//val isEmpty: Boolean = false
//    get() = this.size ==0

var result: String = ""
    get() = field.toString()
    set(value) {
        field = value + "hello"
    }

// 此 setter 是私有的并且有默认实现
object Hello {
    var result2: String = "abc"
        private set
        get() = field + "hello"
}

var counter = 0 // 注意：这个初始器直接为幕后字段赋值
    set(value) {
        if (value >= 0) field = value
    }


// 如果你的需求不符合这套“隐式的幕后字段”方案，那么总可以使用 幕后属性（backing property）：
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // 类型参数已推断出
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

// 编译期常量 位于顶层或者是 object 声明 或 companion object 的一个成员
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
