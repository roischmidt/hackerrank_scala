package techniques

/**
  * Davis has  staircases in his house and he likes to climb each staircase 1,2, or 3
  * or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

Given the respective heights for each of the  staircases in his house,
find and print the number of ways he can climb each staircase on a new line.

Input Format

The first line contains a single integer, s , denoting the number of staircases in his house.
Each line i of the s subsequent lines contains a single integer,n , denoting the height of staircase i.
  
  Constraints :
  1 <= s <= 5
  1 <= n <=36
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
