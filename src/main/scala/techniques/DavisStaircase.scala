package techniques

/**
    https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
  */
object DavisStaircase {

    // lets solve this by Recurrence relation f(n)=f(n-1)+f(n-2)+f(n-3)‎
    // let's init a map with first 3 elements and later an init method to fill the rest 36
    var resMap : Map[Int,Int] = Map(0 -> 1, 1 -> 1, 2 -> 2)
    
    init
    
    def init = {
        for (i <- 3 to 36) {
            resMap = resMap.updated(i, resMap(i - 3) + resMap(i - 2) + resMap(i - 1))
        }
    }
    
    def getNumOfOptions(numOfStairs: Int) : Int = {
        if(numOfStairs >= 0 && numOfStairs <= 36)
            resMap(numOfStairs)
        else -1
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        val s = sc.nextInt()
        var a0 = 0
        while(a0 < s){
            var n = sc.nextInt()
            println(getNumOfOptions(n))
            a0+=1
        }
    }
    
}
