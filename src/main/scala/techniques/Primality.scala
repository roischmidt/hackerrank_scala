package techniques

/**
  * https://www.hackerrank.com/challenges/ctci-big-o/problem
  */
object Primality {
    
    // let's create a history map that will store previous results. in case we have duplicates input it will save time
    var primalMap : Map[Int,Boolean] = Map(1 -> false,2 -> true) // init it with 1,2
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val p = sc.nextInt()
        val a0 = 0
        while (a0 < p) {
            val n = sc.nextInt()
            if(isPrime(n))
                println("Prime")
            else
                println("Not prime")
        }
        
    }
    
    def isPrime(num: Int) : Boolean =
        primalMap.get(num) match {
            case Some(isPrime) =>
                isPrime // first we check our history map if we already calculated this number
            case None =>
                if((num & 1) == 0) { // check if number is even - couldn't be prime if it's not 2
                        primalMap = primalMap.updated(num, false)
                        return false
                    }
                for (i <- 3 until num by 2) { // try to check all modulus until number and skip evens
                    if (num % i == 0) {
                        primalMap = primalMap.updated(num, false)
                        return false
                    }
                }
                primalMap = primalMap.updated(num, true)
                true
        }
    
}
