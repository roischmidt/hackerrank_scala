package dp

/**
  * Dynamic Programming - Coin change
  * https://www.hackerrank.com/challenges/ctci-coin-change/problem
  */
object CoinChange {
    
    /**
      * recursive solution with memory
      */
    
    def calculateChange(arr: Array[Int], amount: Int) : Long = {
        // first, let's sort array to work with smaller coin first
        val sortedArray = arr.sorted
        // prepare change memory map
        var changeMemory : Map[(Int,Int),Long] = Map.empty
    
        /**
          * recursive method that work on current coin and scan right for left coins
          * @param coinIndex
          * @param coinSum
          * @return
          */
        def calculateChangeHelper(coinIndex: Int,coinSum: Int) : Long  = {
            if(coinSum == amount)
                return 1
            if(coinSum > amount)
                return 0
            if(changeMemory.get((coinSum,sortedArray(coinIndex))).isDefined) {
                return changeMemory((coinSum, sortedArray(coinIndex)))
            }
            
            var numOfChanges = 0l
            for(i <- coinIndex until sortedArray.length) {
               numOfChanges += calculateChangeHelper(i, coinSum + sortedArray(i))
            }
            // when all combinations for specific coin have checked we save their sum to the coin memory
            changeMemory = changeMemory.updated((coinSum,sortedArray(coinIndex)),numOfChanges)
            numOfChanges
        }
        calculateChangeHelper(0,0)
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        var n = sc.nextInt()
        var m = sc.nextInt()
        var coins = new Array[Int](m)
        for(coins_i <- 0 until m) {
            coins(coins_i) = sc.nextInt()
        }
        println(calculateChange(coins,n))
    }
}
