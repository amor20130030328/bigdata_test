package com.gy.collection.operation

object IteratorTest {

  def main(args: Array[String]): Unit = {

    /**
      * 通过iterator方法从集合获得一个迭代器，通过while 循环和for表达式对集合进行遍历。
      * 案例小结
      *   1）iterator 的构建实际是AbstractIterator 的一个匿名子类，该子类提供了
      *   def iterator: Iterator[A] = new AbstractIterator[A] {
      *   var these = self
      *   def hasNext: Boolean = !these.isEmpty
      *   def next(): A =
      *
      *   2）该AbstractIterator 子类提供了hasNext   next等方法
      *   3) 因此，我们可以使用while 的方式，使用hasNext next 方法变量
      *
      *
      */

    val list = List(1,2,3,4,5)
    val iterator = list.iterator


    //一下两种方式只执行一种，因为使用迭代器，前面迭代过，后面再迭代就没有数据了
    println("===========遍历方式一============")
     while(iterator.hasNext){
      println(iterator.next())
    }

    println("===========遍历方式二===========")
    for(item <- iterator){
      println(item)
    }



  }

}
