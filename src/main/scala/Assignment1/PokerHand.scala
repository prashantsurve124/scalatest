package Assignment1

object PokerHand {
  def main(args: Array[String]): Unit = {
 //Suits:S,D,H,C
 //1/A,2,3,4,5,6,7,8,9,10,J,Q,K
  
  case class Card(suite:String,rank:Int)
  val hand:List[String]=List("2","2","5","3","3")
  
  
  val ar=fun1(hand)
  println("ar"+ar.distinct)
  val temp1=Sequence(ar)
println( "seq"+temp1) 
println(isSeq(temp1))
  val num1=pair(temp1)
  println(num1)
  }
 
def fun1(suiteRank:List[String]):List[Int]={
  
      val tempRankArray:Array[String]=Array("*","A","2","3","4","5","6","7","8","9","10","J","Q","K")
      var rankIndex=List[Int]()
            for(i<- 0 to 4){
              val arrInt=tempRankArray.indexOf(suiteRank(i))
               println(arrInt)
               rankIndex=arrInt::(rankIndex)
             }
                  println("fun1"+rankIndex)
        rankIndex.sorted
  }

def Sequence(suiteRank:List[Int]):List[Int]={
 
 var sorted:List[Int]=List()
  
    if(suiteRank.contains(10) && suiteRank.contains(1)) 
    {
    suiteRank.sorted
     sorted =suiteRank.map(x=> if(x==1) 14 else x).sorted
    //final sorted List of Ranks
    
   // println("final sorted list"+sorted)
   
    }
    else
    {
    sorted=suiteRank  
    }
 sorted

}
 

def isSeq(sortedRank:List[Int]):Boolean={
  
   val sorted_Rank_Distinct:List[Int]=sortedRank.distinct
   if(sorted_Rank_Distinct.length==5)
   {
     var slidingTpl=sorted_Rank_Distinct.sliding(2, 1)
     println(slidingTpl.mkString(","))
     if(slidingTpl.forall{case List(x,y)=> y-x==1}) true else false 
     
   }
   else
   {
     false
   }
}


def pair(ranks:List[Int]):Boolean={
  val num=ranks.groupBy(f=>List(f)).filter((p)=>(p._1!=p._2))
println("num"+num.mkString(","))
val r = num.map(x=>(x._1(0),x._2.length))
println("rrrr"+r)
var res=false;
 
  if(r.forall{case (x,y)=> y>=2}) true 
else false

//println(num.toList.mkString(","))
}

/*count(x=>x!=null)//
 *   val lDistinct:List[Int]=l.distinct
 * 
    var slidingTpl=l.sliding(2, 1)
    println(slidingTpl.mkString(","))
 * 
 * */
}


