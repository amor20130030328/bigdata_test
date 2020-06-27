package com.gy.collection.operation

object Operator {

  def main(args: Array[String]): Unit = {

    /**
      * 操作符扩展
      * 1）如果想在变量名、类名等定义中使用语法关键字（保留字），可以配合反引号反引号
      */
    val `val` = 41
    println(`val`)

    /**
      * 中置操作符
      */
    val n1 = 1
    val n2 = 2
    val r1 = n1 + n2
    val r2 = n1.+(n2)

    println(r1 + " " + r2)


    /**
      * 前置操作符
      */








  }

}
