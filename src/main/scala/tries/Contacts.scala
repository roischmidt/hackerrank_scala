package tries

import scala.collection.mutable

/**
  * https://www.hackerrank.com/challenges/ctci-contacts/problem
  * solution was based on Mauricio Linhares blog (https://mauricio.github.io/2015/01/06/building-a-prefix-tree-in-scala.html)
  */

/* note this should in timely manner */
object Contacts {
    
    val root = new TrieNode(None)
    
    /**
      *
      * @return if it was find, return number, else none
      */
    def process(command: String,contact: String): Option[Int] = {
        command match {
            case "add" =>
                root.append(contact)
                None
            case _ =>
                Some(root.numOfWordsByPrefix(contact))
        }
    }
    
    
    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in)
        val n = sc.nextInt()
        var a0 = 0
        import java.io.BufferedOutputStream
        val out = new BufferedOutputStream(System.out)
        while (a0 < n) {
            var op = sc.next()
            var contact = sc.next()
            process(op,contact).foreach(e => out.write((e.toString + "\n").getBytes))
            a0 += 1
        }
        out.flush()
    }
    
}
