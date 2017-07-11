package Assignment1

/**
  * Created by prashants on 6/20/2017.
  */
class ListDemo {


  val ls1:List[String]=List("apples" ,"orange")
  val ls2:List[Int]=List(1,2,3,4,5,6,7,8,9,10)
  val ls3:List[List[Int]]=List(List(1,1,0),List(0,1,0),List(0,0,1))
  val emptyls:List[Nothing]=List()


  val fruit="apple"::("oranges"::("mangos"::emptyls))
  val num1=1::(2::(3::(4::(5::(6::(emptyls))))))
  val num2=1::2::3::4::5::6::emptyls

  println(ls3.tail)
}

object Ls{

  def main(args:Array[String]): Unit ={
    val v=new ListDemo()

  }
}