package com.example.myworld.kotlin.classAndobject

/**

* Created by zhuqianglong@bigo.sg on 2020/9/8
* Description:
*/
/**
 * 幕后字段
在 Kotlin 类中不能直接声明字段。
然而，当一个属性需要一个幕后字段时，Kotlin 会自动提供。
这个幕后字段可以使用field标识符在访问器中引用：
 */
var count = 0
    set(value) {
        if (value > 0) {
            field += 1
        }
    }

/**
 * 内联类必须含有唯一的一个属性在主构造函数中初始化。
 * 在运行时，将使用这个唯一属性来表示内联类的实例（关于运行时的内部表达请参阅下文）：
 */
inline class Password(val value: String)

inline class Name(val s: String) {
    val length: Int
        get() = s.length

    fun greet() {
        println("hello $s")
    }
}

/**
 * 然而，内联类的成员也有一些限制：
内联类不能含有 init 代码块
内联类不能含有幕后字段
因此，内联类只能含有简单的计算属性（不能含有延迟初始化/委托属性）
 */

/**
 * 内联类允许去继承接口,但是不能继承其他的类
 *
 * 禁止内联类参与到类的继承关系结构中。
 * 这就意味着内联类不能继承其他的类而且必须是 final。
 */
interface Printable {
    fun prettyPrint(): String
}


inline class Name2(val s: String) : Printable {
    override fun prettyPrint(): String = "Lets go"
}

fun <T> id(x: T) = x


/**
 * 内联类与类型别名
初看起来，内联类似乎与类型别名非常相似。实际上，两者似乎都引入了一种新的类型，并且都在运行时表示为基础类型。

然而，关键的区别在于类型别名与其基础类型(以及具有相同基础类型的其他类型别名)是 赋值兼容 的，而内联类却不是这样。

换句话说，内联类引入了一个真实的新类型，与类型别名正好相反，类型别名仅仅是为现有的类型取了个新的替代名称(别名)：
 */

typealias NameTypeAlias = String

inline class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun main() {
    val name = Name("Jim")
    // `greet` 方法会作为一个静态方法被调用
    name.greet()
    // 属性的 get 方法会作为一个静态方法被调用
    println(name.length)

    val name2 = Name2("Hanmeimei")
    name2.prettyPrint()

    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(string)
    acceptString(nameAlias)

    acceptNameTypeAlias(string)
    acceptNameTypeAlias(nameAlias)

    acceptNameInlineClass(nameInlineClass)

}

