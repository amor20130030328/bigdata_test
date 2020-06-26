package com.gy.collection.map

import scala.collection.mutable

object MapTest {

  def main(args: Array[String]): Unit = {

    /**
      * Scala 中不可变的Map是由有序的，可变的Map是无序的
      * scala.collection.mutable.Map      可变
      * scala.collection.immutable.Map    不可变
      *
      * 1.从输出的结果看到，输出顺序和声明顺序一致
      * 2.构建Map集合中，集合中的元素其实是Tuple2类型
      * 3.默认情况下（即没有引入其它包的情况下）,Map是不可变map
      * 4.为什么说Map中的元素是Tuple2 类型 [反编译或看对应的apply]
      */

      var map1 = scala.collection.mutable.Map("Alice"-> 23,"Bob"->24,"Kotlin"->79)       //Map(Bob -> 24, Kotlin -> 79, Alice -> 23)
      val map2 = scala.collection.immutable.Map("Alice"-> 23,"Bob"->24,"Kotlin"->79)     //Map(Alice -> 23, Bob -> 24, Kotlin -> 79)
      //创建空的映射
      val map3 = new mutable.HashMap[String,Int]()
      //对偶元组：即创建包含键值对的二元组，和第一种方式等价，只是形式上不同而已
      val map4 = mutable.Map(("Amor","阿诺夫"),("Kathy","科西"),("Mike","麦克"),("James","赞木事"))

      println(map1)
      println(map2)
      println(map3)
      println(map4)

      //映射Map-取值
      println("取值:"+map1("Alice"))
      //使用contains方法检查是否存在key ,使用containts先判断在取值，可以防止异常，并加入相应的处理逻辑
      println("contains:"+map1.contains("Alice"))
      //映射取值
      val value = map2.get("Alice").get
      println("map取值:" + value)
      //map.getOrElse() 取值
      val map2Value = map2.getOrElse("Alice2","二狗子")
      println(map2Value)

      //对map元素进行修改
      map1("Alice") = 100    //map 是可变的，才能修改，否则报错
      println(" map1(\"Alice\")=" +  map1("Alice"))

      //添加map元素(单个元素)
      var map6 = mutable.Map(("A",1),("B",2),("C",3))
      map6 += ("D"->4)
      map6 += ("E"->5)

      //添加多个元素
      map6= map6 + ("F"->6,"G"->7,"H"->8)
      println(map6)

      //删除元素

    val map7 = mutable.Map(("A", 1), ("B", "北京"), ("C", "上海"))
    println(map7)
    map7-=("A","B")
    println(map7)

    /**
      * 遍历
      */
    map1 = mutable.Map( ("A", 1), ("B", 11), ("C", 3) )
    for((k,v)<-map1){
      println(k + "->" + v)
    }

    for(v <- map1.keys){
      println(v)
    }


    for(v <- map1.values){
      println(v)
    }

    for(v <- map1){
      println(v)
    }



  }
}
