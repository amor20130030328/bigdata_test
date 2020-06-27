package com.gy.match_

object MatchTuple {

  def main(args: Array[String]): Unit = {
    /**
      * 元组匹配
      */

    for(pair <- Array((0,1),(1,0),(1,1),(1,0,2))){
      val res = pair match {
        case (0,_) => "0,..."
        case (y,0) => y //
        case (x,y) => 1 + 1 + "x,y"
        case _ => "other"
      }

      println(res)
    }







  }
}
