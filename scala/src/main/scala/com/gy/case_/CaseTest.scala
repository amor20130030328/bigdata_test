package com.gy.case_

object CaseTest {

  def main(args: Array[String]): Unit = {
    /**
      * 1）样例类仍然是类
      * 2）样例类用case 关键字进行声明
      * 3）样例类是为模式匹配而优化的类
      * 4）构造器中的每一个参数都成为val -- 除非它被显式地声明为var (不建议这样做)
      * 5）在样例类对应的伴生对象中提供apply方法让你不用new 关键字就能构造相应的对象
      * 6）提供unapply方法让模式匹配可以工作
      * 7）将自动生成toString .equals ,hashCode 和 copy方法（优点类似模板类，直接给生成，供程序员使用）
      * 8）除上述外，样例类和其他类完全一样。你可以添加方法和字段，扩展他们
      *
      */

    for(amt <- Array(Dollar(1000.0),Currency(1000.0,"RMB"),NoAmount)){
      val result = amt match {
        //说明
        case Dollar(v) => "$" + v
        case Currency(u,v) => v + " " + u
        case NoAmount => "啥也不是"
      }
      println(amt + " :" + result)
    }


    /**
      * 样例最佳实践2
      * copy 创建一个与现有对象值相同的新对象，并可以通过带名参数来修改某些属性
      */
      var amt01 = Currency(28.95,"RMB")
      var amt02 = amt01.copy()     //创建了一个新的对象，但是属性值一样
      var amt03 = amt01.copy(value = 19.09)
      var amt04= amt01.copy(unit = "英镑")


    println(amt01 == amt02)
    println(amt01)
    println(amt02)
    println(amt03)
    println(amt04)




  }
}

abstract class Amount
case class Dollar(value : Double) extends Amount
case class Currency(value : Double,unit: String) extends Amount
case object NoAmount extends Amount

//说明：这里的Dollar，Currency，NoAmount 是样例类








