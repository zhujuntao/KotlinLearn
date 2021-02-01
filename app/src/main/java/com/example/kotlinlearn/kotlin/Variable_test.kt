package com.example.kotlinlearn.kotlin

import kotlin.math.max

/**
 *kotlin 中使用对象数据类型
 * 自定义函数
 * fun methodName(param1:Int,prram2:Int):Int{ return 0}
 */
fun main() {
    val a = 10
    val b = 20
    val value = largerNumber(a, b)
    print("a=$a")
    print("value=$value")
}

fun largerNumber(num1: Int, num2: Int): Int {
//    return max(num1,num2)
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}
/**
 * 简化一
 */
//fun largerNumber(num1:Int,num2: Int):Int=max(num1,num2)
//fun largerNumber(num1:Int,num2: Int)=max(num1,num2)
//fun largerNumber(num1:Int,num2: Int)=if (num1>num2) num1 else num2

/*
fun largerNumber(num1:Int,num2: Int):Int{
//    return max(num1,num2)
    val value= if (num1>num2){
        num1
    }else{
        num2
    }
    return value
   */
/* return if (num1>num2){
        num1
    }else{
        num2
    }*//*

}
*/
/**
 * 匹配值->{执行逻辑}
 * 执行逻辑只有一行时，{}可以省略
 */
fun getScore(name: String) {
    when (name) {
        "Tom" -> 86
        "Jim" -> 90
        "Jack" -> 80
        else -> 0
    }
}

/**
 * is 类型匹配 相当于Java中的instanceof
 * Number类是Int double  float  等数字相关的类的父类
 */
fun checkNumber(num: Number) {
    when (num) {
        is Int -> print("number is int")
        is Double -> print("number is Double")
        is Float -> print("number is Float")
        else -> print("number not support")
    }
}

fun checkNumber(name: String) = when {
    //是否包含
    name.startsWith("Tom") -> 70
    name == "Tom" -> 86
    name == "jack" -> 56
    name == "jim" -> 96
    name == "lily" -> 87
    else -> 0
}


