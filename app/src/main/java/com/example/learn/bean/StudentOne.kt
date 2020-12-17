package com.example.learn.bean

/*
* StudentOne 主构造函数中增加的name age  不能声明成val var  ，否则会被当成StudentOne类的字段，会导致和父类中同名name age
* name age 不加任何关键字 作用域仅限定在主构造函数当中
* */
class StudentOne(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age) {
    init {
        println("sno is $sno")
        println("grade is $grade")
    }

    constructor(name: String, age: Int) : this("", 0, name, age)

    constructor() : this("", 0)
}