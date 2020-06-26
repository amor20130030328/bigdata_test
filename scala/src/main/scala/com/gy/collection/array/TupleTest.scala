package com.gy.collection.array

/**
  * 元组
  */
object TupleTest {

  def main(args: Array[String]): Unit = {

      //注意：元组中最大只能有22个元素
    val tuple1 = (1,2,3,"hello",4)
    println(tuple1)

    /**
      * 访问元组中的数据,可以采用顺序号（_顺序号），也可以通过索引
      */

      println(tuple1._4)    //访问元组的第四个元素
      println(tuple1.productElement(0))    //访问元组的第一个元素，从0开始

    /**
      * Tuple元组的遍历
      */

    for (item <- tuple1.productIterator){  //tuple1是一个整体，遍历需要调用其迭代器
      println(item)
    }


  }
}
