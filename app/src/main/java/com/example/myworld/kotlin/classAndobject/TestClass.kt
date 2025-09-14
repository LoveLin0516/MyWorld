package com.example.myworld.kotlin.classAndobject

/**
 * Created by zhuqianglong@bigo.sg on 2020/8/24
 * Description:
 */

//在 Kotlin 中的一个类可以有一个主构造函数以及一个或多个次构造函数。
// 主构造函数是类头的一部分：它跟在类名（与可选的类型参数）后。
class Person constructor(firstName: String)

//如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
class Person2(private val firstName: String)

// 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数，
open class Person5 constructor(private val firstName: String, private val secondName: String) {
    constructor(age: Int) : this("", "")
    constructor(height: Long) : this("", "")
}


//主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
//在实例初始化期间，初始化块按照它们出现在类体中的顺序执行，与属性初始化器交织在一起：
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}
//如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：
//class Customer public @Inject constructor(name: String) { /*……*/ }


//类也可以声明前缀有 constructor的次构造函数：
class Person3 {
    var children: MutableList<Person> = mutableListOf()

    constructor(parent: Person) {
//        parent.children.add(this)
    }
}

class Person6 {
    val books: MutableList<String> = mutableListOf()
    constructor(book: String)
}

// 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数，
// 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可：
class Person4(val name: String) {
    var children: MutableList<Person> = mutableListOf()

    constructor(name: String, parent: Person) : this(name) {
//        parent.children.add(this)
    }
}

//请注意，初始化块中的代码实际上会成为主构造函数的一部分。
// 委托给主构造函数会作为次构造函数的第一条语句，
// 因此所有初始化块与属性初始化器中的代码都会在次构造函数体之前执行。
// 即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块：
class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

//注意：在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成 一个额外的无参构造函数，
// 它将使用默认值。这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样的通过无参构造函数创建类的实例的库。
class Customer2(val customerName: String = "")

//如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。
// 构造函数的可见性是 public。如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数：
class DontCreateMe private constructor() { /*……*/ }

class DontCreateMe3 private constructor()

class NoDream constructor(private var name: String)

open class NoDream2(private val whatsLike: String) {
    constructor(name: String, whatsLike: String) : this(whatsLike) {
        println("name---->${name}")
    }
}

//默认情况下，Kotlin 类是最终（final）的：它们不能被继承。 要使一个类可继承，请用 open 关键字标记它。
class NoDream3 : NoDream2("basketball") {

}

//如果派生类有一个主构造函数，其基类可以（并且必须） 用派生类主构造函数的参数就地初始化。
class NoDream4(ageError: String) : NoDream2(ageError)

//如果派生类没有主构造函数，那么每个次构造函数必须使用
//super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
//注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：

//class MyView : View {
//    constructor(ctx: Context) : super(ctx)
//
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
//}

open class Shape {
    open fun draw() { /*……*/
    }

    open fun fill() { /*……*/
    }
}

class Circle() : Shape() {

    override fun draw() { /*……*/
    }

    override fun fill() {
        super.fill()
    }
}

//标记为 override 的成员本身是开放的，也就是说，它可以在子类中覆盖。
// 如果你想禁止再次覆盖，使用 final 关键字：
open class Rectangle() : Shape() {
    final override fun draw() { /*……*/
    }
}

open class Shape2 {
    open val vertexCount: Int = 0
}

class Rectangle2 : Shape2() {
    override val vertexCount = 4
}

// 请注意，你可以在主构造函数中使用 override 关键字作为属性声明的一部分。
interface Shape3 {
    val vertexCount: Int
}

class Rectangle3(override val vertexCount: Int = 4) : Shape3 // 总是有 4 个顶点

class Polygon : Shape3 {
    override var vertexCount: Int = 0  // 以后可以设置为任何数
}

/**
 * 这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）使用了任何一个这种属性，
那么都可能导致不正确的行为或运行时故障。设计一个基类时，
应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员。
 */

open class Base(val name: String) {

    init {
        println("Initializing Base")
    }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}

class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init {
        println("Initializing Derived")
    }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

/**
 * 派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现：
 */
open class Rectangle8 {
    open fun draw() {
        println("draw a rectangle")
    }

    open val borderColor: String
        get() = "black"

    var borderColor2: String = "1"
        get() {
            return field + "lalal"
        }
        set(value) {
            field = value + "llalal"
        }

    var borderColor4: String = "1"
        get() = field + "lala"
}

class FilledRectangle : Rectangle8() {
    override fun draw() {
        super.draw()
        println("draw a filled rectangle")
    }

    val fillColor = super.borderColor
    val fillColor2: String
        get() = super.borderColor2
}

/**
 * 在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
 */
class FilledRectangle2 : Rectangle8() {
    override fun draw() { /* …… */
    }

    override val borderColor: String
        get() = super.borderColor

    val borderColor3: String get() = "black"

    inner class Filler {
        fun fill() { /* …… */
        }

        fun drawAndFill() {
            draw()
            this@FilledRectangle2.draw()
            super@FilledRectangle2.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            // 使用 Rectangle 所实现的 borderColor 的 get()
            this@FilledRectangle2.borderColor
            println("Drawn a filled rectangle with color ${super@FilledRectangle2.borderColor}")
        }
    }
}

/**
 * 覆盖规则
在 Kotlin 中，实现继承由下述规则规定：如果一个类从它的直接超类继承相同成员的多个实现，
它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>：
 */

open class Rectangle9 {
    open fun draw() { /* …… */
    }
}

interface Polygon9 {
    fun draw() { /* …… */
    } // 接口成员默认就是“open”的
}

class Square() : Rectangle9(), Polygon9 {
    // 编译器要求覆盖 draw()：
    override fun draw() {
        super<Rectangle9>.draw() // 调用 Rectangle.draw()
        super<Polygon9>.draw() // 调用 Polygon.draw()
    }
}

/**
 * 抽象类
类以及其中的某些成员可以声明为 abstract。 抽象成员在本类中可以不用实现。
需要注意的是，我们并不需要用 open 标注一个抽象类或者函数——因为这不言而喻。
我们可以用一个抽象成员覆盖一个非抽象的开放成员
 */
open class Polygon10 {
    open fun draw() {}
}

abstract class Rectangle10 : Polygon10() {
    abstract override fun draw()
}

/**
 * 伴生对象
如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数（例如，工厂方法），
你可以把它写成该类内对象声明中的一员。

更具体地讲，如果在你的类内声明了一个伴生对象， 你就可以访问其成员，只是以类名作为限定符。
 */

fun main() {
    InitOrderDemo("hello")
    Constructors(1)

//    println("Constructing Derived(\"hello\", \"world\")")
//    val d = Derived("hello", "world")
}