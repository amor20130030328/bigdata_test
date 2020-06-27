package com.gy.collection.operation

object ZipTest {

  def main(args: Array[String]): Unit = {

    /**
      * 基本介绍
      * 在开发中，当我们需要将两个集合进行对偶元组合并，可以使用拉链
      * 拉链的本质就是两个集合的合并操作，合并后每一个元素是一个对偶元组
      * 如果两个集合个数不对应，会造成数据丢失
      * 如果要取出合并后的各个对偶元组的数组，可以遍历
      */
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)

    val list3 = list1.zip(list2)

    println(list3)
    for (elem <- list3) {
      println(elem._1 + "  " + elem._2)   //取出时，按照元组的方式取出即可
    }


  }
}
