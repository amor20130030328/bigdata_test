package com.gy.collection.operation

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object FoldTest {

  def main(args: Array[String]): Unit = {

    /**
      * 折叠
      * fold函数将上一步返回的值作为函数的第一个参数继续传递参与运算，直到list中的所有元素被遍历
      * reduceLeft就是调用的foldLeft[B](head)，并且是默认从集合的head元素开始操作的。
      */

    val list = List(1,2,3,4)
    def minus(num1:Int , num2:Int):Int={
      num1 - num2
    }

    println(list.foldLeft(5)(minus))    // -5     (((5 - 1)-2)-3) -4
    println(list.foldRight(5)(minus))   // 3      1-(2-(3-(4-5)))

    /**
      * foldLeft 和 foldRight 缩写方法分别是 : /:    :\
      */
    val list2 = List(1,9,2,8)
    println(list2.foldLeft(1)(minus))
    println((1/:list2)(minus))

    println(list2.foldRight(1)(minus))     //13
    println((list2:\1)(minus))            //13         1-(9-(2-(8-1)))


    /**
      * val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
      * 将sentence 中各个字符，通过foldLeft存放到 一个ArrayBuffer中
      * 目的：理解flodLeft的用法.
      */

    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
    def putArray(arr:ArrayBuffer[Char] , c : Char) :ArrayBuffer[Char]={
      arr.append(c)
      arr
    }


    var arr = ArrayBuffer[Char]()
    sentence.foldLeft(arr)(putArray)    // 将arr 当做第一个参数传入 putArray , 遍历sentence中的元素填充 putArray的第二个参数
    println(arr)

    /**
      * val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
      * 使用映射集合，统计一句话中，各个字母出现的次数
      * 提示：Map[Char, Int]()
      */

  def putMap(map:mutable.Map[Char,Int],char: Char): mutable.Map[Char,Int] ={
       if(map.contains(char))
         map(char) = map(char) + 1
       else
         map+=(char->1)
     map
   }
    def charCount(map : mutable.Map[Char,Int],c :Char):mutable.Map[Char,Int]={
      map + (c -> (map.getOrElse(c,0) + 1))
    }

    def charCountStr(map : mutable.Map[String,Int],c :String):mutable.Map[String,Int]={
      map + (c -> (map.getOrElse(c,0) + 1))
    }


    val map11 = mutable.Map[Char,Int]()
    val map1 = sentence.foldLeft(map11)(putMap)   //Map(D -> 7, A -> 10, C -> 5, B -> 8)
    val map22 = mutable.Map[Char,Int]()
    val map2 = sentence.foldLeft(map22)(charCount)   //Map(D -> 7, A -> 10, C -> 5, B -> 8)
    println(map1)
    println(map2)

    //课后练习3-大数据中经典的wordcount案例
    val lines = List("atguigu han hello ", "atguigu han aaa aaa aaa ccc ddd uuu")
    val map33 = mutable.Map[String,Int]()
    val charToInt: mutable.Map[String, Int] = lines.flatMap(_.split(" ")).foldLeft(map33)(charCountStr)
    println(charToInt)

  }

}
