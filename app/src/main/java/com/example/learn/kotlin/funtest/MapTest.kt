package com.example.learn.kotlin.funtest

class MapTest {
    fun test() {
        val map = HashMap<String, Int>()
        map["apple"] = 1
        val num = map["apple"]
        val map1 = mapOf("apple" to 1, "apple" to 2)

        val list = listOf("apple", "banana", "orange")
        val lambda = { fruit: String -> fruit.length }
//        val maxLength=list.maxBy(lambda)
//        val maxLength=list.maxBy({fruit:String ->fruit.length})
//        val maxLength=list.maxBy(){fruit:String ->fruit.length}
//        val maxLength=list.maxBy{fruit:String ->fruit.length}
//        val maxLength=list.maxBy{fruit ->fruit.length}
        val maxLength = list.maxBy { it.length }
//        val newlist = list.map { it.toUpperCase() }
        //过滤数据
        val newlist = list.filter { it.length <= 5 }.map { it.toUpperCase() }
        //any至少存在一个
        //all所有的都满足
        val anyResult = list.any { it.length <= 5 }
        val allResult = list.all { it.length <= 5 }

    }
}