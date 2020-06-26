package com.gy.collection.array

object MutilArrayTest {

  def main(args: Array[String]): Unit = {

    /**
      * 多维数组的定义和使用
      */
    val array = Array.ofDim[Int](3,4)
    array(2)(3) = 100

    for(arr <- array){
      for(item <- arr){
        println(item)
      }
    }








  }

}
