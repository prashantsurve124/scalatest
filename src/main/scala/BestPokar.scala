import java.time.temporal.IsoFields

import scala.util.control.Breaks

/**
  * Created by admin on 6/17/2017.
  */
object BestPokar {
  def main(ar:Array[String])
  {//Pokar Suites
  val d=new Suite("D") ////Diamonds
  val s=new Suite("S") ////Spades
  val h=new Suite("H") ////Heart
  val c=new Suite("C") ////Club

    //pokar Ranks  2 to A (2,3,4,5,6,7,8,9,J,Q,K,A)

    val r2=new Rank("2")
    val r3=new Rank("3")
    val r4=new Rank("4")
    val r5=new Rank("5")
    val r6=new Rank("6")
    val r7=new Rank("7")
    val r8=new Rank("8")
    val r9=new Rank("9")
    val r10=new Rank("10")
    val rJ=new Rank("J")
    val rQ=new Rank("Q")
    val rK=new Rank("K")
    val rA=new Rank("A")

    //card
    val c1=new Card(h,r3)
    val c2=new Card(h,r4)
    val c3=new Card(h,r9)
    val c4=new Card(h,r6)
    val c5=new Card(h,rQ)


    println(new Poker().bestHand(c1,c2,c3,c4,c5))
  }

}


class Suite(suiteInput:String)
{
  val suite:String=suiteInput
}
class Rank(rankInput:String)
{
  val rank:String=rankInput
}

class Card(suit:Suite,rank:Rank)
{
  val cardSuite=suit
  val cardRank=rank

}



class Poker
{
  def bestHand(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):String={

    ///Four of Kind

    val four_Of_Kind=fourOfKind(i1,i2,i3,i4,i5)
    println(four_Of_Kind+"----")
    val full_House=fullHouse(i1,i2,i3,i4,i5)
    val flush_val=flush(i1,i2,i3,i4,i5)
  val sequence_Val=sequence(straight(List(i1.cardRank.rank,i2.cardRank.rank,i3.cardRank.rank,i4.cardRank.rank,i5.cardRank.rank)))
    
  //pair(i1,i2,i3,i4,i5)
    if(four_Of_Kind>=4) "FOUR_OF_KIND" 
      else if(full_House==3) "FULL_HOUSE" 
        else if(flush_val==true) "FLUSH" 
          else if(isSeq(sequence_Val)==true)"STRAIGHT" 
            else if(four_Of_Kind==3)"THREE_OF_KIND" 
              else if(pair(sequence_Val)==true) "PAIR"
                else "HIGH_CARD"

  }

  ///////----------Four of Kind-----------///////
  def fourOfKind(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):Int=
  {
    var fourOfKindCounter=0;
    var arr=new Array[String](5)
    arr(0)=i1.cardRank.rank
    arr(1)=i2.cardRank.rank
    arr(2)=i3.cardRank.rank
    arr(3)=i4.cardRank.rank
    arr(4)=i5.cardRank.rank

    val outer=new Breaks
    outer.breakable {
      for (i <- 0 until 5) {
        fourOfKindCounter=0
        for (j <- 0 until 5) {

          if (arr(i) == arr(j)) {
            fourOfKindCounter +=1
          }
        }
        if (fourOfKindCounter >= 4) {
          println("break")
          outer.break
        }

      }
    }
    fourOfKindCounter
  }
 
  //----------------FULL_HOUSE------------/
  def fullHouse(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):Int={
    val fhReqRank="A";
    var fullHouseCount=0
    var arr=new Array[String](5)
    arr(0)=i1.cardRank.rank
    arr(1)=i2.cardRank.rank
    arr(2)=i3.cardRank.rank
    arr(3)=i4.cardRank.rank
    arr(4)=i5.cardRank.rank

    for(i<-0 until 5){
      if(arr(i)==fhReqRank){
        fullHouseCount+=1
      }
    }
    fullHouseCount
  }

  

  ///---------FLUSH-------//
  def flush(i1:Card,i2:Card,i3:Card,i4:Card,i5:Card):Boolean={
    var count=0
    var arr=new Array[String](5)
    arr(0)=i1.cardSuite.suite
    arr(1)=i2.cardSuite.suite
    arr(2)=i3.cardSuite.suite
    arr(3)=i4.cardSuite.suite
    arr(4)=i5.cardSuite.suite
    //println(arr(1))
    for(i<-0 until 5){
      if(arr(0).equals(arr(i))) count+=1
    }
   // println(count)
    if(count==5) true else false
  }
  
  //--------------STRAIGHT--------------/////
 def straight(suiteRank:List[String]):List[Int]={
  
      val tempRankArray:Array[String]=Array("*","A","2","3","4","5","6","7","8","9","10","J","Q","K")
      var rankIndex=List[Int]()
            for(i<- 0 to 4){
              val arrInt=tempRankArray.indexOf(suiteRank(i))
               println(arrInt)
               rankIndex=arrInt::(rankIndex)
             }
        rankIndex.sorted
  }

def sequence(suiteRank:List[Int]):List[Int]={
 
 var sorted:List[Int]=List()
  
    if(suiteRank.contains(10) && suiteRank.contains(1)) 
    {
    suiteRank.sorted
     sorted =suiteRank.map(x=> if(x==1) 14 else x).sorted
   
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
             if(slidingTpl.forall{case List(x,y)=> y-x==1}) true else false 
       }
       else
       {
           false
       }
  }



/////////////////////////////////-------------PAIR---------------//////////////////////////////////////////

def pair(ranks:List[Int]):Boolean={
  val num=ranks.groupBy(f=>List(f)).filter((p)=>(p._1!=p._2))
println("num"+num.mkString(","))
val r = num.map(x=>(x._1(0),x._2.length))
println(r)
var res=false;
 
  if(r.forall{case (x,y)=> y>=2}) true 
else false

//println(num.toList.mkString(","))
}

}