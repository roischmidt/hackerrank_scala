package tries

import scala.collection.mutable

/**
  * We're going to make our own Contacts application! The application must perform two types of operations:
  * *
  * add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
  * find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
  * Given  sequential add and find operations, perform each operation in order.
  * *
  * Input Format
  * *
  * The first line contains a single integer, n , denoting the number of operations to perform.
  * Each line i of the n subsequent lines contains an operation in one of the two forms defined above.
  * *
  * Output Format
  * *
  * For each find partial operation, print the number of contact names starting with  on a new line.
  * *
  * Sample Input
  * *
  * 4
  * add hack
  * add hackerrank
  * find hac
  * find hak
  * *
  * Sample Output
  * *
  * 2
  * 0
  * *
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
