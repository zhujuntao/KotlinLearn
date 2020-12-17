package com.example.learn.bean

class StudentTwo : Person {
    //没有主构造函数，继承时不需要给Person加括号（），
    //没有主构造函数，次构造函数调用父类的构造函数 使用super
    constructor(name: String, age: Int) : super(name, age)
}