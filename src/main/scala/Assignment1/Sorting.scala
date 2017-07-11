package Assignment1

object Sorting extends temp {
  
  def main(args:Array[String]){
  
  val ls:List[Int]=List(1,4,2,0)
  val ls1:List[Int]=List(6,7,3,9)
  println(iSort(ls))
  
  println(ls:::ls1)
    
  
  
  def concat[T](xs:List[T],ys:List[T]):List[T]= xs match{
    case List()=>ys
    case z::zs => z::concat(zs,ys)
  }
  
  
  val ls2:List[Int]=List(10,20,30,40)
  
 // println(ls2.ini)
println( concat(ls,ls2))
 println(last(ls2))
 println(ls take 2)
 println(ls drop 2)
 println( ls(0))
println(ls contains 0)
println("ls2 reverse="+reverse(ls2))
  }
}

class temp{
  
  def iSort(xs:List[Int]):List[Int] = xs match{
    case List()=>List()
    case y::ys=>insert(y,iSort(ys))
  }
  def insert(x:Int,xs:List[Int]):List[Int]= xs match{
    case List()=>List(x)
    case y::ys=> if(x<=y)x::xs else y::insert(x,ys)
  }
  
  def last[T](xs:List[T]):T =xs match{
    case List()=>throw new Error("Empty list");
    case List(x)=>x
    case x::xs=>;last(xs)
 
  }
  
  def init[T](xs:List[T]):List[T]= xs match{
    case List()=>throw new Error("Empty List");
    case List(x)=>List()
    case y::ys=>y::init(ys)
  }
  
  
  def reverse[T](xs:List[T]):List[T]= xs match{
    case List()=> List()
    case y::ys=>reverse(ys)++List(y)
  }
  
  
  def removeAt[T](n:Int,xs:List[T])= (xs take n) :::(xs drop n+1)
    
    
  
}