package com.example.learn.kotlin

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.learn.R
import com.example.learn.bean.*
import com.example.learn.kotlin.funtest.doSomething
import com.example.learn.utils.TestUtil

class TestActivity : AppCompatActivity() {
    //实现静态方法调用的类  实际上是在类的内部创建了一个伴生类，内部的方法，就相当于伴生类的里面的实例方法，kotlin会保证这个
    //伴生类只会存在一个，
    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, TestActivity::class.java).apply {
                putExtra("param1", "")
                putExtra("param2", "")
                putExtra("param3", "")
            }
            context.startActivity(intent)
        }

        //JvmStatic 只能加在单例类 和companion object 中的方法上 不允许加在普通方法上
        @JvmStatic
        fun doAction2() {

        }

    }

    private lateinit var number: Number

    /*fun getResultMsg(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> result.error.message
        else -> throw IllegalAccessException
    }
  */
    //实现密封类
    fun getResultMsg(result: ResultT) = when (result) {
        is SuccessTwo -> result.msg
        is FailureTwo -> "result.error.message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        // 使用单例类来实现 静态方法的效果
        TestUtil.doAction()
        //顶层方法
        doSomething()
        number = 0
        //判断是否初始化
        if (!::number.isInitialized) {
            number = 1
        }
        var num = (1..20).random() //1-20的随机数


//        场景二: 替代原有匿名内部类，但是需要注意一点就是只能替代含有单抽象方法的类。
        findViewById<TextView>(R.id.tv).setOnClickListener {
            Toast.makeText(this, "aaaa", Toast.LENGTH_LONG).show();
            AlertDialog.Builder(this).apply {
                setTitle("This is a Dialog")
                setMessage("Something important")
                setCancelable(false)
                setPositiveButton("ok") { dialog, _ ->
                    dialog.dismiss()
                }
                setNegativeButton("cancel") { dialog, which ->
                    dialog.dismiss()
                }
                show()
            }
        }
        /* lambda表达式类型
         Kotlin中提供了简洁的语法去定义函数的类型.
         () -> Unit//表示无参数无返回值的Lambda表达式类型

         (T) -> Unit//表示接收一个T类型参数，无返回值的Lambda表达式类型

         (T) -> R//表示接收一个T类型参数，返回一个R类型值的Lambda表达式类型

         (T, P) -> R//表示接收一个T类型和P类型的参数，返回一个R类型值的Lambda表达式类型

         (T, (P,Q) -> S) -> R//表示接收一个T类型参数和一个接收P、Q类型两个参数并返回一个S类型的值的Lambda表达式类型参数，返回一个R类型值的Lambda表达式类型
       */

//        如果Java方法的参数列表且只有一个Java单抽象方法接口参数，可以将接口名进行省略
//        当lambda表达式是最后一个参数时，可以将lambda表达式移到括号外，同时，如果lambda表达式还是方法的唯一一个参数时，
//        还可以将方法的括号进行省略
//        演变过程：
        findViewById<TextView>(R.id.tv).setOnClickListener(View.OnClickListener {

        })
        findViewById<TextView>(R.id.tv).setOnClickListener({

        })
        findViewById<TextView>(R.id.tv).setOnClickListener() {

        }
        findViewById<TextView>(R.id.tv).setOnClickListener {

        }
        /* 场景一: lambda表达式与集合一起使用，是最常见的场景，可以各种筛选、映射、变换操作符和对集合数据进行各种操作，非常灵活，
         相信使用过RxJava中的开发者已经体会到这种快感，没错Kotlin在语言层面，无需增加额外库，就给你提供了支持函数式编程API。
 */
        val nameList = listOf("Kotlin", "Java", "php", "Python", "JavaScript", "Scala", "C", "C++", "Go", "Swift")
        nameList.filter {
            it.startsWith("K")
        }.map {
            "$it is a very good language"
        }.forEach {
            print(it)
        }

//        Kotlin中出现的常用操作符和用法介绍

        /* ？操作符
         表示这个对象可能为空*/
        //在变量类型后面加上问号，代表该变量是可空变量
        var name: String? = "zhangsan"

        name?.length  //如果name非空，就返回name.length，否则返回null 这个表达式的类型是Int?

        /* ?: 操作符
         如果 r 非空，我使用它；否则使用某个非空的值 x*/
//        val l: Int = if (name != null) name.length else -1
//        除了完整的 if-表达式，这还可以通过 Elvis 操作符表达：
//        如果 ?: 左侧表达式非空，elvis操作符就返回其左侧表达式，否则返回右侧表达式。请注意，当且仅当左侧为空时，才会对右侧表达式求值。
        val n = name?.length ?: -1
        /* !! 操作符
         这会返回一个非空的 b 值 或者如果 b 为空，就会抛出一个 NPE（空指针） 异常：*/
//        val l =name!!.length
//        因此，如果你想要一个 NPE，你可以得到它，但是你必须显式要求它，否则它不会不期而至。

        /* ==与===
         ==判断值是否相等，===判断值及引用是否完全相等。*/
        /* val num:Int =128
          val a:Int?=num
          val b:Int?=num
          print(a==b)
          print(a===b)*/
        /*..代表从x到y，包括x和y,这是一个闭区间运算符，而until则是半闭区间运算符，代表从a到b范围内所有的值，包括a和不包括b。
        in代表在一个区间中，！in代表不在一个区间中。*/
//        使用 in 运算符来检查某个数字是否在指定区间内
        /*if (i in 1..10) {
            //等价于 1<=i &&i<=10
            print(i);
        }*/
//        //使用until函数,创建一个不包括其结束元素的区间
        /* for (i in 1 until 10) {
             //表示 i in [1,10) 排除了10
             println(i)
         }*/
        /* downTo()函数
                 倒叙遍历，区间内循环：*/
        //倒叙遍历 4321
        /* for (i in 4 downTo 1) {
             println(i)
         }*/

        /* step()函数
                 可以进行任意数量的迭代，而不是每次变化都是1*/
        /* for(i in 1..4 step 2) print(i) //prints 1,3
         for (i in 4 downTo 1 step 2) print(i) // 4,2*/
        /*::符号
        得到类的Class对象*/

//        startActivity(Intent(this@KotlinActivity, MainActivity::class.java))

        /* @符号
         1、限定this的类型*/
        /* class User{
            inner  class State{
                fun getUser():User{
                    //返回user
                    return this@User
                }
                fun getState(): State{
                    //返回State
                    return this@State
                }
            }
        }*/
        /* 2、作为标签
         跳出双层for
         loop@ for (itemA in arraysA) {
             var i : Int = 0
             for (itemB in arraysB) {
                 i++
                 if (itemB > 2) {
                     break@loop
                 }

                 println("itemB:$itemB")
             }

         }*/
        /* 命名函数自动定义标签：

         fun fun_run(){
             run {
                 println("lambda")
             }
             var i: Int = run {
                 return@run 1
             }
             println("$i")
             //匿名函数可以通过自定义标签进行跳转和返回
             i = run (outer@{
                 return@outer 2
             })
             println(i)
         }*/
        /* 从forEach函数跳出
         fun forEach_label(ints: List<Int>)
         {
             var i =2
             ints.forEach {
                 //forEach中无法使用continue和break;
 //        if (it == 0) continue //编译错误
 //        if (it == 2) /*break //编译错误 */
                 print(it)
             }
             run outer@{
                 ints.forEach {
                     if (it == 0) return@forEach //相当于在forEach函数中continue,实际上是从匿名函数返回
                     if (it == 2) return@outer //相当于在forEach函数中使用break,实际上是跳转到outer之外
                 }
             }

             if (i == 3)
             {
                 //每个函数的名字代表一个函数地址，所以函数自动成为标签
                 return@forEach_label //等同于return
             }
         }
 */
        /*  as?操作符
  当使用 as 转型的时候，可能会经常出现 ClassCastException。 所以，现在可以使as?安全转型，当转型不成功的时候，它会返回 null。

  注：在使用intent传值的时候，会出现空字符串不能用as强制转型，这是应该使用as?

  val m: Int? = a as? Int*/
        /*冒号：
        用于类的继承，变量的定义
        1、类型和超类型之间的冒号前要有一个空格
        2、实例和类型之间的冒号前不要空格

       //定义全局变量时
        var str: String? = null

        //类的继承与变量定义
        class TestActivity<T : Serializable>(str: String) : Activity{}
        类型判断符 is
        检查某个实例是否是某个类型，如果判断出属于某个类型，那么判断后的分支中可以直接可当该类型使用，无需显示转换

        fun getStringLength(obj: Any): Int? {
            //obj在&&右边自动动转换成"String"类型
            if (obj is String && obj.length > 0)
                return obj.length
            return null
        }*/

        /*多行输入符 三个双引号
                三引号的形式用来输入多行文本，也就是说在三引号之间输入的内容将被原样保留，之中的单号和双引号不用转义，其中的不可见字符比如/n和/t都会被保留。

        val str = """
        one
        two
            """
        //等价于
        val str = "one\ntwo"
        val str =  "one" +"\n"+"two"*/

        /* $操作符
         字符串可以包含模板表达式，及一小段代码，会求值并把结果包含到字符串中。模板字符串以美元符号$开头，由一个简单的名字构成：

         val value:Int=5;
         val str:String="the value is $value"
         println("itemB:$itemB")

 //字符串模板
         var userInfo = "name:${user.name},  age:$age"
         或花括号括起来的任意表达式

         val g:Int=2
         val h:Int=3
         val str:String="g+h=${g+h}"
         转义字符串和原生字符串都支持模板字符串。如果想要在原生字符串中使用$（它不支持反斜杠转义），可以使用以下语法：

         val str:String="""the price is ${'$'}199"""*/
        /*  val persons = listOf(Person(name = "Alice", age = 18), Person(name = "Mikyou", age = 20), Person(name = "Bob", age = 16))
          println(persons.maxBy({ p: Person -> p.age }))*/
//        可以替代为
//        成员引用最常见的使用方式就是类名+双冒号+成员(属性或函数)
//        val persons = listOf(Person(name = "Alice", age = 18), Person(name = "Mikyou", age = 20), Person(name = "Bob", age = 16))
//        println(persons.maxBy(Person::age))//成员引用的类型和maxBy传入的lambda表达式类型一致
        /*val persons= listOf(1,3,4,56,77)
        println(persons.maxBy { a: Int -> a  })*/


    }
}