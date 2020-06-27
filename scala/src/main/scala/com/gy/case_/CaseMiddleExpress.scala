package com.gy.case_


object CaseMiddleExpress {

  def main(args: Array[String]): Unit = {
    /**
      * 基本介绍
      * 什么是中置表达式？  1 + 2 ,这就是一个中置表达式。如果unapply 方法产出一个元组，你可以在
      * case 语句中使用中置表示法。比如可以匹配一个List序列
      */
    List(1,2,5,9) match {   //修改并测试
      //1.两个元素中间 :: 叫做中置表达式，至少first ，second 两个匹配才行。
      //2. first 匹配第一个second 匹配第二个，rest匹配剩余部分(5,9)
      case first::second::last => println(first + "   " + second + " " + last)
      case _ => println("啥也不是")

    }


    /**
      * 匹配嵌套
      * 操作原理类似于正则表达式
      */

    /**
        最佳实践案例-商品捆绑打折出售
        现有一些商品，请使用Scala设计相关的样例类，完成商品捆绑打折出售，要求
        1） 商品捆绑可以是单个商品，也可以是多个商品
        2）打折时按照折扣x 元进行设计
        3） 能够统计出所有捆绑商品打折后的最终价格
      */


    //给出案例表示有一捆数，单本漫画（40-10） +文学作品(两本书)（80+30-20） = 30 + 90 = 120.0
    val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))


    var res = sale match {
      case Bundle(_,_,Book(desc,_),_*) => desc
    }
    println("第一本数的描述为:" + res)

    println("===============================================")

    /**
      * 匹配嵌套结构2
      * 通过 @ 表示法将嵌套的值绑定到变量。  _* 绑定剩余 Item 到 rest
      * val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
      * 这个嵌套结构中的 "漫画" 和 紫色的部分 绑定到变量，即赋值到变量中.
      */

    val res2 = sale match {
      case Bundle(_,_,art @ Book(_,_),rest @ _*) => (art,rest)
    }

    println("art:"+res2._1)
    println("rest:"+res2._2)

    println("=============================================================")

    val result2 = sale match {
      case Bundle(_, _, art @ Book(_, _), rest @ _*) => (art, rest)
    }
    println("art =" + result2._1)
    println("rest=" + result2._2)


    /**
      * 知识点-》不使用 _* 绑定剩余 Item 到 rest
      * 请思考：如何将“漫画”和紫色部分
      *
      */

    val result3 = sale match {
        //说明因为没有使用 _* 即明确说明没有多个Bundle，所以返回的rest ,就不是WrappendArray了
      case Bundle(_,_, art @ Book(_,_),rest) => (art,rest)
    }

    println("art :" + result3._1)
    println("rest :" + result3._2)

     price(sale)


  }


  /**
    * 最佳实践案例-商品捆绑打折出售
    * 现在有一些商品，请使用Scala设计相关的样例类，完成商品可以捆绑打折出售。要求
    * 商品捆绑可以是单个商品，也可以是多个商品。
    * 打折时按照折扣xx元进行设计.
    * 能够统计出所有捆绑商品打折后的最终价格
    */

  def price(it: Item): Double = {
    it match {
      case Book(_, p) => {
        println(p)
        p
      }
      //生成一个新的集合,_是将its中每个循环的元素传递到price中it中。递归操作,分析一个简单的流程
      case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    }
  }



}

abstract class Item // 项
case class Book(description : String ,price : Double) extends Item
//Bundle 捆   discount:Double 折扣    item:Item*,
case class Bundle(description : String,discount : Double,item:Item*) extends Item

//case class Nothing(value :Double) extends Amount2   //Error:(117, 43) illegal inheritance from sealed class Amount2

