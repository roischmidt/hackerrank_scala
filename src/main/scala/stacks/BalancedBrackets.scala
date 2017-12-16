package stacks

import scala.collection.mutable

/**
  * https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
  */
object BalancedBrackets {
    
    val stackForOpeningBrackets = new mutable.ArrayStack[Char]
    
    val bracketsMap = Map('[' -> ']', '{' -> '}', '(' -> ')')
    
    def isOpeningBracket(bracket: Char): Boolean =
        bracketsMap.keySet.contains(bracket)
    
    def isBalanced(str: String): Boolean = {
        stackForOpeningBrackets.clear()
        for (i <- 0 until str.length) {
            if (isOpeningBracket(str(i)))
                stackForOpeningBrackets.push(str(i))
            else {
                if (stackForOpeningBrackets.isEmpty)
                    return false
                val last = stackForOpeningBrackets.pop()
                if (bracketsMap(last) != str(i))
                    return false
            }
        }
        if(stackForOpeningBrackets.nonEmpty) return false
        true
    }
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        var t = sc.nextInt()
        var a0 = 0
        while (a0 < t) {
            var expression = sc.next()
            a0 += 1
            if (isBalanced(expression)) {
                println("YES")
            } else {
                println("NO")
            }
            
        }
    }
    
}
