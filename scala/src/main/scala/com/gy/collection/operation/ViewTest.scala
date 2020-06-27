package com.gy.collection.operation

object ViewTest {

  def main(args: Array[String]): Unit = {

    /**
      * Stream 的懒加载特性，也可以对其他集合应用view方法来得到类似的效果，具有如下特点
      * view 方法产出一个总是被懒加载执行的集合。
      * view不会缓存数据，每次都要重新计算，比如遍历View 时
      *
      */

    def multiple(num:Int) : Int={
      num
    }

    def eq(i:Int):Boolean={
      i.toString.equals(i.toString.reverse)
    }

    //说明：没有使用view
    val viewSquares1 = (1 to 100).map(multiple).filter(eq)
    println(viewSquares1)

    for(item <- viewSquares1){
      println(item)
    }


    println("==============================================================")
    val viewSquares2 = (1 to 100).view.map(multiple).filter(eq)    //加了view使用懒加载
    println(viewSquares2)

    for(item <- viewSquares2){
      println(item)
    }







  }

}
