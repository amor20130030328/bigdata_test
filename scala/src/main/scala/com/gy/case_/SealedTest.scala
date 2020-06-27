package com.gy.case_

object SealedTest {

  def main(args: Array[String]): Unit = {

    /**
      * 密封类，
      * 1）如果想让case 类的所有子类都必须在申明该类的源文件中定义，可以将样例类的通用超类声明为
      *    sealed ,这个超类称之为密封类
      * 2） 密封就是不能在其他文件中定义子类
      */



  }

}

abstract sealed class Amount2
case class Dollar(value : Double) extends Amount2
case class Currency(value : Double,unit:String) extends Amount2
case class Nothing(value :Double) extends Amount2