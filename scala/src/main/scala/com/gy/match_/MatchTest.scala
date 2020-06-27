package com.gy.match_

object MatchTest {

  def main(args: Array[String]): Unit = {
    /**
      * Scala 中的模式匹配类似于Java中的switch语法，但是更加强大
      * 模式匹配语法中，采用match关键字声明，每个分支采用case 关键字进行声明，当需要匹配时，会从第一个case 分支开始
      * 如果匹配成功，那么执行对应的逻辑代码，如果匹配不成功，继续执行下一个分支进行判断。如果所有case 都不匹配，那么会执行 case _ 分支
      * 类似于 Java的 default语句
      */

    val oper = '#'
    val n1 = 20
    val n2 = 10
    var res = 0

    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case _ => println("oper error")
    }

    println(res)

    /**
      * 注意事项
      * 如果所有case都不匹配，那么会执行case _ 分支，类似于Java中default语句
      * 如果所有case都不匹配，又没有写case _ 分支，那么会抛出MatchError
      * 每个case中，不用break语句，自动中断case
      * 可以在match中使用其它类型，而不仅仅是字符
      *
      * => 等价于 java swtich 的 :
      * => 后面的代码块到下一个 case， 是作为一个整体执行，可以使用{} 扩起来，也可以不扩。
      */

    val oper2 = 1
    val i1 = 20
    val i2 = 10

    oper2 match {
      case '+' => res = i1 + i2
      case 1 => res = i1 /i2
      case _ => println("oper error")
    }

    println("res = "+res)




    val oper3 = 1
    val i3 = 20
    val i4 = 10

    oper2 match {             //scala.MatchError
      case '+' => res = i1 + i2
      case 2 => res = i1 /i2
    }

    println("res = "+res)




  }

}
