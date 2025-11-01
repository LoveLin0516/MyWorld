package com.example.myworld.kotlin.classAndobject

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/8
 * Description:
 */

class TestDelegateProperty {
    class Example {
        var p: String by Delegates.notNull<String>()
        var m: String by Delegate()

        fun doSth(){
            
        }
    }

    class User {
        var name: String by Delegates.observable("<no name>")
        { kProperty: KProperty<*>, old: String, new: String ->
            println("$old->$new")
        }

        /**
         * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/vetoable.html
         */
        var like: String by Delegates.vetoable("no like") { property, oldValue, newValue ->
            newValue > oldValue
        }

        var max: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
            newValue > oldValue
        }
    }

    /**
     * Delegating to another property
     */
//    class MyClass {
//        var newName: Int = 0
//        @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
//        var oldName: Int by this::newName
//    }

    /**
     *对于一个只读属性（即 val 声明的），委托必须提供一个操作符函数 getValue()，该函数具有以下参数：

       thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是其超类型。
    property —— 必须是类型 KProperty<*> 或其超类型。
    getValue() 必须返回与属性相同的类型（或其子类型）。
     */

    /**
     *  对于一个可变属性（即 var 声明的），委托必须额外提供一个操作符函数 setValue()， 该函数具有以下参数：
     *
    thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是其超类型。
    property —— 必须是类型 KProperty<*> 或其超类型。
    value — 必须与属性类型相同（或者是其超类型）。
     */

    class Resource

    class Owner {
        var varResource: Resource by ResourceDelegate()
    }

    class ResourceDelegate(private var resource: Resource = Resource()) {
        operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
            return resource
        }
        operator fun setValue(thisRef: Owner, property: KProperty<*>, value: Any?) {
            if (value is Resource) {
                resource = value
            }
        }
    }

}


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

/**
 * 延迟属性 Lazy
lazy() 是接受一个 lambda 并返回一个 Lazy <T> 实例的函数，
返回的实例可以作为实现延迟属性的委托： 第一次调用 get() 会执行已传递给 lazy() 的
lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
 */
val lazyValue: String by lazy {
    println("computed")
    "hello"
}




fun main() {
//    val example = TestDelegateProperty.Example()
//    println(example.m)
//    example.m = "123"
    println(lazyValue)
    println(lazyValue)

    val user = TestDelegateProperty.User()
    user.name = "first"
    user.name = "second"

    println(user.max) // 0

    user.max = 10
    println(user.max) // 10

    user.max = 11
    println(user.max) // 11


//    val myClass = TestDelegateProperty.MyClass()
//    // Notification: 'oldName: Int' is deprecated.
//    // Use 'newName' instead
//    myClass.oldName = 42
//    println(myClass.newName) // 42
}