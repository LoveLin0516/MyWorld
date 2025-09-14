package com.example.myworld.kotlin.coroutines

/**
* Created by zhuqianglong@bigo.sg on 2020/8/10
* Description: 测试协程相关
*/

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun test(): () -> Unit = {
    println("")
}

fun test2() = run {
    println("1")
    println("2")
}

fun main() {
//    main0()
//    main1()
//    main2()

//    runBlocking {
//        wait()
//    }

//    wait2()
//    wait3()
//    wait4()
//    wait42()
//    wait6()

//    main2()
//    main6()
    main7()

}

fun main00() {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
    println("Hello,") // 协程已在等待时主线程还在继续
    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
}

fun main0() {
    thread {
        Thread.sleep(1000L)
//        delay(1000L)
        println("world!")
    }
    println("Hello")
    Thread.sleep(2000L)
}

//本质上，协程是轻量级的线程。 它们在某些 CoroutineScope 上下文中与 launch 协程构建器 一起启动。
// 这里我们在 GlobalScope 中启动了一个新的协程，
// 这意味着新协程的生命周期只受整个应用程序的生命周期限制。

//调用了 runBlocking 的主线程会一直 阻塞 直到 runBlocking 内部的协程执行完毕。
fun main1() = run {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
    println("Hello,") // 协程已在等待时主线程还在继续
//    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

    runBlocking {
        delay(2000L)
    }
}

fun main2() = runBlocking<Unit> {// 开始执行主协程
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
    println("Hello,") // 协程已在等待时主线程还在继续
    delay(2000L)
}

suspend fun wait() = run {
    val job = GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // 等待直到子协程执行结束
    println("nihao,")
}

//协程的实际使用还有一些需要改进的地方。 当我们使用 GlobalScope.launch 时，我们会创建一个顶层协程。
// 虽然它很轻量，但它运行时仍会消耗一些内存资源。如果我们忘记保持对新启动的协程的引用，它还会继续运行。
// 如果协程中的代码挂起了会怎么样（例如，我们错误地延迟了太长时间），如果我们启动了太多的协程并导致内存不足会怎么样？
// 必须手动保持对所有已启动协程的引用并 join 之很容易出错。
//
//有一个更好的解决办法。我们可以在代码中使用结构化并发。 我们可以在执行操作所在的指定作用域内启动协程，
// 而不是像通常使用线程（线程总是全局的）那样在 GlobalScope 中启动。
//
//在我们的示例中，我们使用 runBlocking 协程构建器将 main 函数转换为协程。
// 包括 runBlocking 在内的每个协程构建器都将 CoroutineScope 的实例添加到其代码块所在的作用域中。
// 我们可以在这个作用域中启动协程而无需显式 join 之，因为外部协程（示例中的 runBlocking）直到在其作用域中启动的所有协程都执行完毕后才会结束。
// 因此，可以将我们的示例简化为：


//主要是要启动一个新的协程
fun wait2() = runBlocking {
    launch { // 在 runBlocking 作用域中启动一个新协程
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}


fun wait3() = runBlocking {
    GlobalScope.launch { // 在 runBlocking 作用域中启动一个新协程
        delay(1000L)
        //该语句的顺序，会有影响
        println("World!")
    }
    println("Hello,")
    //该语句是否执行，会有影响
//    delay(1000L)
}

//请注意，（当等待内嵌 launch 时）紧挨“Task from coroutine scope”消息之后，
// 就会执行并输出“Task from runBlocking”——尽管 coroutineScope 尚未结束。


//?????????????????????????????
//?????????????????????????????
//?????????????????????????????
//?????????????????????????????
//?????????????????????????????
fun wait4() = runBlocking { // this: CoroutineScope
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope { // 创建一个协程作用域
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
    }

    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
}

fun wait41() = runBlocking { // this: CoroutineScope
    coroutineScope { // 创建一个协程作用域
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
    }

    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
}

fun wait42() = runBlocking { // this: CoroutineScope

    coroutineScope { // 创建一个协程作用域
        launch {
            delay(500L)
            println("Task from nested launch1")
        }

        delay(100L)
        println("Task from coroutine scope1") // 这一行会在内嵌 launch 之前输出
    }

    coroutineScope { // 创建一个协程作用域
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
    }

    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
}


fun wait5() = runBlocking {
    launch { doWorld() } //启动一个新的协程，该协程作用域为runBlocking的作用域
    println("Hello,")
}

fun wait6() = runBlocking {
    doWorld()
    println("Hello,")
}

// 这是你的第一个挂起函数
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

fun main6() = runBlocking {
    repeat(100_000) { // 启动大量的协程
        launch {
            delay(5000L)
            print(".")
        }
    }
}

//全局协程像守护线程
//以下代码在 GlobalScope 中启动了一个长期运行的协程，
// 该协程每秒输出“I'm sleeping”两次，之后在主函数中延迟一段时间后返回。
fun main7() = runBlocking {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // 在延迟后退出
}