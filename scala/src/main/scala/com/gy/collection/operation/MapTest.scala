package com.gy.collection.operation

object ListTest {

  def main(args: Array[String]): Unit = {
    /**
      * 上面提出的问题，其实就是一个关于集合元素映射操作的问题。
      * 在Scala中可以通过map映射操作来解决：将集合中的每一个元素通过指定功能（函数）映射（转换）成新的结果集合这里其实
      * 就是所谓的将函数作为参数传递给另外一个函数,这是函数式编程的特点
      */
    def f1(n1:Int)={
      n1 * 2
    }

    val list = List(3,5,7)
    val list2 = list.map(f1)
    for (elem <- list2) {
      println(elem)
    }

    //深刻理解map映射函数的机制-模拟实现
    val myList =  MyList()
    val myList2 = myList.map(f1)

    println(myList)
    println(myList2)


    /**
      * 练习
      * val names = List("Alice", "Bob", "Nick")
      */
    val names = List("Alice", "Bob", "Nick")

    val upperNames = names.map(_.toUpperCase)
    println(upperNames)

    /**
      * 集合元素过滤
      * 将符合要求的数据（筛选）放置到新的集合中
      */

    //应用案例：将  val names = List("Alice", "Bob", "Nick") 集合中首字母为'A'的筛选到新的集合。

    val Anames = names.filter(_.startsWith("A"))
    println(Anames)




  }

}

class MyList{
  var list1 = List(3,5,7)
  var list2 = List[Int]()

  def map(f:Int => Int):List[Int]={
    for(item <- list1){
      list2 = list2 :+ f(item)
    }
    list2
  }
}

object MyList {
  def apply(): MyList = new MyList()
}
