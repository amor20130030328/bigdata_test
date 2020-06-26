package com.gy.collection.listbuffer

import scala.collection.mutable.ListBuffer

object ListBufferTest {

  def main(args: Array[String]): Unit = {
    /**
      * ListBuffer是可变的list集合，可以添加，删除元素，ListBuffer属于序列
      */
    val list0 = ListBuffer[Int](1,2,3)
    println("list0(2)"+ list0(2))
    for(item <- list0){
      println(item)
    }

    val list1 = new ListBuffer[Int]
    list1 += 4
    list1.append(5)
    println("=======================================")
    for(item <- list1){
      println(item)
    }

    println("========================================")

    list0 ++=list1   //  list1 -->  list0

    val list2 = list0 ++ list1   // list0 + list1 --> list2

    println(list0)    //1 2 3 4 5
    println(list1)    //4 5
    println(list2)    //1, 2, 3, 4, 5, 4, 5

    /**
      * 添加
      */
    val list3 = list0 :+ 4
    println(list3)

    /**
      * 删除
      */
    println(list0)
    val res = list0.remove(1)
    println("删除的返回值" + res)
    println(list0)
  }
}
