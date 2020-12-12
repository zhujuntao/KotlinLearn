package com.example.learn.kotlin
/*
* kotlin 常用数据结构
* */
class Test(var name:String,val lastName:String) {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    val sunLambda: (Int, Int) -> Int = { x, y ->
        x + y
    }

    //    NULL检查机制
//Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
//    val ages = age!!.toInt()
    //不做处理返回 null
//    val ages1 = age?.toInt()
    //age为空返回-1
//    val ages2 = age?.toInt() ?: -1

    //    在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
/*fun main(args: Array<String>) {
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等
}*/
//    类型转换
//    由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
    var a: Byte = 1
    var i: Int =a.toInt()
    /*val b: Byte = 1 // OK, 字面值是静态检测的
    val i: Int = b // 错误*/
    val b: Byte = 1 // OK, 字面值是静态检测的
//    val i: Int = b.toInt() // OK
  /*  每种数据类型都有下面的这些方法，可以转化为其它的类型：

    toByte(): Byte
    toShort(): Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double
    toChar(): Char*/
//    有些情况下也是可以使用自动类型转化的，前提是可以根据上下文环境推断出正确的数据类型而且数学操作符会做相应的重载。例如下面是正确的：
//
//    val l = 1L + 3 // Long + Int => Long













}