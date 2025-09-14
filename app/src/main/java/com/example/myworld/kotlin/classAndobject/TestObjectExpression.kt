package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/8
 * Description: 函数表达式
 */

class TestObjectExpression {

    /**
     * 对象表达式
     */
//    如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。
//    多个超类型可以由跟在冒号后面的逗号分隔的列表指定：
    open class A(x: Int) {
        public open val y: Int = x
    }

    interface B

    //??????????????  object ???????
    val value: A = object : A(1), B {
        override val y: Int
            get() = 15
    }

    //任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写：
    fun foo() {
        val adHoc = object {
            var x: Int = 0
            var y: Int = 0
        }
        println(adHoc.x + adHoc.y)
    }

    //    请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。
//    如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，
//    那么该函数或属性的实际类型会是匿名对象声明的超类型，
//    如果你没有声明任何超类型，就会是 Any。在匿名对象中添加的成员将无法访问。
    private fun foo2() = object {
        var x: Int = 0
    }

    fun publicFoo2() = object {
        var x: Int = 1
    }

    fun bar() {
        foo2().x // 没问题
        // publicFoo2().x // 错误：未能解析的引用“x”
    }

    /**
     * 对象声明
     */
//    object DataProviderManager {
//        fun registerDataProvider(provider: DataProvider) {
//            // ……
//        }
//
//        val allDataProviders: Collection<DataProvider>
//            get() = // ……
//    }

//    这些对象可以有超类型：
//
//    object DefaultListener : MouseAdapter() {
//        override fun mouseClicked(e: MouseEvent) { …… }
//        ​
//        override fun mouseEntered(e: MouseEvent) { …… }
//    }

    /**
     * 伴生对象
     */

    // 类内部的对象声明可以用 companion 关键字标记：
    class MyClass {
        companion object Factory {
            val TAG = "MyClass"
            fun doSth() {

            }

            fun create(): MyClass = MyClass()
        }

        // 伴生对象
        val y = MyClass.Factory
    }

    class Test {
        //可以省略伴生对象的名称
        companion object {
            const val TAG = "Test"
        }

        //伴生对象
        //可以省略伴生对象的名称，在这种情况下将使用名称 Companion：
        val x = Test.Companion

        //其自身所用的类的名称（不是另一个名称的限定符）可用作对该类的伴生对象 （无论是否具名）的引用：
        val y = MyClass
    }

    /**
     * 请注意，即使伴生对象的成员看起来像其他语言的静态成员，
     * 在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口：
     */

    /**
     * 当然，在 JVM 平台，如果使用 @JvmStatic 注解，
    你可以将伴生对象的成员生成为真正的静态方法和字段。
    更详细信息请参见Java 互操作性一节 。
     */

    class Test2 {
        interface Factory<T> {
            fun create(): T
        }

        companion object : Factory<Test2> {
            override fun create(): Test2 {
                return Test2()
            }
        }

        val f: Factory<Test2> = Test2.Companion
        val f1: Factory<Test2> = Test2
    }

    /**
     * 对象表达式和对象声明之间的语义差异
    对象表达式和对象声明之间有一个重要的语义差别：

    对象表达式是在使用他们的地方立即执行（及初始化）的；
    对象声明是在第一次被访问到时延迟初始化的；
    伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配。
     */

    fun main() {
        MyClass.doSth()
        MyClass.Factory.doSth()
        MyClass.Factory.TAG
        val myClass = MyClass.create()

        println(Test().x.TAG)
    }
}