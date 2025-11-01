package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/9/7
 * Description: 数据类
 */


//我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。
//在 Kotlin 中，这叫做 数据类 并标记为 data：


//编译器自动从主构造函数中声明的所有属性导出以下成员：
//
//equals()/hashCode() 对；
//toString() 格式是 "User(name=John, age=42)"；
//componentN() 函数 按声明顺序对应于所有属性；
//copy() 函数（见下文）。


//为了确保生成的代码的一致性以及有意义的行为，数据类必须满足以下要求：
//
//主构造函数需要至少有一个参数；
//主构造函数的所有参数需要标记为 val 或 var；
//数据类不能是抽象、开放、密封或者内部的；
//（在1.1之前）数据类只能实现接口。
data class User(val name: String, val age: Int)

class HaHa(name: String)

//在类体中声明的属性
//请注意，对于那些自动生成的函数，编译器只使用在主构造函数内部定义的属性。
//如需在生成的实现中排除一个属性，请将其声明在类体中：
data class Person11(val name: String) {
    var age: Int = 0
}

fun main() {

//    在 toString()、 equals()、 hashCode() 以及 copy() 的实现中只会用到 name 属性，
//    并且只有一个 component 函数 component1()。虽然两个 Person 对象可以有不同的年龄，但它们会视为相等。
    val person1 = Person11("John")
    val person2 = Person11("John")
    person1.age = 10
    person2.age = 20
    println("person1 == person2: ${person1 == person2}")
    println("person1 with age ${person1.age}: $person1")
    println("person2 with age ${person2.age}: $person2")

//    数据类与解构声明
//    为数据类生成的 Component 函数 使它们可在解构声明中使用：
    val jane = User("Jane", 35)
    val jane2 = User(name = "Jane2", age = 11)
    val (name1, age1) = jane
    println("$name1, $age1 years of age") // 输出 "Jane, 35 years of age"

    //copy方法
    val jane3= jane.copy()
    println("name--->${jane3.name}, age---->${jane3.age}")
}


val jack = User(name = "Jack", age = 1)





