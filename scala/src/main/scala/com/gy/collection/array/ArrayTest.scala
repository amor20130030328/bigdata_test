package com.gy.collection.array

import scala.collection.mutable.ArrayBuffer

/**
  * 数组
  */
object ArrayTest {

  def main(args: Array[String]): Unit = {

    val arr01 = new Array[Int](4)
    println(arr01.length)

    for(item <- arr01){
      println(item)
    }

    println("=========================================")

    val arr02 = Array(1,"我是TA",26)

    for(item <- arr02){
      println(item)
    }

    /**
      * 变长数组-声明泛型
      */

    println("=========================================")
    val arr03 = ArrayBuffer[Int]()
    arr03.append(1)
    arr03.append(2)
    arr03.append(3)

    for(item <- arr03){
      println(item)
    }


    /**
      * 定长数组与变长数组的转换
      * arr01.toBuffer     定长数组转可变数组
      * arr03.toArray      可变数组转定长数组
      */

    println("===========================================")
    val array1 = arr01.toBuffer
    array1.append(100)
    println("===========================================")

    val array3 = arr03.toArray





  }

}
