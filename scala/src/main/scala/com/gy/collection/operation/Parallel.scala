package com.gy.collection.operation

object Parallel {

  def main(args: Array[String]): Unit = {

    /**
      * 1.Scala为了充分使用多核CPU，提供了并行集合（有别于前面的串行集合）
      * 用于多核环境的并行计算
      *
      * 2.主要用到的算法有
      *   Divide and conquer ：分治算法，Scala通过splitters(分解器)，combiners(组合器)等抽象层来实现，主要原理是将计算工作分解很多任务
      *   分发给一些处理器去完成，并将它们处理结果合并返回
      *
      *   Work stealin算法 ，主要用于任务调用负载均衡（load-balancing） 通俗点完成自己的所有任务之后，发现其他人还有活没干完，主动
      *   帮他人一起干，这样达到尽早干完的目睹
      */

    // 打印1~5
    (1 to 5).foreach(println(_))
    println("=====================================")
    (1 to 5).par.foreach(println(_))

    //查看并行集合中元素访问的线程
    val res1 = (0 to 100).map{
      case _ => Thread.currentThread().getName
    }

    val res2 = (0 to 100).par.map{
      case _ => Thread.currentThread().getName
    }


    println("res1" + res1)
    println("res2" + res2)


  }
}
