package com.gy.match_

object Guard {

  def main(args: Array[String]): Unit = {
    /**
      * 守卫：如果想要表达匹配某个范围的数据，就需要在模式匹配中增加天剑守卫
      */

    for(ch <- "+-3!"){
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if ch.toString.equals("3") => digit = 3
        case _ => sign = 2

      }

      println(ch + " " + sign + " " + digit)

    }

    println("=================================")

    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
        case _  => digit = 3
        case _  => sign = 2
      }
      //
      println(ch + " " + sign + " " + digit) // + 1 0   - -1 0  3 0 3  ! 0 3
    }


    println("===============================")

    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case _  => digit = 3
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
      }
      println(ch + " " + sign + " " + digit)   // + 0 3    - 0 3    3 0 3  ! 0 3
    }



  }

}
