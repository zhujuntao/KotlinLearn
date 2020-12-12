package com.example.learn.kotlin.funtest

class WithTest {
    var list = listOf("Apple", "Banana", "Orange", "Pear")
    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruit!")
        toString()
    }
    val result_two = StringBuilder().run {
        append("Start eating fruit. \n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruit")
        toString()
    }
    val result_Three = StringBuilder().apply {
        append("Start eating fruit. \n")
        for (fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruit")
    }
    var  ss=result_Three.toString()





}