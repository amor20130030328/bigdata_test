package com.gy.collection.queue

object QueueTest {
  def main(args: Array[String]): Unit = {

    /**
      * 队列是一个有序列表，在底层可以用数组或是链表来实现。
      * 其输入和输出要遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出
      * 在Scala中，由设计者直接给我们提供队列类型使用。
      * 在scala中, 有 scala.collection.mutable.Queue 和 scala.collection.immutable.Queue , 一般来说，我们在开发中通常使用可变集合中的队列。
      */

    import scala.collection.mutable   //可变的
    /**
      * 说明：这里的Int是泛型，表示q1队列只能存放Int类型
      * 如果希望q1可以存放其他类型，则使用Any即可
      */
    val q1 = new mutable.Queue[Int]()
    println(q1)
    q1 += 100
    println(q1)
    q1 ++= List(1,2,4)

    println("返回队列的元素" + q1.head)
    println("返回队列最后一个元素" + q1.last)
    println("返回队列的尾部:" + q1.tail)   //除了第一个以外剩余的元素
    println("返回队列的尾部:" + q1.tail.tail)   //除前两个以外的元素


    println(q1)

    /**
      * 队列 Queue-删除和加入队列元素
      * 按照队列的算法，会将数据添加到队列的最后。
      */
    println(q1.dequeue())
    println(q1)
    q1.enqueue(20,30,40)
    println(q1)

  }
}
