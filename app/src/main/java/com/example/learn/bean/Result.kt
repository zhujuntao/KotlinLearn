package com.example.learn.bean

import java.lang.Exception

/*
interface Result {
}*/
/*
* 密封类及其所有的子类只能定义在同一个文件的顶层位置，不能嵌套在其他类中
* 底层机制限制
* */
sealed class ResultT
class SuccessTwo(val msg: String) : ResultT()
class FailureTwo(val exception: Exception) : ResultT()