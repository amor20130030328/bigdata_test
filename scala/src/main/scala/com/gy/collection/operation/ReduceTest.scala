package com.gy.collection.operation

object ReduceTest {


  def main(args: Array[String]): Unit = {

    val list = List(1,20,30,4,5)

    def sum(n1:Int , n2 : Int)={
      n1 + n2
    }

    /**
      * 运行规则是 从左边开始执行将得到的结果返回给第一个参数
      * 然后继续和下一个元素运行，将得到的结果继续返回给第一个参数，继续..
      */
    val res = list.reduceLeft(sum)
    val res2 = list.reduceRight(sum)

    println(res + " " + res2)


    /**
      * 测试reduceLeff reduceRight  reduce
      */


    def minus(num1:Int , num2:Int): Int ={
        num1 - num2
    }

    val list2 = List(1,2,3,4,5)

    println(list2.reduceLeft(minus))    // -13   ((((1-2)-3)-4)-5)
    println(list2.reduceRight(minus))   // 3     (1-(2-(3-(4-5))))
    println(list2.reduce(minus))        // -13   底层调用reduce



  }
}
