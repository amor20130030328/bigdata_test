package com.gy.match_

object MatchArray {
  def main(args: Array[String]): Unit = {

    /**
      * 匹配数组
      * 基本介绍
      *   1） Array(0) 匹配只有一个元素且为0 的数组
      *   2) Array(x,y) 匹配数组有两个元素，并将两个元素赋值为 x,y .当然可以依次类推Array(x,y,z)
      *   3) Array(0,_*) 匹配数组以0 开始
      *
      */

    val arr = Array(0)
    val arr2 = Array(1,3)
    val arr3 = Array(0,11,100)

    for(array <- Array(arr,arr2,arr3)){
      val res = array match{
        case Array(0) => "0"
        case Array(x,y) => x+ "="+ y
        case Array(0,_*) => "以0开头和数组"
        case _ => "什么集合都不是"
      }

      println(res)
    }




  }

}
