package com.gy.collection.array

import java.util

import scala.collection.mutable.ArrayBuffer

object Array2JavaList {

  def main(args: Array[String]): Unit = {

    //scala 集合 和 Java集合互相转换
    val arr = ArrayBuffer("1","2","3")
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)  //
    val arrList = javaArr.command()
    println(arrList)


    //java List转scala 数组（mutable.Buffer）
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    // java.util.List ==> Buffer
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("jack")

    println(scalaArr)
    println(arrList.getClass)
    println(scalaArr.getClass)




  }
}
