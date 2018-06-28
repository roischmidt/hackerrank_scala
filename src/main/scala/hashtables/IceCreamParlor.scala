package hashtables

import scala.collection.mutable

/**
  * Hash Tables: Ice Cream Parlor
  * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
  *
  * Solution done in O(n)
  */
object IceCreamParlor {
    
    // Complete the whatFlavors function below.
    def whatFlavors(cost: Array[Int], money: Int): (Int, Int) = {
        val m = mutable.Map[Int, Int]() // will store the coins we already walked through
        for (i <- cost.indices) {
            if (cost(i) < money) {
                // check if we already had  a coin that is a remainder for the price sum we looking for
                val remainder = money - cost(i)
                val remainderOpt = m.get(remainder)
                if (remainderOpt.isDefined) {
                    //print two indexes in sorted output (4 7) - in order to pass the hackerrank tests
                    return (Math.min(remainderOpt.get, i + 1), Math.max(remainderOpt.get, i + 1))
                } else {
                    m.put(cost(i), i + 1)
                }
            }
        }
        (0,0) // will never happen according to question's constraints
    }
    
    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        
        val t = stdin.readLine.trim.toInt
        
        for (tItr <- 1 to t) {
            val money = stdin.readLine.trim.toInt
            
            val n = stdin.readLine.trim.toInt
            
            val cost = stdin.readLine.split(" ").map(_.trim.toInt)
            val tuple = whatFlavors(cost, money)
            printf(s"${tuple._1} ${tuple._2}")
        }
    }
    
}
