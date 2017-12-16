package arrays

object LeftRotation {
    /**
      * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
      */
    
    def doLeftRotation(arr: Array[Int], rotation: Int) : List[Int] = {
        val (l,r) = arr.toList.splitAt(rotation % arr.length)
        r ::: l
    }

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in)
        val  n = sc.nextInt()
        val k = sc.nextInt()
        val a = new Array[Int](n)
        for(a_i <- 0 to n-1) {
            a(a_i) = sc.nextInt()
        }
        println(doLeftRotation(a,k).mkString(" "))
    }
}
