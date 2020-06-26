package com.gy.collection.list

/**
  * 列表
  */
object ListTest {

  def main(args: Array[String]): Unit = {
    /**
      * scala的List可以直接存放数据，就是一个object,默认情况下Scala的List是不可变的，List属于序列Seq
      *
      * List默认为不可变的集合
      * List 在 scala包对象声明的,因此不需要引入其它包也可以使用
      * val List = scala.collection.immutable.List
      * List 中可以放任何数据类型，比如 arr1的类型为 List[Any]
      * 如果希望得到一个空列表，可以使用Nil对象, 在 scala包对象声明的,因此不需要引入其它包也可以使用
      */
    val list01 = List(1, 2, 3)    //创建是，直接分配元素
    println(list01)

    val list02 = Nil  //空集合

    println(list02)


    /**
      * 访问List元素
      */
    val data = list01(2)  //访问第三个元素
    println(data)

    /**
      * 列表元素的追加
      */
    //在列表的最后面添加
    val list03 = list01 :+ 999  // :+运算符表示在列表的最后增加数据

    //在列表的最前面添加
    val list04 =  999 +: list01  // +:在列表的最前面增加数据

    /**
      * 在列表的最前面增加数据
      * 符号::表示向集合中  新建集合添加元素。
      * 运算时，集合对象一定要放置在最右边，
      * 运算规则，从右向左。
      * ::: 运算符是将集合中的每一个元素加入到空集合中去
      */

    val list05 = 0::1::2::3::4::Nil
    val list06 = 0::11::22::33::44::list01:::Nil


    println("list01:"+list01)
    println("list03:"+list03)
    println("list04:"+list04)
    println("list05:"+list05)
    println("list06:"+list06)


    /**
      * 练习
      */

    val list1 = List(1, 2, 3, "abc")
    val list5 = 4 :: 5 :: 6 :: list1
    println(list5) // (4,5,6,1,2,3,"abc")



  }
}
