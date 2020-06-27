package com.gy.collection.operation

object ScanTest {

  def main(args: Array[String]): Unit = {

    /**
      * 扫描，即对某个集合的所有元素fold 操作，但是会把产生的所有中间结果放置于一个集合中保存
      */

    def minus( num1 : Int, num2 : Int ) : Int = {
      num1 - num2
    }

    def add( num1 : Int, num2 : Int ) : Int = {
      num1 + num2
    }

    val i = (1 to 5).scanLeft(5)(minus)    //      5    5-1(4)    4-2(2)    2-3(-1)   -1-4 (-5)   -5-5(-10)
    println(i)   //Vector(5, 4, 2, -1, -5, -10)

    val i2 = (1 to 5).scanLeft(5)(add)    //      5    5+1(6)    6+2(8)    8+3(11)   11+4 (15)   15+5(20)
    println(i2)   //Vector(5, 6, 8, 11, 15, 20)




  }
}
