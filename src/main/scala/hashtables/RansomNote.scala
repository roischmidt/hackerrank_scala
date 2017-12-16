package hashtables

/**
  * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
  */
object RansomNote {
    
    def isValidWord(word: String): Boolean = {
        if (word.isEmpty || word.length > 5)
            false
        else {
            word.forall(_.isLetter)
        }
    }
    
    def isValidNote(magazine: Array[String], note: Array[String]) : Boolean = {
        //first, let's make map of string -> numOfOccurrences from magazine
        var magazineMap: Map[String, Int] = Map.empty
        magazine foreach { word =>
                val numOfOccurences = magazineMap.getOrElse(word, 0)
                magazineMap = magazineMap.updated(word, numOfOccurences + 1)
        }
        // now iterate each element in note and check if we have same left in magazineMap
        note foreach { word =>
            val numOfOccurences = magazineMap.getOrElse(word, 0)
            if(numOfOccurences == 0)
                return false
            magazineMap = magazineMap.updated(word, numOfOccurences - 1)
        }
        true
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        var m = sc.nextInt()
        var n = sc.nextInt()
        var magazine = new Array[String](m)
        for (magazine_i <- 0 until m) {
            magazine(magazine_i) = sc.next()
        }
        var ransom = new Array[String](n)
        for (ransom_i <- 0 until n) {
            ransom(ransom_i) = sc.next()
        }
        println(isValidNote(magazine,ransom) match {case true => "Yes" case false => "No"})
    }
    
    
}
