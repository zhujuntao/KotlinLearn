package com.example.learn.kotlin.`interface`

interface Study {
    fun readBooks()
    //可以选择实现，不实现就使用默认的逻辑
    fun doHomeWork(){
        println("do homework default implementation")
    }
}