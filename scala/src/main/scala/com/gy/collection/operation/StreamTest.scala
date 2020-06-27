package com.gy.collection.operation

object StreamTest {

  def main(args: Array[String]): Unit = {

    /**
      * 基本说明，stream是一个集合。这个集合，可以用于存放无穷多个元素，但是这无穷个元素并
      * 不会一次性生产出来，而是需要用到多大的区间，就会动态的生产，末尾元素遵循lazy 规则（即：要使用结果才进行计算的）
      * 使用tail ，会动态的向stream集合按规则生产新的元素
      * 如果使用流集合，就不能使用last属性，如果使用last集合就会进入无线循环
      *
      *
      */

    //创建Stream对象
/*    def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(1)
    println(stream1) //
    //取出第一个元素
    println("head=" + stream1.head) //
    println(stream1.tail) //
    println(stream1) //?*/


    def numsForm(n:BigInt):Stream[BigInt] = n #::numsForm(n+1)
    val stream = numsForm(1)
    println(stream)
    //提取第一个元素
    println("head = " + stream.head)
    println(stream.tail)
    println(stream)

    println("========================================")

    /**
      * 使用map 映射stream的元素并进行一些计算
      */

      def mutil(x:BigInt):BigInt={
        x * x
      }


    val stream2 = numsForm(5).map(mutil)

    println(stream2.head)
    println(stream2.tail)
    println(stream2)


  }
}
