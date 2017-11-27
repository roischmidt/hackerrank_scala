package hashtables

/**
  * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to
  * know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
  * The words in his note are case-sensitive and he must use whole words available in the magazine,
  * meaning he cannot use substrings or concatenation to create the words he needs.
  * *
  * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his
  * ransom note exactly using whole words from the magazine; otherwise, print No.
  * *
  * Input Format
  * *
  * The first line contains two space-separated integers describing the respective values of m (the number of words in the magazine)
  * and n (the number of words in the ransom note).
  * The second line contains m space-separated strings denoting the words present in the magazine.
  * The third line contains n space-separated strings denoting the words present in the ransom note.
  * *
  * Constraints
  * 1 <= n,m <= 30000
  * 1 <= length of any word <= 5
  * .
  * Each word consists of English alphabetic letters (i.e., a to z and A to Z).
  * The words in the note and magazine are case-sensitive.
  * *
  * Output Format
  * *
  * Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.
  *
  *
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
