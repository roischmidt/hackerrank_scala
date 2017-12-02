package tries

import scala.annotation.tailrec
import scala.collection.mutable


sealed trait Trie {
    def append(key: String)
    def numOfWordsByPrefix(prefix: String): Int
}


class TrieNode(
    val char: Option[Char] = None,
    var word: Boolean = false,
    var numOfWords: Int = 0) extends Trie {
    val children: mutable.Map[Char, TrieNode] =
        new mutable.ListMap[Char, TrieNode]() // ListMap is faster than triemap or hashmap
    
    override def append(key: String): Unit = {
        @tailrec def appendHelper(node: TrieNode, currentIndex: Int): Unit = {
            if (currentIndex == key.length) {
                node.word = true
            } else {
                val char = key.charAt(currentIndex).toLower
                val result = node.children.getOrElseUpdate(char, {
                    new TrieNode(Some(char))
                })
                result.numOfWords += 1
                appendHelper(result, currentIndex + 1)
            }
        }
        
        appendHelper(this, 0)
    }
    
    override def numOfWordsByPrefix(prefix: String): Int = {
        @tailrec def helper(currentIndex: Int, node: TrieNode): Int = {
            if (currentIndex == prefix.length) {
                node.numOfWords
            } else {
                node.children.get(prefix.charAt(currentIndex).toLower) match {
                    case Some(child) => helper(currentIndex + 1, child)
                    case None => 0
                }
            }
        }
        
        helper(0, this)
    }
}
