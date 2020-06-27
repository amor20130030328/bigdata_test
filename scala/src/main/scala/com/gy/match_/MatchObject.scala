package com.gy.match_

object MatchObject {

  def main(args: Array[String]): Unit = {

    /**
      * 对象匹配，什么才算是匹配，规则如下
      * 1） case 中对象的 unapply 方法（对象提取器）返回 Some集合则为匹配成功
      * 2) 返回none 集合则为匹配失败
      */

    /**
      * 案例解释
      * 1） 构建对象时apply 会被调用，比如 val n1 = Square(5)
      * 2) 当将Square(n) 写在case 后时 [ case Square(n) => xxx] ，会默认调用unapply 方法（对象提取器）
      * 3) number会被传递给 def unapply(z : Double) 的 z 形参
      * 4）如果返回的是Some集合，则unapply 提取器返回的结果会返回给n 这个形参
      * 5) case 中对象的 unapply 方法（提取器）返回Some集合则为匹配成功
      * 6） 返回None集合则为匹配失败
      *
      */
    val number : Double = 36.0
    var result =  number match {
      case Square(number) => number
      case _ => "啥也不是"
    }

    println(result)


    // 构建对象是apply会被调用
    val number2 = Square(5)
    println(number2)

    val namesString = "Alice,Bob,Thomas"

    result =namesString match{
      case Names(x,y,z) => {
        println("the string contains three people's names")
      }
      case _ => println("nothing matched")
    }

    /**
      * 应用案例小结
      * 1) 当case后面的对象提取器方法的参数为多个，则会默认调用def unapplySeq() 方法
      * 2）如果unapplySeq 返回是Some，获取其中的值，判断得到的sequence中的 元素的个数
      * 是否是三个，如果是三个，则把三个元素分别取出，赋值给first，second,third
      * 3）其他规则不变
      */


    println("======================================================================")

    /**
      * 变量声明中的模式
      */
    val (x,y) = (1,2)
    println("x=" + x + " y=" + y )

    val (q,r) = BigInt(10) /% 3 // q = BigInt(10) / 3   r = BigInt(10) % 3
    println("q=" + q + " r=" + r)

    val arr = Array(1,7,2,9)
    val Array(first,second,_*) = arr
    println("first =" + first + " second =" + second)

  }
}


object Square{
  def unapply(arg: Double): Option[Double] = Some(math.sqrt(arg))

  def apply(z:Double) :Double = z * z
}


object Names{

  def unapplySeq(arg: String): Option[Seq[String]] ={
    if(arg.contains(",")){
      Some(arg.split(","))
    }else{
      None
    }
  }

}