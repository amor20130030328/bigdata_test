package com.gy.match_

object Var {

  def main(args: Array[String]): Unit = {

    /**
      * 如果在case 关键字后跟变量名，那么match前表达式的值会赋值给那个变量
      */
    val ch = 'V'

    ch match {
      case '+' => println("OK~~")
      case mychar => println("Ok~" + mychar)
      case _ => println("ok~~")
    }

    /**
      * 可以匹配对象的任意类型，这样做避免了使用isInstanceOf 和 asInstanceOf 方法
      */

    val obj = 1
    val obj2 = '1'
    val obj3 = "1"
    val obj4 = 1L
    val obj5 = false

    val arr = Array(obj,obj2,obj3,obj4,obj5)

    for(item <- arr){
      val res = item match{
                  case a:Int => a
                  case b:String => "对象是一个字符串:" + b
                  case e:Char => "对象是一个字符:" + e
                  case c:Long => "对象是一个Long类型:" + c
                  case d:Boolean => "对象是布尔类型:" + d
                  case _ => "啥也不是"
                }
      println(res)

    }

    println("===============================================")

    /**
      * Map[String, Int] 和Map[Int, String]是两种不同的类型，其它类推。
      * 在进行类型匹配时，编译器会预先检测是否有可能的匹配，如果没有则报错.
      */

  /*  val flag = 10
    val result = flag match {
      case a : Int => a
      case b : Map[String, Int] => "Map集合"    //会报错
      case _ => "啥也不是"
    }*/


    val i2 = obj match {
      case i: Int => i
    }                                 // case i : Int => i   表示 将 i = obj (其它类推);然后再判断类型

    println(i2)

 /*   var result = obj match {
      case a: Int => a
      case _:BigInt => Int.MaxValue //看这里!
      case b:Map[String, Int] => "对象是一个字符串-数字的Map集合"
      case c:Map[Int, String] => "对象是一个数字-字符串的Map集合"
      case d:Array[String] => "对象是一个字符串数组"
      case e :Array[Int] => "对象是一个数字数组"
      case _ => "啥也不是"
    }
    println(result)*/








  }

}
