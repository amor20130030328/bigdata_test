package com.gy.collection.set

object SetTest {

  def main(args: Array[String]): Unit = {

    /**
      * 集是不重复元素的结合。集不保留顺序，默认是以集实现
       */
      //默认情况下，scala使用的是不可变集合，如果你想使用可变集合，需要引用scala.collection.mutable.Set

      val set = Set(1,2,3)   //不可变

      println(set)

      //可变集合的创建
      import scala.collection.mutable.Set
      val mutableSet = Set(1,2,3)
      println(mutableSet)
      mutableSet +=5
      mutableSet +=3
      println(mutableSet)

      mutableSet -= 1
      mutableSet -= 100
      println(mutableSet)

    //集的遍历
    for (elem <- mutableSet) {
      println(elem)
    }
  }

}
